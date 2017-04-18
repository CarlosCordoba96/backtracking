package Mochila.src;


public class Pal {
	public static void main (String [] args) {
		Mochila m = new Mochila (18);
		int [] sol = {0, 0, 0};
		m.back (0, sol, sol);
		m.printSol(sol);
	}
}
