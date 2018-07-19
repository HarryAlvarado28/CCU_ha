
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author HarryAlvarado
 *
 */
public class L5_PS extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8082522582528370899L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String var1 = "La tarea de Sistema Operativo";
		System.out.println("¿Qué haces?, "+var1);
		
		@SuppressWarnings("unused")
		L5_PS l = new L5_PS("Harry");
	
	}
	
	public L5_PS (String title) {
		super(title);
		setVisible(true);
		setBounds(100, 100, 1000, 399);
		add(lb);
		thread_1.start();
		try {
			Thread.sleep(2);
			setBounds(30, 100, 1000, 400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	LaminaPrincipal lp = new LaminaPrincipal();
	LaminaSecundaria ls = new LaminaSecundaria();
	LaminaBase lb = new LaminaBase(lp,ls);
	
	Thread thread_1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ls.setStateTren(lp.getStateTren());

			}
		}
	});
	
}

class LaminaBase extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7610754683019905585L;

	public LaminaBase() {

	}
	
	public LaminaBase(LaminaPrincipal lp, LaminaSecundaria ls) {
		setLayout(new GridLayout(2,1));
		add(lp);
		lp.start_mio();
		add(ls);
	}
	
}

