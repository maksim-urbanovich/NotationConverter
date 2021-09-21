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

    public int toArabic(String romanNotation) throws NotationConverter.InvalidValueException {
        int result = 0;
        if (romanNotation.matches("[IVXLCDM]+$")) {
            char letter = romanNotation.charAt(romanNotation.length() - 1);
            result = mapDigits.get(letter);



        }
        else { throw new InvalidValueException("String must contain only valid roman numerals [I, V, X, L, C, D, M].");
        }
        return result;
    }



    public static void main(String[] args) {
        try {
            System.out.println(new NotationConverter().toArabic("K"));
        }
        catch (InvalidValueException e) {
            System.out.println("InvalidValueException: " + e.getMessage());
        }
    }
}
