package descomponer;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		descomponer d =new descomponer(17);
		LinkedList<Integer> sol=new LinkedList<Integer>();
		LinkedList<Integer> solopt=new LinkedList<Integer>();
		d.back( sol, solopt);
		d.imprimir(solopt);
	}

}
