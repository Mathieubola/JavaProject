package entity;

/**
 * 
 * @see Falling
 */
public class Diamond extends Falling {

	/**
	 * The constructor of Diamant class
	 */
	public Diamond() {
		super(false, true, 'T', 4);
		this.setStep(0.1);
	}

}
