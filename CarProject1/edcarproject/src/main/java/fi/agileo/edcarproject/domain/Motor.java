package fi.agileo.edcarproject.domain;


public class Motor {
	private int power;
	private int numberofcylinders;
	private int brokencylinder;

	public Motor(int power, int numberofcylinders, int brokencyclinder) {
		this.power = power;
		this.numberofcylinders = numberofcylinders;
		this.brokencylinder = brokencylinder;
	}

	public int getpower() {
		return power;
	}

	public void setpower(int power) {
		this.power = power;

	}

	public int getnumberofcylinders() {
		return numberofcylinders;
	}

	public void setnumberofcylinders(int numberofcylinders) {
		this.numberofcylinders = numberofcylinders;
	}

	public int getbrokencylinders() {
		return brokencylinder;
	}

	public void setbrokencylinders(int brokencylinders) {
		this.brokencylinder = brokencylinders;
	}

}
