import java.util.NoSuchElementException;

public class MyQueue<E>{
	private ListaEnlazada<E> cola;
	
	public MyQueue() {
		this.cola=new ListaEnlazada<>();
	}
	
	public int size() {
		return this.cola.size();
	}
	
	public boolean isEmpty() {
		return this.cola.isEmpty();
	}
	
	public void flush() {
		this.cola=new ListaEnlazada<>();
		System.gc();
	}
	
	public void enqueue(E valor) {
		this.cola.insertarFin(valor);
	}
	
	public E dequeue() throws NoSuchElementException{
		try {
			return this.cola.borrarInicio();
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException("No se puede borrar de una cola vacía");
		}
	}
	
	public E next() {
		try {
			return this.cola.inicio();
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException("No se puede obtener el siguiente elemento de una cola vacía");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
