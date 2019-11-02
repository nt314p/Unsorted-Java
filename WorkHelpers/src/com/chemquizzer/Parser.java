package com.chemquizzer;

import java.util.ArrayList;

public class Parser {

	public static final String[] names = { "Hydrogen", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen",
			"Fluorine", "Sodium", "Magnesium", "Aluminum", "Silicon", "Phosphorus", "Sulfur", "Chlorine", "Potassium",
			"Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel",
			"Copper", "Zinc", "Gallium", "Arsenic", "Selenium", "Bromine", "Rubidium", "Strontium", "Yttrium",
			"Zirconium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Iodine", "Cesium", "Barium", "Tungsten",
			"Platinum", "Gold", "Mercury", "Lead" };

	public static final String[] symbols = { "H", "Li", "Be", "B", "C", "N", "O", "F", "Na", "Mg", "Al", "Si", "P", "S",
			"Cl", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "As", "Se", "Br", "Rb",
			"Sr", "Y", "Zr", "Pd", "Ag", "Cd", "In", "Sn", "I", "Cs", "Ba", "W", "Pt", "Au", "Hg", "Pb" };

	public static final int[][] charges = { { 1 }, { 1 }, { 3 }, { 3 }, { 4 }, { -3 }, { -2 }, { -1 }, { 1 }, { 2 },
			{ 3 }, { 4 }, { -3 }, { -2 }, { -1 }, { 1 }, { 2 }, { 3 }, { 3, 4 }, { 4, 5 }, { 2, 3 }, { 2, 4 }, { 2, 3 },
			{ 2, 3 }, { 2, 3 }, { 1, 2 }, { 2 }, { 3 }, { -3 }, { -2 }, { -1 }, { 1 }, { 2 }, { 3 }, { 4 }, { 2, 4 },
			{ 1 }, { 2 }, { 3 }, { 2, 4 }, { -1 }, { 1 }, { 2 }, { 6 }, { 2, 4 }, { 1, 3 }, { 1, 2 }, { 2, 4 } };

	public static final boolean[] metals = { false, true, true, false, false, false, false, false, true, true, true,
			false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true,
			false, false, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true,
			true, true, true };

	public static final String[][] ions = { { "F", "fluoride" }, { "Cl", "chloride" }, { "Br", "bromide" },
			{ "I", "iodide" }, { "O", "oxide" }, { "S", "sulfide" }, { "Se", "selenide" }, { "Te", "telluride" },
			{ "N", "nitride" }, { "P", "phosphide" }, { "As", "arsenide" } };

	public static final String[] prefixes = { "ZERO", "mono", "di", "tri", "tetra", "penta", "hexa", "hepta", "octa",
			"nona", "deca" };

	public static void main(String[] args) {
		initializeAtoms();
		System.out.println(toName("CO"));
		System.out.println(toName("CO2"));
		System.out.println(toName("S2O3"));
		System.out.println(toName("SiF4"));
	}

	private static Element[] elements;

	public static String toName(String formula) {
		ArrayList<Element> els = new ArrayList<Element>();
		ArrayList<Integer> copies = new ArrayList<Integer>();
		String currName = "";
		for (int i = 0; i < formula.length(); i++) {
			currName += formula.charAt(i) + "";
			Element e = getElSymbol(currName);

			if (e != null) {
				try {
					Element temp = e;
					e = getElSymbol(currName + formula.charAt(i + 1));
					if (e == null) {
						e = temp;
					}
				} catch (StringIndexOutOfBoundsException ex) {
				}
				els.add(e);
				try {
					int j = Integer.parseInt(formula.charAt(i + 1) + "");
					copies.add(j);
				} catch (NumberFormatException ex) {
					copies.add(1);
				} catch (StringIndexOutOfBoundsException ex) {
					copies.add(1);
				}
				currName = "";
			} else {
				currName = "";
			}
		}
		boolean molecule = true;
		for (int i = 0; i < els.size(); i++) {
			if (els.get(i).isMetal) {
				molecule = false;
			}
		}

		if (molecule) { // molecule -----------------
			String ret = "";
			for (int i = 0; i < els.size(); i++) {
				if (i != 0 || copies.get(0) != 1) {
					ret += prefixes[copies.get(i)];
				}
				if (i != els.size() - 1) {
					ret += els.get(i).getName() + " ";
				} else {
					ret += nonmetalIonName(els.get(i).getName());
				}
			}
			ret = ret.replace("oo", "o");
			return ret;
		} else {
			
		}

		String ret = "";
		for (int i = 0; i < els.size(); i++) {
			ret += els.get(i).getName() + " ";
		}
		return ret;
	}

	public static String nonmetalIonName(String name) {
		String symbol = getElName(name).getSymbol();
		for (String[] s : ions) {
			if (s[0].equals(symbol)) {
				return s[1];
			}
		}
		return "";
	}

	public static Element getElName(String name) {
		for (Element e : elements) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}

	public static Element getElSymbol(String symbol) {
		for (Element e : elements) {
			if (e.getSymbol().equals(symbol)) {
				return e;
			}
		}
		return null;
	}

	public static void initializeAtoms() {
		elements = new Element[names.length];
		for (int i = 0; i < names.length; i++) {
			elements[i] = new Element(names[i].toLowerCase(), symbols[i], charges[i], metals[i]);
		}
	}

}
