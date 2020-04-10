package com.hardis.reference.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class ContenuErroner {
	// declaration variable et serialisation
	@JacksonXmlProperty(isAttribute = true)
	private int line;
	@JacksonXmlProperty(isAttribute = true)
	private String message;

	/*
	 * La valeur de la variable @value sera sérialisée sans encapsuleur la propriété
	 * (Serialisation XML)
	 */
	@JacksonXmlText
	private String value;

	// construsteur sans paramètres
	public ContenuErroner() {
	}

	// constructeur avec paramètres
	public ContenuErroner(int line, String message, String value) {
		this.line = line;
		this.message = message;
		this.value = value;
	}

	// accesseurs et muttateurs

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
