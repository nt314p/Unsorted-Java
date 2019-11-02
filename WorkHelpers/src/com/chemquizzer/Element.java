package com.chemquizzer;

public class Element {
	
	public String name;
	public String symbol;
	public int[] charges;
	public boolean multivalent;
	public boolean isMetal;
	
	
	public Element(String name, String symbol, int[] charges, boolean isMetal) {
		this.name = name;
		this.symbol = symbol;
		this.charges = charges;
		multivalent = charges.length > 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public int[] getCharges() {
		return charges;
	}

	public void setCharges(int[] charges) {
		this.charges = charges;
	}

	public boolean isMultivalent() {
		return multivalent;
	}

	public void setMultivalent(boolean multivalent) {
		this.multivalent = multivalent;
	}

	public boolean isMetal() {
		return isMetal;
	}

	public void setMetal(boolean isMetal) {
		this.isMetal = isMetal;
	}
	
}
