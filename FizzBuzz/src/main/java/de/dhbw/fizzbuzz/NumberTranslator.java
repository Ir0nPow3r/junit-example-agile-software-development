package de.dhbw.fizzbuzz;

public class NumberTranslator {

    /**
     * Translate the given int to a {@link String}.
     * @param num the input {@link Integer}
     * @return a translated {@link String}:
     * <ul>
     *     <li>If num is multiple of 3 and 5 - return "FizzBuzz"</li>
     *     <li>If num is multiple of 5 - return "Buzz"</li>
     *     <li>If num is multiple of 3 - return "Fizz"</li>
     *     <li>If non of the above applies - return the number as String</li>
     * </ul>
     */
    public String translate(int num) {
        //Multiple of 3 and 5
        if(num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        }
        //Multiple of 5
        if(num % 5 == 0) {
            return "Buzz";
        }
        //Multiple of 3
        if(num % 3 == 0) {
            return "Fizz";
        }
        //Default
        return String.valueOf(num);
    }
}
