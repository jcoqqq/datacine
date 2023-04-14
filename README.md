# Dataciné avec Spring Boot et Java EE
Cette application est une plateforme qui permet de recenser des films, des acteurs et des réalisateurs, et de laisser des avisFilm sur les films. Les utilisateurs peuvent créer un compte, se connecter et laisser des commentaires sur les films qu'ils ont vus.

# Technologies utilisées
- Spring Boot
- Java EE
- Lombok
- Persistence
- MySQL
- HTML, CSS, JavaScript

# Fonctionnalités de l'application
- Inscription et connexion des utilisateurs
- Ajout, modification et suppression de films, acteurs et réalisateurs
- Recherche de films, acteurs et réalisateurs
- Affichage de la liste des films, acteurs et réalisateurs
- Affichage des détails d'un film, avec les avisFilm des utilisateurs
- Les utilisateurs peuvent commenter et donner des notes aux films
#Comment exécuter l'application
# Prérequis
- Java 8 ou supérieur
- Wamp server ou UWampServer
# Étapes
- Clonez le dépôt Git de l'application :
- Configurez la base de données MySQL :
Récupérer le fichier datacine.sql situé au chemin suivant : src/main/resources/templates/sql/

Dans mySql, connecter vous en root (user : root, mdp : root) aller sur "Nouvelle base de données" -> SQL et copier le fichier datacine.sql. 

![image](https://user-images.githubusercontent.com/101265107/231960273-27489edc-aa9a-480e-b8d3-653a1b703719.png)

La BDD est maintenant crée !

- Lancer ensuite l'application à l'aide de la class : src/main/java/datacine/ProjetSpringDatacineApplication.java

- Accédez ensuite à l'application dans votre navigateur à l'adresse suivante :
http://localhost:8081/

