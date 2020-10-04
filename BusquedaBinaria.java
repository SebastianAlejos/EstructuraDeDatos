import javax.swing.JOptionPane;

public class BusquedaBinaria {

	public static <E extends Comparable <E>> int binarySearch(E[] datos, E valor) {
		int min=0,
			max=datos.length-1,
			avg;
		while(min<=max){
			avg=(min+max)/2;
			if(valor.equals(datos[avg])) {
				return avg;
			}else if(valor.compareTo(datos[avg])<0) {
				max=avg-1;
			}else {
				min=avg+1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		String[] nombres= {"Carlos","Daniel","Jorge", "Miriam","Paquito", "Sebastian",};
		String nombre=JOptionPane.showInputDialog("Escribe el nombre a buscar");
		System.out.println("El nombre "+nombre+" está en la pos: "+binarySearch(nombres, nombre));
	}

}
