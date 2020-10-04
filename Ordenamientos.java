public class Ordenamientos {
	public static <E extends Comparable<E>>void bubbleSort(E[] datos){
		for (int i = 0; i < datos.length-1; i++){
			for (int j = 0; j<datos.length-1-i; j++){
				if(datos[j].compareTo(datos[j+1])>0) {
					swap(datos,j,j+1);
				}
			}
		}
	}
	//-------------------------------------------------------------------------------------
	
	private static <E extends Comparable<E>> void mezcla(E[]datos, int primero, int ultimo) {
		//El arreglo datos está ordenado desde primero hasta central y de central+1 hasta último
		//pasar los datos ordenados a un nuevo arreglo y que queden ordenados
		//Al final regresar los datos al arreglo original
	}
	
	public static <E extends Comparable<E>>	void mergeSort(E[] datos){
		mergeSort(datos,0,datos.length-1);
	}
	
	public static <E extends Comparable<E>>	void mergeSort(E[] datos, int primero, int ultimo) {
		if(primero<ultimo) {
			int central=(primero+ultimo)/2;
			mergeSort(datos, primero, central);
			mergeSort(datos, central+1,ultimo);
			mezcla(datos,primero,ultimo);	
		}
	}
	//---------------------------------------------------------------------------------------------------------------
	
	public static <E extends Comparable <E>> void quickSort(E[]datos) {
		quickSort(datos,0,datos.length-1);
	}
	
	private static <E extends Comparable <E>> void quickSort(E[]datos, int left, int right){
		if(left<right) {
			int posPivote= particion(datos,left, right);
			quickSort(datos,left, posPivote-1);
			quickSort(datos, posPivote+1, right);
		}
	}
	
	private static <E extends Comparable <E>> int  particion(E[]datos, int left, int right){
		E p= datos[left];
		int i= left+1;
		for(int j= left+1; j<right ;j++) {
			if(datos[j].compareTo(p)<0) {
				swap(datos,i,j);
				i++;
			}
		}
		swap(datos,left,i-1);
		return i-1;
	}
	//-------------------------------------------------------------------------------------------------------------------------
	
	private static <E>void swap(E[] datos, int i, int j) {
		E aux=datos[i];
		datos[i]=datos[j];
		datos[j]=aux;
	}
	private static <E> void imprimeArreglo(E[]datos) {
		for (E tmp : datos) {
			System.out.print(tmp+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] datos= {324,345,1345, -1345,23,545};
		imprimeArreglo(datos);
		bubbleSort(datos);
		imprimeArreglo(datos);
	}
}
