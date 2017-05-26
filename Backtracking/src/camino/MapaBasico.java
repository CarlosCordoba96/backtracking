package camino;

import java.util.ArrayList;

public class MapaBasico {
	private Grafo<Ciudad,Integer> mapa;

	public class Ciudad{

		int nombre;
		int coste;
		Ciudad vieneDe;
		Ciudad(int n){
			nombre=n;
			coste=99999;
			vieneDe=null;
		}
		public int coste(){ return coste; }
		public void coste(int c){ coste=c; }
		public Ciudad vieneDe(){ return vieneDe;}
		public void vieneDe(Ciudad c){vieneDe=c;}
		public boolean equals(Object c){
			return (c instanceof Ciudad) && ((Ciudad)c).nombre==nombre;
		}
		public String toString(){
			return nombre+" coste "+coste()+" vieneDe "+vieneDe();
		}
		public void inicializar(){
			
			Ciudad c1= new Ciudad(1);
		}
	}//Ciudad
	
	
	
	public void forward(Ciudad primera){//recorrido anchura
		ArrayList<Ciudad> anchura=new ArrayList<Ciudad>();
		primera.coste(0);
		anchura.add(primera);
		ArrayList<Ciudad> Ciudades=mapa.vertices();
		int c=0;
		while(c<Ciudades.size()){//recorrrido en anchura
			Ciudad estoy=anchura.get(c);
			ArrayList<Ciudad> ady=mapa.adyacentes(estoy);
			for(int k=0;k<ady.size();k++){
				Ciudad voy=ady.get(k);
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
	public int backward(Ciudad estoy,ArrayList<Ciudad> visitados){//recorrido profundidad
		visitados.add(estoy);
		if(!calculado(estoy)){
			ArrayList<Ciudad> ady=mapa.adyacentes(estoy);
			if (ady.isEmpty()) estoy.coste(0);//ultimo vertice
			else
				for(int k=0;k<ady.size();k++){
					Ciudad voy=ady.get(k);
					int costo=backward(voy,visitados);
					if (mejor(costo+mapa.peso(estoy,voy), estoy.coste())){
						estoy.coste(costo+mapa.peso(estoy,voy));
						estoy.vieneDe(voy);
					}
				}
		}
		return estoy.coste();
	}//back
	
	public boolean calculado(Ciudad c){
		return c.coste()<99999;
		}
}
