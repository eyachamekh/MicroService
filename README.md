Technologies et Architecture

Ce projet utilise une architecture microservices, où chaque service est développé et déployé indépendamment.
Les services communiquent entre eux via des API REST, ce qui rend le système modulable, évolutif et sécurisé de projet E-Commerce:  application de vente de produit alimentaires .

1. Eureka Server - Service de Découverte
   
Rôle : Sert de registre pour les microservices.
Permet aux services de se découvrir automatiquement.
Dépendance principale : spring-cloud-starter-netflix-eureka-server

3. API Gateway - Point d’entrée unique
   
Rôle : Reçoit toutes les requêtes des clients.
Redirige les requêtes vers les bons microservices via Eureka.
Gère la sécurité avec Keycloak (authentification et autorisation).
Dépendances :
spring-cloud-starter-gateway
spring-cloud-starter-netflix-eureka-client

3. Service Réclamation
   
Rôle : Gère les opérations liées aux réclamations .
Utilise MySQL pour stocker les données.
chaque reclamation ajouté un mail envoyé au admin 


Endpoints  :

http://localhost:8080/api/reclamations/add   pour ajouter reclamation

http://localhost:8080/api/reclamations       pour get all 

http://localhost:8080/api/reclamations/update/id  pour modification de reclamation

http://localhost:8080/api/reclamations/delete/id   pour suprimer reclamation

http://localhost:8080/api/reclamations/search?q=En attente   pour recherche avec nom du client ou status

http://localhost:8080/api/reclamations/addWithFile   pour ajouter reclamation avec file
http://localhost:8080/api/reclamations/filterByStatus?status=Traitée
