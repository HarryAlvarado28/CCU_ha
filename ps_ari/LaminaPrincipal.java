import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LaminaPrincipal extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6164276679171436929L;
	
	JLabel jl_test = new JLabel("Esquema Principal");
	public LaminaPrincipal(){
		add(jl_test);
		setBackground(new Color(78,172,125));
	}
}
