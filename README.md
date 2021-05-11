### Projet_Web_Services_DE3

D3.WebService.Database contient les scripts de création et administration de la base de données MySQL utilisée.  
D3.WebService.Back contient 4 projets :  
* Core, qui correspond à la couche d'accès et de manipulation des données (utilisateurs, projets et créneaux sur les projets)  
* UserService qui sert une api SOAP de gestion des comptes utilisateurs  
* ProjectService qui sert une api SOAP de gestion des projets  
* TimeService qui permet de paramétrer les créneaux des utilisateurs sur des projets. Il accède donc aux api de UserService et ProjectService, ainsi qu'à la base de données, pour servir une api REST de gestion des créneaux.  

D3.WebService.Front contient un projet nodejs utilisant VueJs et accédant à l'api REST TimeService pour proposer une interface de gestion des heures de travail des utilisateurs sur les projets.  
