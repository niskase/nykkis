package fi.agileo.edcarproject.domain;

public class Car {
	private String brand;
	private String model;
	private int topspeed;

	private Motor motor;
	private Driver driver;

	public Car(String brand, String model, int topspeed, int numberofcylinders) {
		this.brand = brand;
		this.model = model;
		this.topspeed = topspeed;
		this.motor = motor;
		this.driver = driver;
	}

	public Car(String string, String string2, int i, Motor motor3,
			Driver driver3) {
		String brand = "BWM";
		String model = "sedan";
		int topspeed = 250;

	}

	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", topspeed= "
				+ topspeed + "]";
	}

	public double calculatespeed() {
		 double returnvalue;

		returnvalue = ((motor.getnumberofcylinders() - motor.getbrokencylinders()) * 
				topspeed / motor.getnumberofcylinders());

		return returnvalue;
	}

	public String getbrand() {
		return brand;
	}

	public void setbrand(String brand) {
		this.brand = brand;
	}

	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}

	public int gettopspeed() {

		return topspeed;

	}

	public void settopspeed(int topspeed) {
		this.topspeed = topspeed;
	}

}
