import java.util.NoSuchElementException;

public class MyHeap<E extends Comparable<E>> {
	private E[] values;
	private int size; //Representa cu�ntos elementos hay guardados en el Heap
	
	public MyHeap(int length) {
		this.values=(E[])new Comparable[length];
		this.size=0;
	}
	
	public MyHeap(E[] data) {//Suponer que el arreglo se recibe lleno
		this.values=data;
		heapify();
		this.size=data.length;
	}
	
	public MyHeap() {
		this(10);
	}
	
	public void heapify() {
		//O(nlog(n))
		pos=0;
		heapify(pos);
	}

	private void heapify(int pos) { 
		int posmayor=pos;
        int izq = 2*i + 1; 
		int der = 2*i + 2; 
		
        if (izq < this.size && this.values[izq].compareTo(values[posmayor])>0){
            posmayor = izq; 
		}
       
        if (der < this.size && this.values[der].compareTo(values[posmayor])>0){
            posmayor=der; 	
		}
        if (posmayor != pos){ 
            int tmp = this.values[pos]; 
            this.values[pos] = this.values[posmayor]; 
            this.values[posmayor] = tmp; 
            heapify(posmayor); 
        } 
	}

	
	
	public int getSize() {
		return this.size;
	}
	
	
	public void insert(E data) {
		//O(log(n))
		if(this.values[size-1]!=null) {
			E[] tmp=(E[])new Comparable[this.size*2];
			//Pasar todos los elementos de values a tmp
			for (int i = 0; i < this.values.length; i++) {
				tmp[i]=this.values[i];
			}
			this.values=tmp;
		}
		this.values[this.size]=data;
		heapify();
		this.size++;
	}

	public E remove() {
		//O(log(n))
		if(this.size>0) { 
			 int ultimo= this.values[this.size-1]; 
			 // Replace root with first element 
			 this.values[0]=ultimo; 
			 this.size=this.size-1; 
	   		 heapify(); 
		}
		else {
			throw new NoSuchElementException("No se puede borrar de un Heap vacio");
		}
	}
	
	public String toString() {
		String res="";
		for(int i=0;i<this.size;i++) {
			res+=this.values[i]+",";
		}
		return res;
	}
}
