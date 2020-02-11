public class Factorial {
	public long factorial(long number){
		if(number<=1){
			return 1;
		}else{
			return number*factorial(number-1);
		}
	}
	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.factorial(5));
	}
}