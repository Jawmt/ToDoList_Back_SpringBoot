
<br />
<div align="center">
  

  <h3 align="center">Application ToDoList Backend</h3>

  <p align="center">
    Application backend permettant de gerer la sauvegarde, l'envoie, ainsi que la suppresion des taches à réaliser au niveau de la base de données.
    L'application backend a été réalisée avec le framework Spring Boot et le SGBD MySql
    <br />
    <br />
    <br />
  </p>
</div>

<!-- ABOUT THE PROJECT -->

# Getting Started  

### Création du fichier env.properties au niveau de la racine pour indiquer les données de connexion Mysql

``` 
'env.properties'
DB_USER=Nom Utilisateur Mysql
DB_PASSWORD=Mot de passe Mysql
```

### Installation des dépendances & lancement du serveur

``` 
mvn clean install
mvn spring-boot:run
```

Le front end de cette application Backend est disponible sur mon repository (ToDoList-Front-Angular).
