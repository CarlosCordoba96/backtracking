package embarcadero;


/*
 * Esta clase contiene la matriz de precios que es el dato de entrada como único atributo.
 * 
 * La primera vez Sol se tiene que copiar a SolOptima indistantemente de lo que tenga; en los demás casos se copia
 * sólo si es mejor que la otra. Por tanto al inicializar Sol y SolOptima debe estar inicializada a -1 para poder interpretar
 * ese caso.
 * */
public class Embarcadero {
	private int precios[][];
	
	public Embarcadero(int precios [][]){
		this.precios=precios;
		Init();
	}
	
	//Apartado d)
	private void Init(){
		int [] Sol = new int[precios.length -1]; //Esta está todo a 0, por lo que no es necesario inicializarla
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
	}
	
	private int CalculaPrecioTotal(int sol []){
		int suma=0;
		int fila=0;
		int i;
		for(i=0;i<sol.length - 1;i++){ //En un principio no tratamos la última posición
			if(sol[i]==1){
				suma+=precios[fila][i+1];
				fila=i+1;
			}
		}
		//Ahora comprobamos si la última es 1 y lo añadimos
		suma+=precios[fila][sol.length -1];
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
		if(etapa==sol.length - 1){//Si estamos en la última etapa
			if(value==0){
				posible=false;
			}
		}
		return posible;
		//Etapa apunta a DONDE VAMOS A ESCRIBIR, value = lo que quiero meter en etapa
	}
}
