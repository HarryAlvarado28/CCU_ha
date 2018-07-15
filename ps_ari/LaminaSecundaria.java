import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LaminaSecundaria extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2384826861727769382L;
	
	JLabel jl_test = new JLabel("Esquema de Detalle");
	public LaminaSecundaria() {
		// TODO Auto-generated constructor stub
		add(jl_test);
		setBackground(new Color(102, 255, 102));
		setLayout(new GridLayout(2,1));
	}


}
