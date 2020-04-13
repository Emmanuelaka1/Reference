package com.hardis.reference;

import java.io.IOException;
import java.util.Scanner;

import com.hardis.reference.metier.TransformeReference;

/**
 * <b>ApplicationMain</b> est la classe principal du projet Reference<br>
 * Elle permettra de demarrer l'application
 * 
 * @author AKA
 *
 * @version V1.0
 */
public class ApplicationMain {

	/**
	 * Creation d'une instance static TransformeReference
	 */
	public static final TransformeReference transformeReference = new TransformeReference();

	/**
	 * Cette methode main est point d'entrer de l'application elle s'execute sous
	 * forme de commande prenant les parametres suivants en entree : <br>
	 * o Chemin du fichier texte <br>
	 * o Format de sortie (XML/JSON)<br>
	 * o Chemin du fichier en sortie<br>
	 *
	 * @param args prend en arguments un tableau de String
	 * @throws IOException createJsonOrXlm
	 */
	public static void main(String args[]) throws IOException {

		/**
		 * declaration et initialisation des variables
		 */
		String fileInput = "", type = "", fileOutput = "", fin = "";

		/**
		 * Creation d'un object Scanner pour la lecture des entrees du clavier,
		 */
		Scanner sc = new Scanner(System.in);

		do {

			do {

				/**
				 * Affiche d'une instruction a l'utilisateur
				 */
				System.out.println("merci de saisir le chemin du fichier texte");

				/**
				 * Recuperation du fichier saisi
				 */
				fileInput = sc.nextLine();
				System.out.println("chemin du fichier texte saisi :" + fileInput + "\n");

				/**
				 * verification de l'extension du fichier saisi
				 */
			} while (!fileInput.endsWith(".txt"));

			do {
				/**
				 * Affiche d'une instruction a l'utilisateur
				 */
				System.out.println("merci de saisir le format de sortie (XML/JSON) ? ");

				/**
				 * Recuperation le format de sortie
				 */
				type = sc.nextLine();

				type = type.toLowerCase();

				System.out.println("le format de sortie choisi :" + type + "\n");

				/**
				 * verification du format de sortie
				 */
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
