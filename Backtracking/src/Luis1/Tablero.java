package Luis1;

public class Tablero {
	
	private Casilla [][] c;
	
	public Tablero(int n, int m){
		int i,j;
		c=new Casilla[n][m];
		for(i=0;i<n;i++){
			for(j=0;j<m;j++){
				c[i][j]=new Casilla(i,j);
			}
		}
		 alterartablero();
	}
	public Casilla[][] getC() {
		return c;
	}
	public void imprimirtablero(){
		int i,j;
		for(i=0;i<c.length;i++){
			for(j=0;j<c[i].length;j++){
				c[i][j].print();
			}
			System.out.println();
		}
	}
	public void alterartablero(){
		c[2][3].setTaken(true);
		c[3][2].setTaken(true);
		c[3][3].setTaken(true);
		c[2][2].setTaken(true);
		c[0][0].setTaken(true);
		c[0][1].setTaken(true);
		c[0][3].setTaken(true);
		c[1][4].setTaken(true);
		c[2][4].setTaken(true);
		c[10][10].setTaken(true);
		c[12][12].setTaken(true);
		c[10][11].setTaken(true);
		c[11][11].setTaken(true);
	}
	public Casilla casilla(int i, int j){
		return c[i][j];
	}
	public int altura(){
		return c.length;
	}
	public int columnas(){
		return c[0].length;
	}
	public void setvisited(int i,int j){
		c[i][j].setVisited(true);
	}
	
}
