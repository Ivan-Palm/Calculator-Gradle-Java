package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void testSomeMethod() {
        var classUnderTest = new App();
        assertTrue(classUnderTest.someMethod(), "someMethod should return 'true'");
	}

}
