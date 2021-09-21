package com.maximus;

import java.util.HashMap;
import java.util.Map;

public class NotationConverter {

    public class InvalidValueException extends Exception {
        public InvalidValueException(String message) {
            super(message);
        }
    }

    private Map<Character, Integer> mapDigits = createMap();

    private Map<Character, Integer> createMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }

    public int toArabic(String romanNotation) throws InvalidValueException {

        if (!romanNotation.matches("[IVXLCDM]+$")) {
            throw new InvalidValueException("String must contain only valid roman numerals [I, V, X, L, C, D, M].");
        }

        int result = 0;
        char lastDigit = romanNotation.charAt(romanNotation.length() - 1);
        result += mapDigits.get(lastDigit);
        for (int i = romanNotation.length() - 2; i >= 0; i--) {
            int previousDigit = mapDigits.get(romanNotation.charAt(i+1));
            int currentDigit = mapDigits.get(romanNotation.charAt(i));

            if (currentDigit < previousDigit) {
                result -= currentDigit;
            } else {
                result += currentDigit;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        try {
            System.out.println(new NotationConverter().toArabic("MCMXLI"));
            System.out.println(new NotationConverter().toArabic("XIX"));
            System.out.println(new NotationConverter().toArabic("K"));

        }
        catch (InvalidValueException e) {
            System.out.println("InvalidValueException: " + e.getMessage());
        }
    }
}
