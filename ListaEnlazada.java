import java.util.NoSuchElementException;

public class ListaEnlazada<E>{
	NodoLE<E> inicio,
			  fin;
	private int size;
	
	public ListaEnlazada() {
		this.inicio=this.fin=null;
		this.size=0;
	}
	
	public ListaEnlazada(E[] valores) {
		this.inicio=new NodoLE<>(valores[0]);
		this.fin=new NodoLE<>(valores[valores.length-1]);
		this.size=valores.length;
		for(int i=1;i<valores.length-1;i++) {
			NodoLE<E> next=new NodoLE<>(valores[i+1]);
			new NodoLE<>(valores[i],next);
		}
	}
	
	public E borrarInicio() throws NoSuchElementException {
		try {
			E valor=this.inicio.valor;
			this.inicio=this.inicio.getNext();
			return valor;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede borrar el primer elemento de una lista vacía");
		}
	}
	
	public E inicio()throws NoSuchElementException {
		try {
			return this.inicio.valor;	
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el primer elemento de una lista vacía");
		}
	}
	
	public E fin() throws NoSuchElementException {
		try {
			return this.fin.valor;	
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el último elemento de una lista vacía");
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public void insertarInicio(E valor) {
		this.inicio=new NodoLE<E>(valor,this.inicio);
		if(this.fin==null) {
			this.fin=this.inicio;
		}
		this.size++;
	}
	
	public void insertarFin(E valor) {
		if(this.size>0) {
			NodoLE<E> nvo=new NodoLE<>(valor);
			this.fin.next=nvo=this.fin;
			this.size++;
		}else {
			this.insertarInicio(valor);
		}
	}
	
	public String toString() {
		String res="";
		NodoLE<E> current=this.inicio;
		for (int i = 0; i <this.size; i++) {
			res+=current.valor+",";
			current=current.next;
		}
		return res;
	}
	
	public void setAt(E valor, int pos) {
		if(pos>=0 && pos<this.size) {
			NodoLE<E> current=this.inicio;
			for(int i=0; i<pos;i++) {
				current=current.next;
			}
			current.setValor(valor);
		}else {
			throw new IndexOutOfBoundsException("No se puede cambiar la posición "+pos+" de una lista de tamaño "+size);
		}
	}
	
	public E borrarFin()throws NoSuchElementException {
		try {
			E valor=this.fin.valor;
			if(this.size>1) {
				NodoLE<E> current=this.inicio;
				for (int i = 0; i <this.size-2; i++) {
					current=current.next;
				}
				current.next=null;
				this.fin=current;
				this.size--;
				
			}else {
				this.inicio=this.fin=null;
			
			}
			return valor;
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede borrar el final de una lista vacia");
		}
	}
	
	
//-----------------------------------------------------------
	public static void main(String[] args) {
		ListaEnlazada<Integer> lista=new ListaEnlazada<>(new Integer[] {1,2,3,4,5,6});
		System.out.println(lista);
	}
}
//------------------------------------------------------------
class NodoLE<E>{
	E valor;
	NodoLE<E> next;
	
	public NodoLE(E valor) {
		this(valor,null);
	}
	
	public NodoLE(E valor, NodoLE<E> next) {
		this.valor = valor;
		this.next = next;
	}
	public E getValor() {
		return valor;
	}
	public void setValor(E valor) {
		this.valor = valor;
	}
	public NodoLE<E> getNext() {
		return next;
	}
	public void setNext(NodoLE<E> next) {
		this.next = next;
	}
	
	public String toString() {
		return this.valor.toString();
	}
	
}