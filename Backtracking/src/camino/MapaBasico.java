package camino;

import java.util.ArrayList;

public class MapaBasico {
	private Grafo<ciudad,Integer> mapa;

	class ciudad{

		int nombre;
		int coste;
		ciudad vieneDe;
		ciudad(int n){
			nombre=n;
			coste=99999;
			vieneDe=null;
		}
		public int coste(){ return coste; }
		public void coste(int c){ coste=c; }
		public ciudad vieneDe(){ return vieneDe;}
		public void vieneDe(ciudad c){vieneDe=c;}
		public boolean equals(Object c){
			return (c instanceof ciudad) && ((ciudad)c).nombre==nombre;
		}
		public String toString(){
			return nombre+" coste "+coste()+" vieneDe "+vieneDe();
		}
	}//ciudad
	public void forward(ciudad primera){//recorrido anchura
		ArrayList<ciudad> anchura=new ArrayList<ciudad>();
		primera.coste(0);
		anchura.add(primera);
		ArrayList<ciudad> ciudades=mapa.vertices();
		int c=0;
		while(c<ciudades.size()){//recorrrido en anchura
			ciudad estoy=anchura.get(c);
			ArrayList<ciudad> ady=mapa.adyacentes(estoy);
			for(int k=0;k<ady.size();k++){
				ciudad voy=ady.get(k);
				if(!anchura.contains(voy)){
					anchura.add(voy);
				}
				if (mejor(estoy.coste()+mapa.peso(estoy,voy),voy.coste())) {
					voy.coste(estoy.coste()+mapa.peso(estoy,voy));
					voy.vieneDe(estoy);
				}
			}
			c++;
		}
	}//forward

	private boolean mejor(int a,int b){
		return a<b;
	}
	public int backward(ciudad estoy,ArrayList<ciudad> visitados){//recorrido profundidad
		visitados.add(estoy);
		if(!calculado(estoy)){
			ArrayList<ciudad> ady=mapa.adyacentes(estoy);
			if (ady.isEmpty()) estoy.coste(0);//ultimo vertice
			else
				for(int k=0;k<ady.size();k++){
					ciudad voy=ady.get(k);
					int costo=backward(voy,visitados);
					if (mejor(costo+mapa.peso(estoy,voy), estoy.coste())){
						estoy.coste(costo+mapa.peso(estoy,voy));
						estoy.vieneDe(voy);
					}
				}
		}
		return estoy.coste();
	}//back
	
	public boolean calculado(ciudad c){
		return c.coste()<99999;
		}
}
