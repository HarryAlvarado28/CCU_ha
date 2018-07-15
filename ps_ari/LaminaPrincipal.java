import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LaminaPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6164276679171436929L;
	
	//JLabel jl_test = new JLabel("Esquema Principal");
	public LaminaPrincipal(){
		//add(jl_test);
		//setBackground(new Color(78,172,125));
		
	}
	
	public void paint (Graphics g) {
		ImageIcon imgRiel = new ImageIcon(getClass().getResource("rieles_n3.png"));
		for (int i = 1; i < 31; i++) {
			g.drawImage(imgRiel.getImage(), 30*i, 100, 40, 28, this);
		}
		
		//ImageIcon imgStation1 = new ImageIcon(getClass().getResource("estacion_n1.png"));
		//g.drawImage(imgStation1.getImage(), 30, 50, 70, 50, this);
		
		ImageIcon imgStation2 = new ImageIcon(getClass().getResource("estacion_n2.png"));
		g.drawImage(imgStation2.getImage(), 30, 50, 70, 50, this);

		//ImageIcon imgStation3 = new ImageIcon(getClass().getResource("estacion_n3.png"));
		//g.drawImage(imgStation3.getImage(), 230, 50, 70, 50, this);
		
		ImageIcon imgTrain1 = new ImageIcon(getClass().getResource("train_n2_2.png"));
		g.drawImage(imgTrain1.getImage(), 330, 97, 80, 24, this);
		
		
		
	}
	
	
	
}
