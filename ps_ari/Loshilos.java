
/**
 * @author harry
 *
 */
public class Loshilos extends Thread{
	String symb;

	public Loshilos(String symb) {
		// TODO Auto-generated constructor stub
		this.symb = symb;
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {
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
