# TP1 - Tests Unitaires Avancés & Couverture du Code

## 🎯 Objectifs

- Évaluer la couverture du code avec JUnit 5 dans IntelliJ IDEA.
- Appliquer trois types de couverture : **lignes**, **branches**, **conditions**.
- Identifier et corriger les bugs présents dans certaines méthodes.
- Rédiger des tests unitaires complets et représentatifs.

---

## 📁 Structure des tests

Pour chaque exercice, les tests sont répartis selon le critère de couverture :

```
org.example.LineCoverageTest.ExoXTest
org.example.BranchCoverageTest.ExoXTest
org.example.ConditionCoverageTest.ExoXTest
```

---

## 📌 Résumé par exercice

### ✅ Exercice 1 : Palindrome

- Vérifie si une chaîne est un palindrome (casse et espaces ignorés).
- 🐞 Bug corrigé : `i--` et `j++` au lieu de `i++` / `j--`.
- ✅ Couverture 100% atteinte après correction.

---

### ✅ Exercice 2 : Anagram

- Vérifie si deux chaînes sont des anagrammes.
- 🐞 Bug corrigé : boucle `for (i <= length)` → `i < length`.
- ✅ Couverture complète des cas `null`, longueurs différentes, etc.

---

### ✅ Exercice 3 : BinarySearch

- Implémente une recherche binaire.
- 🐞 Bug corrigé : condition de boucle `while (low < high)` → `while (low <= high)`.
- ✅ Tests couvrant tous les cas de recherche (élément début, milieu, fin, absent).

---

### ✅ Exercice 4 : QuadraticEquation

- Résout une équation du 2e degré.
- 🐞 Version buggy :
  - `delta < 0` retourne `[0]` au lieu de `null`.
  - `delta == 0` retourne `null` au lieu d'une racine.
  - `delta > 0` retourne une seule racine.
- ✅ Version corrigée conforme à la théorie.

---

### ✅ Exercice 5 : RomanNumeral

- Convertit un entier (1-3999) en chiffre romain.
- 🐞 Bug : boucle `for (i <= symbols.length)` → provoque `ArrayIndexOutOfBoundsException`.
- ✅ Corrigé avec `i < symbols.length`.

---

### ✅ Exercice 6 : FizzBuzz

- Renvoie “Fizz”, “Buzz”, “FizzBuzz” ou le nombre selon sa divisibilité.
- 🐞 Version buggy :
  - Vérifie `% 3` avant `% 15`, donc `"FizzBuzz"` jamais retourné.
  - Condition `n <= 0` au lieu de `n <= 1`.
- ✅ Version corrigée avec les bons ordres de priorité.

---

## ⚠️ Remarque

Les tests de la version **buggy** sont volontairement écrits avec les bons résultats attendus, afin de provoquer des échecs et identifier les erreurs.

Chaque version corrigée passe tous les tests de couverture avec succès.

---

## ✅ Lancer avec IntelliJ

- `clic droit > Run with Coverage`
- Activer les couleurs dans l'éditeur
- Vérifier les taux de couverture dans la fenêtre `Coverage`

---

## 🧪 Résultat attendu

| Exercice | Lignes | Branches | Conditions |
|----------|--------|----------|------------|
| Exo1     | 100%   | 100%     | 100%       |
| Exo2     | 100%   | 100%     | 100%       |
| Exo3     | 100%   | 100%     | 100%       |
| Exo4     | 100%   | 100%     | 100%       |
| Exo5     | 100%   | 100%     | 100%       |
| Exo6     | 100%   | 100%     | 100%       |

---

## 👨‍💻 Groupe 4

Travail réalisé dans le cadre du TP de qualité logicielle — JUnit et couverture de code.
