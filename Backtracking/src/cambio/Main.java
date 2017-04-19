package cambio;

public class Main {
	private static int []monedas={4,2};
	private static int cantidad=37;
	public static void main(String[] args) {
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
