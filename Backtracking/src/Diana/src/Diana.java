package Diana.src;


public class Diana {
	public static void main(String []args){
		int[]v={0,10,10,25,25,50,75};
		Diana d=new Diana(v,100,5);
		d.primerIt();
	}
	private int [] puntuaciones;
	private int goal;
	private int dardos;
	
	public Diana(int [] puntuaciones,int goal,int dardos){
		this.puntuaciones=puntuaciones;
		this.goal=goal;
		this.dardos=dardos;
	}
	private void primerIt(){
		int[]sol=new int [dardos];
		int[]solOp=new int [dardos];
		for(int i=0;i<sol.length;i++){
			sol[i]=0;
			solOp[i]=0;
		}
		back(0,sol,solOp);
		printSol(solOp);
	}
	private void back(int etapa, int[]sol,int [] solOp){
		int suma=0;
		for(int i=0;i<sol.length;i++){
			suma+=sol[i];
		}
		if(goal==suma){
			if(esMejor(sol,solOp)){
				System.arraycopy(sol, 0, solOp, 0, sol.length);
			}
		}else{
			if(poda(goal,solOp)){
				for(int i=0;i<puntuaciones.length;i++){
					sol[etapa]=puntuaciones[i];
					back(etapa+1,sol,solOp);
				}
			}
		}
	}
    private void printSol (int [] sol) {
        for (int i = 0; i < sol.length; i++) {
            System.out.print(sol[i] + " ");
       }
        System.out.print("\n");         
   }
	private boolean poda(int n,int [] sol){
		int suma=0;
		for(int i=0;i<sol.length;i++){
			suma+=sol[i];
		}
		return suma<n;
	}
	private boolean esMejor(int[]sol,int[]solOp){
		int i = sol.length-1;
        boolean Mejor = false;
        while (i > 0 && !Mejor) {
            if (sol[i] == 0 && solOp[i] != 0) {
                Mejor = true;
            }
            i--;
        }
        return Mejor;
	}
}
