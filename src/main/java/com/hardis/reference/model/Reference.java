package com.hardis.reference.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "reference")
public class Reference {

	// declaration de variable et serialisation
	@JacksonXmlProperty(isAttribute = true)
	private String numReference;
	@JacksonXmlProperty(isAttribute = true)
	private int size;
	@JacksonXmlProperty(isAttribute = true)
	private double price;
	@JacksonXmlProperty(localName = "color", isAttribute = true)
	private Color type;

	// contructeur sans parametre
	public Reference() {
	}

	// constructeur avec paramètre
	public Reference(String numReference, int size, double price, Color type) {
		this.numReference = numReference;
		this.size = size;
		this.price = price;
		this.type = type;
	}

	// constructeur avec paramètre
	public Reference(String numReference, int size, double price) {
		this.numReference = numReference;
		this.size = size;
		this.price = price;
	}

	// getters et setters
	public String getNumReference() {
		return numReference;
	}

	public void setNumReference(String numReference) {
		this.numReference = numReference;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Color getType() {
		return type;
	}

	public void setType(Color type) {
		this.type = type;
	}

}
