
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Set;

public class SizeSorting {
    public static void sortSizeSorting(ArrayList<Integer> numArrayList, LinkedList<Integer> numLinkedList, String sortAlgorithm) {
        
        // Define the list sizes to sort 
        int[] sizes = {10000, 50000, 100000, 500000, 1000000, 10000000};

        // Sort and measure time for each list size
        for (int size : sizes) {
            sortAndPrintTimeInteger(numArrayList, size, "arraylist integer", sortAlgorithm);
            sortAndPrintTimeInteger(numLinkedList, size, "linkedlist integer", sortAlgorithm);
        }
        
    }

    public static void sortSizeSorting(ArrayList<String> wordArrayList, String sortAlgorithm) {
        
        // Define the list sizes to sort
        int[] sizes = {10000, 50000, 100000, 500000, 1000000};

        // Sort and measure time for each list size
        for (int size : sizes) {
            sortAndPrintTimeString(wordArrayList, size, "arraylist string", sortAlgorithm);
        }
    }

    // Sort duplicate integer arraylist and linkedlist
    public static void sortDuplicateList(ArrayList<Integer> numArrayList, LinkedList<Integer> numLinkedList, int size, String sortAlgorithm){
        sortAndPrintTimeInteger(numArrayList, size, "arraylist integer", sortAlgorithm);
        sortAndPrintTimeInteger(numLinkedList, size, "linkedlist integer", sortAlgorithm);
    }

    // Sort set
    public static void sortIntegerSet(Set<Integer> numSet, String sortAlgorithm) {
        // Convert the set to a list for sorting
        ArrayList<Integer> numList = new ArrayList<>(numSet);
        sortAndPrintTimeInteger(numList, numList.size(), "set integer", sortAlgorithm);
    }

    // Sort duplicate string arraylist
    public static void sortDuplicateList(ArrayList<String> wordArrayList, int size, String sortAlgorithm){
        sortAndPrintTimeString(wordArrayList, size, "arraylist string", sortAlgorithm);
    }

    public static void sortStringSet(Set<String> wordSet, String sortAlgorithm) {
        // Convert the set to a list for sorting
        ArrayList<String> wordList = new ArrayList<>(wordSet);
        sortAndPrintTimeString(wordList, wordList.size(), "set string", sortAlgorithm);
    }

    // Reverse the entire list
    public static void sortReverseList(ArrayList<Integer> numArrayList, LinkedList<Integer> numLinkedList, String sortAlgorithm){
        Collections.reverse(numArrayList);
        sortAndPrintTimeInteger(numArrayList, numArrayList.size(), "arraylist integer", sortAlgorithm);

        Collections.reverse(numLinkedList);
        sortAndPrintTimeInteger(numLinkedList, numLinkedList.size(), "linkedlist integer", sortAlgorithm);
    }

    public static void sortReverseList(ArrayList<String> wordArrayList, String sortAlgorithm){
        Collections.reverse(wordArrayList);
        sortAndPrintTimeString(wordArrayList, wordArrayList.size(), "arraylist string", sortAlgorithm);
    }

    // test Counting Sort on a list with different ranges of value
    public static void rangeTestCountingSort(ArrayList<Integer> numArrayList, LinkedList<Integer> numLinkedList){
        int [] ranges = {100, 10000, 1000000, 9999999};

        for (int range: ranges){
            List<Integer>numSubArrayList = filterNumbersByRange(numArrayList, range);            
            sortAndPrintTimeInteger(numSubArrayList, numSubArrayList.size(), "arraylist integer", "counting");
            List<Integer>numSubLinkedList = filterNumbersByRange(numLinkedList, range);
            sortAndPrintTimeInteger(numSubLinkedList, numSubLinkedList.size(), "linkedlist integer", "counting");
        }
    }

    // Extract subarrays with values within different ranges
    private static List<Integer> filterNumbersByRange(List<Integer> numList, int maxRange){
        List<Integer> filteredNumbers;
        if (numList instanceof LinkedList){
            filteredNumbers = new LinkedList<>();
        }
        else{
            filteredNumbers = new ArrayList<>();
        }
        
        for (int number: numList){
            if (number <= maxRange){
                filteredNumbers.add(number);
            }
        }
        return filteredNumbers;
    }

    // Method to sort a new list created from the original list for Number and print elapsed time
    private static void sortAndPrintTimeInteger(List<Integer> list, int size, String listType, String sortAlgorithm) {
        List<Integer> newList;
        String algorithm = sortAlgorithm.toLowerCase();
        long start, end;
        if (list instanceof ArrayList) {
            // Handle ArrayList
            newList = new ArrayList<>(((ArrayList<Integer>) list).subList(0, Math.min(size, list.size())));
            //start = System.currentTimeMillis();
            start = System.nanoTime();

            if (algorithm.equals("selection")){
                SortingAlgorithms.selectionSort(newList);
            }else if (algorithm.equals("merge")){
                //SortingAlgorithms.mergeSort(newList);
            }else if (algorithm.equals("comb")){
                SortingAlgorithms.combSort(newList);
            }else if (algorithm.equals("counting")){
                SortingAlgorithms.countingSort(newList);
            }else{
                throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
            }

            //end = System.currentTimeMillis();
            end = System.nanoTime();
            System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");

        } else if (list instanceof LinkedList) {
            // Handle LinkedList
            newList = new LinkedList<>(((LinkedList<Integer>) list).subList(0, Math.min(size, list.size())));
            Node nodeList = SortingAlgorithms.assignNode(newList);
            
            //start = System.currentTimeMillis();
            start = System.nanoTime();

            if (algorithm.equals("selection")){
                SortingAlgorithms.selectionSort(nodeList);
            }else if (algorithm.equals("merge")){
                //SortingAlgorithms.mergeSort(nodeList);
            }else if (algorithm.equals("comb")){
                SortingAlgorithms.combSort(nodeList);
            }else if (algorithm.equals("counting")){
                SortingAlgorithms.countingSort(nodeList);
            }else{
                throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
            }

            //end = System.currentTimeMillis();
            end = System.nanoTime();
            System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
        } else {
            throw new IllegalArgumentException("Unsupported list type: " + listType);
        }
    }

    // Method to sort a new list created from the original list for Words and print elapsed time
    private static void sortAndPrintTimeString(ArrayList<String> list, int size, String listType, String sortAlgorithm) {
        // Handle ArrayList
        ArrayList<String> newList = new ArrayList<>(((ArrayList<String>) list).subList(0, Math.min(size, list.size())));
        String algorithm = sortAlgorithm.toLowerCase();

        //long start = System.currentTimeMillis();
        long start = System.nanoTime();

        if (algorithm.equals("selection")){
            SortingAlgorithms.selectionSort(newList);
        }else if (algorithm.equals("merge")){
            //SortingAlgorithms.mergeSort(newList);
        }else if (algorithm.equals("comb")){
            SortingAlgorithms.combSort(newList);
        }else if (algorithm.equals("counting")){
            SortingAlgorithms.countingSortWords(newList);
        }else{
            throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
        }

        //long end = System.currentTimeMillis();
        long end = System.nanoTime();

        System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
    }
}

