
public class NReinas {
	private int[] tablero;
	public NReinas(int n) {
		this.tablero=new int[n];
		
	}
	
	private void imprimeTablero() {
		for (int i = 0; i < this.tablero.length; i++) {
			System.out.print(this.tablero[i]+",");
		}
		System.out.println();
	}
	
	private boolean valida(int fila, int columna) {
		for(int i=0; i<columna;i++) {
			//Validar quee no haya otra reina en la misma fila en las columnas anteriores
			if(this.tablero[i]==fila) {
				return false;
			}
			
			//Validar quee no haya otra reina en la misma diagonal en las columnas anteriores
			if(Math.abs(columna-i)==Math.abs(fila-this.tablero[i])) {
				return false;
			}
		}
		return true;
	}
	
	public void busca() {
		busca(0);
	}
	
	public void busca(int columna) {
		for (int i = 0; i < this.tablero.length; i++) {
			if(valida(i,columna)) {
				this.tablero[columna]=i;
				if(columna==this.tablero.length-1) {
					imprimeTablero();
				}else {
					busca(columna+1);
				}
			}
		}
	}
	public static void main(String[] args) {
		NReinas nr=new NReinas(20);
		nr.busca();
	}

}
