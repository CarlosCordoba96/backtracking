package camino;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Juan.Giralt
 */
public class Grafo<X,Y> {
    public class arco<X,Y> implements Comparable<arco<X,Y>>{
        X origen,destino;
        Y peso;
        arco (X o,X d,Y p){
            origen=o;destino=d;peso=p;
        }
        public X origen(){
            return origen;
        }
        public X destino(){
            return destino;
        }
        public Y peso(){
            return peso;
        }
        public int compareTo(arco<X,Y> ob){
            int m=0;
            try{
                m=((Comparable)peso).compareTo(ob.peso);
            }
            catch(Exception e){
                m=0;
            }
            return m;
        }
        public boolean equals(Object a){
            boolean iguales=a instanceof arco;
            if(iguales){
                arco aa=(arco)a;
                iguales=origen().equals(aa.origen()) && destino().equals(aa.destino());
            }
            return iguales;
        }
       public String toString(){
            return "<"+origen.toString()+","+destino+","+peso+">";
        }
    }//arco
    X[] vertices;
    Y[][] arcos;
    boolean dirigido;
    
    
    public Grafo(int numVertices,boolean dirigido){
        if (numVertices<=0) numVertices=10;
        vertices=(X[]) new Object[numVertices];
        arcos=(Y[][]) new Object[numVertices][numVertices];
        this.dirigido=dirigido;
    }
     public Grafo(int numVertices){
         this(numVertices,false);
     }
     public boolean dirigido(){
         return dirigido;
     }
     public boolean esVacio(){
         boolean vacio=true;
         for(int n=0;n<vertices.length && vacio;n++) 
             if(vertices[n]!=null) vacio=false;
         return vacio;
     }
     public void nuevoVertice(X v){
         int hueco=hayHueco();
         if(hueco>-1 && posVertice(v)==-1) vertices[hueco]=v;
         else System.out.print("esta lleno o ya esta");
     }
     public void nuevoArco(X origen,X destino,Y peso){
         int posOr=posVertice(origen);
         int posDest=posVertice(destino);
         if(posOr==-1 || posDest==-1) 
             System.out.println(origen+" o "+destino+" no existen");
         else{
             arcos[posOr][posDest]=peso;
             if(!dirigido) arcos[posDest][posOr]=peso;
         }
     }
     public void eliminaArco(X origen, X destino){
         int posOr=posVertice(origen);
         int posDest=posVertice(destino);
         if(posOr==-1 || posDest==-1) 
             System.out.println(origen+" o "+destino+" no existen");
         else{
             arcos[posOr][posDest]=null;
             if(!dirigido) arcos[posDest][posOr]=null;
         }
     }
             
     public void eliminaVertice(X v){
         int pos=posVertice(v);
         if(pos!=-1){
             for(int f=0;f<vertices.length;f++){
                 arcos[f][pos]=null;//eliminaArco(vertices[pos],vertices[f])
                 arcos[pos][f]=null;//eliminaArco(vertices[f],vertices[pos])
             }
             vertices[pos]=null;
         }
     }
     public ArrayList<X> vertices(){
         ArrayList<X> vert=new ArrayList<X>();
         for(int f=0;f<vertices.length;f++){
             if(vertices[f]!=null) vert.add(vertices[f]);
         }
         return vert;
     }
     public ArrayList<arco<X,Y>> arcos(){
         ArrayList<arco<X,Y>> arc=new ArrayList<arco<X,Y>>();
         for(int f=0;f<vertices.length;f++)
             for(int c=0;c<vertices.length;c++){
                if(arcos[f][c]!=null){
                    if(dirigido || f<=c){
                     arco aux=new arco(vertices[f],vertices[c],arcos[f][c]);
                    arc.add(aux);
                    }
                }
            }
         return arc;
     }
     public ArrayList<X[]> verticesArco(){//devuelve solo los vertices
         ArrayList<X[]> arc=new ArrayList<X[]>();
         for(int f=0;f<vertices.length;f++)
             for(int c=0;c<vertices.length;c++){
                if(arcos[f][c]!=null){
                    if(dirigido || f<=c){
                     X[] aux=(X[]) new Object[2];
                     aux[0]=vertices[f];aux[1]=vertices[c];
                    arc.add(aux);
                    }
                }
            }
         return arc;
     }
     public ArrayList<X> adyacentes(X v){
           ArrayList<X> vert=new ArrayList<X>();
           int pos=posVertice(v);
           if(pos>-1){
               for(int col=0;col<vertices.length;col++)
                   if(arcos[pos][col]!=null) vert.add(vertices[col]);
           }
           return vert;
     }
      public ArrayList<X> incidentes(X v){
           ArrayList<X> vert=new ArrayList<X>();
           int pos=posVertice(v);
           if(pos>-1){
               for(int fil=0;fil<vertices.length;fil++)
                   if(arcos[fil][pos]!=null) vert.add(vertices[fil]);
           }
           return vert;
     }
      public Y peso(X origen,X destino){
          Y peso=null;
         int posOr=posVertice(origen);
         int posDest=posVertice(destino);
         if(posOr==-1 || posDest==-1) System.out.println(origen+" o "+destino+" no existen");
         else {
             if(arcos[posOr][posDest]==null) System.out.println("No existe el arco "+origen+"-"+destino+". Devuelvo null");
             else peso=arcos[posOr][posDest];
         }
         return peso;
      }
      public boolean perteneceVertice(X v){
          return posVertice(v)!=-1;
      }
      public boolean perteneceArco(X origen,X destino){
         boolean esta=true;
          int posOr=posVertice(origen);
         int posDest=posVertice(destino);
         if(posOr==-1 || posDest==-1||arcos[posOr][posDest]==null) esta=false;
         return esta;
      }
     
     private int posVertice(X v){
         int pos=-1;
         for (int n=0;n<vertices.length && pos==-1;n++)
             if(vertices[n]!=null && vertices[n].equals(v)) pos=n;
         return pos;
     }
     private int hayHueco(){
          int pos=-1;
         for (int n=0;n<vertices.length&& pos==-1;n++)
             if(vertices[n]==null) pos=n;
         return pos;
     }
     @Override public String toString(){
         String s="Grafo dirigido "+dirigido+"\n";
         s=s+String.format("%10s", "");
         for(int v=0;v<vertices.length;v++) if(vertices[v]!=null) s=s+String.format("%10s", vertices[v]);
         for(int f=0;f<vertices.length;f++){
             if(vertices[f]!=null){
             s=s+"\n"+String.format("%10s", vertices[f]);
             for(int c=0;c<vertices.length;c++){
                    if(vertices[c]!=null){
                            if(arcos[f][c]==null) s=s+String.format("%10s", "-");
                            else s=s+String.format("%10s", arcos[f][c]);
                     }
                 }
             }
         }
          return s+"\n";   
     }
   
}
