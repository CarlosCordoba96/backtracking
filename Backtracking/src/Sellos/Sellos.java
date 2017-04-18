/*Diferentes tarifas postales (inventadas) {10, 5, 2, 1}
*5 sellos: Expresar todas las combinaciones desde 1 a 5 sellos.
*Mostrar todas las tarifas. Ej: 1,2,5,10, 2 1, 2 2, 5 1, 5 5, 10 1, 10 2, 10 5, 10 10, ... (el resto son ceros)
*
*Idea del algoritmo en pseudocódigo: Generar todas las posibilidades de 1 a 5.
Datos de entradad: Vector de tarifas de sellos y una variable caben, con los sellos que caben en el sobre.
Forma de la solución: Un vector de tamaño caben, que tiene en cada posición una tarifa. //las tarifas se pueden repetir.
Árbol de búsqueda: Niveles: 
 */

/*
Problema chungo: Que salga la solución con la puntuación más pequeña por encima de la solución.
*/

package Sellos;

public class Sellos {
    int [] tarifas;
    int nsellos;
    int maximo;
    
    public Sellos (int [] tarifas, int nsellos, int maximo) {
        this.tarifas = tarifas;
        this.nsellos = nsellos;
        this.maximo = maximo;
        int  [] sol = new int [nsellos];
        int  [] solopt = new int [nsellos];
        fillmax(solopt);
        back_sellos (0, sol, solopt);
        imprimirsol(solopt);
    }
    
    private void back_sellos (int etapa, int [] sol, int [] solopt) {
        int i;
        if (etapa == sol.length) {
            if (suma(sol) >= maximo) {
                if (esMejor(sol, solopt)) {
                    System.arraycopy(sol, 0, solopt, 0, sol.length);
                }
            }            
        } else {
            for (i = 0; i < sol.length; i++) {
                if (esPosible (etapa, sol, tarifas[i])) {
                    sol[etapa] = tarifas[i];
                    back_sellos (etapa + 1, sol, solopt);    
                }
            }
        }
    }
    
    private int suma (int [] sol) {
        int i;
        int valor = 0;
        for (i = 0; i < sol.length; i++) {
            valor += sol[i];
        }
        return valor;
    }
    
    private boolean esMejor (int [] sol, int [] solopt) {
        return suma(sol) < suma(solopt);
    }
    
    private void imprimirsol (int [] sol) {
        int i;
        System.out.print("La solución más cercana a " + maximo + " es: ");
        for (i = 0; i < sol.length; i++) {
            if (sol[i] != 0) {
                System.out.print(sol[i] + " ");
            }
        }
    }
    
    private boolean esPosible (int etapa, int [] sol, int valor) {
        int i = 0;
        boolean posible = true;
        if (etapa != 0 && valor > sol[etapa-1])             //Forma menos genérica pero mejor para este problema, revista con el inmediatamente anterior.
            posible =false;
        /*while (i < etapa && posible) {                    //Estructura general y correcta, pero menos óptima aquí. Revisas los anterior y no es necesario.
            if (sol[i] < valor) {
                posible = false;
            }
            i++;
        }*/
        return posible;
    }
    
    private void fillmax (int [] solopt) {
        int i;
        for (i = 0; i < solopt.length; i++) {
            solopt[i] = 10;
        }
    }
}
