import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Writer {
    public static String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Writer(String path) {
        this.path = path;
    }

    public static void Write(LocalDate dateTime, String fio, String city, String district, String crime, String punishment, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            bw.write("/Record/" + "\n");
            bw.write(dateTime + "\n");
            bw.write(fio + "\n");
            bw.write(city + "\n");
            bw.write(district + "\n");
            bw.write(crime + "\n");
            bw.write(punishment + "\n");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void rewriteFile(String[] array) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (String line : array){
                bw.write(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
