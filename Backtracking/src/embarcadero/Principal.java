package embarcadero;


public class Principal {
	public static void main(String [] args){
		int [][] m=new int[4][4];
		m[0][0]=0;
		m[0][1]=1;
		m[0][2]=4;
		m[0][3]=6;
		m[1][0]=0;
		m[1][1]=0;
		m[1][2]=3;
		m[1][3]=3;
		m[2][0]=0;
		m[2][1]=0;
		m[2][2]=0;
		m[2][3]=1;
		m[3][0]=0;
		m[3][1]=0;
		m[3][2]=0;
		m[3][3]=0;
		Embarcadero e =new Embarcadero(m);
		
	}
}
