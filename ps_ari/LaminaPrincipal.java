import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LaminaPrincipal extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6164276679171436929L;
	private int trenposition_x;
	private Thread testing = null;
	//JLabel jl_test = new JLabel("Esquema Principal");
	public LaminaPrincipal(){
		//add(jl_test);
		//setBackground(new Color(78,172,125));
		start();
	}
	
	public void paint (Graphics g) {
		dibujemos(g);
	}
	
	public void update(Graphics g) {
		trenposition_x =+ 2;
		ImageIcon imgTrain1 = new ImageIcon(getClass().getResource("train_n2_2.png"));
		g.drawImage(imgTrain1.getImage(), 330+trenposition_x, 100, 80, 24, this);
		
	}
	
	private void dibujemos(Graphics g) {
		ImageIcon imgRiel = new ImageIcon(getClass().getResource("rieles_n3.png"));
		for (int i = 1; i < 31; i++) {
			g.drawImage(imgRiel.getImage(), 30*i, 100, 40, 28, this);
		}
		
		ImageIcon imgStation2 = new ImageIcon(getClass().getResource("estacion_n2.png"));
		g.drawImage(imgStation2.getImage(), 230, 50, 70, 50, this);
		g.drawImage(imgStation2.getImage(), 500, 50, 70, 50, this);
		g.drawImage(imgStation2.getImage(), 750, 50, 70, 50, this);

		//ImageIcon imgStation3 = new ImageIcon(getClass().getResource("estacion_n3.png"));
		//g.drawImage(imgStation3.getImage(), 230, 50, 70, 50, this);
		
//		ImageIcon imgTrain1 = new ImageIcon(getClass().getResource("train_n2_2.png"));
//		g.drawImage(imgTrain1.getImage(), 330+trenposition_x, 100, 80, 24, this);
	}

	public void start() {
		if (testing == null) {
			testing = new Thread(this);
			testing.start();
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i=+2) {
			//trenposition_x =+ i;
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

	/**
	 * @return the trenposition_x
	 */
	public int getTrenposition_x() {
		return trenposition_x;
	}

	/**
	 * @param trenposition_x the trenposition_x to set
	 */
	public void setTrenposition_x(int trenposition_x) {
		this.trenposition_x = trenposition_x;
	}
	
}