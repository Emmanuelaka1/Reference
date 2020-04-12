package com.hardis.reference.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>ResponseReference</b> est une Classe qui permet contenir tous les donnees
 * serialiser<br>
 * -le chemin du fichier texte.<br>
 * -La liste des references<br>
 * -La liste des references erroner<br>
 * 
 * @author AKA
 * 
 * @version V1.0
 */

public class ResponseReference {

	/**
	 * declaration de variable
	 */
	private String inputFile;
	private List<Reference> references;
	private List<ReferenceErroner> errors;

	/**
	 * Constructeur <b>ResponseReference</b> sans parametre
	 */
	public ResponseReference() {
		this.references = new ArrayList<Reference>();
		this.errors = new ArrayList<ReferenceErroner>();
	}

	/**
	 * Constructeur <b>ResponseReference</b> avec parametre
	 * 
	 * @param inputFile
	 * 
	 * @see {@link ResponseReference#addReference(Reference)}
	 * 
	 * @see {@link ResponseReference#addReferenceErroner(ReferenceErroner)}
	 * 
	 */
	public ResponseReference(String inputFile) {
		this.inputFile = inputFile;
		this.references = new ArrayList<Reference>();
		this.errors = new ArrayList<ReferenceErroner>();
	}

	/**
	 * Retourne la valeur du champ inputFile
	 * 
	 * @return inputFile
	 */
	public String getInputFile() {
		return inputFile;
	}

	/**
	 * Met à jour la variable inputFile
	 * 
	 * @param inputFile
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * ajouter une reference a la liste des references
	 * 
	 * @param reference
	 * 
	 * @see ResponseReference#references
	 */
	public void addReference(Reference reference) {
		this.references.add(reference);
	}

	/**
	 * retourne la liste des references
	 * 
	 * @return references
	 */
	public List<Reference> getReferences() {
		return references;
	}

	/**
	 * ajout une refence Erroner a la liste des refences erroner
	 * 
	 * @param referenceErroner
	 */
	public void addReferenceErroner(ReferenceErroner referenceErroner) {
		this.errors.add(referenceErroner);
	}

	/**
	 * retourne la liste des references erroner
	 * 
	 * @return errors
	 */
	public List<ReferenceErroner> getContenuErroners() {
		return errors;
	}

}
