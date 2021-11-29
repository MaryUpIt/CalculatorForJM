
import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Добро пожаловать, это примитивный калькулятор");
        System.out.println(" Он умеет складывать +, отнимать -, умножать * и делить /"
        +"\n он работает только с арабскими числами - от 0 до 10, или только с римскими от I до X" +
                "\n он умеет складывать +, вычитать -, умножать * и делить /");
        System.out.println(" Введите выражение на которе хотели бы узнать ответ в формате \"4 + 3\" или\"Х - I\"" +
                "\n обязательно через пробел это важное условие, для выхода введите \"EXIT\"" );
        boolean isExit = false;
        while (!isExit)
        {
            String input = scanner.nextLine();
            if (isExit= input.equalsIgnoreCase("exit")){
                System.out.println("Вычисления успешно завершены. Удачи!");
                break;
            }
                      System.out.println(Operation.output(input));
            System.out.println("Введите следующее выражение или EXIT");
        }
    }
}
