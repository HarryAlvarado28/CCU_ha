import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * @author HarryAlvarado
 *
 */
public class Loshilos extends Thread{
	private String symb;
	private Graphics g2d;
	private boolean nice = false;

	public Loshilos(String symb) {
		// TODO Auto-generated constructor stub
		this.symb = symb;
		nice = false;
	}
	
	public Loshilos(String symb, Graphics g2d) {
		this.symb = symb;
		this.g2d = g2d;
		nice = true;
		
	}
	
	public void run() {
		
		if (nice) {
			System.out.println(symb);
			ImageIcon imgTrain1 = new ImageIcon(getClass().getResource("train_n2_2.png"));
			for (int i = 0; i < 1; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g2d.drawImage(imgTrain1.getImage(), 330 + i, 100, 80, 24, imgTrain1.getImageObserver());
			}
			
		} else {

			for (int i = 0; i < 150; i++) {
				System.out.println();
				try {
					sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(symb+i);
				
			}

		}
		
	}

}
