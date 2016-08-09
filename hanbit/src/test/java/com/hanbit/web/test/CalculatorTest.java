package com.hanbit.web.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
  


public class CalculatorTest {
    Calculator calc = new Calculator();
	@Test
	public final void testSum() {
	 assertEquals(10, calc.sum(5, 5));
	}

}
