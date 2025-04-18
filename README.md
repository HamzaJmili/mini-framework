# Mini Framework d'Injection de Dépendances


Ce projet consiste à implémenter un **mini framework Java d'injection de dépendances**, inspiré de Spring, permettant :

- L'injection de dépendances à partir d'un fichier XML (type Spring XML)
- L'injection de dépendances via des annotations personnalisées (`@Component`, `@Inject`, etc.)

L’objectif est de comprendre et reproduire le mécanisme de création et de gestion de beans, ainsi que l’injection de dépendances via différentes approches (setter, constructeur, champ).

---

##  Packages 

### 1. `master.sdia.annotations`

Contient les **annotations personnalisées** utilisées pour déclarer des composants ou injecter des dépendances :

- `@Component` : marque une classe comme un composant géré par le framework.
- `@Inject` : indique qu’un champ, un constructeur ou un setter doit être injecté automatiquement.
- `@ConfigComponent` : annotation pour les classes définies dans le fichier XML.

---

### 2. `master.sdia.framework`

Contient le cœur du mini-framework :

- **`XMLApplicationContext`**  
  Gère l’injection via fichier XML (type Spring XML). Utilise JAXB pour parser les composants définis et Java Reflection pour instancier les classes et injecter les dépendances.

- **`AnnotationApplicationContext`**  
  Scanne dynamiquement le classpath à la recherche de classes annotées avec `@Component`, puis instancie les objets et injecte leurs dépendances selon les annotations `@Inject`.

---

### 3. `master.sdia.dao`

Contient l’interface et l’implémentation de la couche DAO :

- **`IDao`**  
  Interface définissant une méthode `getData()`.

- **`DaoImpl`**  
  Implémentation concrète de l’interface `IDao`. Fournit une valeur simulée pour illustrer le rôle d’une source de données.

---

### 4. `master.sdia.metier`

Contient la logique métier :

- **`IMetier`**  
  Interface définissant une méthode `calcul()`.

- **`MetierImpl`**  
  Implémentation concrète de `IMetier`, dépend de `IDao`. Réalise un calcul simple basé sur la donnée retournée par le DAO.

---

### 5. `master.sdia`

Contient le point d’entrée de l’application :

- **`App`**  
  Classe principale qui illustre deux cas :
  - L’utilisation de `XMLApplicationContext` (injection par XML)
  - L’utilisation de `AnnotationApplicationContext` (injection par annotations)

---


