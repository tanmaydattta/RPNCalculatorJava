package com.tanmaydatta.RPNCalculator;




import org.junit.Test;
import static org.junit.Assert.*;


public class RPNCalculatorAppTest 
   
{
	/**
	 * Test the app
	 */

   @Test
   public void testSimplePushExample1(){
	   RPNCalculatorApp calcApp = new RPNCalculatorApp();
	   String output = calcApp.processString("5 2");
	   assertEquals("stack: 5 2 ",output);
   }
   
   @Test
   public void testSimpleSqrtExample2(){
	   RPNCalculatorApp calcApp = new RPNCalculatorApp();
	   String output = calcApp.processString("2 sqrt");
	   assertEquals("stack: 1.4142135623 ",output);
   }
   
   @Test
   public void testSubtractAndClearExample3(){
	   RPNCalculatorApp calcApp = new RPNCalculatorApp();
	   String output = calcApp.processString("5 2 -");
	   assertEquals("stack: 3 ",output);
	   output = calcApp.processString("3 -");
	   assertEquals("stack: 0 ",output);
	   output = calcApp.processString("clear");
	   assertEquals("stack: ",output);
   }
   
   @Test
   public void testMultiplyAndUndoExample4(){
	   RPNCalculatorApp calcApp = new RPNCalculatorApp();
	   String output = calcApp.processString("5 4 3 2");
	   assertEquals("stack: 5 4 3 2 ",output);
	   output = calcApp.processString("undo undo *");
	   assertEquals("stack: 20 ",output);
	   output = calcApp.processString("5 *");
	   assertEquals("stack: 100 ",output);
	   output = calcApp.processString("undo");
	   assertEquals("stack: 20 5 ",output);
   }
   
   @Test
   public void testMultiplyAndDivideExample5(){
	   RPNCalculatorApp calcApp = new RPNCalculatorApp();
	   String output = calcApp.processString("7 12 2 /");
	   assertEquals("stack: 7 6 ",output);
	   output = calcApp.processString("*");
	   assertEquals("stack: 42 ",output);
	   output = calcApp.processString("4 /");
	   assertEquals("stack: 10.5 ",output);
	}
   @Test
   public void testMultiplyAndSubtractNegExample6(){
	   RPNCalculatorApp calcApp = new RPNCalculatorApp();
	   String output = calcApp.processString("1 2 3 4 5");
	   assertEquals("stack: 1 2 3 4 5 ",output);
	   output = calcApp.processString("*");
	   assertEquals("stack: 1 2 3 20 ",output);
	   output = calcApp.processString("clear 3 4 -");
	   assertEquals("stack: -1 ",output);
	}
   
   @Test
   public void testAllMultiplyExample7(){
	   RPNCalculatorApp calcApp = new RPNCalculatorApp();
	   String output = calcApp.processString("1 2 3 4 5");
	   assertEquals("stack: 1 2 3 4 5 ",output);
	   output = calcApp.processString("* * * *");
	   assertEquals("stack: 120 ",output);
	}
   @Test
   public void testAllMultiplyExample8(){
	   RPNCalculatorApp calcApp = new RPNCalculatorApp();
	   String output = calcApp.processString("1 2 3 * 5 + * * 6 5");
	   assertEquals("operator * (position: 15): insufficient parameters \nstack: 11 ",output);
	}
    
}
