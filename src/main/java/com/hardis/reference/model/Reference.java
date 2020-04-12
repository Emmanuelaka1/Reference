package com.hardis.reference.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * <b>Reference</b> est une Classe qui permet de serialiser en JSON/XML chaque
 * reference du fichier txt.<br>
 * 
 * @author AKA
 * 
 * @version V1.0
 */
@JacksonXmlRootElement(localName = "reference")
public class Reference {

	/**
	 * declaration de variable
	 */
	@JacksonXmlProperty(isAttribute = true)
	private String numReference;
	@JacksonXmlProperty(isAttribute = true)
	private int size;
	@JacksonXmlProperty(isAttribute = true)
	private double price;
	@JacksonXmlProperty(localName = "color", isAttribute = true)
	private Color type;

	/**
	 * Contructeur <b>Reference</b> sans parametre
	 */
	public Reference() {
	}

	/**
	 * constructeur <b>Reference</b> avec paramètre
	 * 
	 * @param numReference
	 * @param size
	 * @param price
	 * @param type
	 */
	public Reference(String numReference, int size, double price, Color type) {
		this.numReference = numReference;
		this.size = size;
		this.price = price;
		this.type = type;
	}

	/**
	 * Retourne la valeur du champ numReference
	 * 
	 * @return numReference
	 */
	public String getNumReference() {
		return numReference;
	}

	/**
	 * Met a jour la variable numReference
	 * 
	 * @param numReference
	 */
	public void setNumReference(String numReference) {
		this.numReference = numReference;
	}

	/**
	 * Retourne la valeur du champ size
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Met a jour la variable size
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Retourne la valeur du champ price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Met a jour la variable price
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Retourne la valeur du champ type
	 * 
	 * @return type
	 */
	public Color getType() {
		return type;
	}

	/**
	 * Met a jour la variable type
	 * 
	 * @param type
	 */
	public void setType(Color type) {
		this.type = type;
	}

}
