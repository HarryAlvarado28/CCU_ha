
/**
 * @author harry
 *
 */
public class F5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String var1 = "La tarea de Sistema Operativo";
		System.out.println("¿Qué haces?, "+var1);
		Loshilos p1 = new Loshilos("*");
		Loshilos p2 = new Loshilos("-");
		Loshilos p3 = new Loshilos("+");
		p1.start();
		p2.start();
		p3.start();
		
	}
	

}
