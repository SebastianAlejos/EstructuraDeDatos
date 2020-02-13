
public class Fibonacci {
	public static long fibonacci(int n){
		if(n<=1){
			return 1;
		}else{
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	public static void main(String[] args) {
		long ini =System.nanoTime(),
				fin;
		System.out.println(Fibonacci.fibonacci(100));
		fin=System.nanoTime();
		System.out.println("Se tardó " + (fin-ini)/1000000000.0);
	}

}
