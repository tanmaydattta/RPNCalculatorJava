package com.tanmaydatta.RPNCalculator;

/*
 * As per requirements bullet point 4
 * Available operators are +, -, *, /, sqrt, undo, clear
 */
public interface IRPNCalculator {
	
	/*
	 *  Arithmetical functions
	 */
	void add() throws InsufficientParametersException;
	void subtract() throws InsufficientParametersException;
	void multiply() throws InsufficientParametersException;
	void divide() throws InsufficientParametersException;
	void sqrt() throws InsufficientParametersException;
	
	void pushOperand(double operand);
	/*
	 * Clears all the operands for current calculation
	 */
	void clear();
	/*
	 * Undo the last operation performed
	 */
	void undo() throws InsufficientParametersException;
	/*
	 *  Get array of operands
	 */
	Double [] toArray();
	/*
	 * 
	 */
	
	

}
