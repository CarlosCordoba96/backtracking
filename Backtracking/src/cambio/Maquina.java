package cambio;

import java.util.ArrayList;

public class Maquina {
	ArrayList<Integer> monedas;
	int cantidad;
	ArrayList<Integer> solOp;
	
	public Maquina( int cantidad, ArrayList<Integer> monedas){
		this.cantidad=cantidad;
		this.monedas=new ArrayList<Integer>(monedas);
		this.solOp=new ArrayList<Integer>();
		iniciar();
	}
	
	public void iniciar(){
		ArrayList<Integer> sol= new ArrayList<Integer>();		
		back(sol);	
		imprimir(solOp);
	}
	
	public void back(ArrayList<Integer> sol){		
		if(esSolucion(sol)){
			if(esMejor(sol)){				
				solOp = new ArrayList<Integer>(sol);				
			}			
		}else{			
			for(int i=0;i<monedas.size();i++){
				if(esPosible(sol,monedas.get(i))){
					sol.add(monedas.get(i));
					back(sol);
					sol.remove(sol.size()-1);
				}
			}
		}
	}
	
	public boolean esPosible(ArrayList<Integer> sol, int plus){
		int suma=0;
		ArrayList<Integer> vector = new ArrayList<Integer>(sol);		
		for(int i=0; i < vector.size() ;i++){
			suma = suma+ vector.get(i);
		}
		suma += plus;
		return (suma<=cantidad);
	}
	
	
	public boolean esSolucion(ArrayList<Integer> sol){
		int suma=0;
		ArrayList<Integer> vector = new ArrayList<Integer>(sol);		
		for(int i=0; i < vector.size() ;i++){
			suma = suma+ vector.get(i);
		}
		return (suma==cantidad);
	}	
	
	public boolean esMejor(ArrayList<Integer> sol){
		ArrayList<Integer> csol= new ArrayList<Integer>(sol);

		if(solOp.size()!=0){
			return (csol.size()<solOp.size());
		}else{
			return true;
		}
	}
	
	public void imprimir(ArrayList<Integer> sol){
		ArrayList<Integer> vector = new ArrayList<Integer>(sol);
		String cad="[ ";
		
		for(int i=0; i<vector.size();i++){
			cad = cad+ vector.get(i)+" ";
		}		
		System.out.println(cad+"]");
	}
}
