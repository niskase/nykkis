package fi.agileo.edcarproject.domain;


public class Driver {
	private Car car;
	private String name;
	private Behaviour behaviour;

	public Driver(Car car, String name,  Behaviour behaviour) {

		this.car = car;
		this.name = name;
		this.behaviour =  behaviour;

	}

	public double run(double hours) {
		double returnvalue;
		if(hours< 0.0){
			return 0.0;
		}
		//System.out.println("return value= ");
		returnvalue = (car.calculatespeed() * hours * behaviour.value);
		return returnvalue;
	}

	public Car getcar() {
		return car;
	}

	public void setcar(Car car) {
		this.car = car;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}


	public Behaviour getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(Behaviour behaviour) {
		this.behaviour = behaviour;
	}


	public enum Behaviour {
		intensive(1.0),
		standard(0.7),
		calm(0.4);
		private final double value;
		
		Behaviour(double value){
			this.value=value;
		}
		
	}

}
