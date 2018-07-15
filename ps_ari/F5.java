import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author harry
 *
 */
public class F5 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8082522582528370899L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String var1 = "La tarea de Sistema Operativo";
		System.out.println("¿Qué haces?, "+var1);
		
		@SuppressWarnings("unused")
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
		setBounds(100, 100, 850, 449);
		add(new LaminaBase());
		try {
			Thread.sleep(2);
			setBounds(100, 100, 750, 450);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class LaminaBase extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7610754683019905585L;

	public LaminaBase() {
		setLayout(new GridLayout(2,1));
		add(new LaminaPrincipal());
		add(new LaminaSecundaria());
		 
	}
}



