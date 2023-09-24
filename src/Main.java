import java.time.LocalDate;
import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Задача 1");
        checkleapYear();
        System.out.println("Задача 2");
        printInfoAboutVersion();
        System.out.println("Задача 3");
        int deliveryDays = calculateDeliveryTime();
        if (deliveryDays > 0) {
            System.out.println("Потребуется дней: " + deliveryDays);
        } else {
            System.out.println("Доставки нет");
        }

    }

    //Задача 1
    public static boolean leapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

    }

    public static void checkleapYear() {
        System.out.println("Укажите год для проверки в формате ГГГГ");
        int year = sc.nextInt();
        if (leapYear(year)) {
            System.out.println("Год - " + year + " является високосным");
        } else {
            System.out.println("Год - " + year + " не является високосным");
        }
    }

    //Задача 2
    public static void printInfoAboutVersion() {

        System.out.println("Введите число соответствующее вайшей ОС \n0-iOS 1-Android");
        int os = sc.nextInt();
        if (os != 0 && os != 1) {
            System.out.println("Некоректная ОС!");
            return;
        }
        System.out.println("Введите год выпуска вашего смартфона");
        int deviceYear = sc.nextInt();
        int currentYear = LocalDate.now().getYear();
        if (deviceYear < 2000 && deviceYear > currentYear) {
            System.out.println("Некорректно указан год смартфона");
            return;
        }
        StringBuilder infoText = new StringBuilder("Установите ");
        if (deviceYear < currentYear) {
            infoText.append("облегченную ");
        }
        infoText.append("версию приложения для ");
        if (os == 0) {
            infoText.append("iOS");
        } else {
            infoText.append("Android");
        }
        System.out.println(infoText);
    }

    //Задача 3

    public static int calculateDeliveryTime() {
        System.out.println("Укажите дистанцию от офиса до места доставки в км:");
        int distance = sc.nextInt();
        int days = 1;

        if (distance < 0 || distance > 100) {
            return 0;
        }
        if (distance > 20) {
            days++;
        }
        if (distance > 60) {
            days++;
        }
        return days;
    }
}