package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));	
		assertEquals(2, Calculator.add("2"));	
		assertEquals(3, Calculator.add("3"));	
	
	}
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(8, Calculator.add("3,5"));
		assertEquals(42, Calculator.add("12,30"));
	}	

	@Test
        public void testMultipleNumbers(){
        	assertEquals(6, Calculator.add("1,2,3"));
        	assertEquals(1, Calculator.add("1,0,0"));
        	assertEquals(42, Calculator.add("11,12,13,6"));
        }
	@Test
	public void testNewLine(){
		assertEquals(7, Calculator.add("2\n2,3"));
		assertEquals(122, Calculator.add("100\n20,2"));
		assertEquals(42, Calculator.add("40\n2,0"));
	}
	@Test
	public void testNewDelimiter(){
		assertEquals(12, Calculator.add("//;\n5;7"));
		assertEquals(12, Calculator.add("//:\n5:7"));
		assertEquals(12, Calculator.add("//R\n5R7"));
	
	}
	@Test
        public void negativeNotAllowed(){
          try{
               Calculator.add("-2,3,-4");
	      // Assert.fail("Should have thrown NegativeNumberException but did not!");
          }catch (Exception negError){
         assertEquals("Negative numbers not allowed: -2, -4", negError.getMessage());
          }
        }
	@Test
	public void numbersLargerThan1000NotAllowed() {
	
		 assertEquals(42, Calculator.add("1001,2,40"));
	}
	@Test
	public void delimitersOfAnyLength() {
	
		 assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
}
