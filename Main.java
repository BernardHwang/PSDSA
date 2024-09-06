import java.util.LinkedHashSet;
import java.util.ArrayList;
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
        Set<Integer> numSet = new LinkedHashSet<>(numArrayList);
        Set<String> wordSet = new LinkedHashSet<>(wordArrayList);

        boolean exit = false;
        Scanner in = new Scanner(System.in);;
        while (!exit) {
            System.out.println("Choose Number:");
            System.out.println("[1] Demo of 4 Sorting Algorithms");
            System.out.println("[2] Selection Sort");
            System.out.println("[3] Merge Sort");
            System.out.println("[4] Comb Sort");
            System.out.println("[5] Counting Sort");
            System.out.println("[6] Multithreaded Counting Sort");
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

                    System.out.println("** Sorting ArrayList of Integers **\n");
                    PartitionSorted.numArray1PartitionSorted(numArrayList, "selection");
                    PartitionSorted.numArray2PartitionSorted(numArrayList, "selection");
                    PartitionSorted.numArray3PartitionSorted(numArrayList, "selection");
                    PartitionSorted.numArray4PartitionSorted(numArrayList, "selection");
                    PartitionSorted.numArrayHalfSorted(numArrayList, "selection");
                    PartitionSorted.numArray75PercentSorted(numArrayList, "selection");
                    PartitionSorted.numArray100PercentSorted(numArrayList, "selection");
            
                    System.out.println("\n** Sorting LinkedList of Integers **\n");
                    PartitionSorted.numLinked1PartitionSorted(numLinkedList, "selection");
                    PartitionSorted.numLinked2PartitionSorted(numLinkedList, "selection");
                    PartitionSorted.numLinked3PartitionSorted(numLinkedList, "selection");
                    PartitionSorted.numLinked4PartitionSorted(numLinkedList, "selection");
                    PartitionSorted.numLinkedHalfSorted(numLinkedList, "selection");
                    PartitionSorted.numLinked75PercentSorted(numLinkedList, "selection");
            
                    System.out.println("\n** Sorting ArrayList of Strings **\n");
                    PartitionSorted.wordArray1PartitionSorted(wordArrayList, "selection");
                    PartitionSorted.wordArray2PartitionSorted(wordArrayList, "selection");
                    PartitionSorted.wordArray3PartitionSorted(wordArrayList, "selection");
                    PartitionSorted.wordArray4PartitionSorted(wordArrayList, "selection");
                    
                    break;
                case 3:
                    System.out.println("\nSorting with different Size (10k, 50k, 100k, 500k, 1M)");
                    SizeSorting.sortSizeSorting(numArrayList, numLinkedList, "merge");
                    SizeSorting.sortSizeSorting(wordArrayList, "merge");

                    System.out.println("\nSorting without duplicates");
                    SizeSorting.sortIntegerSet(numSet, "merge");
                    SizeSorting.sortStringSet(wordSet, "merge");

                    System.out.println("\nSorting duplicates");
                    SizeSorting.sortDuplicateList(numArrayList, numLinkedList, numSet.size(), "merge");
                    SizeSorting.sortDuplicateList(wordArrayList, wordSet.size(), "merge");

                    //worst case
                    System.out.println("\nSorting with fully reverse-ordered list");
                    SizeSorting.sortReverseList(numArrayList, numLinkedList, "merge");
                    SizeSorting.sortReverseList(wordArrayList, "merge");

                    System.out.println("** Sorting ArrayList of Integers **\n");
                    PartitionSorted.numArray1PartitionSorted(numArrayList, "merge");
                    PartitionSorted.numArray2PartitionSorted(numArrayList, "merge");
                    PartitionSorted.numArray3PartitionSorted(numArrayList, "merge");
                    PartitionSorted.numArray4PartitionSorted(numArrayList, "merge");
                    PartitionSorted.numArrayHalfSorted(numArrayList, "merge");
                    PartitionSorted.numArray75PercentSorted(numArrayList, "merge");
                    PartitionSorted.numArray100PercentSorted(numArrayList, "merge");
            
                    System.out.println("\n** Sorting LinkedList of Integers **\n");
                    PartitionSorted.numLinked1PartitionSorted(numLinkedList, "merge");
                    PartitionSorted.numLinked2PartitionSorted(numLinkedList, "merge");
                    PartitionSorted.numLinked3PartitionSorted(numLinkedList, "merge");
                    PartitionSorted.numLinked4PartitionSorted(numLinkedList, "merge");
                    PartitionSorted.numLinkedHalfSorted(numLinkedList, "merge");
                    PartitionSorted.numLinked75PercentSorted(numLinkedList, "merge");
            
                    System.out.println("\n** Sorting ArrayList of Strings **\n");
                    PartitionSorted.wordArray1PartitionSorted(wordArrayList, "merge");
                    PartitionSorted.wordArray2PartitionSorted(wordArrayList, "merge");
                    PartitionSorted.wordArray3PartitionSorted(wordArrayList, "merge");
                    PartitionSorted.wordArray4PartitionSorted(wordArrayList, "merge");
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

                    System.out.println("** Sorting ArrayList of Integers **\n");
                    PartitionSorted.numArray1PartitionSorted(numArrayList, "comb");
                    PartitionSorted.numArray2PartitionSorted(numArrayList, "comb");
                    PartitionSorted.numArray3PartitionSorted(numArrayList, "comb");
                    PartitionSorted.numArray4PartitionSorted(numArrayList, "comb");
                    PartitionSorted.numArrayHalfSorted(numArrayList, "comb");
                    PartitionSorted.numArray75PercentSorted(numArrayList, "comb");
                    PartitionSorted.numArray100PercentSorted(numArrayList, "comb");
            
                    System.out.println("\n** Sorting LinkedList of Integers **\n");
                    PartitionSorted.numLinked1PartitionSorted(numLinkedList, "comb");
                    PartitionSorted.numLinked2PartitionSorted(numLinkedList, "comb");
                    PartitionSorted.numLinked3PartitionSorted(numLinkedList, "comb");
                    PartitionSorted.numLinked4PartitionSorted(numLinkedList, "comb");
                    PartitionSorted.numLinkedHalfSorted(numLinkedList, "comb");
                    PartitionSorted.numLinked75PercentSorted(numLinkedList, "comb");
            
                    System.out.println("\n** Sorting ArrayList of Strings **\n");
                    PartitionSorted.wordArray1PartitionSorted(wordArrayList, "comb");
                    PartitionSorted.wordArray2PartitionSorted(wordArrayList, "comb");
                    PartitionSorted.wordArray3PartitionSorted(wordArrayList, "comb");
                    PartitionSorted.wordArray4PartitionSorted(wordArrayList, "comb");

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

                    System.out.println("** Sorting ArrayList of Integers **\n");
                    PartitionSorted.numArray1PartitionSorted(numArrayList, "counting");
                    PartitionSorted.numArray2PartitionSorted(numArrayList, "counting");
                    PartitionSorted.numArray3PartitionSorted(numArrayList, "counting");
                    PartitionSorted.numArray4PartitionSorted(numArrayList, "counting");
                    PartitionSorted.numArrayHalfSorted(numArrayList, "counting");
                    PartitionSorted.numArray75PercentSorted(numArrayList, "counting");
                    PartitionSorted.numArray100PercentSorted(numArrayList, "counting");
            
                    System.out.println("\n** Sorting LinkedList of Integers **\n");
                    PartitionSorted.numLinked1PartitionSorted(numLinkedList, "counting");
                    PartitionSorted.numLinked2PartitionSorted(numLinkedList, "counting");
                    PartitionSorted.numLinked3PartitionSorted(numLinkedList, "counting");
                    PartitionSorted.numLinked4PartitionSorted(numLinkedList, "counting");
                    PartitionSorted.numLinkedHalfSorted(numLinkedList, "counting");
                    PartitionSorted.numLinked75PercentSorted(numLinkedList, "counting");
            
                    System.out.println("\n** Sorting ArrayList of Strings **\n");
                    PartitionSorted.wordArray1PartitionSorted(wordArrayList, "counting");
                    PartitionSorted.wordArray2PartitionSorted(wordArrayList, "counting");
                    PartitionSorted.wordArray3PartitionSorted(wordArrayList, "counting");
                    PartitionSorted.wordArray4PartitionSorted(wordArrayList, "counting");

                    //Test counting sort with different ranges of value
                    System.out.println("\nSorting with different ranges of value (100, 10000, 1000000, 9999999)");
                    SizeSorting.rangeTestCountingSort(numArrayList, numLinkedList);
                    break;
                case 6:
                    System.out.println("\nSorting with different Size (10k, 50k, 100k, 500k, 1M)");
                    SizeSorting.sortSizeSorting(numArrayList, numLinkedList, "multithreadedcounting");
                    SizeSorting.sortSizeSorting(wordArrayList, "multithreadedcounting");

                    System.out.println("\nSorting without duplicates");
                    SizeSorting.sortIntegerSet(numSet, "multithreadedcounting");
                    SizeSorting.sortStringSet(wordSet, "multithreadedcounting");

                    System.out.println("\nSorting duplicates");
                    SizeSorting.sortDuplicateList(numArrayList, numLinkedList, numSet.size(), "multithreadedcounting");
                    SizeSorting.sortDuplicateList(wordArrayList, wordSet.size(), "multithreadedcounting");

                    System.out.println("\nSorting with fully reverse-ordered list");
                    SizeSorting.sortReverseList(numArrayList, numLinkedList, "multithreadedcounting");
                    SizeSorting.sortReverseList(wordArrayList, "multithreadedcounting");

                    System.out.println("** Sorting ArrayList of Integers **\n");
                    PartitionSorted.numArray1PartitionSorted(numArrayList, "multithreadedcounting");
                    PartitionSorted.numArray2PartitionSorted(numArrayList, "multithreadedcounting");
                    PartitionSorted.numArray3PartitionSorted(numArrayList, "multithreadedcounting");
                    PartitionSorted.numArray4PartitionSorted(numArrayList, "multithreadedcounting");
                    PartitionSorted.numArrayHalfSorted(numArrayList, "multithreadedcounting");
                    PartitionSorted.numArray75PercentSorted(numArrayList, "multithreadedcounting");
                    PartitionSorted.numArray100PercentSorted(numArrayList, "multithreadedcounting");
            
                    System.out.println("\n** Sorting LinkedList of Integers **\n");
                    PartitionSorted.numLinked1PartitionSorted(numLinkedList, "multithreadedcounting");
                    PartitionSorted.numLinked2PartitionSorted(numLinkedList, "multithreadedcounting");
                    PartitionSorted.numLinked3PartitionSorted(numLinkedList, "multithreadedcounting");
                    PartitionSorted.numLinked4PartitionSorted(numLinkedList, "multithreadedcounting");
                    PartitionSorted.numLinkedHalfSorted(numLinkedList, "multithreadedcounting");
                    PartitionSorted.numLinked75PercentSorted(numLinkedList, "multithreadedcounting");
            
                    System.out.println("\n** Sorting ArrayList of Strings **\n");
                    PartitionSorted.wordArray1PartitionSorted(wordArrayList, "multithreadedcounting");
                    PartitionSorted.wordArray2PartitionSorted(wordArrayList, "multithreadedcounting");
                    PartitionSorted.wordArray3PartitionSorted(wordArrayList, "multithreadedcounting");
                    PartitionSorted.wordArray4PartitionSorted(wordArrayList, "multithreadedcounting");

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
