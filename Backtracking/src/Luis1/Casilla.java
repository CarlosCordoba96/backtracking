package Luis1;

public class Casilla {
	private int x;
	private int y;
	private boolean visited;
	private boolean taken;

	public Casilla(int x,int y){
		this.x=x;
		this.y=y;
		visited=false;
		taken=false;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public void print(){
		if(taken==true){
			System.out.print("* ");
		}else{
			System.out.print("O ");
		}
	}
	public String printcoordinates(){
		return "( "+ x+", "+y+" ) ";
	}
}
