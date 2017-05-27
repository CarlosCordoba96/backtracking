package Mochila.src;

import java.util.ArrayList;

public class MochilaPD {
	int[][] mochila;
	int capacidad;

	public MochilaPD(int[][] c,int cap){
		mochila=c;
		capacidad=cap;
	}
	public int capacidad(){return capacidad;}
	public int dim(){return mochila[0].length;}
	public int[] forwardSinMemo(){

		Cosa mejor=mejor(forwardSinMemoria());
		System.out.println(" mejor Sin Memo "+mejor+"\nforward sin memo");
		int[] sol=solucion(mejor);
		pinta(sol);
		return sol;
	}
	public void pinta(int[]v){
		int i;
		for(i=0;i<v.length;i++){
			System.out.print(v[i]);
		}
		System.out.println();
	}
	private Cosa mejor(ArrayList<Cosa> anchura){
		Cosa mejor=anchura.get(0);
		for(int n=1;n<anchura.size();n++)
			if(anchura.get(n).valor()>mejor.valor()
					) mejor=anchura.get(n);
		return mejor;
	}

	private int[] solucion(Cosa mejor){
		int[] sol=new int[dim()];
		Cosa ultimo=mejor;
		while(ultimo.vengo()!=null){
			sol[ultimo.nombre()]=ultimo.pongo();
			ultimo=ultimo.vengo();
		}
		return sol;
	}
	private ArrayList<Cosa> forwardSinMemoria(){
		ArrayList<Cosa> anchura=new ArrayList<Cosa>();
		anchura.add(new Cosa(-1,capacidad(),0,0,null));
		int pos=0;
		int objeto=-1;
		Cosa nuevo=null;
		while (pos<anchura.size()){
			Cosa actual=anchura.get(pos);
			objeto=actual.nombre()+1;
			if(objeto<dim()){
				for(int p=0;p<=1;p++){//adyacentes
					int nuevoPeso=actual.vCapacidad()-mochila[0][objeto]*p;
					if (nuevoPeso>=0){//cabe
						nuevo=new Cosa(objeto,nuevoPeso,actual.valor()+mochila[1][objeto]*p,p,actual);
						anchura.add(nuevo);
					}
				}//for
			}
			pos++;
		}
		return anchura;
	}
	public int[] backward(){
		int[] sol=new int[dim()];
		Cosa primer=new Cosa(-1,capacidad,0,0,null);
		primer=backward(primer,new ArrayList<Cosa>());
		sol=matriz(primer);
		System.out.println("backward...");
		pinta(sol);
		return sol;
	}
	private int[] matriz(Cosa primer){
		int[] sol=new int[dim()];
		Cosa p=primer;
		while(p.vengo()!=null){
			int pongo=p.pongo();
			p=p.vengo();
			sol[p.nombre()]=pongo;
		}
		return sol;
	}
	private Cosa backward(Cosa actual,ArrayList<Cosa> calculados){
		Cosa valor=null;
		if(calculados.contains(actual)){
			valor=calculados.get(calculados.indexOf(actual));
			// valor=actual.valor();MAL
		}
		else{
			int objeto=actual.nombre()+1;
			if(objeto<dim()){
				for(int p=0;p<=1;p++){
					int nuevoPeso=actual.vCapacidad()-mochila[0][objeto]*p;
					if (nuevoPeso>=0){
						Cosa nuevo=new Cosa(objeto,nuevoPeso,0,0,null);
						valor=backward(nuevo,calculados);
						if (valor.valor()+mochila[1][valor.nombre()]*p>actual.valor()){
							actual.valor(valor.valor()+mochila[1][valor.nombre()]*p);
							actual.pongo(p);
							actual.vengo(valor);
						}
					}
				}//for
			}
			valor=actual;
			calculados.add(actual);
		}
		return valor;
	}



}
