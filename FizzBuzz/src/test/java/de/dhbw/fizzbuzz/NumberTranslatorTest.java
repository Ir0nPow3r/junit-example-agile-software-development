package de.dhbw.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTranslatorTest {

    private NumberTranslator numberTranslator;

    @BeforeEach
    void setUp() {
        numberTranslator = new NumberTranslator();
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9,12,18})
    void multipleOf3IsFizz(int num) {
        assertEquals(numberTranslator.translate(num), "Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5,10,20,25,35,40})
    void multipleOf5IsBuzz(int num) {
        assertEquals(numberTranslator.translate(num), "Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15,30,45})
    void multipleOf3And5IsFizzBuzz(int num) {
        assertEquals(numberTranslator.translate(num), "FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4,7,8,11,13})
    void numberIsNumber(int num) {
        assertEquals(numberTranslator.translate(num), "" + num);
    }
}
