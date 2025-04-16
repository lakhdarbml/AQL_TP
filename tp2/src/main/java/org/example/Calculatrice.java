package main.java.org.example;
public class Calculatrice {
    private int result;

    public int additionner(int a, int b) {
        result = a + b;
        return result;
    }

    // Optionnel : getter pour tester l'état
    public int getResult() {
        return result;
    }
}
