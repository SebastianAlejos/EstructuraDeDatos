import java.util.NoSuchElementException;

public class MyABB<E extends Comparable<E>>{
	private MyNodoABB<E> raiz;
	private int size;
	
	public MyABB(){
		super();
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public E buscar(E valor) {
		MyNodoABB<E> current=this.raiz;
		while(current!=null) {
			if(valor.equals(current.dato)) {
				return current.dato;
			}else if(valor.compareTo(current.dato)<0) {
				current=current.izq;
			}else {
				current=current.der;
			}
		}
		throw new NoSuchElementException("No se puede regresar un elemento que no está en el árbol");
	}
	
	public void insertar(E valor) {
		if(this.isEmpty()) {
			this.raiz=new MyNodoABB<E>(valor);
			System.out.println(this.raiz);
		}else {
			MyNodoABB<E> current=this.raiz,
						  prev;
			while(current!=null) {
				prev=current;
				if(valor.compareTo(current.dato)<0) {
					current=current.izq;
					System.out.println(current);
				}else {
					current=current.der;
					System.out.println(current);
				}
				if(valor.compareTo(prev.dato)<0) {
					prev.izq=new MyNodoABB<E>(valor);
					System.out.println(current);
				}else {
					prev.der=new MyNodoABB<E>(valor);
					System.out.println(current);
				}
			}
		}
		this.size++;
		
	}
	
	//public E borrar() {
		//borrar un valor del arbol 
	//}
	
	private void preorden() {
		this.preorden(this.raiz);
		System.out.println();
	}
	
	private void preorden(MyNodoABB<E> current) {
		if(current!=null) {
			System.out.print(current.dato+",");
			preorden(current.izq);
			preorden(current.der);
		}
	}
	
	private void inorden() {
		this.inorden(this.raiz);
		System.out.println();
	}
	
	private void inorden(MyNodoABB<E> current) {
		if(current!=null) {
			inorden(current.izq);
			System.out.print(current.dato+",");
			inorden(current.der);
		}
	}

	
	public static void main(String[] args) {	
		MyABB<Integer> arbol=new MyABB<>();
		arbol.insertar(100);
		arbol.insertar(50);
		arbol.insertar(200);
		arbol.insertar(25);
		arbol.insertar(75);
		arbol.insertar(150);
		arbol.insertar(250);
		arbol.preorden();
		arbol.inorden();
	}
}
class MyNodoABB<E>{
	E dato;
	MyNodoABB <E> izq,
				  der;
	
	public MyNodoABB(E dato) {
		this(dato,null,null);
	}
	
	public MyNodoABB(E dato, MyNodoABB<E> izq,MyNodoABB<E> der) {
		this.dato=dato;
		this.izq=izq;
		this.der=der;
	}
	public String toString() {
		return this.dato.toString();
	}
}