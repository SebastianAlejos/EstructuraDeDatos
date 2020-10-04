import java.util.NoSuchElementException;

public class MyStack <E>{
	private ListaEnlazada<E> stack;
	
	public MyStack() {
		this.stack=new ListaEnlazada<>();
	}
	
	public int size() {
		return this.stack.size();
	}
	
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	
	public void flush() {
		this.stack=new ListaEnlazada<>();
		System.gc();
	}
	
	public void push(E valor) {
		this.stack.insertarInicio(valor);
	}
	
	public E pop() {
		try {
			return this.stack.borrarInicio();
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer pop de una pila vacía");
		}
	}
	
	public E top() {
		try {
			return this.stack.inicio();
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer top de una pila vacía");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
