
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SizeSorting {
    public static void sortSizeSorting(ArrayList<Integer> numArrayList, LinkedList<Integer> numLinkedList, String sortAlgorithm) {
        
        // Define the list sizes to sort 
        int[] sizes = {10000, 50000, 100000, 500000, 1000000};

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

    // Generic method to sort a new list created from the original list and print elapsed time
    private static void sortAndPrintTimeInteger(List<Integer> list, int size, String listType, String sortAlgorithm) {
        List<Integer> newList;
        String algorithm = sortAlgorithm.toLowerCase();
        long start, end;
        if (list instanceof ArrayList) {
            // Handle ArrayList
            newList = new ArrayList<>(((ArrayList<Integer>) list).subList(0, Math.min(size, list.size())));
           
            start = System.currentTimeMillis();

            if (algorithm.equals("selection")){
                SortingAlgorithms.selectionSort(newList);
            }else if (algorithm.equals("merge")){
                //SortingAlgorithms.mergeSort(newList);
            }else if (algorithm.equals("comb")){
                SortingAlgorithms.combSort(newList);
            }else if (algorithm.equals("counting")){
                //SortingAlgorithms.countingSort(newList);
            }else{
                throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
            }

            end = System.currentTimeMillis();
            System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");

        } else if (list instanceof LinkedList) {
            // Handle LinkedList
            newList = new LinkedList<>(((LinkedList<Integer>) list).subList(0, Math.min(size, list.size())));
            Node nodeList = SortingAlgorithms.assignNode(newList);
            
            start = System.currentTimeMillis();

            if (algorithm.equals("selection")){
                SortingAlgorithms.selectionSort(nodeList);
            }else if (algorithm.equals("merge")){
                //SortingAlgorithms.mergeSort(nodeList);
            }else if (algorithm.equals("comb")){
                SortingAlgorithms.combSort(nodeList);
            }else if (algorithm.equals("counting")){
                //SortingAlgorithms.countingSort(nodeList);
            }else{
                throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
            }

            end = System.currentTimeMillis();
            System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
        } else {
            throw new IllegalArgumentException("Unsupported list type: " + listType);
        }
        
        
    }

    private static void sortAndPrintTimeString(ArrayList<String> list, int size, String listType, String sortAlgorithm) {
        // Handle ArrayList
        ArrayList<String> newList = new ArrayList<>(((ArrayList<String>) list).subList(0, Math.min(size, list.size())));
        String algorithm = sortAlgorithm.toLowerCase();

        long start = System.currentTimeMillis();

        if (algorithm.equals("selection")){
            SortingAlgorithms.selectionSort(newList);
        }else if (algorithm.equals("merge")){
            //SortingAlgorithms.mergeSort(newList);
        }else if (algorithm.equals("comb")){
            SortingAlgorithms.combSort(newList);
        }else if (algorithm.equals("counting")){
            //SortingAlgorithms.countingSort(newList);
        }else{
            throw new IllegalArgumentException("Unsupported algorithm: "+algorithm);
        }

        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time " + size + " " + listType + ": " + (end - start) + " ms");
    }
}

