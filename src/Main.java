import java.time.LocalDate;
import java.util.Scanner;
//homework
public class Main {

    public static final int CURRENT_YEAR = LocalDate.now().getYear();

//    public static void printAnswer (int year) {
//        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
//            System.out.println(year + " год - високосный");}
//        else {
//                System.out.println(year + "год - не високосный");}
//        }

    public static void printAnswer (int year) {
        boolean leapYear = isLeapYear (year);
        printAnswer (year, leapYear);
        }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static void printAnswer(int year, boolean leapYear) {
        if (leapYear) {
            System.out.println(year + " год - високосный");
        } else {
            System.out.println(year + " год - не високосный");
        }
    }

    public static void printAppInstallMessage(int typeOS, int clientDeviceYear) {
        boolean oldDevice = isOldDevice(clientDeviceYear);
        printAppInstallMessageResult(typeOS, oldDevice);
    }
    private static String defineClientOS(int typeOS) {
        if (typeOS == 0) {
            return "IOS";
        } else if (typeOS == 1) {
            return "Android";
        }
        return "другой операционной системы";
    }
    private static boolean isOldDevice(int clientDeviceYear) {
        return clientDeviceYear < CURRENT_YEAR;
    }
    private static void printAppInstallMessageResult(int typeOS, boolean oldDevice) {
        if (oldDevice) {
            System.out.println("Установите облегчённую версию приложения для " + defineClientOS(typeOS) + " по ссылке");
        } else {
            System.out.println("Установите приложение для " + defineClientOS(typeOS) + " по ссылке");
        }
    }

    private static void printDeliveryDays (int deliveryDistance) {
        int deliveryDays = printDeliveryDaysResult(deliveryDistance);
        if (deliveryDays == 0) {
            System.out.println("К сожалению, доставка не будет осуществлена");
        } else {
            System.out.println("Количество дней доставки : " + deliveryDays + ".");
        }
    }

    private static int printDeliveryDaysResult (int deliveryDistance) {
        int firstBoarders = 20;
        int secondBoarders = 60;
        int thirdBoarders = 100;

        if (deliveryDistance > thirdBoarders) {
            return 0;
        } else if (deliveryDistance < firstBoarders) {
            return 1;
        } else if (deliveryDistance < secondBoarders) {
            return 2;
        } else {
            return 3;
        }
    }


    public static void main(String[] args) {
        System.out.println("задача 1");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите год для определения его високосности: ");
        int year = in.nextInt();
        printAnswer(year);

        System.out.println("\nзадача 2");
        System.out.print("Введите 1, если вы пользователь Android. Введите 0, если вы пользователь iOS: ");
        int typeOS = in.nextInt();
        System.out.print("Введите год выпуска вашего телефона: ");
        int clientDeviceYear = in.nextInt();
        printAppInstallMessage (typeOS, clientDeviceYear);

        System.out.println("\nзадача 3");
        System.out.print("Укажите расстояние от вашего дома до нашего офиса: ");
        int deliveryDistance = in.nextInt();
        printDeliveryDays (deliveryDistance);
    }
    }
