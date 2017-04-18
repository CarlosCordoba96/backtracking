package moneda;

/**
 *
 * @author Luis Ayuga
 */
public class Casilla {
    // Atributos
    private int fila,columna;
    private boolean visitado;
    private int monedas;
    
    // Constructor
    public Casilla(int fila,int columna){
        this.fila=fila;
        this.columna=columna;
        this.visitado=false;
    }

    // Devolver una fila
    public int getFila() {
        return fila;
    }

    // Poner una valor fila
    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public int getMonedas() {
        return monedas;
    }
    
    public void takeMonedas() {
        monedas = 0;
    }

    // Devolver una columna
    public int getColumna() {
        return columna;
    }

    // Poner una valor columna
    public void setColumna(int columna) {
        this.columna = columna;
    }

    // Devolver si una casilla esta Visitada
    public boolean isVisitado() {
        return visitado;
    }

    // Poner una casilla a visitado true o false
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    // Metodo que comprueba si hay comunicación en diagonal entre dos casillas		//Sólo se usa para alfil (el resto sí pueden, menos peón)
//    public boolean existeCamino(Casilla casilla){
//        return((casilla.getColumna()+casilla.getFila())%2 == (getColumna()+getFila())%2);
//    }
    
    // Devuelve la distancia Manhattan entre dos casillas
    public int distanciaM(Casilla c) {
        return Math.max(Math.abs(getFila()-c.getFila()),Math.abs(getColumna()-c.getColumna()));
    }
    
    // Compara dos objetos casilla
    @Override
    public boolean equals(Object obj) {
        Casilla c=(Casilla) obj;
        if(getColumna()==c.getColumna() && getFila()==c.getFila()){
            return true;
        }
        return false;
    }

    // Muestra las coordenadas de una casilla
    @Override
    public String toString() {
        return "(" + getFila() + "," + getColumna() + ')';
    }   
}