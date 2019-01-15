package com.tanmaydatta.RPNCalculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Stack;

public class RPNCalculator implements IRPNCalculator {
	//The basic container is stack
	private Stack<Double> _stack = new Stack<Double>();
	private Stack<Stack<Double>> _state = new Stack<Stack<Double>>();
	
	
	
	
	public void pushOperand(double operand){
		Stack<Double> currentStackCopy = new Stack<Double>();
		currentStackCopy.addAll(Arrays.asList(this.toArray()));
		this._stack.push(operand);
		this._state.push(currentStackCopy);
		
	}
	
	public void add() {
		Stack<Double> currentStackCopy = new Stack<Double>();
		currentStackCopy.addAll(Arrays.asList(this.toArray()));
	
		this._state.push(currentStackCopy);
		if(_stack.size() > 1){
			Double top1 = this._stack.pop();
			Double top2 = this._stack.pop();
			_stack.push(top1+top2);
		}else{
			throw new InsufficientParametersException("+");
		}
	}

	public void clear() {
		this._state.push(_stack);
		this._stack.removeAllElements();
		
		
	}

	public Double[] toArray() {
		Double [] operandArray = this._stack.toArray(new Double[this._stack.size()]);
		return operandArray;
	}
	
	private String getPreciseRep(Double val){
		BigDecimal preciseVal = new BigDecimal(val);
		preciseVal = preciseVal.setScale(10, BigDecimal.ROUND_DOWN);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(10);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(false);
		return df.format(preciseVal);	
		
	}
	private String [] getStringRepOfStack(){
		Double [] operands = this.toArray();
		String [] strs = new String[operands.length];
		for(int i = 0 ; i < operands.length;i++){
			strs[i] = getPreciseRep(operands[i]);
		}
		return strs;
	}

	

	public void sqrt() throws InsufficientParametersException {
		this._state.push(_stack);
		
		if(_stack.size() > 0){
			Double top = this._stack.pop();
			_stack.push(Double.valueOf(Math.sqrt(top)));
		}else{
			throw new InsufficientParametersException("sqrt");
		}
		
	}
	
	public String toString(){
		String [] stackStringRep = this.getStringRepOfStack();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < stackStringRep.length ; i++ ){
			sb.append(stackStringRep[i]);
			sb.append(" ");
		}
		return String.format("stack: %s",sb.toString());
	}

	public void subtract() throws InsufficientParametersException {
		Stack<Double> currentStackCopy = new Stack<Double>();
		currentStackCopy.addAll(Arrays.asList(this.toArray()));
		
		this._state.push(currentStackCopy);
		if(_stack.size() > 1){
			Double top1 = this._stack.pop();
			Double top2 = this._stack.pop();
			_stack.push(top2-top1);
		}else{
			throw new InsufficientParametersException("-");
		}
		
	}

	public void multiply() throws InsufficientParametersException {
		Stack<Double> currentStackCopy = new Stack<Double>();
		currentStackCopy.addAll(Arrays.asList(this.toArray()));
	
		this._state.push(currentStackCopy);
		if(_stack.size() > 1){
			Double top1 = this._stack.pop();
			Double top2 = this._stack.pop();
			_stack.push(top2*top1);
		}else{
			throw new InsufficientParametersException("*");
		}
		
	}

	public void divide() throws InsufficientParametersException {
		Stack<Double> currentStackCopy = new Stack<Double>();
		currentStackCopy.addAll(Arrays.asList(this.toArray()));
	
		this._state.push(currentStackCopy);
		if(_stack.size() > 1){
			Double top1 = this._stack.pop();
			Double top2 = this._stack.pop();
			_stack.push(top2/top1);
		}else{
			throw new InsufficientParametersException("/");
		}
		
	}

	public void undo() throws InsufficientParametersException {
		if(this._state.size() != 1){
			this._stack = this._state.pop();
		}else{
			throw new InsufficientParametersException("undo");
		}
		
	}
 
	

}
