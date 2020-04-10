package com.hardis.reference;

import java.io.IOException;
import java.util.Scanner;

import com.hardis.reference.metier.TransformeReference;

public class ApplicationMain {

	public static final TransformeReference transformeReference = new TransformeReference();

	public static void main(String args[]) throws IOException {

		// declaration et initialisation des variables vide
		String fileInput = "", type = "", fileOutput = "", fin = "";

		// Notre objet Scanner,
		Scanner sc = new Scanner(System.in);

		do {

			do {
				// On affiche une instruction
				System.out.println("merci de saisir le chemin du fichier texte");

				// On récupère le fichier saisi
				fileInput = sc.nextLine();
				System.out.println("chemin du fichier texte saisi :" + fileInput + "\n");
				// verifier l'extension du fichier
			} while (!fileInput.endsWith(".txt"));

			do {
				// On affiche une instruction
				System.out.println("merci de saisir le format de sortie (XML/JSON) ? ");
				// On récupère le type saisi
				type = sc.nextLine();

				type = type.toLowerCase();

				System.out.println("le format de sortie choisi :" + type + "\n");

			} while (!(type.equals("xml") || type.equals("json")));

			do {
				System.out.println("merci de saisir le chemin du fichier en sortie");

				fileOutput = sc.nextLine();

				System.out.println("chemin de sortie du fichier saisi :" + fileOutput + "\n");
			} while (fileOutput.equals(""));

			transformeReference.createJsonOrXlm(fileInput, fileOutput, type);

			System.out.println("Merci de saisir OK pour reprendre une autre convertion \n");

			fin = sc.nextLine();

		} while (fin.equalsIgnoreCase("ok"));
	}

}
