import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LaminaPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6164276679171436929L;
	private int trenposition_x;
	private Thread hilo1 = null;
	
	public LaminaPrincipal(){
		
	}
	public void start_mio() {
		if (hilo1 == null) {
			hilo1 = new Thread(h1);
			hilo1.start();
		}
	}
	
	@Override
	public void paint (Graphics g) {
		
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

		ImageIcon imgTrain1 = new ImageIcon(getClass().getResource("train_n2_2.png"));
		g.drawImage(imgTrain1.getImage(), 130 + getTrenposition_x(), 100, 80, 24, this);
	}
	
	
	Runnable h1 = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Thread.sleep(100);
					//repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				progresiveTrenposition_x();
				repaint();
				System.out.println("desdelaminaprincipal hilo::: "+getTrenposition_x());
			}
		}
	};
	
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
	
	protected void progresiveTrenposition_x() {
		trenposition_x = trenposition_x +  1;
	}
}