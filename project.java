import java.util.Scanner;

public class project {
    public static String encryption() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите сообщение для зашифровки: ");
        String text = scan.nextLine();
        return text;
    }

    public static String decryption() {
        System.out.print("Введите имеющийся у Вас ключ: ");
        Scanner scan = new Scanner(System.in);
        String inputKey = scan.nextLine();
        return inputKey;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String freeInput;
        System.out.print("Здравствуйте! \n \nВыберите режим работы: \n 1) Зашифровка сообщения (\\enc) \n 2) Дешифровка сообщения (\\dec)\nВвод ответа: ");
        freeInput = scan.nextLine();
        switch (freeInput) {
            case "\\enc": encryption();
        }
    }
}