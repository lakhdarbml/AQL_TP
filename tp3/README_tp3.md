# TP2 - Tests Unitaires avec JUnit 5 et Mockito

## ✨ Objectifs

- Comprendre l’importance des tests unitaires.
- Apprendre à isoler les composants avec des mockups.
- Utiliser JUnit 5 et Mockito pour tester des composants.
- Distinguer tests d’état et tests d’interaction.

---

## 🔹 Prérequis
- Java 8 ou supérieur
- IDE IntelliJ IDEA
- Connexion Internet
- Bibliothèques : JUnit 5, Mockito

---

## 🔹 Concepts clés

### Mockup (objet simulé)
Un mockup simule un vrai objet pour isoler une partie du code pendant les tests.

- **isolation** : pas besoin d’implémentations réelles.
- **contrôle total** du comportement avec `when(...)` et `verify(...)`

---

# Exercice 1 : Initiation

### Classe à tester
```java
public class Calculatrice {
    public int additionner(int a, int b) {
        result = a + b;
        return result;
    }
    private int result;
}
```

### Test
```java
@Test
public void testAdditionner() {
    when(calculatrice.additionner(2, 3)).thenReturn(5);

    int resultat = calculatrice.additionner(2, 3);

    assertEquals(5, resultat);
    verify(calculatrice).additionner(2, 3);
    verifyNoMoreInteractions(calculatrice);
}
```

### Nature du test : interaction

---

# Exercice 2 : Mocker un service externe

### Code à tester
```java
public class UserService {
    private final UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);
    }
}
```

### Test
```java
@Test
public void testCreerUtilisateur() throws ServiceException {
    Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean@email.com");
    doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

    UserService userService = new UserService(utilisateurApiMock);
    userService.creerUtilisateur(utilisateur);

    verify(utilisateurApiMock).creerUtilisateur(utilisateur);
}
```

---

# Exercice 3 : Mocker avec scénarios

### 1. Lever une exception
```java
@Test
public void testCreationUtilisateur_Echec() {
    Utilisateur utilisateur = new Utilisateur("Ali", "Yahia", "ali@email.com");
    doThrow(new ServiceException("Echec de la création de l'utilisateur"))
        .when(utilisateurApiMock).creerUtilisateur(utilisateur);

    UserService userService = new UserService(utilisateurApiMock);

    assertThrows(ServiceException.class, () -> {
        userService.creerUtilisateur(utilisateur);
    });
}
```

### 2. Erreur de validation (ex: email vide)
```java
@Test
public void testErreurValidation() throws ServiceException {
    Utilisateur utilisateur = new Utilisateur("Ali", "Yahia", "");

    UserService userService = new UserService(utilisateurApiMock);
    userService.creerUtilisateur(utilisateur);

    verify(utilisateurApiMock, never()).creerUtilisateur(any());
}
```

### 3. API retourne un ID
```java
@Test
public void testRetourID() throws ServiceException {
    Utilisateur utilisateur = new Utilisateur("Nora", "Salah", "nora@email.com");
    when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(123);

    UserService userService = new UserService(utilisateurApiMock);
    userService.creerUtilisateur(utilisateur);

    assertEquals(123, utilisateur.getId());
}
```

### 4. Capture des arguments
```java
@Test
public void testCaptureArguments() throws ServiceException {
    Utilisateur utilisateur = new Utilisateur("Salim", "Kaci", "salim@email.com");
    ArgumentCaptor<Utilisateur> captor = ArgumentCaptor.forClass(Utilisateur.class);

    when(utilisateurApiMock.creerUtilisateur(any())).thenReturn(456);
    UserService userService = new UserService(utilisateurApiMock);
    userService.creerUtilisateur(utilisateur);

    verify(utilisateurApiMock).creerUtilisateur(captor.capture());
    Utilisateur capture = captor.getValue();

    assertEquals("Salim", capture.getNom());
    assertEquals("Kaci", capture.getPrenom());
    assertEquals("salim@email.com", capture.getEmail());
}
```

---

# Exercice 4 : Jeu de dés

## 1. Objets à mocker
- `Joueur`, `Banque`, `De`
- Pourquoi ? Ce sont des dépendances externes à `Jeu`, et doivent être simulées

## 2. Scénarios
| Cas | Description | Type de test |
|-----|-------------|--------------|
| Cas 1 | Jeu fermé | Test d'état |
| Cas 2 | Joueur insolvable | Test d'interactions |
| Cas 3 | Somme != 7 | Test d'interactions |
| Cas 4 | Somme = 7, banque solvable | État + interaction |
| Cas 5 | Somme = 7, banque devient insolvable | Test d'état |

## 3. Implémentation `Jeu`

```java
public class Jeu {
    private Banque banque;
    private boolean ouvert = true;

    public Jeu(Banque banque) {
        this.banque = banque;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) throw new JeuFermeException();

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            return;
        }

        banque.crediter(mise);
        int somme = de1.lancer() + de2.lancer();

        if (somme == 7) {
            int gain = 2 * mise;
            banque.debiter(gain);
            joueur.crediter(gain);
        }

        if (!banque.est_solvable()) {
            this.fermer();
        }
    }

    public void fermer() { ouvert = false; }
    public boolean estOuvert() { return ouvert; }
}
```

## 4. Test : jeu fermé
```java
@Test
void testJeuFerme() {
    Jeu jeu = new Jeu(mock(Banque.class));
    jeu.fermer();
    assertThrows(JeuFermeException.class, () -> {
        jeu.jouer(mock(Joueur.class), mock(De.class), mock(De.class));
    });
}
```

## 5. Test : joueur insolvable
```java
@Test
void testJoueurInsolvable() throws Exception {
    Joueur joueur = mock(Joueur.class);
    when(joueur.mise()).thenReturn(100);
    doThrow(new DebitImpossibleException()).when(joueur).debiter(100);

    Jeu jeu = new Jeu(mock(Banque.class));
    jeu.jouer(joueur, mock(De.class), mock(De.class));

    verify(joueur).debiter(100);
    verifyNoMoreInteractions(joueur);
}
```

## 6. Test avec banque réelle
```java
class BanqueConcrete implements Banque {
    private int solde;
    private int seuil;

    public BanqueConcrete(int solde, int seuil) {
        this.solde = solde;
        this.seuil = seuil;
    }

    public void crediter(int somme) { solde += somme; }
    public void debiter(int somme) { solde -= somme; }
    public boolean est_solvable() { return solde >= seuil; }
}

@Test
void testBanqueInsolvableFermeJeu() throws Exception {
    Joueur joueur = mock(Joueur.class);
    when(joueur.mise()).thenReturn(100);
    De de1 = mock(De.class);
    De de2 = mock(De.class);
    when(de1.lancer()).thenReturn(3);
    when(de2.lancer()).thenReturn(4);

    BanqueConcrete banque = new BanqueConcrete(150, 100);
    Jeu jeu = new Jeu(banque);

    jeu.jouer(joueur, de1, de2);

    assertFalse(jeu.estOuvert());
}
```

## 7. Différence entre mock et implémentation
- **Mock** : rapide, test purement unitaire, comportement prévisible
- **Implémentation réelle** : test plus intégré, vérifie le comportement réel avec effet de bord (solde)

---