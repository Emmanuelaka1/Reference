package com.hardis.reference.exception;

/**
 * <b>ReferenceException</b> herite de la super classe
 * <b>RuntimeException</b><br>
 * ReferenceException permet de levees un exception pendant le fonctionnement
 * JVM
 * 
 * @author AKA
 *
 * @version V1.0
 */
public class ReferenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Le constructeur ReferenceException permet Construit une nouvelle exception
	 * avec un message.
	 * 
	 * @param message de type String
	 */
	public ReferenceException(String message) {
		super(message);
	}

}
