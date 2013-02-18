package entidades.bicicletas;

public class BicicletaMontanha extends Bicicleta {

	public BicicletaMontanha() {
		super();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bicicleta bi = new BicicletaMontanha();
		
		bi.setVelocidad(5);

	}
	
	public void setVelocidad(int f) {
		System.out.println("Bicicleta montaña");
	}

}
