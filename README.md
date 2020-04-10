# Reference
Test technique Java

Contexte
Une société de service en informatique a décidé de développer un logiciel pour un de ses clients dont le but est de transformer un fichier TXT dans un format plus pratique.

Ce fichier contient une liste de références ainsi que diverses informations.

Le fichier TXT transmis peut éventuellement contenir des données erronées.

Il est donc nécessaire d’identifier les lignes erronées et détailler le type d’erreur trouvé.
Le format des références est expliqué ci-dessous: 
o	Numéro de la référence (10 chiffres)
o	Couleur, valeurs possibles :
o	R = Rouge 
o	G = Vert 
o	B = Bleu
o	Prix, valeur en euros (ex : 5.23) 
o	Taille, valeur entière

Exercice
Le but de l’exercice est d’écrire un programme Java 1.6+, capable de prendre un fichier texte en entrée ainsi que le format de sortie désiré (XML ou JSON).

Exemple de fichier TXT en entrée :
1460100040;R;45.12;27
1460900848;G;12.0;145
1462100044;G;5.56;19
1462100403;B;105.23;97
1462100403;A;100.1;9

Exemple de fichier XML en sortie :
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<report>
<inputFile>Ref_07102014.txt</inputFile>
<references>
 <reference color="R" price="45.12" size="27" numReference="1460100040"/>
 <reference color="G" price="12.0" size="145" numReference="1460900848"/>
 <reference color="G" price="5.56" size="19" numReference="1462100044"/>
 <reference color="B" price="105.23" size="97" numReference="1462100403"/>
</references>
<errors>
  <error line="5" message="Incorrect value for color">
         1462100403;A;100.1;9</error>
</errors>
</report>





Exemple de fichier JSON en sortie :
{
  "inputFile" : "Ref_07102014.txt",

"references" : [ {
  "numReference" : "1460100040",
  "size" : 27,
  "price" : 45.12,
  "type" : "R"
}, {
  "numReference" : "1460900848",
  "size" : 145,
  "price" : 12.0,
  "type" : "G"
}, {
  "numReference" : "1462100044",
  "size" : 19,
  "price" : 5.56,
  "type" : "G"
}, {
  "numReference" : "1462100403",
  "size" : 97,
  "price" : 105.23,
  "type" : "B"
} ],
"errors" : [{
  "line" : 5,
  "message" : "Incorrect value for color",
  "value" : "1462100403;A;100.1;9"
}]
}
Consignes
Merci de respecter les consignes suivantes :
o	Pas plus de 3 heures de développement (l’objectif n’est pas de terminer l’exercice dans sa totalité mais de vérifier votre implémentation)
o	Le programme s’exécutera sous la forme d’une commande prenant les paramètres suivants en entrée :
o	Chemin du fichier texte
o	Format de sortie (XML/JSON)
o	Chemin du fichier en sortie
o	L’application devra comporter des tests unitaires
o	Le code devra être commenté
o	Vous êtes libres d’utiliser tous les outils et librairies à votre disposition
L’attention sera portée sur l’architecture du code, sa qualité, la gestion des erreurs et dans une moindre mesure le packaging.
