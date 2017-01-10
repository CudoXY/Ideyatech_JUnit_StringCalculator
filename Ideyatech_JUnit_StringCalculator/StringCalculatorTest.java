package com.ideyatech.ut.exercise.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest
{
	StringCalculator calc;

	@Before
	public void init()
	{
		calc = new StringCalculator();
	}

	@Test
	public void testCalculate_NullReturns0()
	{
		assertEquals(0, calc.calculate(null));
	}

	@Test
	public void testCalculate_EmptyReturns0()
	{
		assertEquals(0, calc.calculate(""));
	}

	@Test
	public void testCalculate_SingleNumber()
	{
		assertEquals(55, calc.calculate("55"));
	}

	@Test
	public void testCalculate_2NumbersCommaDelimeteredReturnsSum()
	{
		assertEquals(100, calc.calculate("10,20,30,40"));
	}

	@Test
	public void testCalculate_2NumbersCommaDelimeteredReturnsSum_WithSpace()
	{
		assertEquals(100, calc.calculate("10, 20, 30, 40"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculate_NegativeNumberThrowsException()
	{
		calc.calculate("-100");
	}

	@Test
	public void testCalculate_NumbersGreaterThan1000Ignored()
	{
		assertEquals(0, calc.calculate("1001"));
	}

	@Test
	public void testCalculate_CommaDelimetered_NumbersGreaterThan1000Ignored()
	{
		assertEquals(60, calc.calculate("10,20,30,1001"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculate_CommaDelimetered_NegativeNumberThrow()
	{
		assertEquals(60, calc.calculate("10,20,30,-100"));
	}

	@Test
	public void testCalculate_CustomOneCharacterDelimeter()
	{
		assertEquals(21, calc.calculate("//=1=2=3=4=5=6"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculate_CustomOneCharacterDelimeter_NegativeNumberThrow()
	{
		calc.calculate("//=1=2=-3=4=5=6");
	}

	@Test
	public void testCalculate_CustomOneCharacterDelimeter_MoreThan1000()
	{
		assertEquals(18, calc.calculate("//=1=2=3000=4=5=6"));
	}

	@Test
	public void testCalculate_CustomMultipleCharacterDelimeter()
	{
		assertEquals(21, calc.calculate("//[abc]1abc2abc3abc4abc5abc6"));
	}

	@Test
	public void testCalculate_CustomMultipleCharacterDelimeter_WithSpace()
	{
		assertEquals(21, calc.calculate("//[abc]1 abc2abc3abc4abc5abc6"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculate_CustomMultipleCharacterDelimeter_WithSpaceDelimeter_Invalid()
	{
		calc.calculate("//[abc ]1abc2abc3abc4abc5abc6");
	}

	@Test
	public void testCalculate_CustomMultipleCharacterDelimeter_WithSpaceDelimeter()
	{
		assertEquals(21, calc.calculate("//[abc ]1abc 2abc 3abc 4abc 5abc 6"));
	}

	@Test
	public void testCalculate_CustomMultipleCharacterDelimeter_MoreThan1000()
	{
		assertEquals(18, calc.calculate("//[abc]1abc2abc2000abc4abc5abc6"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculate_CustomMultipleCharacterDelimeter_NegativeNumberThrow()
	{
		calc.calculate("//[abc]1abc2abc3abc-123abc5abc6");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculate_InvalidDelimeter()
	{
		calc.calculate("1,2,3,4,5.6");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculate_CustomMultipleCharacterDelimeter_InvalidDelimeter()
	{
		calc.calculate("//[abc]1abc2abc3abc-123abcD5abc6");
	}

}
