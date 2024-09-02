import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DemoUsed {
    public static void demo(ArrayList<String> wordArrayList, ArrayList<Integer> numArrayList, LinkedList<Integer> numLinkedList) {
        

        // Test sorting algorithms on number ArrayList
        System.out.println("Testing on ArrayList<Integer>:");
        ArrayList<Integer> numSubArrayList = new ArrayList<>(numArrayList.subList(0, Math.min(20, numArrayList.size())));
        testSortingAlgorithms(numSubArrayList);

        // Test sorting algorithms on number LinkedList
        System.out.println("Testing on LinkedList<Integer>:");
        LinkedList<Integer> numSubLinkedList = new LinkedList<>(numLinkedList.subList(0, Math.min(20, numLinkedList.size())));
        testSortingAlgorithms(numSubLinkedList);

        // Test sorting algorithms on word ArrayList
        System.out.println("Testing on ArrayList<String>:");
        ArrayList<String> wordSubArrayList = new ArrayList<>(wordArrayList.subList(0, Math.min(20, wordArrayList.size())));
        testSortingAlgorithms(wordSubArrayList);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void testSortingAlgorithms(List<T> list) {
        if (list instanceof ArrayList) {
            List<T> list1 = new ArrayList<>(list);
            List<T> list2 = new ArrayList<>(list);
            List<T> list3 = new ArrayList<>(list);
            List<T> list4 = new ArrayList<>(list);

            System.out.println("Sublist before sorting: \n" + list + "\n");

            // Test selection sort
            SortingAlgorithms.selectionSort(list1);
            System.out.println("Sublist after selection sorting: \n" + list1 + "\n");

            // Test merge sort
            //SortingAlgorithms.mergeSort(list2);
            //System.out.println("Sublist after merge sorting: \n" + list2 + "\n");
            
            // Test comb sort
            if (list.get(0) instanceof Integer){
                SortingAlgorithms.combSortNumber((List<Integer>)list3);
            } 
            else if (list.get(0) instanceof String){
                SortingAlgorithms.combSortWords((List<String>)list3);
            }
            System.out.println("Sublist after comb sorting: \n" + list3 + "\n");

            // Test Counting sort
            if (((ArrayList<?>) list4).get(0) instanceof Integer) {
                SortingAlgorithms.countingSort((ArrayList<Integer>)list4);
            }
            else{
                SortingAlgorithms.countingSortWords((ArrayList<String>)list4);
            }
            System.out.println("Sublist after counting sorting: \n" + list4 + "\n");

        } else if (list instanceof LinkedList) {
            Node list1 = SortingAlgorithms.assignNode((LinkedList<Integer>)list);
            Node list2 = SortingAlgorithms.assignNode((LinkedList<Integer>)list);
            LinkedList<Integer> list3 = new LinkedList<>((List<Integer>)list);
            Node list4 = SortingAlgorithms.assignNode((LinkedList<Integer>)list);

            System.out.println("Sublist before sorting: \n" + list + "\n");

            // Test Selection sort
            Node sortedList1 = SortingAlgorithms.selectionSort(list1);
            System.out.println("Sublist after selection sorting: ");
            SortingAlgorithms.printList(sortedList1);
            System.out.println();

            // Test Merge sort
            //SortingAlgorithms.mergeSort(list2);
            //System.out.println("Sublist after merge sorting: \n" + list2 + "\n");
            
            // Test Comb sort
            SortingAlgorithms.combSortNumber(list3);
            System.out.println("Sublist after comb sorting: \n" + list3 + "\n");

            // Test Counting sort
            Node sortedList4 = SortingAlgorithms.countingSort(list4);
            System.out.println("Sublist after counting sorting: ");
            SortingAlgorithms.printList(sortedList4);
            System.out.println();

        }
    }
}
