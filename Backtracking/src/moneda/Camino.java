package moneda;

import java.util.*;

/**
 *
 * @author Luis Ayuga
 */
public class Camino {
    //Atributos
    private List<Casilla> lista;
    private int Mostrados;
    
    //Constructor
    public Camino() {
        lista= new ArrayList<Casilla>();
        Mostrados=0;
    }
    
    //Devolver el numero de caminos impresos por pantalla
    public int getMostrados(){
        return Mostrados;
    }
    
    public int getsize() {
        return lista.size();
    }
    
    public int suma() {
        int sum = 0;
        for (int i = 0; i < lista.size(); i++) {
            sum += lista.get(i).getMonedas();
        }
        return sum;
    }
    
        
    //Insertar una casilla en el camino
    public void insertarCasilla(Casilla aux){
        lista.add(aux);
    }
    
    //Eliminar la ultima casilla introducida en el camino
    public void eliminarCasilla(){
        lista.remove(lista.size()-1);
    }
    
    //Devolver la casilla de la posicion pos
    public Casilla devolverCasilla(int pos){
        return lista.get(pos);
    }
    
    // Mostrar el camino de casillas
    @Override
    public String toString(){
        String texto="";
        if (Mostrados==0)
            System.out.println("LOS CAMINOS MINIMOS SON: ");
        this.Mostrados++;
        for(int i=0;i<lista.size();i++){
            texto+=lista.get(i).toString();
            if (i!=lista.size()-1)
                texto+=" --> ";
        }
        return texto;
    }
    
    public List<Casilla> getList() {
            return lista;
    }
    
    public void setList (List  lista) {
        this.lista=new ArrayList(lista);
    }

    void remove(int i) {
        lista.remove(i);
    }
}
