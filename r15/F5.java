/**
 * 
 */

/**
 * @author harry
 *
 */
public class F5 extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String var1 = "La tarea de Sistema Operativo";
		System.out.println("¿Qué haces?, "+var1);
		F5 p1 = new F5("*");
		F5 p2 = new F5("-");
		F5 p3 = new F5("+");
		p1.start();
		p2.start();
		p3.start();
		
	}
	
	String name;
	public F5 (String name) {
		this.name = name;
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
			System.out.print(name+i);
			
		}
	}

}
