import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author harry
 *
 */
public class F5 extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String var1 = "La tarea de Sistema Operativo";
		System.out.println("¿Qué haces?, "+var1);
		
		F5 l = new F5("Harry");
	
		Loshilos p1 = new Loshilos("*");
		Loshilos p2 = new Loshilos("-");
		Loshilos p3 = new Loshilos("+");
		p1.start();
		p2.start();
		p3.start();
		
	}
	
	public F5 (String title) {
		super(title);
		setVisible(true);
		setBounds(100, 100, 350, 250);
		add(new Lamina());
		
	}

}

class Lamina extends JPanel {
	
	public Lamina( ) {
		
	}
}
