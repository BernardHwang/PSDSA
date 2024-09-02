import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String wordFile = "random_words.txt";
        String numFile = "random_numbers.txt";
        ArrayList<String> wordArrayList = new ArrayList<>();
        ArrayList<Integer> numArrayList = new ArrayList<>();
        LinkedList<Integer> numLinkedList = new LinkedList<>();

        // Read file
        readNumbersFromFile(numFile, numArrayList, numLinkedList);
        readWordsFromFile(wordFile, wordArrayList);

        // Create sets for sorting without duplicates
        Set<Integer> numSet = new HashSet<>(numArrayList);
        Set<String> wordSet = new HashSet<>(wordArrayList);

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

                    System.out.println("\nSorting without duplicates");
                    SizeSorting.sortIntegerSet(numSet, "selection");
                    SizeSorting.sortStringSet(wordSet, "selection");

                    System.out.println("\nSorting duplicates");
                    SizeSorting.sortDuplicateList(numArrayList, numLinkedList, numSet.size(), "selection");
                    SizeSorting.sortDuplicateList(wordArrayList, wordSet.size(), "selection");

                    System.out.println("\nSorting with fully reverse-ordered list");
                    SizeSorting.sortReverseList(numArrayList, numLinkedList, "selection");
                    SizeSorting.sortReverseList(wordArrayList, "selection");
                    
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("\nSorting with different Size (10k, 50k, 100k, 500k, 1M)");
                    SizeSorting.sortSizeSorting(numArrayList, numLinkedList, "comb");
                    SizeSorting.sortSizeSorting(wordArrayList, "comb");

                    System.out.println("\nSorting without duplicates");
                    SizeSorting.sortIntegerSet(numSet, "comb");
                    SizeSorting.sortStringSet(wordSet, "comb");

                    System.out.println("\nSorting duplicates");
                    SizeSorting.sortDuplicateList(numArrayList, numLinkedList, numSet.size(), "comb");
                    SizeSorting.sortDuplicateList(wordArrayList, wordSet.size(), "comb");

                    //worst case
                    System.out.println("\nSorting with fully reverse-ordered list");
                    SizeSorting.sortReverseList(numArrayList, numLinkedList, "comb");
                    SizeSorting.sortReverseList(wordArrayList, "comb");

                    //20% sorted
                    System.out.println("\nSorting with 20% sorted list");

                    //50% sorted
                    System.out.println("\nSorting with 50% sorted list");

                    //70% sorted
                    System.out.println("\nSorting with 70% sorted list");

                    //100% sorted
                    System.out.println("\nSorting with fully sorted list");

                    break;
                case 5:
                    System.out.println("\nSorting with different Size (10k, 50k, 100k, 500k, 1M)");
                    SizeSorting.sortSizeSorting(numArrayList, numLinkedList, "counting");
                    SizeSorting.sortSizeSorting(wordArrayList, "counting");

                    System.out.println("\nSorting without duplicates");
                    SizeSorting.sortIntegerSet(numSet, "counting");
                    SizeSorting.sortStringSet(wordSet, "counting");

                    System.out.println("\nSorting duplicates");
                    SizeSorting.sortDuplicateList(numArrayList, numLinkedList, numSet.size(), "counting");
                    SizeSorting.sortDuplicateList(wordArrayList, wordSet.size(), "counting");

                    System.out.println("\nSorting with fully reverse-ordered list");
                    SizeSorting.sortReverseList(numArrayList, numLinkedList, "counting");
                    SizeSorting.sortReverseList(wordArrayList, "counting");

                    //20% sorted
                    System.out.println("\nSorting with 20% sorted list");

                    //50% sorted
                    System.out.println("\nSorting with 50% sorted list");

                    //70% sorted
                    System.out.println("\nSorting with 70% sorted list");

                    //100% sorted
                    System.out.println("\nSorting with fully sorted list");

                    //Test counting sort with different ranges of value
                    System.out.println("\nSorting with different ranges of value (100, 10000, 1000000, 9999999)");
                    SizeSorting.rangeTestCountingSort(numArrayList, numLinkedList);
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
        in.close();
    }

    private static void readWordsFromFile(String fileName, ArrayList<String> wordArrayList) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordArrayList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read numbers from a file into both an ArrayList and a LinkedList
    private static void readNumbersFromFile(String fileName, ArrayList<Integer> numArrayList, LinkedList<Integer> numLinkedList) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                numArrayList.add(number);
                numLinkedList.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
