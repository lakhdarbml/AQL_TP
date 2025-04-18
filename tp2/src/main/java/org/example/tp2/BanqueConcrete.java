package org.example.tp2;
public class BanqueConcrete implements Banque {
    private int solde;
    private int seuilMin;

    public BanqueConcrete(int soldeInitial, int seuilMin) {
        this.solde = soldeInitial;
        this.seuilMin = seuilMin;
    }

    @Override
    public void crediter(int somme) {
        solde += somme;
    }

    @Override
    public void debiter(int somme) {
        solde -= somme;
    }

    @Override
    public boolean est_solvable() {
        return solde >= seuilMin;
    }
}

