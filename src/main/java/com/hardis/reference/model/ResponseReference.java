package com.hardis.reference.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

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
@JacksonXmlRootElement(localName = "report")
public class ResponseReference {

	/**
	 * inputFile va contenir le chemin du fichier texte entree
	 */
	private String inputFile;

	/**
	 * references va contenir la liste des references valide
	 */
	private List<Reference> references;

	/**
	 * errors va contenir la liste des references erroner
	 */
	private List<ReferenceErroner> errors;

	/**
	 * Constructeur <b>ResponseReference</b> sans parametre <br>
	 * Il initiale les listes {@link ResponseReference#references} et
	 * {@link ResponseReference#references}
	 */
	public ResponseReference() {
		this.references = new ArrayList<Reference>();
		this.errors = new ArrayList<ReferenceErroner>();
	}

	/**
	 * Constructeur <b>ResponseReference</b> avec parametre <br>
	 * <br>
	 * Il initiale les listes {@link ResponseReference#references} et
	 * {@link ResponseReference#references}
	 * 
	 * @param inputFile de type String
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
	 * @param inputFile de type String
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * ajouter une reference a la liste des references
	 * 
	 * @param reference de type Reference
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
	 * @param referenceErroner de type ReferenceErroner
	 */
	public void addReferenceErroner(ReferenceErroner error) {
		this.errors.add(error);
	}

	/**
	 * retourne la liste des references erroner
	 * 
	 * @return errors
	 */
	public List<ReferenceErroner> getReferenceErroners() {
		return errors;
	}

}
