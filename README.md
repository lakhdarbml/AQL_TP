# Projet AQL_TP - Tests Unitaires et Qualité Logicielle

![Java](https://img.shields.io/badge/Java-17+-blue)
![Maven](https://img.shields.io/badge/Maven-3.6+-orange)
![JUnit](https://img.shields.io/badge/JUnit-5.9.2-green)

# Structure du projet

AQL_TP/
├── .gitignore           # Configuration Git
├── pom.xml              # Configuration Maven
├── README.md            # Documentation principale
│
├── tp0/                 # TP0 - Tests unitaires de base
│   ├── src/
│   │   ├── main/        # Implémentations
│   │   └── test/       # Tests JUnit
│   └── README.md       # Instructions TP0
│
├── tp1/                 # TP1 - Tests avancés
│   ├── src/
│   │   ├── main/
│   │   └── test/
│   └── README.md
│
└── tp2/                 # TP2 - Qualité logicielle
├── src/
│   ├── main/
│   └── test/
└── README.md


## 🛠 Configuration requise

- **Java JDK 17+**
- **Apache Maven 3.6+**
- **IDE** : IntelliJ IDEA (recommandé)
- **Dépendances** :
    - JUnit 5.9.2
    - AssertJ (optionnel)
    - Mockito (optionnel)

## 🚀 Guide d'installation

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/lakhdarbml/AQL_TP.git
   cd AQL_TP
Importer dans IntelliJ :

File → New → Project from Existing Sources

Sélectionner le fichier pom.xml

Configurer le JDK 17+

Installer les dépendances :

bash
Copy
mvn clean install
🔧 Exécution des tests
Méthode	Commande
Via IDE	Clic droit → "Run Test"
Terminal	mvn test
Test spécifique	mvn test -Dtest=NomClasseTest
🔄 Gestion de version
Convention de commits
Copy
<tpX>-ex<Y>: <description>
Exemples :

tp0-ex1: tests pour Person

tp0-ex2: correction Stack

# Après chaque exercice
git add .
git commit -m "tp0-ex1: description"
git push origin main
# 📚 Liste des TPs
TP	Sujet	Technologies
TP0	Tests unitaires	JUnit5, AssertJ
TP1	Tests avancés	Parametrized Tests
TP2	Qualité code	JaCoCo, Pitest
