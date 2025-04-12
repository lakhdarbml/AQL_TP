package org.example;

public class QuadraticEquationBuggy {
    public static double[] solve(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("a must not be zero");
        }
        double delta = (b * b) - (4 * a * c);
        if (delta < 0) {
            return new double[]{0}; // ❌ erreur : ne doit pas renvoyer un tableau !
        }
        if (delta == 0) {
            return null; // ❌ erreur : devrait renvoyer un tableau à 1 élément
        }
        return new double[]{(-b + Math.sqrt(delta)) / (2 * a)};
    }
}
