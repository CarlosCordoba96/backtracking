package descomponer;

import java.util.Arrays;
import java.util.LinkedList;

public class descomponer {
	private int num;
	private boolean solu;
	public descomponer(int n){
		num=n;
	}

	public LinkedList<Integer> back(LinkedList<Integer>ops,LinkedList<Integer> sol){
		solu=false;
		if(calcular(ops)==num&&solu==false){
			if(ops.size()<sol.size()||sol.size()==0){
				copiar(ops,sol);
				System.out.println(calcular(ops));
				solu=true;
			}
		}else if(solu==false){
			
				for(int i=0;i<=1&&solu==false;i++){
					if(esposible(ops,i,num)){
					ops.add(i);
					back(ops,sol);
					ops.remove(i);
				}
			}
			
		}
		return sol;
	}
	public void imprimir(LinkedList<Integer> sol){
		System.out.print(num+"=1 ");
		for(int i=0;i<sol.size();i++){
			int get=sol.get(i);
			if(get==0){
				System.out.print("*2 ");
			}else{
				System.out.print("/3 ");
			}
			
		}
	}
	private void copiar(LinkedList<Integer>ops,LinkedList<Integer>sol){
		for(int i=0;i<ops.size();i++){
			sol.add(ops.get(i));
		}
	}
	public boolean esposible(LinkedList<Integer>ops,int ameter, int num){
		LinkedList<Integer>aux=new LinkedList(ops);
		aux.add(ameter);
		if(calcular(aux)<=num+((num*2)/3)){
			return true;
		}else{
			return false;
		}
	}
	public int calcular(LinkedList<Integer> ops){
		int sol=1;
		
		for(int i=0;i<ops.size();i++){
			int op=ops.get(i);
			switch(op){
			case 0:
				sol=sol*2;
				break;
			case 1:
				sol=sol/3;
				break;
			}
			
		}
		
		return sol;
	}
}
