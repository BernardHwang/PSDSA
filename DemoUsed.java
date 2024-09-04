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
            if (list.get(0) instanceof Integer){
                SortingAlgorithms.selectionSortNumber((List<Integer>)list1);
            } 
            else if (list.get(0) instanceof String){
                SortingAlgorithms.selectionSortWords((List<String>)list1);
            }
            
            System.out.println("Sublist after selection sorting: \n" + list1 + "\n");

            // Test merge sort
            if (list.get(0) instanceof Integer){
                SortingAlgorithms.mergeSort((List<Integer>)list2);
            } 
            else if (list.get(0) instanceof String){
                SortingAlgorithms.mergeSortWords((List<String>)list2);
            }
            System.out.println("Sublist after merge sorting: \n" + list2 + "\n");
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
                SortingAlgorithms.countingSort2((ArrayList<Integer>)list4);
            }
            else{
                SortingAlgorithms.countingSortWords((ArrayList<String>)list4);
            }
            System.out.println("Sublist after counting sorting: \n" + list4 + "\n");

        } else if (list instanceof LinkedList) {
            Node list1 = SortingAlgorithms.assignNode((LinkedList<Integer>)list);
            Node list2 = SortingAlgorithms.assignNode((LinkedList<Integer>)list);
            LinkedList<Integer> list3 = new LinkedList<>((List<Integer>)list);
            LinkedList<Integer> list4 = new LinkedList<>((List<Integer>)list);
            //Node list4 = SortingAlgorithms.assignNode((LinkedList<Integer>)list);

            System.out.println("Sublist before sorting: \n" + list + "\n");

            // Test Selection sort
            Node sortedList1 = SortingAlgorithms.selectionSortNode(list1);
            System.out.println("Sublist after selection sorting: ");
            SortingAlgorithms.printList(sortedList1);
            System.out.println();

            // Test Merge sort
            Node sortedList2 = SortingAlgorithms.mergeSort(list2);
            System.out.println("Sublist after merge sorting: ");
            SortingAlgorithms.printList(sortedList2);
            System.out.println();
            
            // Test Comb sort
            SortingAlgorithms.combSortNumber(list3);
            System.out.println("Sublist after comb sorting: \n" + list3 + "\n");

            // Test Counting sort
            SortingAlgorithms.countingSort(list4);
            System.out.println("Sublist after count sorting: \n" + list4 + "\n");

        }
    }
}
