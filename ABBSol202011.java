//Sebastián Alejos Acosta
//A00344555
//25 de abril de 2020
//FAVOR DE NO BORRAR LOS COMENTARIOS
//NI MOVERLOS DE POSICIÓN
//Completa la firma de la clase
public class ABBSol202011<E extends Comparable<E>> extends ABBAbstract<E>{
	public ABBSol202011() {
		//Llama al constructor padre
		super();
	}
	
	//Implementar la inserción en el ABB. Puedes suponer que el valor
	//que se va a insertar no
	public void insertar(E valor) {
		System.out.println("Insertando "+valor);
		//Prueba este método en el main insertando los valores
		//{3969,904,2692,3474,393,2838,2006,1815,2973,4017,2760,4911,2271,3667,2726,3064,4889,4634,2386,4637,926,1143,3015,1125,100,2479,2288,2451,1577,3866,1370,3388,1375,1497,145,1947,1914,871,2645,2121,2584,3569,673,4452,496,3211,4307,4688,4920,2303};
		if(this.valores[0]==null) {
			this.valores[0]=valor;
			this.size++;
		}else {
			int pos=0;
			try {
				while(this.valores[pos]!=null){
					if(valor.compareTo(this.valores[pos])<0) {
						pos=(pos*2)+1;
					}else{
						pos=(pos*2)+2;						
					}
				}
				this.valores[pos]=valor;;
				size++;
			} catch (ArrayIndexOutOfBoundsException e) {
				this.expansion();
				this.valores[pos]=valor;
				size++;
			}
		}
	}
	
	//Aquí implementa la expansion del arreglo.
	//Se llamará sólo cuando la posicion donde se debe insertar un valor no existe
	protected void expansion() {
			E[] temporal;
			temporal=valores;
			int tamaño=this.valores.length*2+1;
			this.valores=(E[]) new Integer[tamaño];
			for(int i=0;i<temporal.length;i++) {
				if(temporal[i]!=null) {
					this.valores[i]=temporal[i];
				}
			}
	}

	//Funcion de preparación. Después de escribir todo el recorrido debe haber un salto de linea
	public void inorden() {
		int pos=0;
		this.inorden(pos);
		System.out.println("");
	}

	//Función recursiva que imprime el recorrido inorden del arbol separando cada elemento por una coma
	//y sin espacios en blanco
	protected void inorden(int pos) {
		try {
			if(valores[pos]!=null){
				int posmenor=(pos*2)+1;
				inorden(posmenor);
				System.out.print(valores[pos]+",");
				int posmayor=(pos*2)+2;
				inorden(posmayor);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
	}

	public static void main(String[] args) {
		//Haz una instancia de esta clase en la cual el genérico sea un Integer
		ABBSol202011<Integer> Abb=new ABBSol202011<>();
		
		//Inicializa un arreglo con los valores a insertar en el ABB.
		//(Descomentaría la siguiente línea y completala)
		Integer[] enteros={3969,904,2692,3474,393,2838,2006,1815,2973,4017,2760,4911,2271,3667,2726,3064,4889,4634,2386,4637,926,1143,3015,1125,100,2479,2288,2451,1577,3866,1370,3388,1375,1497,145,1947,1914,871,2645,2121,2584,3569,673,4452,496,3211,4307,4688,4920,2303};
		
		//Haz un ciclo para ir insertando los valores del arreglo en el ABB
		for(int i=0;i<enteros.length;i++) {
			Abb.insertar(enteros[i]);
		}
	}
}