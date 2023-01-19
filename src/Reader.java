import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class Reader {

    public static String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Reader(String path)
    {
        this.path = path;
    }

    public void read() {
        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){

                System.out.println(s);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
    public static String readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
    public static String readSpecificLine(int index) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            //чтение построчно
            String line;
            int counter =0;
            while((line=br.readLine())!=null){

                if (counter == index)
                {
                    return line;
                }
                counter++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return "Не найдено";
    }
}
