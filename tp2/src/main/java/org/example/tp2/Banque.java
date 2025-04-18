package org.example.tp2;

public interface Banque {
    void crediter(int somme);
    void debiter(int somme);
    boolean est_solvable();
}
