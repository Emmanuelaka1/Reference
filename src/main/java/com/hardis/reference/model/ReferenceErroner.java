package com.hardis.reference.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * <b>ReferenceErroner</b> est une Classe qui permet de serialiser en JSON/XML
 * les references erroner du fichier txt.<br>
 * 
 * @author AKA
 * 
 * @version V1.0
 */
public class ReferenceErroner {
	/**
	 * Le champ <b>line</b> permet de serialiser le nom de variable line et le
	 * numero de ligne erroner
	 * 
	 * @see ReferenceErroner#line
	 */
	@JacksonXmlProperty(isAttribute = true)
	private int line;

	/**
	 * Le champ <b>message</b> permet de serialiser le contenu de message et le
	 * champ message erroner de fichier txt
	 * 
	 * @see ReferenceErroner#message
	 */
	@JacksonXmlProperty(isAttribute = true)
	private String message;

	/**
	 * Le champ <b>value</b> permet de serialiser le contenu de la ligne erroner de
	 * 
	 * @see ReferenceErroner#value
	 */
	@JacksonXmlText
	private String value;

	/**
	 * Construsteur <b>ReferenceErroner</b> sans parameteres
	 * 
	 */
	public ReferenceErroner() {
	}

	/**
	 * Constructeur <b>ReferenceErroner</b> avec parametres
	 * 
	 * @param line    de type int
	 * 
	 * @param message de type String
	 * 
	 * @param value   de type String
	 * 
	 * @see ReferenceErroner#line
	 * 
	 * @see ReferenceErroner#message
	 * 
	 * @see ReferenceErroner#value
	 */
	public ReferenceErroner(int line, String message, String value) {
		this.line = line;
		this.message = message;
		this.value = value;
	}

	/**
	 * retourne la valeur du champ line
	 * 
	 * @return line
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Met a jour la variable line
	 * 
	 * @param line de type int
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * Retourne la valeur du champ message
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Met a jour le champ message
	 * 
	 * @param message de type String
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Retourne la valeur du champ value
	 * 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Met a jour le champ value
	 * 
	 * @param value de type String
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
