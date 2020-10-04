//Sebastian Alejos Acosta 
//A00344555
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashTable<K,V>{
	//Direccionamiento por encadenamiento
	private LinkedList<NodoHT<K,V>>[] tabla;
	private int size;
	
	public MyHashTable() {
		this(11);
	}
	
	public MyHashTable(int length) {
		this.tabla= (LinkedList<NodoHT<K,V>>[])new LinkedList[length];
		for (int i = 0; i < this.tabla.length; i++) {
			this.tabla[i]=new LinkedList<NodoHT<K,V>>();
		}
		this.size=0;	
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public boolean containsKey(K llave) {
		int pos=Math.abs(llave.hashCode()%this.tabla.length);
		LinkedList<NodoHT<K,V>>lista=this.tabla[pos];
		for (NodoHT<K,V> nodo:lista) {
			if(nodo.llave.equals(llave)) {
				return true;
			}
		}
	    return false;
	}

	
	private void rehashing() {
		 LinkedList<NodoHT<K, V>>[] tmp = this.tabla; 
	     this.tabla =(LinkedList<NodoHT<K,V>>[])new LinkedList[2 * this.size]; 
	     this.size = 0;
	     for (int i = 0; i < tmp.length; i++) {
	    	 LinkedList<NodoHT<K,V>>lista=tmp[i];
	    	 for (int j = 0; j < lista.size(); j++) { 
		    	 NodoHT<K, V> current=lista.get(j);
		    	 K llave = current.llave; 
		         V valor = current.valor; 
		         put(llave,valor); 
	    	 } 
	     }
	}

	
	public void put(K llave,V valor) {
		int pos=Math.abs(llave.hashCode()%this.tabla.length);
		this.tabla[pos].addFirst(new NodoHT<K,V>(llave, valor));
		this.size++;
	}
	
	public V get(K llave) {
		int pos=Math.abs(llave.hashCode()%this.tabla.length);
		LinkedList<NodoHT<K,V>>lista=this.tabla[pos];
		for (NodoHT<K,V> nodo:lista) {
			if(nodo.llave.equals(llave)) {
				return nodo.valor;
			}
		}
		throw new NoSuchElementException("No se encontró la llave "+llave+" en la tabla");
	}
	
	public V delete(K llave) {
		int pos=Math.abs(llave.hashCode()%this.tabla.length);
		LinkedList<NodoHT<K,V>>lista=this.tabla[pos];
		for (int i=0;i<lista.size();i++) {
			NodoHT<K, V> current=lista.get(i);
			if(current.llave.equals(llave)) {
				lista.remove(current);
	            this.size--;
	            return current.valor;
	         }
		}
		throw new NoSuchElementException("No se encontró la llave "+llave+" en la tabla");
	}
	
	
	
	public static void main(String[] args) {
		
	}

}

class NodoHT<K,V>{
	K llave;
	V valor;
	public NodoHT(K llave, V valor) {
		super();
		this.llave = llave;
		this.valor = valor;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
	public K getLlave() {
		return llave;
	}
	
}
