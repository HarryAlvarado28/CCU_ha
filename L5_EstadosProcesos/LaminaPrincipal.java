import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LaminaPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6164276679171436929L;
	
	static final public String LISTO0 = "LISTO0";
	static final public String LISTO = "LISTO";
	static final public String EJECUCION = "EJECUCION";
	static final public String BLOQUEADO = "BLOQUEADO";
	static final public String TERMINADO = "TERMINADO";
	
	
	static final public int stationInicio = 2;
	static final public int stationN1 = 230;
	static final public int stationN2 = 500;
	static final public int stationN3 = 750;
	static final public int stationFinal = 850;
	
	private int trenposition_x;
	private Thread hilo1 = null;
	private Thread hilo2 = null;
	private int numero_estacion = -1;
	private String stateTren;
	
	private int stop_random;
	
	public LaminaPrincipal(){
		thread_stop_random.start();
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
		
		ImageIcon imgRiel = new ImageIcon(getClass().getResource("rieles_n3.png"));
		for (int i = 1; i < 31; i++) {
			g.drawImage(imgRiel.getImage(), 30*i, 100, 40, 28, this);
		}
		
		ImageIcon imgStation2 = new ImageIcon(getClass().getResource("estacion_n2.png"));
		g.drawImage(imgStation2.getImage(), stationN1, 50, 70, 50, this);
		g.drawImage(imgStation2.getImage(), stationN2, 50, 70, 50, this);
		g.drawImage(imgStation2.getImage(), stationN3, 50, 70, 50, this);

		
		ImageIcon imgTrain1 = new ImageIcon(getClass().getResource("train_n2_2.png"));
		g.drawImage(imgTrain1.getImage(), 20 + getTrenposition_x(), 100, 80, 24, this);
	}
		
	Runnable h1 = new Runnable() {
		 
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(getTrenposition_x() <= stationFinal) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					// TODO Auto-generated catch block
					if (stationInicio == getTrenposition_x()) {
						setStateTren(LaminaPrincipal.LISTO0);
						Thread.sleep(3000);
					}else if (getNumero_estacion() == 1) {
						setStateTren(LaminaPrincipal.BLOQUEADO);
						Thread.sleep(3000);
						setStateTren(LaminaPrincipal.LISTO);
						Thread.sleep(3000);
					}else if (getNumero_estacion() == 2) {
						setStateTren(LaminaPrincipal.BLOQUEADO);
						Thread.sleep(3000);
						setStateTren(LaminaPrincipal.LISTO);
						Thread.sleep(3000);
					}else if (getNumero_estacion() == 3) {
						setStateTren(LaminaPrincipal.BLOQUEADO);
						Thread.sleep(3000);
						setStateTren(LaminaPrincipal.LISTO);
						Thread.sleep(3000);
					}else if(getTrenposition_x() == getStop_random()) {
						setStateTren(LaminaPrincipal.LISTO);
						Thread.sleep(4000);
					}else {
						setStateTren(LaminaPrincipal.EJECUCION);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				progresiveTrenposition_x();
				repaint();
			}
			setStateTren(LaminaPrincipal.TERMINADO);
		}
	};
	
	Runnable h2 = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("In po:"+(getTrenposition_x()));
				switch (getDetectPositionTren(getTrenposition_x()+20)) {
				case stationInicio:
					setStateTren(LaminaPrincipal.LISTO);
					break;
				case stationN1:
					setNumero_estacion(1);
					break;
				case stationN2:
					setNumero_estacion(2);
					break;
				case stationN3:
					setNumero_estacion(3);
					break;
				default:
					setNumero_estacion(1428);
					break;
				}
			}
		}
		
		private int getDetectPositionTren(int positionStation) {
			if (positionStation > 229 && 231 > positionStation) {
				return stationN1; 
			} else if (positionStation > 499 && 501 > positionStation) {
				return stationN2;
			} else if (positionStation > 749 && 751 > positionStation) {
				return stationN3;
			}else if (positionStation == stationInicio) {
				return stationInicio;
			}else if (positionStation == stationFinal) {
				return stationFinal;
			}else {
				return 0;
			}
		}
	};
	
	Thread thread_stop_random = new Thread(new Runnable() {
		public void run() {
			for (int i = 0; i < 2; i++) {
				setStop_random((int) (Math.random()*1000));
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	});
	
	
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

	/**
	 * @return the stateTren
	 */
	public String getStateTren() {
		return stateTren;
	}

	/**
	 * @param stateTren the stateTren to set
	 */
	public void setStateTren(String stateTren) {
		this.stateTren = stateTren;
	}

	/**
	 * @return the stop_random
	 */
	public int getStop_random() {
		return stop_random;
	}

	/**
	 * @param stop_random the stop_random to set
	 */
	public void setStop_random(int stop_random) {
		this.stop_random = stop_random;
	}
}