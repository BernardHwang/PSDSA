package Generator;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RandomNumbersGenerator {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        ArrayList<Integer> numList = new ArrayList<>(10);
        int numbers = 20000000;
        
        // Use try-with-resources to ensure FileWriter is closed
        try (FileWriter writer = new FileWriter("random_numbers.txt")) {
            for (int i = 0; i < numbers; i++) {
                int numDigits = random.nextInt(8) + 1;
                int min = (int) Math.pow(10, numDigits - 1);
                int max = (int) Math.pow(10, numDigits) - 1;
                int number = random.nextInt((max - min) + 1) + min;
                numList.add(number);
                writer.write(number + "\n");
            }
        }
    }
}
