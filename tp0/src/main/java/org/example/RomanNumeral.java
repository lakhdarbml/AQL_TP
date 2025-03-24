package org.example;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    // Définir la Map en tant qu'attribut statique
    private static final Map<Character, Integer> map = new HashMap<>();

    // Initialiser la Map avec les valeurs des chiffres romains
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("L'entrée ne peut pas être nulle ou vide.");
        }

        int convertedNumber = 0;
        int previousNumber = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentNumber = map.getOrDefault(currentChar, -1);

            if (currentNumber == -1) {
                throw new IllegalArgumentException("Caractère romain invalide : " + currentChar);
            }

            // Si le chiffre actuel est inférieur au précédent, on le soustrait
            if (currentNumber < previousNumber) {
                convertedNumber -= currentNumber;
            } else {
                convertedNumber += currentNumber;
            }

            previousNumber = currentNumber;
        }

        return convertedNumber;
    }
}
