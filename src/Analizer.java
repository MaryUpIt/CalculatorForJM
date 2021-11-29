import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analizer extends Converter {
    protected static final String ROME = "ROME";
    protected static final String ARAB = "ARAB";


    protected static String[] resultArray(String input) throws Exception {
        String[] arrayOfInput = new String[3];
        try {
            arrayOfInput = arrayOfInput(input);
        } catch (NullPointerException badNumber) {

            System.out.println(" Нарушены првила ввода, проверьте наличие пробелов в выражении." +
                    "\n Программа совершила выход.");
            return arrayOfInput;
        }
        return components(arrayOfInput);
    }


    private static String[] components(String[] arrayOfInput) {
        String[] operation = Arrays.copyOf(arrayOfInput, 4);

        try {
            operation[3] = typeOfNumber(operation[0], operation[2]);
        } catch (NumberFormatException differentTypeOfNumber) {
            System.out.println(" Используются разные системы исчисления " +
                    "\n Удостоверьтесь, что вы ввели два римских или два арабских числа" +
                    "\n Программа совершила выход.");
            return null;
        } catch (IllegalArgumentException wrongTypeOfNumber) {
            System.out.println(" Нарушены правила ввода аргументов " +
                    "\n Удостоверьтесь что в качестве аргументов операции" +
                    "\n введены целочисленные значения или римские цифры?" +
                    "\n Программа совершила выход.");
            return null;
        }
        return operation;
    }


    private static String[] arrayOfInput(String input) throws Exception {
        String[] arrayOfInput = input.split(" ");
        if (arrayOfInput.length != 3)
            throw new NullPointerException();

        return arrayOfInput;
    }

    private static String typeOfNumber(String firstNumber, String secondNumber) {
        Matcher arabicFirstNumber = Pattern.compile("\\d+").matcher(firstNumber);
        Matcher romansFirstNumber = Pattern.compile("[IVX]+").matcher(firstNumber.toUpperCase());
        Matcher arabicSecondNumber = Pattern.compile("\\d+").matcher(secondNumber);
        Matcher romansSecondNumber = Pattern.compile("[IVX]+").matcher(secondNumber.toUpperCase());
        if (romansFirstNumber.matches() && romansSecondNumber.matches()) {
            return ROME;
        } else if (arabicFirstNumber.matches() && arabicSecondNumber.matches()) {
            return ARAB;
        } else if (romansFirstNumber.matches() && arabicSecondNumber.matches() ||
                arabicFirstNumber.matches() && romansSecondNumber.matches()) {
            throw new NumberFormatException();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
