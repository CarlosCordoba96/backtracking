package Inversiones.src;


public class Principal {
	public static void main(String []args){
		int[][] b;
		b=crearM();
		Banco bank = new Banco(b);
		bank.ejecutar();
	}
	public static int[][] crearM(){
		int[][]m=new int[4][4];
		m[0][0]=1;
		m[0][1]=2;
		m[0][2]=1;
		m[0][3]=1;
		m[1][0]=2;
		m[1][1]=5;
		m[1][2]=3;
		m[1][3]=4;
		m[2][0]=3;
		m[2][1]=6;
		m[2][2]=6;
		m[2][3]=5;
		m[3][0]=4;
		m[3][1]=7;
		m[3][2]=7;
		m[3][3]=8;
		return m;
	}
	public static void printM(int[][]m){
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				System.out.print(" "+i+j+" - "+m[i][j]);
			}
		}
	}
}