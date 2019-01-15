package com.tanmaydatta.RPNCalculator;

public class InsufficientParametersException extends RuntimeException {
	
	private int _position;
	private String _operator;
	public InsufficientParametersException(String operator){
		this._operator = operator;
	}
	public void setPosition(int position){
		this._position = position;
	}
	public String getMessage(){
		String message = String.format("operator %s (position: %d): insufficient parameters ",this._operator,this._position);
	    return message;
	}

}
