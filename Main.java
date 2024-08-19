import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Reader.NumberFileReader;
import Reader.WordFileReader;

public class Main {
    public static void main(String[] args) {
        String wordFile = "random_words.txt";
        String numFile = "random_numbers.txt";
        ArrayList<String> wordArrayList = new ArrayList<>();
        ArrayList<Integer> numArrayList = new ArrayList<>();
        LinkedList<Integer> numLinkedList = new LinkedList<>();

        // Create threads for reading files concurrently
        Thread wordThread = new Thread(new WordFileReader(wordFile, wordArrayList));
        Thread numThread = new Thread(new NumberFileReader(numFile, numArrayList, numLinkedList));

        // Start the threads
        wordThread.start();
        numThread.start();

        try {
            // Wait for both threads to finish
            wordThread.join();
            numThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean exit = false;
        Scanner in = new Scanner(System.in);;
        while (!exit) {
            System.out.println("Choose Number:");
            System.out.println("[1] Demo of 4 Sorting Algorithms");
            System.out.println("[2] Selection Sort");
            System.out.println("[3] Merge Sort");
            System.out.println("[4] Comb Sort");
            System.out.println("[5] Counting Sort");
            System.out.println("[0] Bye Bye");
            System.out.print("Option: ");
            int option = Integer.parseInt(in.nextLine());
            switch (option) {
                case 1:
                    DemoUsed.demo(wordArrayList, numArrayList, numLinkedList);
                    break;
                case 2:
                    System.out.println("\nSorting with different Size (10k, 50k, 100k, 500k, 1M)");
                    SizeSorting.SelectionSortSizeSorting(numArrayList, numLinkedList);
                    SizeSorting.SelectionSortSizeSorting(wordArrayList);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    exit = true;
                    break;

            }
        }
        in.close();
    }
}
