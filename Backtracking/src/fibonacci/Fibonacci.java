package fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		int n=6;
		System.out.println("Fibonnaci backw "+n+" es : "+fiboback(n));
		System.out.println("Fibonnaci forw "+n+" es : "+fibofor(n));

	}

	public static int fiboback(int n){
		if(n<2){
			return 1;
		}else{
			return fiboback(n-1)+fiboback(n-2);
		}
	}
	
	public static int fibofor(int n){
		int f1=1,f2=1,f=1;
		if(n<=2){
			return f1;
			
		}else{
			for(int i=1;i<n;i++){
				f=f1+f2;
				f2=f1;
				f1=f;
			}
			return f;
		}
	}
	
	
	
}
