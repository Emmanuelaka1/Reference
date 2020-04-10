package com.hardis.reference.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hardis.reference.exception.ReferenceException;
import com.hardis.reference.model.ResponseReference;

public class TransformeReferenceTest {

	TransformeReference transformeReference;

	String inputFile = "src/main/resources/reference.txt";
	String outputFile = "src/main/resources/transformeReference.json";

	@BeforeEach
	public void init() throws IOException {
		transformeReference = new TransformeReference();
	}

	@Test
	public void transformeReference_return_true_txt_transforme_json() {
		String type = "json";
		boolean resultat = transformeReference.createJsonOrXlm(inputFile, outputFile, type);
		assertTrue(resultat);
	}

	@Test
	public void transformeReference_return_true_txt_transforme_xml() {
		String type = "xml";
		boolean resultat = transformeReference.createJsonOrXlm(inputFile, outputFile, type);
		assertTrue(resultat);
	}

	@Test
	public void transformeReference_return_throws_exception_createJsonOrXlm() {
		String inputFiles = "", type = "json";
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.createJsonOrXlm(inputFiles, outputFile, type));
		assertTrue(thrown.getMessage().contains("error lors du traitement"));
	}

	@Test
	public void transformeReference_return_throws_exception_on_type() {
		String type = "";
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.createJsonOrXlm(inputFile, outputFile, type));
		assertTrue(thrown.getMessage().contains("type de sortie"));
	}

	@Test
	public void transformeReference_return_throws_exception_on_numReference() {
		String[] valeur = "14601000;R;45.12;27".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("numReference"));
	}

	@Test
	public void transformeReference_return_throws_exception_on_price() {
		String[] valeur = "1460100040;R;AKA;27".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("price"));
	}

	@Test
	public void transformeReference_return_throws_exception_on_taille() {
		String[] valeur = "1460100040;R;45.12;ALAIN".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("size"));
	}

	@Test
	public void transformeReference_return_throws_exception_on_color() {
		String[] valeur = "1460100040;A;45.12;27".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("color"));
	}

	@Test
	public void transformeReference_return_throws_exception_on_arguments() {
		String[] valeur = "1460100040;G;45.12".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("arguments"));

	}

	@Test
	public void transformeReference_return_nombre_references_valide() throws IOException {
		ResponseReference response = transformeReference.createReference(inputFile);
		assertEquals(response.getReferences().size(), 4);
	}

	@Test
	public void transformeReference_return_nombre_contenu_erroner() throws IOException {
		ResponseReference response = transformeReference.createReference(inputFile);
		assertEquals(response.getContenuErroners().size(), 1);
	}

	@Test
	public void transformeReference_return_file_name() throws IOException {
		ResponseReference response = transformeReference.createReference(inputFile);
		assertTrue(response.getInputFile().endsWith("reference.txt"));
	}

}
