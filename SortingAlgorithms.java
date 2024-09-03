import java.util.*;

class Node {
    int data;
    Node next;

    public  Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortingAlgorithms {
    //Assign the LinkedList elemenent to Node
    public static Node assignNode(List<Integer> list) {
        Node head = null;
        Node tail = null;
    
        for (Integer data : list) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Print element in Node after sorted
    public static void printList(Node head) {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null)
                System.out.print(", ");
            current = current.next;
        }
        System.out.print("]\n");
    }

    // Optimized for ArrayList
    public static void selectionSortNumber(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap the elements
            if (minIndex != i) {
                int temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }

    public static void selectionSortWord(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the elements
            if (minIndex != i) {
                String temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }

    // Optimized for LinkedList
    public static Node selectionSortNode(Node head) {
        Node temp = head; 
  
        // Traverse the List 
        while (temp != null) { 
            Node min = temp; 
            Node r = temp.next; 
    
            // Traverse the unsorted sublist 
            while (r != null) { 
                if (min.data > r.data) 
                    min = r; 
    
                r = r.next; 
            } 
    
            // Swap Data 
            int x = temp.data; 
            temp.data = min.data; 
            min.data = x; 
            temp = temp.next; 
        } 
        return head;
    }

    public static void mergeSort(List<Integer> list) {
        int n = list.size();
        // Use a single auxiliary array to avoid multiple allocations
        int[] aux = new int[n];
        mergeSortHelper(list, aux, 0, n - 1);
    }

    private static void mergeSortHelper(List<Integer> list, int[] aux, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Recursively sort both halves
        mergeSortHelper(list, aux, left, mid);
        mergeSortHelper(list, aux, mid + 1, right);

        // Merge the sorted halves
        merge(list, aux, left, mid, right);
    }

    private static void merge(List<Integer> list, int[] aux, int left, int mid, int right) {
        // Copy the data to the auxiliary array
        for (int i = left; i <= right; i++) {
            aux[i] = list.get(i);
        }

        int i = left, j = mid + 1, k = left;

        // Merge back into the list
        while (i <= mid && j <= right) {
            if (aux[i] <= aux[j]) {
                list.set(k++, aux[i++]);
            } else {
                list.set(k++, aux[j++]);
            }
        }

        // Copy any remaining elements from the left half
        while (i <= mid) {
            list.set(k++, aux[i++]);
        }
    }
    
    public static Node mergeSort(Node head) {
        // Base case: if head is null or there is only one element in the list
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Divide the list into two halves
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        // Split the list into two halves
        middle.next = null;

        // Step 2: Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // Step 3: Merge the sorted halves
        Node sortedList = merge(left, right);
        return sortedList;
    }

    public static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        // Move fast by two and slow by one
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node left, Node right) {
        Node dummyNode = new Node(0);
        Node tail = dummyNode;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // If left has remaining elements
        if (left != null) {
            tail.next = left;
        }

        // If right has remaining elements
        if (right != null) {
            tail.next = right;
        }

        return dummyNode.next;
    }

    public static void mergeSortWords(List<String> list) {
        int n = list.size();
        // Use a single auxiliary array to avoid multiple allocations
        String[] aux = new String[n];
        mergeSortHelper(list, aux, 0, n - 1);
    }

    private static void mergeSortHelper(List<String> list, String[] aux, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Recursively sort both halves
        mergeSortHelper(list, aux, left, mid);
        mergeSortHelper(list, aux, mid + 1, right);

        // Merge the sorted halves
        merge(list, aux, left, mid, right);
    }

    private static void merge(List<String> list, String[] aux, int left, int mid, int right) {
        // Copy the data to the auxiliary array
        for (int i = left; i <= right; i++) {
            aux[i] = list.get(i);
        }

        int i = left, j = mid + 1, k = left;

        // Merge back into the list
        while (i <= mid && j <= right) {
            if (aux[i].compareTo(aux[j]) <= 0) {  // Lexicographical comparison of strings
                list.set(k++, aux[i++]);
            } else {
                list.set(k++, aux[j++]);
            }
        }

        // Copy any remaining elements from the left half
        while (i <= mid) {
            list.set(k++, aux[i++]);
        }
    }
    
    public static void combSortWords(List<String> list) {
        int n = list.size();
        int gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            // Calculate next gap value
            gap = Math.max(1, (gap*10)/13);

            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false;

            // Compare all elements with the current gap
            for (int i = 0; i < n - gap; i++) {
                if (list.get(i).compareTo(list.get(i + gap)) > 0) {
                    // Swap the elements
                    String temp = list.get(i);
                    list.set(i, list.get(i + gap));
                    list.set(i + gap, temp);

                    // Set swapped to true to indicate that swapping happened
                    swapped = true;
                }
            }
        }
    }

    public static void combSortNumber(List<Integer> list) {
        int n = list.size();
        int gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            // Calculate next gap value
            gap = Math.max(1, (gap*10)/13);

            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false;

            // Compare all elements with the current gap
            for (int i = 0; i < n - gap; i++) {
                if (list.get(i) > list.get(i+gap)){
                    Integer temp = list.get(i);
                    list.set(i, list.get(i + gap));
                    list.set(i + gap, temp);
                    swapped=true;
                }
            }
        }
    }

    // Comb sort for Linked List
    public static void combSortNumber(LinkedList<Integer> list) {
        int gap = list.size();
        boolean swapped = true;
    
        while (gap > 1 || swapped) {  // Corrected the gap condition to avoid infinite loop
            gap = Math.max(1, (gap * 10) / 13);
            swapped = false;
    
            ListIterator<Integer> iter1 = list.listIterator();
            ListIterator<Integer> iter2 = list.listIterator(gap);
    
            while (iter2.hasNext()) {
                Integer val1 = iter1.next();
                Integer val2 = iter2.next();
    
                if (val1 > val2) {
                    iter1.set(val2);
                    iter2.set(val1);
                    swapped = true;
                }
    
                // Ensure iter1 and iter2 advance correctly
                if (!iter1.hasNext() || !iter2.hasNext()) {
                    break;
                }
            }
        }
    }
    
    //testing for counting sort arraylist
    public static void countingSort2(List<Integer> list) {
        if (list == null || list.size() <= 1) return;
    
        // Find the maximum element to determine the size of the counting array
        int max = Collections.max(list);
    
        // Create a counting array with a size of max + 1
        int[] countArray = new int[max + 1];
    
        // Count each element in the original list
        for (int num : list) {
            countArray[num]++;
        }
    
        // Reconstruct the original list in a single pass
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                list.set(index++, i);
                countArray[i]--;
            }
        }
    }
    
    
    public static void countingSort(List<Integer> list) {
        if (list == null || list.size() <= 1) return;
    
        // Find the maximum element to determine the size of the counting array
        int max = Collections.max(list);
    
        // Create a counting array with a size of max + 1 (to include the max value)
        int[] countArray = new int[max + 1];
    
        // Count each element in the original list
        for (int num : list) {
            countArray[num]++;
        }
    
        // Overwrite the original list with sorted elements
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                list.set(index++, i);
                countArray[i]--;
            }
        }
    }    

    public static Node countingSort(Node head) {
        if (head == null || head.next == null) return head;
    
        // Find the maximum element to determine the size of the counting array
        int max = findMax(head);
    
        // Create a counting array with a size of max + 1
        int[] countArray = new int[max + 1];
    
        // Count each element in the linked list
        Node current = head;
        while (current != null) {
            countArray[current.data]++;
            current = current.next;
        }
    
        // Overwrite the original linked list with sorted elements
        current = head;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                current.data = i;
                current = current.next;
                countArray[i]--;
            }
        }
    
        return head;
    }
    
    private static int findMax(Node head) {
        int max = Integer.MIN_VALUE;
        Node current = head;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    // Method to sort the words using counting sort on each character
    public static void countingSortWords(ArrayList<String> words) {

        // Find the maximum length of the words in the list
        int maxLen = words.stream().mapToInt(String::length).max().orElse(0);

        // Sort each character position starting from the last character
        for (int index = maxLen - 1; index >= 0; index--) {
            countingSortChar(words, index);
        }
    }

    // Method to perform counting sort on the words based on a specific character index
    private static void countingSortChar(ArrayList<String> words, int index) {
        // Create a count array for characters A-Z, a-z, and '-'
        int[] count = new int[53]; // 26 uppercase + lowercase letters + 1 for space

        // Count occurrences of each character at the given index
        for (String word : words) {
            char charAtIdx = index < word.length() ? word.charAt(index) : ' ';
            count[charToIndex(charAtIdx)]++;
        }

        // Update count array to positions
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Create a temporary list to store sorted words
        ArrayList<String> temp = new ArrayList<>(Collections.nCopies(words.size(), ""));

        // Build the temporary list
        for (int i = words.size() - 1; i >= 0; i--) {
            char charAtIdx = index < words.get(i).length() ? words.get(i).charAt(index) : ' ';
            temp.set(--count[charToIndex(charAtIdx)], words.get(i));
        }

        // Copy the sorted words back to the original list
        for (int i = 0; i < words.size(); i++) {
            words.set(i, temp.get(i));
        }
    }

    // Helper method to convert a character to an index for the count array
    private static int charToIndex(char c) {
        if (c == ' ') {
            return 0; // blank space
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 1; // uppercase letters
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 27; // lowercase letters
        } else {
            throw new IllegalArgumentException("Unsupported character: " + c);
        }
    }

}
