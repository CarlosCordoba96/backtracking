package Mochila.src;


public class Mochila {
	int [][] objetos;
	int size;
	
	public Mochila(int s){
		objetos=init();
		s=size;
	}
	
	private int[][] init(){
		int [][] mochila = new int [2][3];
		mochila[0][0] = 10; //El objeto 0 pesa 10
		mochila[0][1] = 10;
		mochila[0][2] = 5;
		mochila[1][0] = 5; //El objeto 0 vale 5
		mochila[1][1] = 4;
		mochila[1][2] = 3;
		
		return mochila;
	}
	
	public void printSol(int[]v){
		int i;
		for(i=0;i<v.length;i++){
			System.out.print(v[i]);
		}
	}
	
	public void back(int etapa,int[]sol,int[]solOp){
		if(etapa==sol.length){ //El caso base es cuando tengo una combinación de objetos
			if(esMejor(sol,solOp)){
				System.arraycopy(sol, 0, solOp, 0, sol.length);
			}
			printSol(solOp);
		}else{
			for (int i = 0; i <= 1; i++) {
				if (puedometer(sol, etapa, i)){
					sol[etapa] = i;
					back(etapa + 1, sol, solOp);
				}
			}
		}
	}
	public boolean puedometer (int [] sol, int etapa, int p) {
		int peso = 0;
		
		for (int i = 0; i < etapa; i++) {
			peso += objetos[0][i] * sol[i];
		}
		
		peso+= objetos[0][etapa] * p;
		
		return (peso <= size);
	}
	private boolean esMejor(int[]s,int[]so){
		int valor=0,valorOp=0;
		for(int i=0;i<s.length;i++){
			valor+=objetos[1][i] * s[i];
			valorOp+=objetos[1][i] * so[i];
		}
		return valor>valorOp;
	}
}
