package com.maximus;

public class Main {
    public static void main(String[] args) {

        NotationConverter notationConverter = new NotationConverter();

        try {
            System.out.println(notationConverter.toArabic("MCMXLI"));
            System.out.println(notationConverter.toArabic("XIX"));
            System.out.println(notationConverter.toArabic(null));
        }
        catch (NotationConverter.InvalidValueException e) {
            System.out.println(e.getMessage());
        }
    }
}
