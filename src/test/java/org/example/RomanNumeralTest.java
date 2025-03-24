package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class RomanNumeralTest {

    @Test
    void convert() {
    }

    @Test
    public void numberWithManyDigits() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }
}




