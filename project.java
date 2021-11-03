import java.util.Arrays;
import java.util.Scanner;

public class project {

    public static String encryption() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведите сообщение для зашифровки: ");
        String inputText = scan.nextLine();
        char[] text = inputText.toCharArray();
        int i = 0;
        inputText = new String(text);
        while (i != 1) {
            System.out.print("Введите '\\rand', чтобы получить случайный ключ ИЛИ введите свой ключ для зашифровки.\nЭто может быть любая последовательность любых символов, длинной " + inputText.length() + ": ");
            String key = scan.nextLine();
            switch (key) {
                case ("\\rand"):
                    int randomInt;
                    double randomDouble;
                    System.out.print("\nВаш сгенерированный ключ: ");
                    for (i = 0; i < inputText.length(); i = i) {
                        randomDouble = (Math.random());
                        randomInt = (int) (randomDouble * 1000);
                        if ((randomInt > 31 & randomInt < 126) | (randomInt > 1039 & randomInt < 1104)) {
                            System.out.print((char) (randomInt));
                            int a = (((int) text[i]) + randomInt);
                            if (((((int) text[i]) + randomInt) > 125) & ((((int) text[i]) + randomInt) < 1040)) {
                                while (a > 125) {
                                    a = 31 + a - 125;
                                }
                                text[i] = (char) (a);
                                i++;
                            } else if ((((int) text[i]) + randomInt) > 1103) {
                                while (a > 1103) {
                                    a = 1039 + a - 1104;
                                }
                                text[i] = (char) (a);
                                i++;
                            } else {
                                text[i] = (char) (((int) text[i]) + randomInt);
                                i++;
                            }
                        }
                    }
                    inputText = new String(text);
                    System.out.println("\nВаш зашифрованный текст: " + inputText);
                    i = 1;
                    break;
                default:
                    if (key.length() == inputText.length()) {
                        System.out.println("\nВаш ключ: " + key);
                        char[] arrayOfKey = key.toCharArray();
                        int a = (((int) text[i]) + ((int) arrayOfKey[i]));
                        for (i = 0; i < inputText.length(); i++) {
                            if ((((int) arrayOfKey[i]) > 31 & ((int) arrayOfKey[i]) < 126) | (((int) arrayOfKey[i]) > 1039 & ((int) arrayOfKey[i]) < 1104)) {
                                if (((((int) text[i]) + ((int) arrayOfKey[i])) > 125) & ((((int) text[i]) + ((int) arrayOfKey[i])) < 1040)) {
                                    while (a > 125) {
                                        a = 31 + a - 126;
                                    }
                                    text[i] = (char) (a);
                                } else if ((((int) text[i]) + ((int) arrayOfKey[i])) > 1103) {
                                    while (a > 1103) {
                                        a = 1039 + a - 1104;
                                    }
                                    text[i] = (char) (a);
                                } else {
                                    text[i] = (char) (a);
                                }
                            }
                        }
                        inputText = new String(text);
                        System.out.println("Ваш зашифрованный текст: " + inputText);
                        i = 1;
                    } else {
                        i = 0;
                        System.out.println("\nОШИБКА! Введён ключ неверной длины! Повторите попытку...");
                    }
            }
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
        System.out.print("Здравствуйте! ");
        while (i != 1) {
            System.out.print("\n \nВыберите режим работы: \n 1) Зашифровка сообщения (\\enc) \n 2) Дешифровка сообщения (\\dec)\n 3) Выход из программы (\\exit)\nВвод команды: ");
            freeInput = scan.nextLine();
            switch (freeInput) {
                case ("\\enc") -> encryption();
                //case ("\\dec") -> decryption();
                case ("\\exit") -> {
                    System.out.print("\nВыход...");
                    i = 1;
                }
                default -> System.out.print("\n\nОшибка! Попробуйте ввести команду ещё раз...");
            }
        }
    }
}