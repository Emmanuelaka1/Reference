package com.hardis.reference.metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.hardis.reference.exception.ReferenceException;
import com.hardis.reference.model.Color;
import com.hardis.reference.model.ContenuErroner;
import com.hardis.reference.model.Reference;
import com.hardis.reference.model.ResponseReference;

public class TransformeReference {

	/*
	 * methode pour le traitement du contenu du fichier text
	 * 
	 * @param inputFile
	 * 
	 * @return ResponseReference
	 * 
	 * @throws IOException
	 */
	public ResponseReference createReference(String inputFile) throws ReferenceException, IOException {
		List<String> contenuFichierText = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

		ResponseReference listeRefernce = new ResponseReference(inputFile);
		for (int i = 0; i < contenuFichierText.size(); i++) {
			String line = contenuFichierText.get(i);
			try {
				String[] valeur = line.split(";");
				verifContenu(valeur);
				Reference reference = new Reference();
				reference.setNumReference(valeur[0]);
				reference.setType(Color.valueOf(valeur[1]));
				reference.setPrice(Double.parseDouble(valeur[2]));
				reference.setSize(Integer.parseInt(valeur[3]));
				listeRefernce.addReference(reference);
			} catch (ReferenceException ex) {
				ContenuErroner error = new ContenuErroner(i, ex.getMessage(), line);

				listeRefernce.addContenuErroner(error);
			}
		}
		return listeRefernce;
	}

	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/*
	 * methode pour la verification du contenu du fichier
	 * 
	 * @param String[]
	 */

	public void verifContenu(String[] reference) {
		String colors = Arrays.asList(Color.values()).toString();
		if (reference.length != 4) {
			throw new ReferenceException("Incorrect number of arguments");
		}
		if (!colors.contains(reference[1])) {
			throw new ReferenceException("Incorrect value for color");
		}
		if (reference[0].length() != 10) {
			throw new ReferenceException("Incorrect value for numReference");
		}
		if (!isNumeric(reference[2])) {
			throw new ReferenceException("Incorrect value for price");
		}
		if (!isNumeric(reference[3])) {
			throw new ReferenceException("Incorrect value for size");
		}
	}

	/*
	 * methode pour la verification du repertoire de sortie
	 * 
	 * @param inputFile
	 * 
	 * @param outputFile
	 * 
	 * @param type
	 * 
	 * @return File
	 */
	private File verifPath(String inputFile, String outputFile, String type) {
		File file = null;

		if (!outputFile.isEmpty()) {
			file = new File(outputFile);

			String path = file.getPath().toLowerCase();
			if (!path.endsWith(".json") || !path.endsWith(".xml")) {
				String fileName = new File(inputFile).getName();
				int last = fileName.indexOf(".");
				path = new File(inputFile).getPath();
				path = path.substring(0, path.lastIndexOf(File.separator)) + File.separator
						+ fileName.substring(0, last) + "." + type;
				file = new File(path);
			}

			// System.out.println("path :" + path);
		}

		return file;
	}

	/*
	 * methode pour la creation du fichier XML ou JSON
	 * 
	 * @param inputFile
	 * 
	 * @param outputFile
	 * 
	 * @param type
	 */

	public boolean createJsonOrXlm(String inputFile, String outputFile, String type) throws ReferenceException {
		boolean result = false;
		try {
			ResponseReference listeRefernce = createReference(inputFile);

			File file = verifPath(inputFile, outputFile, type);

			if (type.equalsIgnoreCase("xml")) { // creer du fichier XML
				XmlMapper xmlMapper = new XmlMapper();
				xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
				xmlMapper.writeValue(file, listeRefernce);
				result = true;
			} else if (type.equalsIgnoreCase("json")) {// creer du fichier JSON
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.writeValue(file, listeRefernce);
				result = true;
			} else {
				throw new ReferenceException("le type de sortie demander non implementer");

			}

		} catch (IOException e) {
			throw new ReferenceException("error lors du traitement");
		}
		return result;

	}

}
