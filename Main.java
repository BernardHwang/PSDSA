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
            boolean exit1 = false;
            System.out.println("\tChoose Number:");
            System.out.println("\t[1] Demo of 4 Sorting Algorithms");
            System.out.println("\t[2] Selection Sort");
            System.out.println("\t[3] Merge Sort");
            System.out.println("\t[4] Comb Sort");
            System.out.println("\t[5] Counting Sort");
            System.out.println("\t[6] Upgraded Selection Sort");
            System.out.println("\t[0] Bye Bye");
            System.out.print("\nOption: ");
            int option = Integer.parseInt(in.nextLine());
            switch (option) {
                case 1:
                    DemoUsed.demo(wordArrayList, numArrayList, numLinkedList);
                    break;
                case 2:
                    while (!exit1) {
                        boolean exit2 = false;
                        System.out.println("\tChoose Number:");
                        System.out.println("\t[1] Integer ArrayList");
                        System.out.println("\t[2] Integer LinkedList");
                        System.out.println("\t[3] String ArrayList");
                        System.out.println("\t[0] Bye Bye");
                        System.out.print("\nOption: ");
                        int option1 = Integer.parseInt(in.nextLine());
                        switch (option1) {
                            case 1:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (1M - 100k)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingArray(numArrayList, "selection");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortIntegerArraySet(numSet, "selection");
                                            SizeSorting.sortDuplicateArray(numArrayList, numSet.size(), "selection");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseArray(numArrayList, "selection");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray1PartitionSorted(numArrayList, "selection");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray2PartitionSorted(numArrayList, "selection");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray3PartitionSorted(numArrayList, "selection");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray4PartitionSorted(numArrayList, "selection");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArrayHalfSorted(numArrayList, "selection");
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray75PercentSorted(numArrayList, "selection");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray100PercentSorted(numArrayList, "selection");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 2:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (1M - 100k)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingLinked(numLinkedList, "selection");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortIntegerLinkedSet(numSet, "selection");
                                            SizeSorting.sortDuplicateLinked(numLinkedList, numSet.size(), "selection");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseLinked(numLinkedList, "selection");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked1PartitionSorted(numLinkedList, "selection");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked2PartitionSorted(numLinkedList, "selection");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked3PartitionSorted(numLinkedList, "selection");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked4PartitionSorted(numLinkedList, "selection");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinkedHalfSorted(numLinkedList, "selection");
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked75PercentSorted(numLinkedList, "selection");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked100PercentSorted(numLinkedList, "selection");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 3:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (100k - 10k)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingWord(wordArrayList, "selection");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortStringSet(wordSet, "selection");
                                            SizeSorting.sortDuplicateWord(wordArrayList, wordSet.size(), "selection");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseWord(wordArrayList, "selection");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray1PartitionSorted(wordArrayList, "selection");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray2PartitionSorted(wordArrayList, "selection");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray3PartitionSorted(wordArrayList, "selection");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray4PartitionSorted(wordArrayList, "selection");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArrayHalfSorted(wordArrayList, "selection");
                                            
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray75PercentSorted(wordArrayList, "selection");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray100PercentSorted(wordArrayList, "selection");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 0:
                                exit1 = true;
                                break;
                            default:
                                System.out.println("Invalid Input!");
                        }
                    }
                    break;
                case 3:
                    while (!exit1) {
                        boolean exit2 = false;
                        System.out.println("\tChoose Number:");
                        System.out.println("\t[1] Integer ArrayList");
                        System.out.println("\t[2] Integer LinkedList");
                        System.out.println("\t[3] String ArrayList");
                        System.out.println("\t[0] Bye Bye");
                        System.out.print("\nOption: ");
                        int option1 = Integer.parseInt(in.nextLine());
                        switch (option1) {
                            case 1:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (20M - 2M)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingArray(numArrayList, "merge");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortIntegerArraySet(numSet, "merge");
                                            SizeSorting.sortDuplicateArray(numArrayList, numSet.size(), "merge");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseArray(numArrayList, "merge");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray1PartitionSorted(numArrayList, "merge");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray2PartitionSorted(numArrayList, "merge");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray3PartitionSorted(numArrayList, "merge");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray4PartitionSorted(numArrayList, "merge");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArrayHalfSorted(numArrayList, "merge");
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray75PercentSorted(numArrayList, "merge");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray100PercentSorted(numArrayList, "merge");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 2:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (20M - 2M)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingLinked(numLinkedList, "merge");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortIntegerLinkedSet(numSet, "merge");
                                            SizeSorting.sortDuplicateLinked(numLinkedList, numSet.size(), "merge");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseLinked(numLinkedList, "merge");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked1PartitionSorted(numLinkedList, "merge");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked2PartitionSorted(numLinkedList, "merge");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked3PartitionSorted(numLinkedList, "merge");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked4PartitionSorted(numLinkedList, "merge");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinkedHalfSorted(numLinkedList, "merge");
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked75PercentSorted(numLinkedList, "merge");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked100PercentSorted(numLinkedList, "merge");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 3:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (1M - 100k)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingWord(wordArrayList, numFile);
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortStringSet(wordSet, "merge");
                                            SizeSorting.sortDuplicateWord(wordArrayList, wordSet.size(), "merge");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseWord(wordArrayList, "merge");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray1PartitionSorted(wordArrayList, "merge");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray2PartitionSorted(wordArrayList, "merge");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray3PartitionSorted(wordArrayList, "merge");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray4PartitionSorted(wordArrayList, "merge");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArrayHalfSorted(wordArrayList, "merge");
                                            
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray75PercentSorted(wordArrayList, "merge");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray100PercentSorted(wordArrayList, "merge");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 0:
                                exit1 = true;
                                break;
                            default:
                                System.out.println("Invalid Input!");
                        }
                    }
                    break;
                case 4:
                    while (!exit1) {
                        boolean exit2 = false;
                        System.out.println("\tChoose Number:");
                        System.out.println("\t[1] Integer ArrayList");
                        System.out.println("\t[2] Integer LinkedList");
                        System.out.println("\t[3] String ArrayList");
                        System.out.println("\t[0] Bye Bye");
                        System.out.print("\nOption: ");
                        int option1 = Integer.parseInt(in.nextLine());
                        switch (option1) {
                            case 1:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (20M - 2M)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingArray(numArrayList, "comb");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortIntegerArraySet(numSet, "comb");
                                            SizeSorting.sortDuplicateArray(numArrayList, numSet.size(), "comb");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseArray(numArrayList, "comb");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray1PartitionSorted(numArrayList, "comb");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray2PartitionSorted(numArrayList, "comb");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray3PartitionSorted(numArrayList, "comb");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray4PartitionSorted(numArrayList, "comb");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArrayHalfSorted(numArrayList, "comb");
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray75PercentSorted(numArrayList, "comb");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray100PercentSorted(numArrayList, "comb");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 2:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (20M - 2M)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingLinked(numLinkedList, "comb");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortIntegerLinkedSet(numSet, "comb");
                                            SizeSorting.sortDuplicateLinked(numLinkedList, numSet.size(), "comb");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseLinked(numLinkedList, "comb");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked1PartitionSorted(numLinkedList, "comb");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked2PartitionSorted(numLinkedList, "comb");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked3PartitionSorted(numLinkedList, "comb");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked4PartitionSorted(numLinkedList, "comb");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinkedHalfSorted(numLinkedList, "comb");
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked75PercentSorted(numLinkedList, "comb");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked100PercentSorted(numLinkedList, "comb");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 3:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (1M - 100k)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingWord(wordArrayList, "comb");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortStringSet(wordSet, "comb");
                                            SizeSorting.sortDuplicateWord(wordArrayList, wordSet.size(), "comb");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseWord(wordArrayList, "comb");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray1PartitionSorted(wordArrayList, "comb");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray2PartitionSorted(wordArrayList, "comb");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray3PartitionSorted(wordArrayList, "comb");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray4PartitionSorted(wordArrayList, "comb");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArrayHalfSorted(wordArrayList, "comb");
                                            
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray75PercentSorted(wordArrayList, "comb");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray100PercentSorted(wordArrayList, "comb");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 0:
                                exit1 = true;
                                break;
                            default:
                                System.out.println("Invalid Input!");
                        }
                    }
                    break;
                case 5:
                    while (!exit1) {
                        boolean exit2 = false;
                        System.out.println("\tChoose Number:");
                        System.out.println("\t[1] Integer ArrayList");
                        System.out.println("\t[2] Integer LinkedList");
                        System.out.println("\t[3] String ArrayList");
                        System.out.println("\t[0] Bye Bye");
                        System.out.print("\nOption: ");
                        int option1 = Integer.parseInt(in.nextLine());
                        switch (option1) {
                            case 1:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[11] Range Test For Counting Sort");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (20M - 2M)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingArray(numArrayList, "counting");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortIntegerArraySet(numSet, "counting");
                                            SizeSorting.sortDuplicateArray(numArrayList, numSet.size(), "counting");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseArray(numArrayList, "counting");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray1PartitionSorted(numArrayList, "counting");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray2PartitionSorted(numArrayList, "counting");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray3PartitionSorted(numArrayList, "counting");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray4PartitionSorted(numArrayList, "counting");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArrayHalfSorted(numArrayList, "counting");
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray75PercentSorted(numArrayList, "counting");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numArray100PercentSorted(numArrayList, "counting");
                                            break;
                                        case 11:
                                            System.out.println("** Range Test For Counting Sort**\n");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.rangeTestCountingSortArray(numArrayList);
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 2:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[11] Range Test For Counting Sort");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (20M - 2M)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingLinked(numLinkedList, "counting");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortIntegerLinkedSet(numSet, "counting");
                                            SizeSorting.sortDuplicateLinked(numLinkedList, numSet.size(), "counting");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseLinked(numLinkedList, "counting");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked1PartitionSorted(numLinkedList, "counting");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked2PartitionSorted(numLinkedList, "counting");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked3PartitionSorted(numLinkedList, "counting");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked4PartitionSorted(numLinkedList, "counting");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinkedHalfSorted(numLinkedList, "counting");
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked75PercentSorted(numLinkedList, "counting");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.numLinked100PercentSorted(numLinkedList, "counting");
                                            break;
                                        case 11:
                                            System.out.println("** Range Test For Counting Sort**\n");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.rangeTestCountingSortLinked(numLinkedList);
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 3:
                                while (!exit2) {
                                    System.out.println("\tChoose Number:");
                                    System.out.println("\t[1] Different Size");
                                    System.out.println("\t[2] Duplicates and Non-Duplicates");
                                    System.out.println("\t[3] Reverse Order");
                                    System.out.println("\t[4] 1 Partition / 25% Sorted ");
                                    System.out.println("\t[5] 2 Partition Sorted");
                                    System.out.println("\t[6] 3 Partition Sorted");
                                    System.out.println("\t[7] 4 Partition Sorted");
                                    System.out.println("\t[8] 50% Sorted");
                                    System.out.println("\t[9] 75% Sorted");
                                    System.out.println("\t[10] 100% Sorted");
                                    System.out.println("\t[0] Bye Bye");
                                    System.out.print("\nOption: ");
                                    int option2 = Integer.parseInt(in.nextLine());
                                    switch (option2) {
                                        case 1:
                                            System.out.println("\nSorting with different Size (1M - 100k)");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sizeSortingWord(wordArrayList, "counting");
                                            break;
                                        case 2:
                                            System.out.println("\nSorting with Non-duplicates and Dupliacates");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortStringSet(wordSet, "counting");
                                            SizeSorting.sortDuplicateWord(wordArrayList, wordSet.size(), "counting");
                                            break;
                                        case 3:
                                            System.out.println("\nSorting with fully reverse-ordered list");
                                            System.out.println("_____________________________________________________");
                                            SizeSorting.sortReverseWord(wordArrayList, "counting");
                                            break;
                                        case 4:
                                            System.out.println("** Sorting with 1 Partition / 25% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray1PartitionSorted(wordArrayList, "counting");
                                            break;
                                        case 5:
                                            System.out.println("** Sorting with 2 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray2PartitionSorted(wordArrayList, "counting");
                                            break;
                                        case 6:
                                            System.out.println("** Sorting with 3 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray3PartitionSorted(wordArrayList, "counting");
                                            break;
                                        case 7:
                                            System.out.println("** Sorting with 4 Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray4PartitionSorted(wordArrayList, "counting");
                                            break;
                                        case 8:
                                            System.out.println("** Sorting with 50% Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArrayHalfSorted(wordArrayList, "counting");
                                            
                                            break;
                                        case 9:
                                            System.out.println("** Sorting with 75% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray75PercentSorted(wordArrayList, "counting");
                                            break;
                                        case 10:
                                            System.out.println("** Sorting with 100% Partition Sorted **\n");
                                            System.out.println("_____________________________________________________");
                                            PartitionSorted.wordArray100PercentSorted(wordArrayList, "counting");
                                            break;
                                        case 0:
                                            exit2 = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");     
                                    }
                                }
                                break;
                            case 0:
                                exit1 = true;
                                break;
                            default:
                                System.out.println("Invalid Input!");
                        }
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Input!");
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
