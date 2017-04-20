package cambio;

import java.util.Arrays;

public class Examen {
	private int [] monedas;
	private int cambio;

	public Examen(int [] m,int cambio){
		monedas=m;
		this.cambio=cambio;
	}
	
	public void back(int etapa,int []sol,int []solopt){
		int i;
		if(etapa==sol.length){
			if(calcular(sol)==cambio){
				//printsol(sol);
				if(esmejor(sol,solopt)){
					System.arraycopy(sol, 0, solopt,0,sol.length);
				}
			}
		}else{
			for(i=0;i<=cambio;i++){
				if(esposible(sol,etapa,i)){
				sol[etapa]=i;
				back(etapa+1,sol,solopt);	
				}
			}
		}
		
	}
	
	
	private int calcular(int []sol){
		int sum=0;
		for(int i=0;i<sol.length;i++){
			sum+=sol[i]*monedas[i];
		}
		return sum;
	}
	
	private int contar(int[]sol){
		int sum=0;
		for(int i=0;i<sol.length;i++){
			sum+=sol[i];
		}
		return sum;
	}
	private boolean esmejor(int []sol,int[]solopt){
		return contar(sol)<=contar(solopt);
	}
	private boolean esposible(int sol[],int etapa,int moneda){
		int [] aux=new int[sol.length];
		System.arraycopy(sol, 0, aux, 0, sol.length);
		aux[etapa]=moneda;
		int acum=0;
		for(int i=0;i<=etapa;i++){
			acum+=aux[i];
		}		
		return acum<=cambio;
	}
	private  void printsol(int[]sol){
		System.out.println("El cambio para "+cambio+" ha sido: ");
		for(int i=0;i<sol.length;i++){
			if(sol[i]==Integer.MAX_VALUE){
				System.out.println("No ha sido posible encontrar solucion");
				break;
			}
			System.out.println(sol[i]+" monedas de  "+monedas[i]);
		}
	}

	public void forward1(int []sol){//Encuentra la solucion optima ya que ordenamos la matriz de mayor a menor
		int i=0;
		boolean found=false;
		int acum=0;
		while (i<monedas.length && !found){//mientras no nos salgamos del array y no encontremos solucion
			for(;acum<cambio;sol[i]=sol[i]+1){//mientras lo acumulado sea menos que el cambio vamos metiendo en sol[i] mas monedas
				acum=acum+monedas[i];
			}
			if (acum==cambio)//	Encontramos solucion
				found=true;
			else {// la solucion no se ha encontrado entonces eliminamos lo acumulado y lo ultimo metido y vamos a mirar con otro tipo de monedas
				acum=acum-monedas[i];
				sol[i]=sol[i]-1;
				i++;
			}
		}
	}
	

}
