
public class Fibonacci {
	public static long fibonacci(int n){
		if(n<=1){
			return 1;
		}else{
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	//Función de preparación
	public static long fibonacciOpt(int n) {
		long[]res=new long[n+1];
		res[0]=res[1]=1;
		return fibonacciOpt1(n,res);
	}
	
	private static long fibonacciOpt1(int n, long[] res) {
		if(res[n]!=0) {
		}else {
			res[n]=fibonacciOpt1(n-1,res)+fibonacciOpt1(n-2,res);
		}
		return res[n];
	}
	
	public static void main(String[] args) {
		long ini1 =System.nanoTime(),
				fin1;
		System.out.println(Fibonacci.fibonacciOpt(2000));
		fin1=System.nanoTime();
		System.out.println("Se tardó " + (fin1-ini1)/1000000000.0);
	}

}
