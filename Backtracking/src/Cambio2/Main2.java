package Cambio2;
import java.util.ArrayList;

/*
 *a)	Idea del algoritomo en pseudocodigo: 
 *  Hacer todas las combinaciones posibles de monedas que sumen la cantidad N y quedarnos con la solucion que menos monedas utilicemos.
 *
 *b)	Datos de entrada y forma de la solucion:
 *	- Vector de monedas,Cantidad N
 *	- Se muestra un ArrayList de monedas que suman la cantidad N.
 c) Arbol de busqueda

	
*/

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantidad=16;
		ArrayList<Integer> monedas= new ArrayList<Integer>();
		monedas.add(5);
		monedas.add(2);
		monedas.add(1);
		new Maquina(cantidad,monedas);
	}
}
