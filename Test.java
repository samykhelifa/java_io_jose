import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File f = new File
                ("C:\\pluralsight\\dir");
       // f.delete();
        f.mkdirs();
     //   System.out.println(f.canExecute());
     //   System.out.println(File.pathSeparator);
    }
}

