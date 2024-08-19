package Reader;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordFileReader implements Runnable {
    private String filePath;
    private ArrayList<String> arrayList;

    public WordFileReader(String filePath, ArrayList<String> arrayList) {
        this.filePath = filePath;
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            arrayList.addAll(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
