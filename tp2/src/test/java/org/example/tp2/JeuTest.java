package org.example.tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JeuTest {

    @Test
    public void testJeuFerme_ThrowException() {
        Banque banque = mock(Banque.class);
        Jeu jeu = new Jeu(banque);
        jeu.fermer();

        assertThrows(JeuFermeException.class, () -> {
            jeu.jouer(mock(Joueur.class), mock(De.class), mock(De.class));
        });
    }
    @Test
    void testAvecBanqueConcrete_GainMaisBanqueInsolvable() throws Exception {
        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        // Mise = 100
        when(joueur.mise()).thenReturn(100);

        // Crée une banque juste assez solvable (150 avec seuil 100)
        BanqueConcrete banque = new BanqueConcrete(150, 100); // 💸

        Jeu jeu = new Jeu(banque);

        // Le joueur fait 7
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4); // somme = 7

        // Appel de la méthode jouer
        jeu.jouer(joueur, de1, de2);

        // Attendu : la banque paie 2×mise (200) → solde passe à -50 → insolvable
        // Donc le jeu doit se fermer
        assertFalse(jeu.estOuvert());
    }


}
