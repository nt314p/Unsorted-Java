package com.chemquizzer;

public class Atom extends Species{
	
	Element e;
	
	public Atom(String value, boolean valIsSymbol) {
		if (valIsSymbol) {
			e = Parser.getElSymbol(value);
		} else {
			e = Parser.getElName(value);
		}
		setName(e.getName());
		setFormula(e.getSymbol());
	}
	

}
