package libros;

/**
 *
 * @author Alvaro
 */
public class Libros {
        private int [][] seguidores;

        public Libros (int [][] seguidores) {
                this.seguidores = seguidores;
                inicializar();
        }

        public void inicializar () {
                int [] sol = new int [seguidores.length];
                int [] solopt = new int [seguidores.length];
                solopt [0] = -1;
                solopt [1] = -1;
                solopt [2] = -1;
                libros (0, sol, solopt);
                imprimirvector (solopt);
        }

        public static void main (String [] args) {
                new Libros(cargardatos());
        }

        public static int [][] cargardatos() {
                int [][] m = new int [3][4];
                m [0][0] = 10;	m [0][1] = 8;	m [0][2] = 5;	m [0][3] = 7;
                m [1][0] = 8;	m [1][1] = 7;	m [1][2] = 6;	m [1][3] = 6;
                m [2][0] = 12;	m [2][1] = 6;	m [2][2] = 2;	m [2][3] = 10;

                return m;
        }
        
        public void libros (int etapa, int [] sol, int [] solopt) {
            int i;
            if (etapa == sol.length) {
                if (esMejor (sol, solopt)) {
                    System.arraycopy(sol, 0, solopt, 0, sol.length);
                }
            } else {
                for (i = 0; i <= 3; i++) {
                    if (esPosible(sol, etapa, i)) {
                        sol[etapa] = i;
                        libros (etapa + 1, sol, solopt);
                    }
                }
            }
        }
        
        private boolean esMejor (int [] sol, int [] solopt) {
            int value = 0; int valueopt = 0;
            
            for (int j = 0; j < sol.length; j++) {
                value += seguidores[j][sol[j]];
                if (solopt[j] == -1) {
                    valueopt += 0;
                } else
                valueopt += seguidores[j][solopt[j]];
            }
            return (value > valueopt);
        }
        
        private boolean esPosible (int [] sol, int etapa, int i) {
            boolean found = false;
            int k = 0;
            while (k < etapa && !found) {
                if (sol[k] == i) {
                    found = true;
                }
                k++;
            }
            return !found;
        }
        
        public void imprimirvector (int [] v) {
            System.out.print("The solution vector is:");
            for (int i = 0; i < v.length; i++) {
                System.out.print(" " + v[i]);
            }
            System.out.print(".");
        }
}
