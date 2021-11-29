public class Operation extends Analizer {

    public static String output(String input) throws Exception {
        String[] array = resultArray(input);
        int result = 0;
        if (array[3] == ARAB) {
            try {
                result = arabicResult(array[0], array[2], array[1]);

            } catch (ArithmeticException byZero) {
                System.out.println("Делить на нуль строго запрещено!!");
                return null;
            } catch (IllegalArgumentException wrongOperator) {
                System.out.println(" Неверный знак в выраженииию" +
                        "\n убедитесь что ввели +, -, * или /");
                return null;
            }
            return String.valueOf(result);
        } else if (array[3] == ROME) {
            try {
                result = romanResult(array[0], array[2], array[1]);
            } catch (NumberFormatException notExist) {
                System.out.println("в римской системе исчисления не существует " +
                        "\nотрицательных и нулевого значаений" +
                        "\nрезультатом данной операции является число менее 1");
            } catch (IllegalArgumentException wrongOperator) {
                System.out.println("Неверный знак в выраженииию" +
                        "\nубедитесь что ввели +, -, * или /");
                return null;
            }
            return arabicToRoman(result);
        }
        return null;
    }

    private static int arabicResult(String firstNumber, String secondNumber, String operator) throws Exception {
        int numberOne = Integer.parseInt(firstNumber);
        int numberTwo = Integer.parseInt(secondNumber);
        if (operator.equals("+")) {
            return numberOne + numberTwo;
        } else if (operator.equals("-")) {
            return numberOne - numberTwo;
        } else if (operator.equals("*")) {
            return numberOne * numberTwo;
        } else if (operator.equals("/")) {
            if (numberTwo == 0) {
                throw new ArithmeticException();
            }
            return numberOne / numberTwo;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static int romanResult(String firstNumber, String secondNumber, String operator) {
        int numberOne = romanToArabic(firstNumber);
        int numberTwo = romanToArabic(secondNumber);
        if (operator.equals("+")) {
            return numberOne + numberTwo;
        } else if (operator.equals("-")) {
            if (numberOne <= numberTwo) {
                throw new NumberFormatException();
            }
            return numberOne - numberTwo;
        } else if (operator.equals("*")) {
            return numberOne * numberTwo;
        } else if (operator.equals("/")) {
            if (numberOne < numberTwo) {
                throw new NumberFormatException();
            }
            return numberOne / numberTwo;
        } else {
            throw new IllegalArgumentException();
        }
    }
}