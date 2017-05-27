package map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] distances = {{0,0,0,0,0,0,0,0},{0,0,5,7,0,0,0,0},{0,0,0,0,5,0,0,0},
				{0,0,0,0,4,0,0,0},{0,0,0,0,0,8,9,0},{0,0,0,0,0,0,0,6},{0,0,0,0,0,0,0,3},
				{0,0,0,0,0,0,0,0}};
		print(distances);
		Map map = new Map(distances);
		System.out.println("Backward: " + map.backwardSolution(1));
		System.out.println();
		System.out.println("Forward: " + map.forwardSolution());
	}
 public static void print(int [][]m){
	 for(int i=0;i<m.length;i++){
		 for(int j=0;j<m[i].length;j++){
			 System.out.print(m[i][j]+" ");
		 }
		 System.out.println();
	 }
 }
}
