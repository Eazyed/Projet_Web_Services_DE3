# Cra Manager

Ce projet est le site web du projet Webservice de notre équipe.

Ce site web utilise un serveur **Node.js**.
Le framework **BootstrapVue** a été utilisé pour la mise en forme.

---

## Installation

Clonez le repo, déplacez vous vers le dossier **cra_manager** et installez les dépendences.

```bash
git clone https://github.com/Eazyed/Projet_Web_Services_DE3.git
cd .\Projet_Web_Services_DE3\DE3.WebServices.Front\cra_manager\
npm install
```

---

## Utilisation

Pour démarrer le serveur, utilisez la commande suivante dans le dossier **cra_manager**

```bash
npm run serve
```
Ouvrez [http://localhost:3454](http://localhost:3454) sur votre navigateur.

---

## Configuration

Le port est configurable dans le fichier **vue.config.js**

```js
module.exports = {
    devServer: {
        port: 3454
    }
}
```
