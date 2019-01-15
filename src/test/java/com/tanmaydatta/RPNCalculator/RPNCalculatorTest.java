package com.tanmaydatta.RPNCalculator;



import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;


public class RPNCalculatorTest 
   
{
	IRPNCalculator calc = new RPNCalculator();

    /**
     * Tests given as a part of assignment
     */
    
    
    /**
     *  Push two numbers to the Calculator and verify the stack
     */
	@Test
    public void testPush(){
    	calc.clear();
    	Double operands [] = {2d,5d};
    	calc.pushOperand(operands[0]);
    	calc.pushOperand(operands[1]);
    	Double [] operandCalc = calc.toArray();
    	assertTrue(Arrays.equals(operands, operandCalc));
    }
    /**
     * If no operands are added the sqrt should raise exception as per assignment.
     */
    @Test(expected=InsufficientParametersException.class)
    public void testSqrtEmpty(){
    	calc.clear();
    	calc.sqrt();
    }
    /**
     * Test sqrt with simple values
     */
    @Test
   public void testSqrt2(){
    	calc.clear();
    	calc.pushOperand(2d);
    	calc.sqrt();
    	assertEquals(calc.toString(),"stack: 1.4142135623 ");
    }
    @Test
    public void testSqrt9(){
     	calc.clear();
     	calc.pushOperand(9d);
     	calc.sqrt();
     	assertEquals(calc.toString(),"stack: 3 ");
     }
    /**
     * Check +,-,*,/ work for simple cases
     */
    @Test
    public void testAdd(){
    	calc.clear();
    	calc.pushOperand(5d);
    	calc.pushOperand(3d);
    	calc.add();
    	assertEquals(calc.toString(),"stack: 8 ");
    }
    @Test
    public void testSubtract(){
    	calc.clear();
    	calc.pushOperand(5d);
    	calc.pushOperand(3d);
    	calc.subtract();
    	assertEquals(calc.toString(),"stack: 2 ");
    }
    @Test
    public void testMultiply(){
    	calc.clear();
    	calc.pushOperand(5d);
    	calc.pushOperand(3d);
    	calc.multiply();
    	assertEquals(calc.toString(),"stack: 15 ");
    }
    @Test
    public void testDivide(){
    	calc.clear();
    	calc.pushOperand(12d);
    	calc.pushOperand(2d);
    	calc.divide();
    	assertEquals(calc.toString(),"stack: 6 ");
    }
    /**
     * Test undo function
     */
    @Test
    public void testUndoExample4(){
    	calc.clear();
    	calc.pushOperand(5d);
    	calc.pushOperand(4d);
    	calc.pushOperand(3d);
    	calc.pushOperand(2d);
    	assertEquals(calc.toString(),"stack: 5 4 3 2 ");
    	calc.undo();
    	calc.undo();
    	calc.multiply();
    	assertEquals(calc.toString(),"stack: 20 ");
    }
    @Test
    public void testMultDivideExample5(){
    	calc.clear();
    	calc.pushOperand(7d);
    	calc.pushOperand(12d);
    	calc.pushOperand(2d);
    	calc.divide();
    	assertEquals(calc.toString(),"stack: 7 6 ");
    	calc.multiply();
    	assertEquals(calc.toString(),"stack: 42 ");
    	calc.pushOperand(4d);
    	calc.divide();
    	assertEquals(calc.toString(),"stack: 10.5 ");
    }
    @Test
    public void testSubtractMultiplyClearExample6(){
    	calc.clear();
    	calc.pushOperand(1d);
    	calc.pushOperand(2d);
    	calc.pushOperand(3d);
    	calc.pushOperand(4d);
    	calc.pushOperand(5d);
    	assertEquals(calc.toString(),"stack: 1 2 3 4 5 ");
    	calc.multiply();
    	assertEquals(calc.toString(),"stack: 1 2 3 20 ");
    	calc.clear();
    	calc.pushOperand(3d);
    	calc.pushOperand(4d);
    	calc.subtract();
    	assertEquals(calc.toString(),"stack: -1 ");
    }
    @Test
    public void testAllMutilplyExample7(){
    	calc.clear();
    	calc.pushOperand(1d);
    	calc.pushOperand(2d);
    	calc.pushOperand(3d);
    	calc.pushOperand(4d);
    	calc.pushOperand(5d);
    	assertEquals(calc.toString(),"stack: 1 2 3 4 5 ");
    	calc.multiply();
    	calc.multiply();
    	calc.multiply();
    	calc.multiply();
    	assertEquals(calc.toString(),"stack: 120 ");
    }
    
    
}
