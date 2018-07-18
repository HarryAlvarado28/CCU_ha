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
	private Thread hilo2 = null;
	final private int ps_n1 = 230;
	final private int ps_n2 = 500;
	final private int ps_n3 = 750;
	private int numero_estacion = -1;
	
	public LaminaPrincipal(){
		
	}
	
	public void start_mio() {
		if (hilo1 == null && hilo2 == null) {
			hilo1 = new Thread(h1);
			hilo1.start();
			hilo2 = new Thread(h2);
			hilo2.start();
		}
	}
	
	@Override
	public void paint (Graphics g) {
		ImageIcon imgBackground = new ImageIcon(getClass().getResource("background.jpg"));
		g.drawImage(imgBackground.getImage(), 0, 0, 1000, 300, this);
		
		//add(jl_test);
		//setBackground(new Color(78,172,125));
		start();
	}
	
	public void paint1 (Graphics g) {
		//dibujemos(g);
		ImageIcon imgRiel = new ImageIcon(getClass().getResource("rieles_n3.png"));
		for (int i = 1; i < 31; i++) {
			g.drawImage(imgRiel.getImage(), 30*i, 100, 40, 28, this);
		}
		
		ImageIcon imgStation2 = new ImageIcon(getClass().getResource("estacion_n2.png"));
		g.drawImage(imgStation2.getImage(), ps_n1, 50, 70, 50, this);
		g.drawImage(imgStation2.getImage(), ps_n2, 50, 70, 50, this);
		g.drawImage(imgStation2.getImage(), ps_n3, 50, 70, 50, this);

		//ImageIcon imgStation3 = new ImageIcon(getClass().getResource("estacion_n3.png"));
		//g.drawImage(imgStation3.getImage(), 230, 50, 70, 50, this);
		
		ImageIcon imgTrain1 = new ImageIcon(getClass().getResource("train_n2_2.png"));
		g.drawImage(imgTrain1.getImage(), 20 + getTrenposition_x(), 100, 80, 24, this);
	}
	
	public void update(Graphics g) {
		trenposition_x =+ 2;
		ImageIcon imgTrain1 = new ImageIcon(getClass().getResource("train_n2_2.png"));
		g.drawImage(imgTrain1.getImage(), 330+trenposition_x, 100, 80, 24, this);
		
	}
	
	

	public void start() {
		if (testing == null) {
			testing = new Thread(this);
			testing.start();
		}
	}
	
	Runnable h1 = new Runnable() {
		 
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true && getTrenposition_x() < 900) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				runtren();
				repaint();
				//System.out.println("desdelaminaprincipal hilo::: "+getTrenposition_x());
			}
		}
	};
	
	public synchronized void runtren() {
		progresiveTrenposition_x();
	}
	
	Runnable h2 = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				switch (getTrenposition_x()) {
				case ps_n1:
					setNumero_estacion(1);
					break;
				case ps_n2:
					setNumero_estacion(2);
					break;
				case ps_n3:
					setNumero_estacion(3);
					break;
				default:
					setNumero_estacion(0);
					break;
				}
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
	
	private void progresiveTrenposition_x() {
		trenposition_x +=  1;
	}
	/**
	 * @return the numero_estacion
	 */
	public int getNumero_estacion() {
		return numero_estacion;
	}
	/**
	 * @param numero_estacion the numero_estacion to set
	 */
	public void setNumero_estacion(int numero_estacion) {
		this.numero_estacion = numero_estacion;
	}
}