# TP0 - Tests Unitaires avec JUnit 5

## Objectifs
Ce TP a pour objectifs de vous apprendre à :
- Installer et configurer JUnit 5 sur IntelliJ IDEA
- Écrire et exécuter des tests unitaires avec JUnit 5
- Utiliser les annotations, assertions et hypothèses de JUnit 5
- Écrire des tests dynamiques et paramétrés avec JUnit 5

## Prérequis
- Java 8 ou supérieur
- IntelliJ IDEA
- Connexion internet
- Compte GitHub

## Installation et configuration
1. Créer un nouveau projet Maven dans IntelliJ IDEA
2. Ajouter les dépendances JUnit 5 dans le fichier `pom.xml`
3. Créer la structure de dossiers `src/test/java` pour les classes de test

## Structure du projet
project/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── (classes à tester)
│ └── test/
│ └── java/
│ └── (classes de test)
└── pom.xml

Copy

## Exercices

### Exercice 1 : Classe Person
Tester les méthodes :
- `getFullName()` : doit retourner "prénom nom"
- `isAdult()` : doit retourner true si age ≥ 18

### Exercice 2 : Classe Stack
Tester les méthodes :
- `push()`, `pop()`, `peek()`
- `isEmpty()`, `size()`
- Comportement avec pile vide/pleine
- Redimensionnement automatique

### Exercice 3 : Classe Fibonacci
Tester la méthode `fibonacci(n)` pour :
- Cas de base (n=0, n=1)
- Cas récursifs (n>1)
- Cas exceptionnel (n<0)

### Exercice 4 : Classe Prime
Tester la méthode `isPrime(n)` pour :
- Nombres premiers
- Nombres non premiers
- Cas limites (0, 1, 2)
- Nombres négatifs

### Exercice 5 : Classe Factorial
Tester la méthode `factorial(n)` pour :
- Cas de base (0! = 1)
- Cas normaux (n>0)
- Cas exceptionnel (n<0)

### Exercices Bonus

#### Bonus 1 : Classe BankAccount
Tester les méthodes :
- `deposit()`, `withdraw()`, `transfer()`
- `addInterest()`, `getBalance()`
- Cas de solde insuffisant
- Montants négatifs

#### Bonus 2 : Classe Matrix
Tester les opérations matricielles :
- `add()`, `multiply()`, `transpose()`
- Cas de matrices incompatibles
- Matrice nulle



## Ressources
- [Documentation JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
- [Guide de test unitaire](https://www.baeldung.com/junit-5)