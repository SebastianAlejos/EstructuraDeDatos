import java.util.NoSuchElementException;

public class EvaluacionParentesis {
	
	public static boolean evaluacionParentesis(String exp) {
		try {
		MyStack<String> pila=new MyStack<>();
		String[] tokens=exp.split(" ");
		String pop;
		for (String t:tokens) {
			switch(t) {
				case "(":
				case "[":
				case "{":
					pila.push(t);
					break;
				case ")":
					pop=pila.pop();
					if(!"(".equals(pop)) {
						System.out.println("No hacía match");
						return false;
					}
					break;
				case "]":
					pop=pila.pop();
					if(!"[".equals(pop)) {
						System.out.println("No hacía match");
						return false;
					}
					break;
				case "}":
					pop=pila.pop();
					if(!"{".equals(pop)) {
						System.out.println("No hacía match");
						return false;
					}	
					break;
			}
		}
		return pila.isEmpty();
		}catch(NoSuchElementException e) {
			System.out.println("El parentesis no tiene quien lo abra");
			return false;
		}
	}
	
	public static void main(String[] args) {
		String expresion="{ ( 5 + [ ( 6 + 2 ) * 3 ] ) / 4 } + ( 8 * 2 ) ";
		System.out.println(evaluacionParentesis(expresion));
	}

}
