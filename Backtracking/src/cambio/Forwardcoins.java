package cambio;
/**
 * @author Luis
 */
public class Forwardcoins {

   private static int [] monedas = {1,2,4};
    private static int [] cantidades = {5,3,2};
    
    public static void main(String[] args) {
           
        int devolucion = 10;
        int [][] m = new int [monedas.length][devolucion];
        generar_tabla (m , devolucion);
        printmatrix (m,devolucion);
    }                      
    
    public static void generar_tabla (int [][] m, int devolucion) {
        int valor = 0;
        int k = 0;
        int contador = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                k = i;
                while (valor != (j + 1)) {//Valor a obtener correspondiente a j
                    valor += monedas[k];
                    contador ++;
                    if (valor > (j + 1)|| contador>cantidades[k]) {//Valor a obtener correspondiente a j
                       if(k!=0){
                    	   valor -= monedas[k];
                           contador --;
                           k--;
                       }                    	
                    }
                }
                if (i == 0) {
                    m[i][j] = contador;
                    if(contador>cantidades[i]){
                    	m[i][j]=Integer.MAX_VALUE;
                    }
                } else if (contador <= m[i - 1][j ])
                    m[i][j] = contador;
                else
                    m[i][j]  = m[i - 1][j];
                valor = 0;
                contador = 0;
            }
        }
    }
    
    public static void printmatrix(int [][] m, int devolucion) {
        //tabla dinamica generada
        System.out.println("Matriz dinamica: (-1 significa que no hay suficientes monedas)\n");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j]==Integer.MAX_VALUE)
                    System.out.print("-1 ");
                else
                    System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        
        //resultado
        int totalmonedas = m[m.length-1][m[0].length-1]; // valor de la ultima fila ultima columna buscado
        int sol []; // soluciones generadas
        int total=0; //total acumulado 
        int cantidad=0; // cantidad de monedas
        int restantes=0; // para la cantidad de monedas que me quedan
        
        do {
            cantidad=0;
            sol=new int [monedas.length];
            total=0;
            for (int i=monedas.length-1;i>=0;i--) {
                restantes=cantidades[i];
                while ((total + monedas[i])<=devolucion && restantes>0) {
                    total+=monedas[i];
                    restantes--;
                    sol[i]++;
                    cantidad++;
                }            
            } 
        } while (cantidad != totalmonedas);
                    
        System.out.println("\nPara devolver " + devolucion + " ctmos se necesitan " + cantidad + " monedas de la siguiente forma:\n ");
               
        for (int i=0;i<sol.length;i++) {
            System.out.println (sol[i] + " monedas de "+ monedas[i] + " centimos" + " (max a utilizar " + cantidades[i]  + ")");
        }         
    }    
    
}
