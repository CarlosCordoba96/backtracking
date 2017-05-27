package embarcadero;

import java.util.ArrayList;

import map.City;

/*
 * Esta clase contiene la matriz de precios que es el dato de entrada como �nico atributo.
 * 
 * La primera vez Sol se tiene que copiar a SolOptima indistantemente de lo que tenga; en los dem�s casos se copia
 * s�lo si es mejor que la otra. Por tanto al inicializar Sol y SolOptima debe estar inicializada a -1 para poder interpretar
 * ese caso.
 * */
public class Embarcadero {
	private int precios[][];
	private ArrayList<Balsa> balsas;
	public Embarcadero(int precios [][]){
		this.precios=precios;
		Init();
	}
	
	//Apartado d)
	private void Init(){
		balsas = putBalsas();
		int [] Sol = new int[precios.length -1]; //Esta est� todo a 0, por lo que no es necesario inicializarla
		int [] SolOptima = new int[Sol.length];
		
		for(int i=0;i<Sol.length;i++){
			SolOptima[i]=-1;
		}
		Back(0,Sol,SolOptima); 
		
		//Una vez terminado el algoritmo tengo que mostrar el resultado
		for(int j=0;j<Sol.length;j++){
			System.out.print(SolOptima[j]+" ");
		}
		System.out.println("Precio: "+CalculaPrecioTotal(SolOptima));
		System.out.println(forward());
		System.out.println(backward(3));
	}
	
	private int CalculaPrecioTotal(int sol []){
		int suma=0;
		int fila=0;
		if(sol[0]==-1){
			suma=Integer.MAX_VALUE;
		}else{
			
			int i;
			for(i=0;i<sol.length - 1;i++){ //En un principio no tratamos la �ltima posici�n
				if(sol[i]==1){
					suma+=precios[fila][i+1];
					fila=i+1;
				}
			}
			//Ahora comprobamos si la �ltima es 1 y lo a�adimos
			suma+=precios[fila][sol.length ];
		}
		
		return suma;
	}
	
	private void Back(int etapa, int sol [], int SolOptima []){
		//Primero el caso base. Siempre es lo mismo. Esta estructura se suele repetir
		if(etapa==sol.length){
				if(esMejor(sol,SolOptima)){
					System.arraycopy(sol, 0, SolOptima, 0, SolOptima.length);
				}
		}else{
			//lo que diga el nivel es lo que tenemos que meter en el for
			for(int i=0; i<=1;i++){
				//Ahora la poda
				if(esPosible(sol,etapa,i)){
					sol[etapa]=i;
					Back(etapa+1,sol,SolOptima);
				}
			}
		}
	}
	
	private boolean esMejor(int sol [],int soloptima[]){
		return CalculaPrecioTotal(sol)<CalculaPrecioTotal(soloptima);
	}
	
	private boolean esPosible(int sol [], int etapa, int value){
		boolean posible = true;
		if(etapa==sol.length - 1){//Si estamos en la �ltima etapa
			if(value==0){
				posible=false;
			}
		}
		return posible;
		//Etapa apunta a DONDE VAMOS A ESCRIBIR, value = lo que quiero meter en etapa
	}
	private ArrayList<Balsa> getBalsas(){
		return balsas;
	}
	private Balsa forward(){
		int x=0;
		while(x<precios[0].length){
			Balsa b=getBalsas().get(x);
			ArrayList<Balsa>ady=adyacentes(b);
			for(int i=0;i<ady.size();i++){
				Balsa aux=ady.get(i);
				if(aux.getCost()==0|| b.getCost() + precios[b.getId()][aux.getId()]<aux.getCost()){
					aux.setCost(b.getCost() + precios[b.getId()][aux.getId()]);
					aux.setNext(b);
				}
			}		
		x++;	
		}
		return getBalsas().get(precios[0].length-1);
	}
	
	private Balsa backward(int n){
		Balsa b=getBalsas().get(n);
		if(b.getCost()==0){
			ArrayList<Balsa>ady=adyacentes(b);
			for(int i=0;i<ady.size();i++){
				Balsa aux=ady.get(i);
				if(aux.getCost()==0|| b.getCost() + precios[b.getId()][aux.getId()]<aux.getCost()){
					aux.setCost(b.getCost() + precios[b.getId()][aux.getId()]);
					aux.setNext(b);
				}
			}
			
		}		
		return b;
	}
	
	
	private ArrayList<Balsa> putBalsas(){
		ArrayList<Balsa> balsa = new ArrayList<Balsa>();
		for(int i = 0; i < precios[0].length; i++){
			balsa.add(new Balsa(i));
		}
		return balsa;
	}
	
	
	private ArrayList<Balsa> adyacentes (Balsa c){
		ArrayList<Balsa> adjacents = new ArrayList<Balsa>();
		for(int i = 0; i < precios[0].length; i++){
			if(precios[c.getId()][i] > 0)
				adjacents.add(balsas.get(i));
		}
		return adjacents;
	}
	
	
}
