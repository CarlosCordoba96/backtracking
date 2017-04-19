package cambio;

public class Main {
	//Dados unos tipos de monedas con un nº infinito de ellas calcular el cambio de una cantidad en fordward y backward
	private static int []monedas={5,2,1};
	private static int cantidad=22;
	
	public static void main(String[] args){
		int [] sol=new int[monedas.length];
		int [] solopt=new int[monedas.length];
		for(int i=0;i<solopt.length;i++){
			solopt[i]=Integer.MAX_VALUE;
		}
		Examen e=new Examen(monedas,cantidad);
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
