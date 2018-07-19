import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LaminaSecundaria extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2384826861727769382L;
	
	private JLabel jl_test = new JLabel("Esquema de Detalle");
	
	private JPanel jp_details = new JPanel();
	private JTextArea jta_resumentext = new JTextArea();
	private JScrollPane jsp_scroll = new JScrollPane(jta_resumentext);
	private JPanel jp_resumengrafic = new JPanel();
	
	private JPanel jp_allbutton = new JPanel();
	private JButton jb_start_restart = new JButton("Iniciar");
	private JButton jb_pause = new JButton("Pausar");
	private JButton jb_stop = new JButton("Detener");
	
	private String stateTren;
	
	public LaminaSecundaria() {
		// TODO Auto-generated constructor stub
		setBackground(new Color(102, 255, 102));
		setLayout(new BorderLayout());
		
		add(collectionResumen(),BorderLayout.CENTER);
		add(collectionButton(),BorderLayout.SOUTH);
	}

	private Component collectionButton() {
		jp_allbutton.add(jb_start_restart);
		jp_allbutton.add(jb_pause);
		jp_allbutton.add(jb_stop);
		
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
	
	
//	String Listo0 = "El Tren esta listo para empezar su marcha.";
//	String Listo1 = "El Tren esta listo para continuar su marcha, despues del intercambio de los pasajeros.";
//	String Bloqueado = "El Tren ha llegado a la estación, y los usuarios están entrando o saliendo.";
//	String Ejecucion = "El Tren esta en marcha";
//	String Terminado = "El Tren a llegado a su destino final";
	
}
