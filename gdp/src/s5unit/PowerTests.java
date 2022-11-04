package s5unit;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerTests {

	@Test
	public void testPowers() {
		assertEquals(9.0, Power.power(3.0, 2), 0.0);
		assertEquals(27.0, Power.power(3.0, 3), 0.0);
		assertEquals(81.0, Power.power(3.0, 4), 0.0);
		assertEquals(243.0, Power.power(3.0, 5), 0.0);
		assertEquals(4.0, Power.power(4.0, 1), 0.0);
		assertEquals(16.0, Power.power(4.0, 2), 0.0);
		assertEquals(64.0, Power.power(4.0, 3), 0.0);
		assertEquals(256.0, Power.power(4.0, 4), 0.0);
		assertEquals(1024.0, Power.power(4.0, 5), 0.0);
		assertEquals(4096.0, Power.power(4.0, 6), 0.0);
		assertEquals(1.0, Power.power(4.0, 0), 0.0);
		assertEquals(148035889.0, Power.power(23.0, 6), 0.0);
		assertEquals(0.125, Power.power(0.5, 3), 0.0);
	}
}
