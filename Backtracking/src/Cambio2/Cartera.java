package Cambio2;

import java.util.ArrayList;

public class Cartera {
	private int [][] cartera;
	private int cantidad;
	public Cartera(int [][] c,int cant){
		cartera=c;
		cantidad=cant;
	}
	public int cantidad(){
		return cantidad;
	}
	public int dim(){
		return cartera[0].length;
	}
	public int[] forwardSinMemo(){

		Moneda mejor=mejor(forwardSinMemoria());
		System.out.println(" mejor Sin Memo "+mejor+"\nforward sin memo");
		int[] sol=solucion(mejor);
		//pinta(sol);
		return sol;
	}
	private Moneda mejor(ArrayList<Moneda> anchura){
		Moneda mejor=new Moneda(-1,cantidad(),max(),9999,null);
		for(int n=1;n<anchura.size();n++){
			//System.out.println("Contarmonedas : "+anchura.get(n).contarmonedas() +" y "+ mejor.contarmonedas());
			if(anchura.get(n).getCantidad()==0 && anchura.get(n).contarmonedas()>0 && anchura.get(n).contarmonedas()<mejor.contarmonedas()){
				//System.out.println(anchura.get(n));
				//System.out.println("Contar monedas; "+anchura.get(n).contarmonedas());
				mejor=anchura.get(n);
			}
				
		}
			
		return mejor;
	}
	private int max(){
		int max=cartera[0][0];
		for(int i=0;i<cartera[0].length;i++){
			if(cartera[0][i]>max){
				max=cartera[0][i];
			}
			
		}
		return max;
	}
	public void pinta(int[]v){
		int i;
		for(i=0;i<v.length;i++){
			System.out.print(v[i]);
		}
		System.out.println();
	}
	private int[] solucion(Moneda mejor){
		int[] sol=new int[dim()];
		Moneda ultimo=mejor;
		while(ultimo.vengo()!=null){
			System.out.println(ultimo.getValor()+" de monedas de "+cartera[0][ultimo.getNombre()]);
			sol[ultimo.getNombre()]=ultimo.getNumero();
			ultimo=ultimo.vengo();
		}
		return sol;
	}
	private ArrayList<Moneda> forwardSinMemoria(){
		ArrayList<Moneda> anchura=new ArrayList<Moneda>();
		anchura.add(new Moneda(-1,cantidad(),max(),Integer.MAX_VALUE,null));
		int pos=0;
		int objeto=-1;
		Moneda nuevo=null;
		while (pos<anchura.size()){
			Moneda actual=anchura.get(pos);
			objeto=actual.getNombre()+1;
			if(objeto<dim()){
				for(int p=0;p<dim();p++){//adyacentes
					
						for(int i=0;i<=cartera[1][p];i++){
							
							int nuevoPeso=actual.getCantidad()-cartera[0][p]*i;
							if (nuevoPeso>=0){//cabe
								nuevo=new Moneda(objeto,nuevoPeso,cartera[0][p],i,actual);
								anchura.add(nuevo);
							}
						
						
					}
					
				}//for
			}
			
			pos++;
		}
		return anchura;
	}
}
