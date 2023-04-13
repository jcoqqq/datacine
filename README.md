# Dataciné avec Spring Boot et Java EE
Cette application est une plateforme qui permet de recenser des films, des acteurs et des réalisateurs, et de laisser des avisFilm sur les films. Les utilisateurs peuvent créer un compte, se connecter et laisser des commentaires sur les films qu'ils ont vus.

# Technologies utilisées
- Spring Boot
- Java EE
- MySQL
- HTML, CSS, JavaScript
- Bootstrap

# Fonctionnalités de l'application
Inscription et connexion des utilisateurs
Ajout, modification et suppression de films, acteurs et réalisateurs
Recherche de films, acteurs et réalisateurs
Affichage de la liste des films, acteurs et réalisateurs
Affichage des détails d'un film, avec les avisFilm des utilisateurs
Laisser des avisFilm sur les films
#Comment exécuter l'application
# Prérequis
- Java 8 ou supérieur
- Maven 3.6 ou supérieur
- MySQL 5.7 ou supérieur
- Étapes
1. Clonez le dépôt Git de l'application :
bash
Copy code
git clone https://github.com/votre-nom/application-recensement-films.git
Configurez la base de données MySQL. Vous pouvez utiliser l'interface graphique ou les commandes suivantes :
sql
Copy code
mysql -u root -p
CREATE DATABASE nom_de_la_base;
GRANT ALL PRIVILEGES ON nom_de_la_base.* TO 'nom_utilisateur'@'localhost' IDENTIFIED BY 'mot_de_passe';
Modifiez les informations de connexion à la base de données dans le fichier application.properties :
bash
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/nom_de_la_base?useSSL=false
spring.datasource.username=nom_utilisateur
spring.datasource.password=mot_de_passe
Compilez l'application avec Maven :
bash
Copy code
cd application-recensement-films
mvn clean install
Démarrez l'application :
bash
Copy code
java -jar target/application-recensement-films-1.0.0.jar
Accédez à l'application dans votre navigateur à l'adresse suivante :
arduino
Copy code
http://localhost:8080/
# Contribution
Les contributions sont les bienvenues ! N'hésitez pas à créer une pull request pour proposer une amélioration ou corriger un bug.

Licence
Cette application est sous licence MIT. Consultez le fichier LICENSE pour plus d'informations.
