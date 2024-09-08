import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Set;

public class SizeSorting {
    private static int[] smallIntegerSizes = {1000000, 900000, 800000, 700000, 600000, 500000, 400000, 300000, 200000, 100000};
    private static int[] bigIntegerSizes = {20000000, 18000000, 16000000, 14000000, 12000000, 10000000, 8000000, 6000000, 4000000, 2000000};
    private static int[] smallStringSizes = {100000, 90000, 80000, 70000, 60000, 50000, 40000, 30000, 20000, 10000};
    private static int[] bigStringSizes = {1000000, 900000, 800000, 700000, 600000, 500000, 400000, 300000, 200000, 100000};

    public static void sizeSortingArray(ArrayList<Integer> numArrayList, String sortAlgorithm) {
        // Sort and measure time for each list size
        if (sortAlgorithm.equals("selection")){
            for (int size : smallIntegerSizes) {
                sortAndPrintTimeInteger(numArrayList, size, "arraylist integer", sortAlgorithm);
            }
        } else {
            for (int size : bigIntegerSizes) {
                sortAndPrintTimeInteger(numArrayList, size, "arraylist integer", sortAlgorithm);
            }
        }
    }

    public static void sizeSortingLinked(LinkedList<Integer> numLinkedList, String sortAlgorithm) {
        sortAndPrintTimeIntegerSlow(numLinkedList, 100000, "linkedlist (build in) integer", sortAlgorithm);
        if (sortAlgorithm.equals("selection")){
            for (int size : smallIntegerSizes) {
                sortAndPrintTimeInteger(numLinkedList, size, "linkedlist integer", sortAlgorithm);
            }
        } else {
            for (int size : bigIntegerSizes) {
                sortAndPrintTimeInteger(numLinkedList, size, "linkedlist integer", sortAlgorithm);
            }
        } 
    }

    public static void sizeSortingWord(ArrayList<String> wordArrayList, String sortAlgorithm) {
        if(sortAlgorithm.equals("selection")){
            for (int size : smallStringSizes) {
                sortAndPrintTimeString(wordArrayList, size, "arraylist string", sortAlgorithm);
            }
        } else{
            for (int size : bigStringSizes) {
                sortAndPrintTimeString(wordArrayList, size, "arraylist string", sortAlgorithm);
            }
        }
    }

    // Sort duplicate integer arraylist and linkedlist
    public static void sortDuplicateArray(ArrayList<Integer> numArrayList, int size, String sortAlgorithm) {
        if (sortAlgorithm.equals("selection")){
            int newSize= 100000;
            sortAndPrintTimeInteger(numArrayList, newSize, "arraylist integer", sortAlgorithm);
        }
        else{
            sortAndPrintTimeInteger(numArrayList, size, "arraylist integer", sortAlgorithm);
        }
    }

    public static void sortDuplicateLinked(LinkedList<Integer> numLinkedList, int size, String sortAlgorithm) {
        if (sortAlgorithm.equals("selection")){
            int newSize= 100000;
            sortAndPrintTimeInteger(numLinkedList, newSize, "linkedlist integer", sortAlgorithm);
        }
        else{
            sortAndPrintTimeInteger(numLinkedList, size, "linkedlist integer", sortAlgorithm);
        }
    }

    public static void sortDuplicateWord(ArrayList<String> wordArrayList, int size, String sortAlgorithm){
        sortAndPrintTimeString(wordArrayList, size, "arraylist string", sortAlgorithm);
    }

    // Sort set
    public static void sortIntegerArraySet(Set<Integer> numSet, String sortAlgorithm) {
        // Convert the set to a list for sorting
        ArrayList<Integer> numArrayList = new ArrayList<>(numSet);
        if(sortAlgorithm.equals("selection") ){
            int newSize= 100000;
            sortAndPrintTimeInteger(numArrayList, newSize, "arraylist integer", sortAlgorithm);
        }
        else{
            sortAndPrintTimeInteger(numArrayList, numArrayList.size(), "arraylist integer", sortAlgorithm);
        }
    } 

    public static void sortIntegerLinkedSet(Set<Integer> numSet, String sortAlgorithm) {
        // Convert the set to a list for sorting
        LinkedList<Integer> numLinkedList = new LinkedList<>(numSet);
        if(sortAlgorithm.equals("selection") ){
            int newSize= 100000;
            sortAndPrintTimeInteger(numLinkedList, newSize, "linkedlist integer", sortAlgorithm);
        }
        else{
            sortAndPrintTimeInteger(numLinkedList, numLinkedList.size(), "linkedlist integer", sortAlgorithm);
        }
    } 

    public static void sortStringSet(Set<String> wordSet, String sortAlgorithm) {
        // Convert the set to a list for sorting
        ArrayList<String> wordList = new ArrayList<>(wordSet);
        sortAndPrintTimeString(wordList, wordList.size(), "set string", sortAlgorithm);
    }

    // Reverse the entire list
    public static void sortReverseArray(ArrayList<Integer> numArrayList, String sortAlgorithm){
        Collections.sort(numArrayList, Collections.reverseOrder());
        if (sortAlgorithm.equals("selection") ){
            int newSize= 100000;
            sortAndPrintTimeInteger(numArrayList, newSize, "arraylist integer", sortAlgorithm);
        }
        else{
            sortAndPrintTimeInteger(numArrayList, numArrayList.size(), "arraylist integer", sortAlgorithm);
        }
    }

    public static void sortReverseLinked(LinkedList<Integer> numLinkedList, String sortAlgorithm){
        Collections.sort(numLinkedList, Collections.reverseOrder());
        if (sortAlgorithm.equals("selection") ){
            int newSize= 100000;
            sortAndPrintTimeInteger(numLinkedList, newSize, "linkedlist integer", sortAlgorithm);
        }
        else{
            sortAndPrintTimeInteger(numLinkedList, numLinkedList.size(), "linkedlist integer", sortAlgorithm);
        }
    }

    public static void sortReverseWord(ArrayList<String> wordArrayList, String sortAlgorithm){
        Collections.sort(wordArrayList, Collections.reverseOrder());
        if (sortAlgorithm.equals("selection") ){
            int newSize= 100000;
            sortAndPrintTimeString(wordArrayList, newSize, "arraylist string", sortAlgorithm);
        }
        else{
            sortAndPrintTimeString(wordArrayList, wordArrayList.size(), "arraylist string", sortAlgorithm);
        }
    }

    // test Counting Sort on a list with different ranges of value
    public static void rangeTestCountingSortArray(ArrayList<Integer> numArrayList){
        int [] ranges = {100, 10000, 1000000, 9999999};

        for (int range: ranges){
            List<Integer>numSubArrayList = filterNumbersByRange(numArrayList, range);            
            sortAndPrintTimeInteger(numSubArrayList, numSubArrayList.size(), "arraylist integer", "counting");
        }
    }

    public static void rangeTestCountingSortLinked(LinkedList<Integer> numLinkedList){
        int [] ranges = {100, 10000, 1000000, 9999999};

        for (int range: ranges){
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
            start = System.currentTimeMillis();

            if (algorithm.equals("selection")){
                SortingAlgorithms.selectionSortNumber(newList);
            }else if (algorithm.equals("merge")){
                SortingAlgorithms.mergeSort(newList);
            }else if (algorithm.equals("comb")){
                SortingAlgorithms.combSortNumber(newList);
            }else if (algorithm.equals("counting")){
                SortingAlgorithms.countingSort(newList);
            }else{
                throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
            }

            //end = System.currentTimeMillis();
            end = System.currentTimeMillis();
            System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");

        } else if (list instanceof LinkedList) {
            // Handle LinkedList
            newList = new LinkedList<>(((LinkedList<Integer>) list).subList(0, Math.min(size, list.size())));
            Node nodeList = SortingAlgorithms.assignNode(newList);
            
            //start = System.currentTimeMillis();
            start = System.currentTimeMillis();

            if (algorithm.equals("selection")){
                SortingAlgorithms.selectionSortNode(nodeList);
            }else if (algorithm.equals("merge")){
                SortingAlgorithms.mergeSort(nodeList);
            }else if (algorithm.equals("comb")){
                SortingAlgorithms.combSortNumber((LinkedList<Integer>) newList);
            }else if (algorithm.equals("counting")){
                SortingAlgorithms.countingSort((LinkedList<Integer>) newList); 
            }else{
                throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
            }

            //end = System.currentTimeMillis();
            end = System.currentTimeMillis();
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
        long start = System.currentTimeMillis();

        if (algorithm.equals("selection")){
            SortingAlgorithms.selectionSortWords(newList);
        }else if (algorithm.equals("merge")){
            SortingAlgorithms.mergeSortWords(newList);
        }else if (algorithm.equals("comb")){
            SortingAlgorithms.combSortWords(newList);
        }else if (algorithm.equals("counting")){
            SortingAlgorithms.countingSortWords(newList);
        }else{
            throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
        }

        //long end = System.currentTimeMillis();
        long end = System.currentTimeMillis();

        System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
    }
    
    private static void sortAndPrintTimeIntegerSlow(List<Integer> list, int size, String listType, String sortAlgorithm) {
        long start, end;
        LinkedList<Integer> newList = new LinkedList<>(((LinkedList<Integer>) list).subList(0, Math.min(size, list.size())));
        //start = System.currentTimeMillis();
        start = System.currentTimeMillis();
        SortingAlgorithms.mergeSortSlow(newList);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
    }
}
