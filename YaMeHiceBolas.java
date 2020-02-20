/*Sebastián Alejos Acosta 
A00344555
19 de febrero de 2020*/
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YaMeHiceBolas extends JFrame{
	private int nivel;
	public YaMeHiceBolas(){
		super("Ya me hice bolas");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.nivel=Integer.parseInt(JOptionPane.showInputDialog("Escribe el nivel de profundidad:"));
		this.setVisible(true);
	}
	
	private void pintaCirculo(Graphics g, int x, int y, int largo) {
		g.drawOval(x, y, largo, largo);
	}
	
	
	public void pintaCirculos(Graphics g , int nivel , int x1 , int y1 , int largo) {
		if(nivel==0) {
			this.pintaCirculo(g, x1, (y1-largo/2), largo);
		}else {
			this.pintaCirculos(g, nivel-1, x1, y1, largo);
            this.pintaCirculos(g, nivel-1, x1, y1, largo/2);
            this.pintaCirculos(g, nivel-1, x1+largo/2, y1, largo/2);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.pintaCirculos(g, this.nivel, 50, 350, 600);
	}
	
	
	public static void main(String[] args) {
		YaMeHiceBolas ymhb=new YaMeHiceBolas();
	}
}

