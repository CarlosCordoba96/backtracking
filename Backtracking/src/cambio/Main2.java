package cambio;

import java.util.Arrays;

public class Main2 {
	 //Dados unos tipos de monedas con un nº infinito de ellas calcular el cambio de una cantidad en fordward y backward
	 private static int []monedas={2,5,1};
	 private static int cantidad=22;
	 
	 public static void main(String[] args){
	  int [] sol=new int[monedas.length];
	  int [] solopt=new int[monedas.length];
	  for(int i=0;i<solopt.length;i++){
	   solopt[i]=Integer.MAX_VALUE;
	   sol[i]=0;
	  }
	  reverse(monedas);
	  Examen e=new Examen(monedas,cantidad);
	  e.forward(cantidad,monedas,sol);
	  printsol(sol);
	 }
	 
	 static void reverse(int[] data) {
		  Arrays.sort(data);
		     for (int left = 0, right = data.length - 1; left < right; left++, right--) {
		         // swap the values at the left and right indices
		         int temp = data[left];
		         data[left]  = data[right];
		         data[right] = temp;
		     }
		 }
	
	 
	 
	 private static void printsol(int[]sol){
	  System.out.println("El cambio para "+cantidad+" ha sido: ");
	  for(int i=0;i<sol.length;i++){
	//   if(sol[i]==Integer.MAX_VALUE){
//	    System.out.println("No ha sido posible encontrar solucion");
//	    break;
	//   }
	   System.out.println(sol[i]+" monedas de  "+monedas[i]);
	  }
	 }
	}
	 
