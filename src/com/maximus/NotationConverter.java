package com.maximus;

import java.util.HashMap;
import java.util.Map;

public class NotationConverter {

    public int toArabic(String romanNotation) throws InvalidValueException {
        Map<Character, Integer> mapDigits = createMap();

        if (romanNotation != null && romanNotation.matches("[IVXLCDM]+$")) {
            char lastDigit = romanNotation.charAt(romanNotation.length() - 1);
            int result = mapDigits.get(lastDigit);

            for (int i = romanNotation.length() - 2; i >= 0; i--) {
                int previousDigit = mapDigits.get(romanNotation.charAt(i + 1));
                int currentDigit = mapDigits.get(romanNotation.charAt(i));

                if (currentDigit < previousDigit) {
                    result -= currentDigit;
                } else {
                    result += currentDigit;
                }
            }

            return result;
        } else {
            throw new InvalidValueException("InvalidValueException: String must contain only valid roman numerals [I, V, X, L, C, D, M].");
        }
    }

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

    public class InvalidValueException extends RuntimeException {
        public InvalidValueException(String message) {
            super(message);
        }
    }
}
