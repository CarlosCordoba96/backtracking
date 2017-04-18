package moneda;

/**
 *
 * @author Luis Ayuga
 */
public class Tablero {
    //Atributos
    private Casilla[][] tabla;
    
    //Constructor
    public Tablero(){
        tabla=new Casilla [8][8];
        InicializarTablero();
    }

    // Metodo para inicializar el tablero de casillas
    private void InicializarTablero() {
        for(int i=0; i<tabla.length;i++){
            for(int j=0; j<tabla[i].length;j++){
                tabla[i][j]=new Casilla(i,j);
            }
        }
    }
    
    // Metodo para devolver una Casilla del tablero
    public Casilla getCasilla(int i,int j){
        return tabla[i][j];    }
    
    // Metodo para comprobar si una casilla esta dentro del tablero
    public boolean estaDentro(Casilla aux){
        return aux.getFila() >=0 && aux.getFila()<=7 && aux.getColumna() >=0 && aux.getColumna()<=(7);
    }
    
    // Metodo para comprobar si una casilla del tablero esta a Visitado=true
    public boolean isVisitado(Casilla aux){
        return tabla[aux.getFila()][aux.getColumna()].isVisitado();
    }
    
    // Metodo para poner una casilla del tablero a Visitado
    public void setVisitado(Casilla aux){
        tabla[aux.getFila()][aux.getColumna()].setVisitado(true);
    }
    
    // Metodo para poner una casilla del tablero a NO Visitado
    public void setNoVisitado(Casilla aux){
        tabla[aux.getFila()][aux.getColumna()].setVisitado(false);
    }
    
    public boolean hayMonedas (Casilla aux) {
        return aux.getMonedas() != 0;
    }
    
    // Metodo para imprimir el tablero inicialmente
    public String toString (){
        String texto="\n TABLERO AJEDREZ \n\n";
        for(int i=0; i<tabla.length;i++){
            for(int j=0; j<tabla[0].length;j++){
               texto+= " ["+tabla[i][j].getFila()+","+tabla[i][j].getColumna()+"] ";
            }
            texto+="\n";
        }
        return texto;
    }
   
}
