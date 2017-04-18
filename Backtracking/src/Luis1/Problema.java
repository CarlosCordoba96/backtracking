package Luis1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Problema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero t =new Tablero(14,14);//Filas por columnass
		t.imprimirtablero();
		printsolution(contargrupos(t));
	}



	public static ArrayList<ArrayList> contargrupos(Tablero t){
		int n_grupos=0;
		ArrayList<ArrayList> grupos = new ArrayList();
		


		int i,j;
		for(i=0;i<t.getC().length;i++){

			
			for(j=0;j<t.getC()[i].length;j++){
				ArrayList prueba=new ArrayList();
				Casilla aux=new Casilla(i,j);
				if(t.casilla(i,j).isTaken()==true && t.casilla(i,j).isVisited()==false){
					t.casilla(i, j).setVisited(true);
					n_grupos++;
					grupos.add(recursivo(t, aux,prueba));
				}
				t.casilla(i, j).setVisited(true);
			}
			

		}
		
		

		return  grupos;
	}
	public static void printsolution(ArrayList<ArrayList> grupos){
		int actual=1;
		for(int k=0;k<grupos.size();k++){
			ArrayList<Casilla> aux= grupos.get(k);
			System.out.println("Grupo nº : "+ actual++);
			for(int p=0;p<aux.size();p++){
				System.out.print(aux.get(p).printcoordinates()+" ");
			}
			System.out.println();
		}
	}
	public static ArrayList recursivo(Tablero t,Casilla c,ArrayList grupo){
			t.casilla(c.getX(), c.getY()).setVisited(true);
			grupo.add(c);
		int i,j;
		for(i=-1;i<=1;i++){
			for(j=-1;j<=1;j++){
				if(c.getX()+i>=0 && c.getX()+i<t.altura() && c.getY()+j>=0 && c.getY()+j<t.columnas()){
					if( Math.abs(c.getX()-c.getX()-i)+Math.abs(c.getY()-c.getY()-j)==1 ){
							if( t.casilla(c.getX()+i,c.getY()+j).isVisited()==false && t.casilla(c.getX()+i,c.getY()+j).isTaken()==true ){
								Casilla aux=t.casilla(c.getX()+i,c.getY()+j);
								recursivo(t,aux,grupo);
								
							}
					}
				}
			}
		}


		return  grupo;
	}


}
