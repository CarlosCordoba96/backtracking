package descomponer;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		int prueba=1*2*2*2*2/3*2/3*2;
		descomponer d =new descomponer(prueba);
		LinkedList<Integer> sol=new LinkedList<Integer>();
		LinkedList<Integer> solopt=new LinkedList<Integer>();
		d.back( sol, solopt);
		d.imprimir(solopt);
	}

}
