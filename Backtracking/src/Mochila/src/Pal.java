package Mochila.src;


public class Pal {
	public static void main (String [] args) {
		int [][] mochila = new int [2][4];
		mochila[0][0] = 10; //El objeto 0 pesa 10
		mochila[0][1] = 10;
		mochila[0][2] = 7;
		mochila[0][3] = 7;
		mochila[1][0] = 10; //El objeto 0 vale 5
		mochila[1][1] = 5;
		mochila[1][2] = 3;
		mochila[1][3] = 3;
		MochilaPD mpd=new MochilaPD(mochila,25);
		mpd.forwardSinMemo();
		mpd.backward();
	}
}
