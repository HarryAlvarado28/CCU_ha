import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class LaminaSecundaria extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2384826861727769382L;
	
	private JLabel jl_test = new JLabel("Detalle Gráfico");
	
	private JPanel jp_details = new JPanel();
	private JTextPane jta_resumentext = new JTextPane();
	private JPanel jp_resumengrafic = new JPanel();
	
	private JPanel jp_allbutton = new JPanel();
//	private JButton jb_start_restart = new JButton("Iniciar");
//	private JButton jb_pause = new JButton("Pausar");
//	private JButton jb_stop = new JButton("Detener");
	
	private String stateTren;
	private Color resaltaBase = new Color(174, 214, 241);
	private Color resaltaAlive = new Color(247, 220, 111);
	private Color resaltaListo;
	private Color resaltaEjecucion;
	private Color resaltaBloqueado;
	private Color resaltaLineaGo;
	private Color resaltaTerminado;
	
	
	public LaminaSecundaria() {
		// TODO Auto-generated constructor stub
		setBackground(new Color(102, 255, 102));
		setLayout(new BorderLayout());
		
		add(collectionResumen(),BorderLayout.CENTER);
		add(collectionButton(),BorderLayout.SOUTH);
		thread_inStateResalta.start();
	}

	private Component collectionButton() {
//		jp_allbutton.add(jb_start_restart);
//		jp_allbutton.add(jb_pause);
//		jp_allbutton.add(jb_stop);
		
		return jp_allbutton;
	}
	
	private Component collectionResumen() {
		jp_details.setLayout(new GridLayout(1, 2));
		jta_resumentext.setEditable(false);;
		thread_log_state.start();
		
		jp_details.add(jta_resumentext);
		jp_details.add(jp_resumengrafic);
		jp_resumengrafic.add(jl_test);
		
		return jp_details;
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

	Thread thread_log_state = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(50);
					
					if (getStateTren() == LaminaPrincipal.LISTO0) {
						jta_resumentext.setText("	Estado: "+getStateTren()+"\n"+"El Tren esta listo para empezar su marcha.");
						
					} else if (getStateTren() == LaminaPrincipal.LISTO) {
						jta_resumentext.setText("	Estado: "+getStateTren()+"\n"+ "El Tren esta listo para continuar su marcha, despues del intercambio de los pasajeros.");
		
					} else if (getStateTren() == LaminaPrincipal.BLOQUEADO) {
						jta_resumentext.setText("	Estado: "+getStateTren()+"\n"+"El Tren ha llegado a la estaci�n, y los usuarios est�n entrando o saliendo.");
						
					} else if (getStateTren() == LaminaPrincipal.EJECUCION) {
						jta_resumentext.setText("	Estado: "+getStateTren()+"\n"+"El Tren esta en marcha");
						
					}else if (getStateTren() == LaminaPrincipal.TERMINADO) {
						jta_resumentext.setText("	Estado: "+getStateTren()+"\n"+"El Tren a llegado a su destino final");
						
					}
					jta_resumentext.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	});
	
	//new Color(174, 214, 241) <----- Color Base.
	
	public void paint (Graphics g) {
		super.paint(g);
		
		g.setColor(getResaltaListo());
		g.fillOval(570, 100, 50, 50);
		g.setColor(new Color(0,0,0));
		g.drawString(LaminaPrincipal.LISTO, 580, 128);
	
		g.setColor(getResaltaEjecucion());
		g.fillOval(700, 32, 60, 60);
		g.setColor(new Color(0,0,0));
		g.drawString(LaminaPrincipal.EJECUCION, 703, 65);
		
		g.setColor(getResaltaBloqueado());
		g.fillOval(830, 110, 62, 62);
		g.setColor(new Color(0,0,0));
		g.drawString(LaminaPrincipal.BLOQUEADO, 831, 144);
		
		g.setColor(getResaltaTerminado());
		g.fillOval(855, 30, 62, 62);
		g.setColor(new Color(0,0,0));
		g.drawString(LaminaPrincipal.TERMINADO, 857, 65);
		
		g.setColor(new Color(0, 0, 0));
		
		g.drawLine(500, 125, 565, 125);
		g.drawLine(600, 100, 700, 55);
		g.drawLine(620, 120, 705, 80);
		g.drawLine(625, 130, 825, 140);		
		g.drawLine(760, 60, 850, 60);
		g.drawLine(755, 80, 830, 125);
		
		g.setColor(new Color(200,15,50));
		
		g.fillOval(565, 125, 5, 5); // to Listo
		g.fillOval(600, 100, 5, 5); // from Ejecucion to Listo
		g.fillOval(705, 80, 5, 5); // from Listo to Ejecucion
		g.fillOval(625, 130, 5, 5); // from Listo to Bloqueado
		g.fillOval(849, 61, 5, 5);	 // from Ejecucion to Terminado
		g.fillOval(828, 127, 5, 5); // from Ejecucion to Bloqueado
		
		if (getStateTren() == LaminaPrincipal.LISTO0) {
			setResaltaListo(resaltaAlive);
			setResaltaBloqueado(resaltaBase);
			setResaltaEjecucion(resaltaBase);
			setResaltaLineFin(resaltaBase);
		} else if (getStateTren() == LaminaPrincipal.LISTO) {
			setResaltaListo(resaltaAlive);
			setResaltaBloqueado(resaltaBase);
			setResaltaEjecucion(resaltaBase);
			setResaltaLineFin(resaltaBase);
		} else if (getStateTren() == LaminaPrincipal.BLOQUEADO) {
			setResaltaListo(resaltaBase);
			setResaltaBloqueado(resaltaAlive);
			setResaltaEjecucion(resaltaBase);
			setResaltaLineFin(resaltaBase);
		} else if (getStateTren() == LaminaPrincipal.EJECUCION) {
			setResaltaListo(resaltaBase);
			setResaltaBloqueado(resaltaBase);
			setResaltaEjecucion(resaltaAlive);
			setResaltaLineFin(resaltaBase);
		}else if (getStateTren() == LaminaPrincipal.TERMINADO) {
			setResaltaListo(resaltaBase);
			setResaltaBloqueado(resaltaBase);
			setResaltaEjecucion(resaltaBase);
			setResaltaLineFin(resaltaAlive);
		}
		
	}
	
	Thread thread_inStateResalta = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			do {
				try {
					Thread.sleep(45);
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}while(true);

		}
	});
	
	public Color getResaltaListo() {
		return resaltaListo;
	}

	public void setResaltaListo(Color resaltaListo) {
		this.resaltaListo = resaltaListo;
	}

	public Color getResaltaEjecucion() {
		return resaltaEjecucion;
	}

	public void setResaltaEjecucion(Color resaltaEjecucion) {
		this.resaltaEjecucion = resaltaEjecucion;
	}

	public Color getResaltaBloqueado() {
		return resaltaBloqueado;
	}

	public void setResaltaBloqueado(Color resaltaBloqueado) {
		this.resaltaBloqueado = resaltaBloqueado;
	}

	public Color getResaltaLineaGo() {
		return resaltaLineaGo;
	}

	public void setResaltaLineaGo(Color resaltaLineaGo) {
		this.resaltaLineaGo = resaltaLineaGo;
	}

	public Color getResaltaTerminado() {
		return resaltaTerminado;
	}

	public void setResaltaLineFin(Color resaltaLineFin) {
		this.resaltaTerminado = resaltaLineFin;
	}
	
}
