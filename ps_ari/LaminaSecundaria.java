import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LaminaSecundaria extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2384826861727769382L;
	
	private JLabel jl_test = new JLabel("Esquema de Detalle");
	
	private JPanel jp_details = new JPanel();
	private JTextArea jta_resumentext = new JTextArea();
	private JPanel jp_resumengrafic = new JPanel();
	
	private JPanel jp_allbutton = new JPanel();
	private JButton jb_start_restart = new JButton("Iniciar");
	private JButton jb_pause = new JButton("Pausar");
	private JButton jb_stop = new JButton("Detener");
	
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
		
		jp_details.add(jta_resumentext);
		jp_details.add(jp_resumengrafic);
		jp_resumengrafic.add(jl_test);
		
		return jp_details;
	}
	
}
