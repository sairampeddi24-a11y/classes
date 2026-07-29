package myclass.myclass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import myclass.myclass.multithreading.ExecutableService;

public class ExecutableServiceTest {

	@Test
	public void testAdd() {
		ExecutableService ex = new ExecutableService();
		int result = ex.add(1, 0);
		assertEquals(1, result);
		assertTrue(result > 0);
	}

}
