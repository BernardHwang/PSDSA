import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SizeSorting {
    public static void SelectionSortSizeSorting(ArrayList<Integer> numArrayList, LinkedList<Integer> numLinkedList) {
        // Define the list sizes to sort
        int[] sizes = {10000, 50000, 100000, 500000, 1000000};

        // Sort and measure time for each list size
        for (int size : sizes) {
            sortAndPrintTimeInteger(numArrayList, size, "arraylist integer");
            sortAndPrintTimeInteger(numLinkedList, size, "linkedlist integer");
        }
    }

    public static void SelectionSortSizeSorting(ArrayList<String> wordArrayList) {
        // Define the list sizes to sort
        int[] sizes = {10000, 50000, 100000, 500000, 1000000};

        // Sort and measure time for each list size
        for (int size : sizes) {
            sortAndPrintTimeString(wordArrayList, size, "arraylist string");
        }
    }

    // Generic method to sort a new list created from the original list and print elapsed time
    private static void sortAndPrintTimeInteger(List<Integer> list, int size, String listType) {
        List<Integer> newList;

        if (list instanceof ArrayList) {
            // Handle ArrayList
            newList = new ArrayList<>(((ArrayList<Integer>) list).subList(0, Math.min(size, list.size())));
            long start = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(newList);
            long end = System.currentTimeMillis();
            System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
        } else if (list instanceof LinkedList) {
            // Handle LinkedList
            newList = new LinkedList<>(((LinkedList<Integer>) list).subList(0, Math.min(size, list.size())));
            Node nodeList = SortingAlgorithms.assignNode(newList);
            long start = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(nodeList);
            long end = System.currentTimeMillis();
            System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
        } else {
            throw new IllegalArgumentException("Unsupported list type: " + listType);
        }
        
    }

    private static void sortAndPrintTimeString(ArrayList<String> list, int size, String listType) {
        // Handle ArrayList
        ArrayList<String> newList = new ArrayList<>(((ArrayList<String>) list).subList(0, Math.min(size, list.size())));
        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(newList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
    }
}
