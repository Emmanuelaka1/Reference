package com.hardis.reference.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseReference {

	// declaration de variable privées
	private String inputFile;
	private List<Reference> references;
	private List<ContenuErroner> Errors;

	// constructer sans paramètre
	public ResponseReference() {
		this.references = new ArrayList<Reference>();
		this.Errors = new ArrayList<ContenuErroner>();
	}

	// contructeur avec paramètre
	public ResponseReference(String inputFile) {
		this.inputFile = inputFile;
		this.references = new ArrayList<Reference>();
		this.Errors = new ArrayList<ContenuErroner>();
	}

	// getters
	public String getInputFile() {
		return inputFile;
	}

	// setters
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	// ajouter une reference a la liste des refernces
	public void addReference(Reference reference) {
		this.references.add(reference);
	}

	// retourne la liste des references
	public List<Reference> getReferences() {
		return references;
	}

	// ajout une refence Erroner a la liste des refences erroner
	public void addContenuErroner(ContenuErroner contenuErroner) {
		this.Errors.add(contenuErroner);
	}

	// retourne la liste des references erroner
	public List<ContenuErroner> getContenuErroners() {
		return Errors;
	}

}
