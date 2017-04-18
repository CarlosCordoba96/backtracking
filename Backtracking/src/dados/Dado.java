package dados;

public class Dado {
private int tiradas;
private int ptossuperar;

public Dado(int tiradas,int ptossuperar){
	this.tiradas=tiradas;
	this.ptossuperar=ptossuperar;
	init();
}
public void init(){
	int [] v=new int[tiradas];
	backward(0,v,0);
}

public void backward(int etapa,int [] v,int suma){
	int i;
	if(etapa==tiradas){
		if(suma>ptossuperar){
			for(int j=0;j<v.length;j++){
				System.out.print(v[j]+" ");
			}
			System.out.println();
		}
	}else{
		for(i=0;i<=6;i++){
			
			v[etapa]=i;
			suma+=i;
			int poda=suma+(tiradas-(etapa+1))*6;
			if(poda>ptossuperar){
				backward(etapa+1,v,suma);
			}
			
			suma-=i;
			
			
		}//fin for
	}
	
}
private boolean esPosible(int suma,int etapa){
	boolean posible=false;
	if((suma+(tiradas-(etapa+1)*6))>ptossuperar){
		posible=true;
	}
	
	return posible;
}

}
