import java.util.HashMap;

public class Converter {
    private final static HashMap<String, Integer> mapArabicRomanCounter = new HashMap<>();

    private static void addMap() {
        mapArabicRomanCounter.put("I", 1);
        mapArabicRomanCounter.put("II", 2);
        mapArabicRomanCounter.put("III", 3);
        mapArabicRomanCounter.put("IV", 4);
        mapArabicRomanCounter.put("V", 5);
        mapArabicRomanCounter.put("VI", 6);
        mapArabicRomanCounter.put("VII", 7);
        mapArabicRomanCounter.put("VIII", 8);
        mapArabicRomanCounter.put("IX",9);
        mapArabicRomanCounter.put("X", 10);
    }

    protected static int romanToArabic(String romanNumber) {
        addMap();
        int romanValue = mapArabicRomanCounter.get(romanNumber.toUpperCase());
        return romanValue;
    }

    protected static String arabicToRoman(int arabicNumber) {
        String romanNumber = "";
        if (arabicNumber >= 100) {
            romanNumber += "C";
            arabicNumber -= 100;
        }
        arabicNumber = arabicNumber % 100;
        int tens = arabicNumber / 10;
        while (tens > 0) {
            if (tens == 9) {
                romanNumber += "XC";
                tens -= 9;
            } else if (tens >= 5) {
                tens -= 5;
                romanNumber += "L";

            } else if (tens == 4) {
                romanNumber += "Xl";
                tens -= 4;
            } else {
                romanNumber += "X";
                tens--;
            }
        }
        int ones = arabicNumber % 10;
        while (ones > 0) {
            if (ones == 9) {
                romanNumber += "IX";
                ones -= 9;
            } else if (ones >= 5) {
                romanNumber += "V";
                ones -= 5;
            } else if (ones == 4) {
                romanNumber += "IV";
                ones -= 4;
            } else {
                romanNumber += "I";
                ones--;
            }
        }
        return romanNumber;
    }

}


