/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo2013;

import java.util.ArrayList;

/**
 *
 * @author Juan.Giralt
 */
public class GrafoNV<X> extends Grafo<X,Boolean>{
    public GrafoNV(int n,boolean dirigido){
        super(n,dirigido);
    }
    public GrafoNV(int n){
        super(n);
    }
    public void nuevoArco(X origen,X destino){
        super.nuevoArco(origen,destino,true);
    }
    public Boolean peso(X origen,X destino){
       return perteneceArco(origen,destino);
    }
   
    
}
