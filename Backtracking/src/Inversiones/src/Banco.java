package Inversiones.src;


public class Banco {
	int [][]inversiones;
	
	public Banco(int [][] inversiones){
		this.inversiones=inversiones;
	}
	//Metodo final para ejecutar la solución e imprimirla
	public void ejecutar(){
		int [] sol=new int[inversiones[0].length]; //Vector del tamaño del número de columnas, es decir, el número de bancos
		int [] solOp=new int[inversiones[0].length];
		//Siempre inicializar los vectores de la soluión
		for(int i=0;i<sol.length;i++){
			sol[i]=0;
			solOp[i]=0;
		}
		System.out.println("Solución backwards:\n");
		Back(sol,solOp,0);
		System.out.println("Solución forward:\n");
		//Forward();
	}
	private void Back(int [] sol, int [] solOp, int etapa){
		int i;
		//La estructura siempre es igual, primer if=caso base=encontrar una solución
		if(etapa==sol.length){ //Es decir, ya he invertido todos mis millones en el banco que sea
			if(esMejor(sol,solOp)){ //El segundo if es siempre la comparación
				System.arraycopy(sol, 0, solOp, 0, sol.length);
			}
			printSol(sol);
		}else{
			for(i=0;i<=3;i++){//4 porque son todas las combinaciones posibles de inversión en cada etapa: invertir 0,1,2 o 3
				//Ahora la poda, que es que sólo puedo invertir un máximo de 3 millones en nuestro ejemplo, por lo que
				//si ya llevo 3 invertidas no tengo que seguir mirando otras soluciones
				if(esPosible(sol,etapa,i)){
					sol[etapa]=i;
					Back(sol,solOp,etapa+1);
				}
			}
		}
	}//Back
	
	private boolean esPosible(int [] sol, int etapa, int i){
		int acumulado=0;
		int j;
		for(j=0;i<etapa;i++){
			acumulado+=sol[i];
		}
		return ((acumulado+1)<=3);
	}
	
	private boolean esMejor(int [] sol, int [] solOp){
		int acumSol=0, acumOp=0,i;
		for(i=0;i<sol.length;i++){
			acumSol=inversiones[sol[i]][i];
			acumOp=inversiones[solOp[i]][i];
		}
		return acumSol>acumOp;
	}
	
	private void printSol(int []v){
		for(int i=0;i<v.length;i++){
			System.out.println("Invertido en banco "+i +" cantidad: "+v[i]);
			System.out.println("");
		}
	}
}
