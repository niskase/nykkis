package fi.agileo.edcarproject.domain;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fi.agileo.edcarproject.domain.Driver.Behaviour;

@RunWith(MockitoJUnitRunner.class)
public class DiverTest {

	@Mock
	Car mockCar;
	
	@Before
	public void setUp() {
		
		when(mockCar.calculatespeed()).thenReturn(100.0);		
//		when(mockProfiili.muunnaHinta(200.0)).thenReturn(200.0);		
//		when(mockProfiili.muunnaHinta(300.0)).thenReturn(300.0);		
	}

	@Test
	public void testDriver() {
		
	Driver testing = new Driver(mockCar,"Mika", Behaviour.intensive);
	
	assertEquals( 0.01, testing.run(0.0001),2);
	assertEquals( 50, testing.run(0.5),3);
	assertEquals(100, testing.run(1.0),2);
	assertEquals( 0, testing.run(-1.0),3);
	assertEquals( 1000000, testing.run(10000),1);
	

		
	//assertEquals("Hinta on 100.0", testattava.kerroHinta(100));
	}

}
