import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LaminaSecundaria extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2384826861727769382L;
	
	private JLabel jl_test = new JLabel("Detalle Gráfico");
	
	private JPanel jp_details = new JPanel();
	private JTextArea jta_resumentext = new JTextArea();
	private JScrollPane jsp_scroll = new JScrollPane(jta_resumentext);
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
	private Color resaltaLineFin;
	
	
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
		
		jp_details.add(jsp_scroll);
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
			int i = 0;
			while (true) {
				try {
					Thread.sleep(50);
					
					if (getStateTren() == "Listo0") {
						jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+"El Tren esta listo para empezar su marcha.");
					} else if (getStateTren() == "Listo") {
						jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+ "El Tren esta listo para continuar su marcha, despues del intercambio de los pasajeros.");
					} else if (getStateTren() == "Bloqueado") {
						jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+"El Tren ha llegado a la estación, y los usuarios están entrando o saliendo.");
					} else if (getStateTren() == "Ejecucion") {
						jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+"El Tren esta en marcha");
					}else if (getStateTren() == "Terminado") {
						jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+"El Tren a llegado a su destino final");
					}				
					
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
		g.drawString("Listo", 580, 128);
	
		g.setColor(getResaltaEjecucion());
		g.fillOval(700, 32, 60, 60);
		g.setColor(new Color(0,0,0));
		g.drawString("Ejecucion", 703, 65);
		
		g.setColor(getResaltaBloqueado());
		g.fillOval(830, 110, 62, 62);
		g.setColor(new Color(0,0,0));
		g.drawString("Bloqueado", 831, 144);
		
		
		g.setColor(new Color(0, 0, 0));
		
		g.drawLine(500, 125, 565, 125);
		g.drawLine(600, 100, 700, 55);
		g.drawLine(620, 120, 705, 80);
		g.drawLine(625, 130, 825, 140);
		g.drawLine(760, 60, 850, 60);
		g.drawLine(755, 80, 830, 125);
		
		
		g.setColor(new Color(200,15,50));
		
		g.fillOval(565, 125, 5, 5);
		g.fillOval(600, 100, 5, 5);
		g.fillOval(705, 80, 5, 5);
		g.fillOval(825, 140, 5, 5);
		g.fillOval(849, 61, 5, 5);	
		g.fillOval(828, 127, 5, 5);
		
		
		if (getStateTren() == "Listo0") {
			//jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+"El Tren esta listo para empezar su marcha.");
			
			setResaltaListo(resaltaAlive);
			setResaltaBloqueado(resaltaBase);
			setResaltaEjecucion(resaltaBase);
			
		} else if (getStateTren() == "Listo") {
			//jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+ "El Tren esta listo para continuar su marcha, despues del intercambio de los pasajeros.");
			
			setResaltaListo(resaltaAlive);
			setResaltaBloqueado(resaltaBase);
			setResaltaEjecucion(resaltaBase);
			
		} else if (getStateTren() == "Bloqueado") {
			//jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+"El Tren ha llegado a la estación, y los usuarios están entrando o saliendo.");
			setResaltaListo(resaltaBase);
			setResaltaBloqueado(resaltaAlive);
			setResaltaEjecucion(resaltaBase);
		} else if (getStateTren() == "Ejecucion") {
			//jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+"El Tren esta en marcha");
			setResaltaListo(resaltaBase);
			setResaltaBloqueado(resaltaBase);
			setResaltaEjecucion(resaltaAlive);
		}else if (getStateTren() == "Terminado") {
			//jta_resumentext.setText((i+=1)+" Estado (que se simulado): "+getStateTren()+"\n"+"El Tren a llegado a su destino final");
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
					Thread.sleep(50);
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}while(getStateTren() != "Terminado");
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

	public Color getResaltaLineFin() {
		return resaltaLineFin;
	}

	public void setResaltaLineFin(Color resaltaLineFin) {
		this.resaltaLineFin = resaltaLineFin;
	}
	
}
