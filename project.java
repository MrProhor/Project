import java.util.Arrays;
import java.util.Scanner;

public class project {

    public static String encryption() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведите сообщение для зашифровки: ");
        String inputText = scan.nextLine();
        char[] text = inputText.toCharArray();
        System.out.print("Введите '\\rand', чтобы получить случайный ключ ИЛИ введите свой ключ для зашифровки.\nЭто может быть любая последовательность любых символов, длинной " + inputText.length() + ": ");
        String key = scan.nextLine();
        if (key.equals("\\rand")) {
            char[] elementsOfKey = new char[inputText.length()];
            int randomInt;
            double randomDouble;
            System.out.print("Ваш случайный ключ:");
            for (int i = 0; i < inputText.length(); ++i) {
                randomDouble = (Math.random());
                randomInt = (int) (randomDouble*1000);
                text[i] = (char) (((int) text[i]) + randomInt);
                System.out.print( (char) (randomInt));
                elementsOfKey[i] = (((char) (randomInt)));
            }
            System.out.println("\n" + Arrays.toString(elementsOfKey));
            System.out.println(text);
        }
        return null;
    }

    /*
    public static String decryption() {
        System.out.print("Введите имеющийся у Вас ключ: ");
        Scanner scan = new Scanner(System.in);
        String inputKey = scan.nextLine();
        return inputKey;
    }
    Эта часть кода не дописана
    */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String freeInput;
        int i = 0;
        while (i!=1) {
        System.out.print("Здравствуйте! \n \nВыберите режим работы: \n 1) Зашифровка сообщения (\\enc) \n 2) Дешифровка сообщения (\\dec)\nВвод команды: ");
        freeInput = scan.nextLine();
            switch (freeInput) {
                case ("\\enc") -> encryption();
                case ("\\dec") -> decryption();
                case ("\\exit") -> {
                    System.out.print("\nВыход...");
                    i = 1;
                }
                default -> System.out.print("\nОшибка! Попробуйте ввести команду ещё раз...\n\n");
            }
        }
    }
}