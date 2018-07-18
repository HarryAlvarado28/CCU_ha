
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author HarryAlvarado
 *
 */
public class F5 extends JFrame{

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
		System.out.println("Â¿QuÃ© haces?, "+var1);
		
		@SuppressWarnings("unused")
		F5 l = new F5("Harry");
	
		Loshilos p1 = new Loshilos("*");
		Loshilos p2 = new Loshilos("-");
		
		p1.start();
		p2.start();	
	}
	
	public F5 (String title) {
		super(title);
		setVisible(true);
		setBounds(100, 100, 1000, 399);
		add(lb);
		thread.start();
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
	
	Thread thread = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 350; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("asdf: "+lp.getTrenposition_x());
				if (lp.getNumero_estacion() == 1) {
					System.out.println("Estación UNOOOOOOOOOOOOOOOOO");
				}else if (lp.getNumero_estacion() == 2) {
					System.out.println("Estación DOOOOOSSSSSSSSSSSSS");
				}
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
//		setLayout(new GridLayout(2,1));
//		LaminaPrincipal lp = new LaminaPrincipal();
//		add(lp);
//		lp.start_mio();
//		LaminaSecundaria ls = new LaminaSecundaria();
//		add(ls);
	}
	
	public LaminaBase(LaminaPrincipal lp, LaminaSecundaria ls) {
		setLayout(new GridLayout(2,1));
		//LaminaPrincipal lp = new LaminaPrincipal();
		
		add(lp);
		lp.start_mio();
		add(ls);
		//LaminaSecundaria ls = new LaminaSecundaria();	
	}
	
}

