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
	 * Le champ <b>numReference</b> permet de serialiser le nom de variable
	 * numReference la valeur de numReference
	 */
	@JacksonXmlProperty(isAttribute = true)
	private String numReference;

	/**
	 * Le champ <b>size</b> permet de serialiser le nom de variable size et la
	 * valeur de size
	 */
	@JacksonXmlProperty(isAttribute = true)
	private int size;

	/**
	 * Le champ <b>price</b> permet de serialiser le nom de variable price et la
	 * valeur de price
	 */
	@JacksonXmlProperty(isAttribute = true)
	private double price;

	/**
	 * Le champ <b>type</b> permet de serialiser le nom color et la valeur type
	 */
	@JacksonXmlProperty(localName = "color", isAttribute = true)
	private Color type;

	/**
	 * Contructeur <b>Reference</b> sans parametre
	 */
	public Reference() {
	}

	/**
	 * constructeur <b>Reference</b> avec parametres
	 * 
	 * @param numReference de type String
	 * @param size         de type int
	 * @param price        de type double
	 * @param type         de type {@link Color}
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
	 * @param numReference de type String
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
	 * @param size de type int
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
	 * @param price de type double
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
	 * @param type de type Color
	 */
	public void setType(Color type) {
		this.type = type;
	}

}
