package com.hardis.reference.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hardis.reference.exception.ReferenceException;
import com.hardis.reference.model.ResponseReference;

/**
 * Cette classe <b>TransformeReferenceTest</b> permet de realiser les tests
 * unitaires du projet Reference
 * 
 * @author AKA
 *
 * @version V1.0
 */
public class TransformeReferenceTest {

	/**
	 * creation d'une instance de TransformeReference
	 */
	private TransformeReference transformeReference;

	/**
	 * creation d'une variable inputFile initialer avec un chemin d'entree de type
	 * type texte
	 */
	String inputFile = "src/main/resources/reference.txt";

	/**
	 * creation d'une variable outputFile initialer avec un chemin de sortie
	 */
	String outputFile = "src/main/resources/transformeReference.json";

	/**
	 * Initialise une instant TransformeReference avant chaque Test
	 * 
	 * @throws IOException
	 */
	@BeforeEach
	public void init() throws IOException {
		transformeReference = new TransformeReference();
	}

	/**
	 * Test la transformation d'un fichier Texte en JSON<br>
	 * La methode
	 * <b>{@link TransformeReference#createJsonOrXlm(String, String, String)}</b> de
	 * la classe <b>TransformeReference</b> avec un fichier Texte en entree,un
	 * chemin du fichier en sortie et un type JSON <br>
	 * Retourne true si le fichier a ete creer
	 */
	@Test
	public void transformeReference_return_true_txt_transforme_json() {
		String type = "json";
		boolean resultat = transformeReference.createJsonOrXlm(inputFile, outputFile, type);
		assertTrue(resultat);
	}

	/**
	 * Test la transformation d'un fichier Texte en XML<br>
	 * La methode
	 * <b>{@link TransformeReference#createJsonOrXlm(String, String, String)}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec un fichier Texte en
	 * entree,un chemin du fichier en sortie et un type XML <br>
	 * Retourne true si le fichier a ete creer
	 */
	@Test
	public void transformeReference_return_true_txt_transforme_xml() {
		String outputFile = "test", type = "xml";
		boolean resultat = transformeReference.createJsonOrXlm(inputFile, outputFile, type);
		assertTrue(resultat);
	}

	/**
	 * Test ReferenceException dans le cas ou le inputFile est vide
	 */
	/**
	 * Test la transformation d'un fichier Texte en XML<br>
	 * La methode
	 * <b>{@link TransformeReference#createJsonOrXlm(String, String, String)}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec un inputFile,un chemin du
	 * fichier en sortie et un type JSON <br>
	 * Retourne une ReferenceException sera lever
	 */
	@Test
	public void transformeReference_return_throws_exception_createJsonOrXlm() {
		String inputFile = "", type = "json";
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.createJsonOrXlm(inputFile, outputFile, type));
		assertTrue(thrown.getMessage().contains("error lors du traitement"));
	}

	/**
	 * Test la methode
	 * <b>{@link TransformeReference#verifPath(String, String, String)}</b> de la
	 * classe <b>{@link TransformeReference}</b> avec un outputFile vide et type XML
	 * <br>
	 * Retourne le chemin du fichier en sortie
	 */
	@Test
	public void transformeReference_test_verifpath() {
		String outputFile = "", type = "xml";
		String path = transformeReference.verifPath(inputFile, outputFile, type).getPath();
		assertTrue(path.equalsIgnoreCase("src\\main\\resources\\reference.xml"));
	}

	/**
	 * Test la methode
	 * <b>{@link TransformeReference#createJsonOrXlm(String, String, String)}</b> de
	 * la classe <b>{@link TransformeReference}</b> dans le cas ou le type de sortie
	 * est vide<br>
	 * Une ReferenceException sera lever
	 */
	@Test
	public void transformeReference_return_throws_exception_on_type() {
		String type = "";
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.createJsonOrXlm(inputFile, outputFile, type));
		assertTrue(thrown.getMessage().contains("type de sortie"));
	}

	/**
	 * Test la methode <b>{@link TransformeReference#verifContenu(String[])}</b> de
	 * la classe <b>{@link TransformeReference}</b> dans le cas numReference
	 * inferieur a 10 carateres<br>
	 * Une ReferenceException sera lever
	 */
	@Test
	public void transformeReference_return_throws_exception_on_numReference() {
		String[] valeur = "14601000;R;45.12;27".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("numReference"));
	}

	/**
	 * Test la methode <b>{@link TransformeReference#verifContenu(String[])}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec une valeur de price
	 * different d'un double<br>
	 * Une ReferenceException sera lever
	 */
	@Test
	public void transformeReference_return_throws_exception_on_price() {
		String[] valeur = "1460100040;R;AKA;27".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("price"));
	}

	/**
	 * Test la methode <b>{@link TransformeReference#verifContenu(String[])}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec une valeur de size
	 * different d'un entier<br>
	 * Une ReferenceException sera lever
	 */

	@Test
	public void transformeReference_return_throws_exception_on_taille() {
		String[] valeur = "1460100040;R;45.12;ALAIN".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("size"));
	}

	/**
	 * Test la methode <b>{@link TransformeReference#verifContenu(String[])}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec une valeur de color non
	 * specifier dans l'enumerer Color<br>
	 * Une ReferenceException sera lever
	 */
	@Test
	public void transformeReference_return_throws_exception_on_color() {
		String[] valeur = "1460100040;A;45.12;27".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("color"));
	}

	/**
	 * Test la methode <b>{@link TransformeReference#verifContenu(String[])}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec une valeur manquante<br>
	 * Une ReferenceException sera lever
	 */
	@Test
	public void transformeReference_return_throws_exception_on_arguments() {
		String[] valeur = "1460100040;G;45.12".split(";");
		ReferenceException thrown = assertThrows(ReferenceException.class,
				() -> transformeReference.verifContenu(valeur));
		assertTrue(thrown.getMessage().contains("arguments"));

	}

	/**
	 * Test la methode <b>{@link TransformeReference#createReference(String)}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec un inputFile<br>
	 * Retourne le nombre de reference valide
	 */
	@Test
	public void transformeReference_return_nombre_references_valide() throws IOException {
		ResponseReference response = transformeReference.createReference(inputFile);
		assertEquals(response.getReferences().size(), 4);
	}

	/**
	 * Test la methode <b>{@link TransformeReference#createReference(String)}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec inputFile<br>
	 * Retourne le nombre de reference erroner
	 */
	@Test
	public void transformeReference_return_nombre_reference_erroner() throws IOException {
		ResponseReference response = transformeReference.createReference(inputFile);
		assertEquals(response.getReferenceErroners().size(), 1);
	}

	/**
	 * Test la methode <b>{@link TransformeReference#createReference(String)}</b> de
	 * la classe <b>{@link TransformeReference}</b> avec un inputFile<br>
	 * Retourne le chemin du fichier texte
	 */
	@Test
	public void transformeReference_return_file_name() throws IOException {
		ResponseReference response = transformeReference.createReference(inputFile);
		assertTrue(response.getInputFile().endsWith(".txt"));
	}

}
