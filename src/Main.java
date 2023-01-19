import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static String path = "text.txt";

    LocalDate dateTime = LocalDate.of(2015, 7, 20);
    String fio = "Иванов Иван Иванович";
    String city = "Минск";
    String district = "Малиновка";
    String crime = "Убийство";
    String punishment = "Штраф";

    public static void main(String[] args) {


        Menu menu = new Menu(path);
        boolean exit = false;


        do {

            System.out.println("1 Для каждого преступления показать имена преступников в хронологическом порядке совершения преступления.");
            System.out.println("2 Добавить новое преступление.");
            System.out.println("3 Измененить данные о наказании преступления.");
            System.out.println("4 Показать преступления, осуществленные в указанный интервал дат.");
            System.out.println("5 Добавить нового преступника в состав указанного преступления.");
            System.out.println("6 Показать информацию о каждом совершенном преступлении данного преступника.");
            System.out.println("7 Показать список преступлений, которые совершались данным преступником в указанный промежуток времени.");
            System.out.println("8 Предоставить информацию о том, сколько преступников совершили указанное преступление.");
            System.out.println("9 Выйти из программы");
            Scanner in = new Scanner(System.in);

            String choose = "1";
            choose = in.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Введите преступление.");
                    String chooseCrime = in.nextLine();
                    menu.task1(chooseCrime);
                    in.nextLine();
                    System.out.print("\n");
                    break;
                case "2":
                    System.out.println("Введите дату, фио, город, район, преступление, наказание.");
                    String[] date = in.nextLine().split("-");
                    LocalDate dateTime5 = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
                    String fio2 = in.nextLine();
                    String city2 = in.nextLine();
                    String district2 = in.nextLine();
                    String crime2 = in.nextLine();
                    String punishment2 = in.nextLine();

                    menu.task2(dateTime5, fio2, city2, district2, crime2, punishment2, true);
                    in.nextLine();
                    System.out.print("\n");
                    break;
                case "3":
                    System.out.println("Введите преступление, наказание которого нужно исправить, и наказание.");
                    String crime3 = in.nextLine();
                    String punishment3 = in.nextLine();
                    menu.task3(crime3, punishment3);
                    in.nextLine();
                    System.out.print("\n");
                    break;
                case "4":
                    System.out.println("Введите интервал дат( пример 2012-07-15).");
                    String[] date1 = in.nextLine().split("-");
                    LocalDate dateTime1 = LocalDate.of(Integer.valueOf(date1[0]), Integer.valueOf(date1[1]), Integer.valueOf(date1[2]));
                    String[] date2 = in.nextLine().split("-");
                    LocalDate dateTime2 = LocalDate.of(Integer.valueOf(date2[0]), Integer.valueOf(date2[1]), Integer.valueOf(date2[2]));
                    menu.task4(dateTime1, dateTime2);
                    in.nextLine();
                    System.out.print("\n");
                    break;
                case "5":
                    System.out.println("Введите фио преступника и номер записи.");
                    String name = in.nextLine();
                    int ind = Integer.valueOf(in.nextLine());
                    menu.task5(name, ind);
                    in.nextLine();
                    System.out.print("\n");
                    break;
                case "6":
                    System.out.println("Введите фио преступника.");
                    String name2 = in.nextLine();
                    menu.task6(name2);
                    in.nextLine();
                    System.out.print("\n");
                    break;
                case "7":
                    System.out.println("Введите интервал дат( пример 2012-07-15) и фио преступника.");
                    String[] date3 = in.nextLine().split("-");
                    LocalDate dateTime3 = LocalDate.of(Integer.valueOf(date3[0]), Integer.valueOf(date3[1]), Integer.valueOf(date3[2]));
                    String[] date4 = in.nextLine().split("-");
                    LocalDate dateTime4 = LocalDate.of(Integer.valueOf(date4[0]), Integer.valueOf(date4[1]), Integer.valueOf(date4[2]));
                    String name3 = in.nextLine();
                    menu.task7(name3, dateTime3, dateTime4);
                    in.nextLine();
                    System.out.print("\n");
                    break;
                case "8":
                    System.out.println("Введите преступление.");
                    String crime4 = in.nextLine();
                    menu.task8(crime4);
                    in.nextLine();
                    System.out.print("\n");
                    break;
                case "9":
                    exit = true;
                    System.out.print("\n");
                    break;
                default:
                    exit = true;
                    System.out.print("\n");
                    break;
            }
        } while (!exit);
    }
}
