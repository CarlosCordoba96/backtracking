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

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantidad=10;
		int [][] monedas=new int[2][3];
		monedas[0][0]=1;
		monedas[0][1]=2;
		monedas[0][2]=4;
		monedas[1][0]=5;
		monedas[1][1]=3;
		monedas[1][2]=2;
		Cartera c=new Cartera(monedas,cantidad);
		c.forwardSinMemo();
	}
}
