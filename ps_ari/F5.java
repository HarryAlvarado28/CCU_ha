import java.awt.Color;
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
		setBounds(100, 100, 750, 350);
		add(new LaminaBase());
		
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


class LaminaPrincipal extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3409061449977916970L;
	JLabel jl_test = new JLabel("Esquema Principal");
	public LaminaPrincipal(){
		add(jl_test);
		setBackground(new Color(178,102,255));
	}
	
}


class LaminaSecundaria extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2384826861727769382L;
	JLabel jl_test = new JLabel("Esquema de Detalle");
	public LaminaSecundaria(){
		add(jl_test);
		setBackground(new Color(102, 255, 102));
	}
	
}


