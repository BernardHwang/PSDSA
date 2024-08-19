package Reader;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NumberFileReader implements Runnable {
    private String filePath;
    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;

    public NumberFileReader(String filePath, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        this.filePath = filePath;
        this.arrayList = arrayList;
        this.linkedList = linkedList;
    }

    @Override
    public void run() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                try {
                    Integer number = Integer.parseInt(line);
                    arrayList.add(number);
                    linkedList.add(number);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid Integer format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
