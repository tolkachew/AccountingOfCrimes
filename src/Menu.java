import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Menu {
    public String path = "text.txt";

    public Menu(String path) {
        this.path = path;
        Writer.path = path;
        Reader.path = path;
    }

    public void task1(String crime) {
        TreeMap< LocalDate,String> people = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Указанное преступление: " + crime);
            //чтение построчно
            String line;
            int counter = 0;
            int startingPosition = 5;
            while ((line = br.readLine()) != null) {

                if (counter == startingPosition) {
                    if (line.equals(crime)) {
                        LocalDate date = LocalDate.parse(Reader.readSpecificLine(startingPosition - 4));
                        people.put(date,Reader.readSpecificLine(startingPosition - 3));
                    }
                    startingPosition += 7;
                }
                counter++;
            }
            for(Map.Entry m: people.entrySet()){
                System.out.println("Дата совершения преступления: "+m.getKey()+" Преступник: "+m.getValue());
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void task2(LocalDate dateTime, String fio, String city, String district, String crime, String punishment, boolean append) {
        Writer.Write(dateTime, fio, city, district, crime, punishment, append);
    }

    public void task3(String crime, String newPunishment) {
        String content = null;
        try {
            content = Reader.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splited = content.split("\r");
        int startingPosition = 5;
        for (int i = 0; i < splited.length; i++) {
            if (splited[startingPosition].equals("\n" + crime)) {

                splited[startingPosition + 1] = "\n" + newPunishment;
                if (startingPosition + 7 <= splited.length) {
                    startingPosition += 7;
                } else {
                    break;
                }
            }
        }
        Writer.rewriteFile(splited);
        //Arrays.stream(splited).forEach(System.out::print);
        //System.out.println(splited);
    }

    public void task4(LocalDate beginning, LocalDate theEnd) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Преступлелния, совершенные между: " + beginning+" и " + theEnd);
            //чтение построчно
            String line;
            int counter = 0;
            int startingPosition = 2;
            LocalDate date;
            while ((line = br.readLine()) != null) {

                if (counter == startingPosition) {
                     date = LocalDate.parse(Reader.readSpecificLine(startingPosition - 1));
                     if(beginning.isBefore(date) && theEnd.isAfter(date)){
                         System.out.println(Reader.readSpecificLine(startingPosition +3));
                     }
                     startingPosition+=7;
                }
                counter++;
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void task5(String criminal, int index) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            String text="";
            int j = 1;
            int startingPosition = 0;

            try {
                text = Reader.readFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] array= text.split("\r");
            for(int i=0; i<array.length;i++){
                if (index == j)
                {
                    array[startingPosition + 2] = array[startingPosition + 2] + " "+criminal;
                    if (startingPosition + 7 <= array.length)
                    {
                        j++;
                        startingPosition += 7;
                    }
                    else
                    {
                        break;
                    }
                }
                else {
                    if (startingPosition + 7 <= array.length)
                    {
                        j++;
                        startingPosition += 7;
                    }
                    else
                    {
                        break;
                    }
                }
            }
            Writer.rewriteFile(array);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void task6(String criminal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Преступлелния, совершенные : " + criminal);
            //чтение построчно
            String line;
            int counter = 0;
            int startingPosition = 2;

            while ((line = br.readLine()) != null) {

                if (counter == startingPosition) {

                    if(line.contains(criminal)){
                        System.out.println(Reader.readSpecificLine(startingPosition +3));
                    }
                    startingPosition+=7;
                }
                counter++;
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void task7(String criminal, LocalDate beginning, LocalDate theEnd) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Преступлелния, совершенные "+criminal+" между: " + beginning+" и " + theEnd);
            //чтение построчно
            String line;
            int counter = 0;
            int startingPosition = 2;
            LocalDate date;
            while ((line = br.readLine()) != null) {

                if (counter == startingPosition) {
                    if(line.contains(criminal)){
                        date = LocalDate.parse(Reader.readSpecificLine(startingPosition - 1));
                        if(beginning.isBefore(date) && theEnd.isAfter(date)){
                            System.out.println(Reader.readSpecificLine(startingPosition +3));
                        }
                    }
                    startingPosition+=7;
                }
                counter++;
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void task8(String crime) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Указанное реступлелние: "+crime);
            //чтение построчно
            String line;
            int counter = 0;
            int startingPosition = 5;
            while ((line = br.readLine()) != null) {

                if (counter == startingPosition) {
                    if(line.equals(crime)){
                        System.out.println(Reader.readSpecificLine(startingPosition -3));
                    }
                    startingPosition+=7;
                }
                counter++;
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public String readSpecificLine(int index) {
        return "";
    }

    public void rewriteFile(String[] array) throws IOException {

    }
}
