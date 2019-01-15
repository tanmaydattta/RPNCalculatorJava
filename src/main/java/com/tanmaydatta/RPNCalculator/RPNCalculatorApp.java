package com.tanmaydatta.RPNCalculator;

import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class RPNCalculatorApp 
{
	private IRPNCalculator calc = new RPNCalculator();
	
	public String processString(String input){
		StringTokenizer st = new StringTokenizer(input);
		String msg = null ;
		int position = -1;
		try{
			while (st.hasMoreTokens()) {
		         String token = st.nextToken();
		         position = position + token.length() + 1;
		         switch(token){
		         case "+":
		        	 calc.add();break;
		         case "-":
		        	 calc.subtract();break;
		         case "*":
		        	 calc.multiply();break;
		         case "/":
		        	 calc.divide();break;
		         case "sqrt":
		        	 calc.sqrt();break;
		         case "clear":
		        	 calc.clear();break;
		         case "undo":
		        	 calc.undo();break;
		         default:
		        	 calc.pushOperand(Double.parseDouble(token));
		         }
		     }
		}catch(InsufficientParametersException e){
			e.setPosition(position);
			msg = e.getMessage();
		}
		String stackRep = calc.toString();
		if(msg != null ){
			return String.format("%s\n%s",msg,stackRep);
		}
		return stackRep;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "RPNCalculator App" );
    }
}
