# TodoListAPI

Une application Spring Boot pour gérer une liste de tâches avec des statistiques journalières et une interface utilisateur basée sur HTML/CSS/JavaScript.

---

## 🚀 Technologies Utilisées

- **Spring Boot** : Cadre de développement backend.
- **Spring Data JPA** : Persistance des données avec H2.
- **H2 Database** : Base de données en mémoire pour les tests.
- **Swagger (SpringDoc)** : Documentation interactive des APIs.
- **HTML/CSS/JavaScript** : Interface utilisateur.
- **Bootstrap** : Design responsive.

---

## 📂 Structure du Projet

```
src
├── main
│   ├── java
│   │   └── gl2/example/todolistapi
│   │       ├── Todo.java         # Modèle de données
│   │       ├── TodoRepository.java # Accès à la base de données
│   │       ├── TodoService.java  # Logique métier
│   │       └── TodoController.java # Endpoints REST
│   └── resources
│       ├── static
│       │   ├── index.html        # Interface utilisateur
│       │   └── dashboard.html    # Tableau de bord
│       ├── css                   # Styles CSS
│       └── application.properties # Configuration
└── test
    └── ... (tests unitaires/intégration)
```

## 🌐 Endpoints REST

### **Liste des Endpoints**

| Méthode    | Endpoint                   | Description                                  |
| ---------- | -------------------------- | -------------------------------------------- |
| **POST**   | `/api/todos`               | Créer une nouvelle tâche                     |
| **GET**    | `/api/todos`               | Récupérer toutes les tâches                  |
| **GET**    | `/api/todos/{id}`          | Récupérer une tâche par ID                   |
| **PATCH**  | `/api/todos/{id}/complete` | Marquer une tâche comme terminée             |
| **DELETE** | `/api/todos/{id}`          | Supprimer une tâche                          |
| **GET**    | `/api/todos/stats/daily`   | Statistiques journalières (complétion, etc.) |

## 🚨 Prerequisites

- **Java 17+**
- **Maven** pour la gestion des dépendances.
- **Navigateur Web** pour accéder à l'interface

---

## 🎲 Fonctionnalités Clés

1. **Création/Suppression/Mise à Jour des Tâches** .
2. **Statistiques en Temps Réel** :
   - Tâches créées aujourd'hui.
   - Tâches terminées aujourd'hui.
   - Taux de complétion quotidien.
3. **Interface Utilisateur** :
   - Formulaire pour ajouter des tâches.
   - Affichage dynamique des tâches avec statut.
   - Dashboard pour les stats.

---

## 🚀 Getting Started

### **1. Cloner le Projet**

```bash
git clone https://github.com/ton-nom/TodoListAPI.git
```

### **2. Compiler et Lancer l'Application**

```bash
cd TodoListAPI
mvn clean install
mvn spring-boot:run
```

### **3. Accéder à l'Application**

- **Via interface Web** : `http://localhost:8088` (formulaire et liste).

---

## 🛠️ Usage Avancé

### **1. Tester avec Postman**

- **Créer une tâche** :
  
  ```bash
  POST http://localhost:8088/api/todos
  Body:
  {
      "title": "Tâche de Test",
      "description": "Description de test"
  }
  ```
* **Marquer une tâche comme terminée** :
  
  ```bash
  PATCH http://localhost:8088/api/todos/1/complete
  ```

### **2. Vérifier les Données dans H2**

- **Console H2** : `http://localhost:8088/h2-console`.
- **Paramètres** :
  - **JDBC URL** : `jdbc:h2:mem:testdb`
  - **User Name** : `sa`
  - **Password** : `password`

---

## 🛠️ Configuration du Port

Tant que le port usuel `8080` est déjà utilisé , on a ajouter cette ligne dans le fichier `application.properties`

```properties
server.port=8088
```


