package entity;

/**
 * 
 * @see Falling
 */
public class Diamant extends Falling {

	/**
	 * The constructor of Diamant class
	 */
	public Diamant() {
		super(false, true, 'T', 4);
		this.setStep(0.1);
	}

}
