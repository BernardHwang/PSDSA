package Generator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWordsGenerator {

    public static void main(String[] args) throws IOException {
        String csvFile = "dictionary.csv";
        String line;
        String cvsSplitBy = ",";
        int numberOfWords = 1000000; // 1 million words

        List<String> words = new ArrayList<>();

        // Read the CSV file and store words
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] nGramData = line.split(cvsSplitBy);
                String word = nGramData[0];
                if (word.matches("[a-zA-Z]+")){
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] selectedWords = new String[numberOfWords];
        Random random = new Random();

        // Select 1 million words randomly
        try (FileWriter write = new FileWriter("random_words.txt")) {
            for (int i = 0; i < numberOfWords; i++) {
                int randomIndex = random.nextInt(words.size());
                selectedWords[i] = words.get(randomIndex);
                write.write(selectedWords[i] + "\n");
            }
        }
    }
}
