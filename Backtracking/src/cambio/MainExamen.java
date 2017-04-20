package cambio;

import java.util.Arrays;

public class MainExamen {
	//Dados unos tipos de monedas con un nº infinito de ellas calcular el cambio de una cantidad en fordward y backward
	private static int []monedas={1,3,2,4};
	private static int cantidad=90;

	public static void main(String[] args){
		
		espejo(monedas);
		Examen e=new Examen(monedas,cantidad);
		System.out.println("Solucion fordward:");
		ford(e);
		System.out.println("Solucion backward: ");
		back(e);
	}

	static void reiniciar(int[]sol,int[]solopt){
		for(int i=0;i<solopt.length;i++){
			sol[i]=0;
		}
	}
	static void espejo(int[] data) {
		Arrays.sort(data);//ordenamos el array para conseguir la mejor solucion
		for (int left = 0, right = data.length - 1; left < right; left++, right--) {
			int temp = data[left];
			data[left]  = data[right];
			data[right] = temp;
		}
	}

	private static void ford(Examen e){
		int [] sol=new int[monedas.length];
		int [] solopt=new int[monedas.length];
		reiniciar(sol,solopt);
		System.out.println("Solución fordward");
		e.forward1(sol);
		printsol(sol);
	}
	private static void back(Examen e){
		int [] sol=new int[monedas.length];
		int [] solopt=new int[monedas.length];
		for(int i=0;i<solopt.length;i++){
			solopt[i]=999;
		}
		e.back(0, sol, solopt);
		printsol(solopt);
	}

	private static void printsol(int[]sol){
		System.out.println("El cambio para "+cantidad+" ha sido: ");
		for(int i=0;i<sol.length;i++){
			if(sol[i]==Integer.MAX_VALUE){
				System.out.println("No ha sido posible encontrar solucion");
				break;
			}
			System.out.println(sol[i]+" monedas de  "+monedas[i]);
		}
	}


}
