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
                    SizeSorting.sortSizeSorting(numArrayList, numLinkedList, "selection");
                    SizeSorting.sortSizeSorting(wordArrayList, "selection");

                    System.out.println("\nSorting with fully reverse-ordered list");
                    SizeSorting.sortReverseList(numArrayList, numLinkedList, "selection");
                    SizeSorting.sortReverseList(wordArrayList, "selection");
                    
                    System.out.println("\nSorting with partially reverse-ordered list");
                    SizeSorting.sortReversePartialList(numArrayList, numLinkedList, "selection");
                    SizeSorting.sortReversePartialList(wordArrayList, "selection");
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("\nSorting with different Size (10k, 50k, 100k, 500k, 1M)");
                    SizeSorting.sortSizeSorting(numArrayList, numLinkedList, "comb");
                    SizeSorting.sortSizeSorting(wordArrayList, "comb");

                    System.out.println("\nSorting with fully reverse-ordered list");
                    SizeSorting.sortReverseList(numArrayList, numLinkedList, "comb");
                    SizeSorting.sortReverseList(wordArrayList, "comb");

                    System.out.println("\nSorting with partially reverse-ordered list");
                    SizeSorting.sortReversePartialList(numArrayList, numLinkedList, "comb");
                    SizeSorting.sortReversePartialList(wordArrayList, "comb");
                    break;
                case 5:
                    System.out.println("\nSorting with different Size (10k, 50k, 100k, 500k, 1M)");
                    SizeSorting.sortSizeSorting(numArrayList, numLinkedList, "counting");
                    //SizeSorting.sortSizeSorting(wordArrayList, "counting");

                    // System.out.println("\nSorting with fully reverse-ordered list");
                    // SizeSorting.sortReverseList(numArrayList, numLinkedList, "counting");
                    // SizeSorting.sortReverseList(wordArrayList, "counting");

                    // System.out.println("\nSorting with partially reverse-ordered list");
                    // SizeSorting.sortReversePartialList(numArrayList, numLinkedList, "counting");
                    // SizeSorting.sortReversePartialList(wordArrayList, "counting");
                    break;
                case 0:
                    exit = true;
                    break;

            }
        }
        in.close();
    }
}
