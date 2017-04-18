package moneda;

import java.util.Collections;

/*
Idea del algoritmo en pseudocódigo: Generar todas las combinaciones de movimiento, sumando sus monedas hasta que
se obtiene el número mínimo necesario. Así, nos quedamos con la que use menos movimientos posibles.
Datos de entrada y forma de la solución: Una matriz de 8x8 con una cantidad de monedas entre 0 y 5. La forma de la solución
es una lista de las casillas por las que has pasado hasta hallar la solución. La lista comienza vacía.
Árbol de búsqueda. Niveles y aristas: Cada nivel es uno de los movimientos realizados. Las aristas son los movimientos adjacentes no visitados  ni iguales a 0 monedas
*/

public class coin {
    int solution = 30;
    Tablero t;
    
    public void back (Casilla origen, Camino sol, Camino solopt) {            //suma es la que tienes a cada paso
        int i,j;
        Casilla aux;
        if (sol.suma() == solution) {
            if (esMejor(sol, solopt)) {
                solopt.setList(sol.getList());            //Al ser casillas/objetos y no arrays
            }
        } else {
            for (i = -1; i <= 1; i++) {
                for (j = -1; i <= 1; j++) {
                    aux = new Casilla (origen.getFila() + i, origen.getColumna() + j);
                    if (t.estaDentro(aux)) {
                        if (!t.isVisitado(aux) && t.hayMonedas(aux)) {
                            t.setVisitado(aux);
                            sol.getList().add(aux);
                            back (aux, sol, solopt);
                            t.setNoVisitado(aux);
                            sol.remove(sol.getsize()-1);
                        }
                    }
                }
            }
        }
    }
    
    private boolean esMejor (Camino sol, Camino solopt) {
        return sol.suma() > solopt.suma();
    }
    
   /* private int calcularmonedas (ArrayList<Casilla> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getvalue();
        }
        return sum;
    }*/
}
