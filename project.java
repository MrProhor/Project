import java.util.Scanner;

public class project {

    public static void encryption() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведите сообщение для зашифровки: ");
        String inputText = scan.nextLine();
        char[] text = inputText.toCharArray();
        int i = 0;
        inputText = new String(text);
        while (i != 1) {
            System.out.print("Введите '\\rand', чтобы получить случайный ключ ИЛИ введите свой ключ для зашифровки.\nЭто может быть любая последовательность латинских букв, знаков препинания и цифр, длинной " + inputText.length() + ": ");
            String key = scan.nextLine();
            switch (key) {
                case ("\\rand"):
                    int randomInt;
                    double randomDouble;
                    System.out.print("\nВаш сгенерированный ключ: ");
                    for (i = 0; i < inputText.length(); ) {
                        randomDouble = (Math.random());
                        randomInt = (int) (randomDouble * 1000);
                        if ((randomInt > 31 & randomInt < 127) | (randomInt > 1039 & randomInt < 1104)) {
                            System.out.print((char) (randomInt));
                            int a = (((int) text[i]) + randomInt);
                            if (((((int) text[i]) + randomInt) > 126) & ((((int) text[i]) + randomInt) < 1040)) {
                                while (a > 126) {
                                    a = 31 + a - 126;
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
                        char[] arrayOfKey = key.toCharArray();
                        for (i = 0; i < key.length()-1; i++) {
                            if (arrayOfKey[i] < 32 | arrayOfKey[i] > 126) {
                                System.out.print("\nОШИБКА! Введён недопустимый символ!\n\n");
                                i = -1;
                                break;
                            }
                        }
                        if (i == -1) {
                            break;
                        }
                        System.out.println("\nВаш ключ: " + key);
                        i = 0;
                        int a;
                        for (i = 0; i < inputText.length(); ) {
                            a = ((int) text[i]) + ((int) arrayOfKey[i]);
                            if ((((int) arrayOfKey[i]) > 31 & ((int) arrayOfKey[i]) < 127) | (((int) arrayOfKey[i]) > 1039 & ((int) arrayOfKey[i]) < 1104)) {
                                if ((a > 126) & (a < 1040)) {
                                    while (a > 126) {
                                        a = 31 + a - 126;
                                    }
                                    text[i] = (char) (a);
                                    i++;
                                } else if (a > 1103) {
                                    while (a > 1103) {
                                        a = 1039 + a - 1104;
                                    }
                                    text[i] = (char) (a);
                                    i++;
                                } else {
                                    text[i] = (char) (a);
                                    i++;
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
    }

    public static void decryption() {
        int a = 1;
        while (a != 0) {
            System.out.print("\nВведите имеющийся у Вас текст: ");
            Scanner scan = new Scanner(System.in);
            String inputText = scan.nextLine();
            char[] text = inputText.toCharArray();
            System.out.print("Введите имеющийся у Вас ключ: ");
            String inputKey = scan.nextLine();
            char[] key = inputKey.toCharArray();
            if (inputKey.length() != inputText.length()) {
                System.out.print("ОШИБКА! Длинна ключа не совпадает с длинной зашифрованного сообщения!\n");
            } else {
                System.out.print("\nИсходное сообщение: ");
                for (a = 0; a < inputText.length(); a++) {
                    char i;
                    if ((text[a] - key[a] > 31) & ((text[a] > 31 & text[a] < 127) | (text[a] > 1039 & text[a] < 1104))) {
                        System.out.print((char) (text[a] - key[a]));
                    } else if (text[a] - key[a] < 31) {
                        i = ((char) (text[a] - 31 + 126));
                        if (i - key[a] < 31) {
                            i = ((char) (i - 31 + 126 - key[a]));
                        } else {
                            i = (char) (i -  key[a]);
                        }
                        System.out.print(i);
                        break;
                    } else if (text[a] - key[a] < 32) {
                        i = (char) (125 + 32 - text[a] - key[a]);
                        System.out.print(i);
                    } else {
                        i = (char) (text[a] - key[a]);
                        System.out.print(i);
                    }
                }
            }
            a = 0;
        }
    }

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
                case ("\\dec") -> decryption();
                case ("\\exit") -> {
                    System.out.print("\nВыход...");
                    i = 1;
                }
                default -> System.out.print("\n\nОшибка! Попробуйте ввести команду ещё раз...");
            }
        }
    }
}