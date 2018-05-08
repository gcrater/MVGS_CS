package projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public static void readFile(File file) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
