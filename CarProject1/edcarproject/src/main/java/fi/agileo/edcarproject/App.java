package fi.agileo.edcarproject;

import fi.agileo.edcarproject.domain.Car;
import fi.agileo.edcarproject.domain.Driver;
import fi.agileo.edcarproject.domain.Driver.Behaviour;
import fi.agileo.edcarproject.domain.Motor;


public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Hello World!" );

		Driver driver1 = new Driver(null, "Mika", Behaviour.intensive);
    	Driver driver2 = new Driver(null,"Manu",Behaviour.calm);
    	Driver driver3 = new Driver(null,"Mikko",Behaviour.standard);

    	Motor motor1 = new Motor (2,2,1);
    	Motor  motor2 = new Motor (1,2,2);
    	Motor  motor3 = new Motor (3,2,3);

    	Car car1 = new Car("BMW","532",230,motor1,driver1);
    	Car car2 = new Car("VW","Golf",200,motor2,driver2);
    	Car car3 = new Car("Toyota","Almera",210,motor3,driver3);

    	System.out.println(car1.toString());
    	System.out.println(car2.toString());
    	System.out.println(car3.toString());
    }
}
