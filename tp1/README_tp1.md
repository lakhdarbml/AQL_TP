# TP1 - Tests Unitaires Avancés & Couverture du Code

## 🎯 Objectifs

Ce TP a pour but de :
- Mesurer la couverture du code selon 3 critères : **lignes**, **branches**, **conditions**
- Écrire des tests unitaires robustes avec **JUnit 5**
- Utiliser **IntelliJ IDEA** pour visualiser et analyser la couverture
- Identifier et corriger les erreurs dans le code source

---

## 🗂️ Structure du projet

```
tp1/
├── src/
│   ├── main/
│   │   └── java/org/example/Palindrome.java
│   └── test/
│       ├── java/linecoveragetest/Exo1Test.java
│       ├── java/branchcoveragetest/Exo1Test.java
│       └── java/conditioncoveragetest/Exo1Test.java
```

---

## 🧪 Tests

### ✅ Couverture des lignes
- Tous les chemins simples sont couverts : cas palindrome, non palindrome, casse, espaces, null.

### ✅ Couverture des branches
- Chaque `if`/`else` et boucle `while` sont parcourus.
- Tests sur :
  - palindrome pair/impair
  - chaîne non palindrome
  - entrée null

### ✅ Couverture des conditions
- Les conditions booléennes `i < j` et `s.charAt(i) != s.charAt(j)` sont testées avec `true` et `false`.

---

## 🐞 Bugs identifiés

### ❌ **Bug dans la méthode `Palindrome.isPalindrome()`**

```java
while (i < j) {
    if (s.charAt(i) != s.charAt(j)) {
        return false;
    }
    j++;  // ❌ erreur
    i--;  // ❌ erreur
}
```

### ✅ **Correction appliquée :**

```java
while (i < j) {
    if (s.charAt(i) != s.charAt(j)) {
        return false;
    }
    i++;  // ✅ on avance i
    j--;  // ✅ on recule j
}
```

### 📌 Conséquence :
L'erreur causait une `StringIndexOutOfBoundsException` dans certains cas de test (ex: "Esope reste ici et se repose").

---

## 📊 Résultats de la couverture (IntelliJ IDEA)

- ✅ **Lignes :** 100%
- ✅ **Branches :** 100%
- ✅ **Conditions :** 100%

Afficher les résultats via : `Run > Run with Coverage`

Légende :
- 🟩 Vert = ligne exécutée
- 🟥 Rouge = ligne non exécutée
- 🟨 Jaune = condition ou branche partiellement couverte

---

## 📁 Nomenclature recommandée pour GitHub

```
TP1/
├── LineCoverageTest/Exo1Test.class
├── BranchCoverageTest/Exo1Test.class
├── ConditionCoverageTest/Exo1Test.class
└── README.md
```

---

## 📌 Remarque

Dans ce TP, les tests des trois types de couverture sont **similaires** car la méthode `isPalindrome` est courte, avec peu de branches.  
Les différences entre les tests sont minimes, mais ont été conservées pour respecter les consignes pédagogiques.
