import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

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

    public static void selectionSortWords(List<String> list) {
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
    
    //Counting sort for ArrayList
    public static void countingSort(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
    
        int max = Collections.max(list);
        int min = Collections.min(list);
        int range = max - min + 1;
    
        int[] count = new int[range];
        int[] output = new int[list.size()];
    
        // Count occurrences of each number
        for (int number : list) {
            count[number - min]++;
        }
    
        // Modify count array to hold actual positions
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    
        // Build the output array using a for-each loop for better cache performance
        for (int i = list.size() - 1; i >= 0; i--) {
            int current = list.get(i);
            output[count[current - min] - 1] = current;
            count[current - min]--;
        }
    
        // Copy the output array to list
        for (int i = 0; i < list.size(); i++) {
            list.set(i, output[i]);
        }
    }    

    //Counting sort for LinkedList
    public static void countingSort(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return;
        }
    
        int max = Collections.max(list);
        int min = Collections.min(list);
        int range = max - min + 1;
    
        int[] count = new int[range];
        int[] output = new int[list.size()];
    
        // Store count of each number
        for (int number : list) {
            count[number - min]++;
        }
    
        // Change count[i] so that it contains the actual position of this number in the output array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    
        // Build the output array
        ListIterator<Integer> iter = list.listIterator(list.size());
        while (iter.hasPrevious()) {
            int val = iter.previous();
            output[count[val - min] - 1] = val;
            count[val - min]--;
        }
    
        // Copy the output array to the list, so that list now contains sorted numbers
        iter = list.listIterator();
        for (int num : output) {
            iter.next();
            iter.set(num);
        }
    }

    // Counting sort for Words
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
    
    //Multithreaded Counting Sort for ArrayList
    public static void multithreadedcountingSort(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }

        int max = Collections.max(list);
        int min = Collections.min(list);
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[list.size()];

        // Create a ForkJoinPool for parallel processing
        ForkJoinPool pool = new ForkJoinPool();

        // Parallel Count
        pool.submit(() -> list.parallelStream().forEach(number -> {
            synchronized (count) {
                count[number - min]++;
            }
        })).join();

        // Modify count array to hold actual positions
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Parallel Build Output Array
        pool.submit(() -> {
            IntStream.range(0, list.size()).parallel().forEach(i -> {
                int current = list.get(i);
                synchronized (count) {
                    output[--count[current - min]] = current;
                }
            });
        }).join();

        // Copy the output array to the list
        for (int i = 0; i < list.size(); i++) {
            list.set(i, output[i]);
        }

        pool.shutdown();
    }

    //Multithreaded Counting Sort for LinkedList
    public static void multithreadedcountingSort(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return;
        }

        int max = Collections.max(list);
        int min = Collections.min(list);
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[list.size()];

        // Create a ForkJoinPool for parallel processing
        ForkJoinPool pool = new ForkJoinPool();

        // Parallel Count
        pool.submit(() -> list.parallelStream().forEach(number -> {
            synchronized (count) {
                count[number - min]++;
            }
        })).join();

        // Modify count array to hold actual positions
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Parallel Build Output Array
        pool.submit(() -> {
            ListIterator<Integer> iter = list.listIterator(list.size());
            while (iter.hasPrevious()) {
                int val = iter.previous();
                synchronized (count) {
                    output[--count[val - min]] = val;
                }
            }
        }).join();

        // Copy the output array to the list
        ListIterator<Integer> iter = list.listIterator();
        for (int num : output) {
            iter.next();
            iter.set(num);
        }

        pool.shutdown();
    }

    //Multithreaded Counting sort for Words
    public static void multithreadedcountingSortWords(ArrayList<String> words) {
        if (words.isEmpty()) {
            return;
        }

        // Find the maximum length of the words in the list
        int maxLen = words.stream().mapToInt(String::length).max().orElse(0);

        // Create a ForkJoinPool for parallel processing
        ForkJoinPool pool = new ForkJoinPool();

        // Perform counting sort on each character position in parallel
        for (int index = maxLen - 1; index >= 0; index--) {
            final int charIndex = index;
            pool.submit(() -> MultithreadedCountingSortChar(words, charIndex)).join();
        }

        pool.shutdown();
    }

    private static void MultithreadedCountingSortChar(ArrayList<String> words, int index) {
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

    //To prove why use node
    public static void mergeSortSlow(LinkedList<Integer> list) {
        if (list.size() <= 1) {
            return; // Base case: no need to sort if the list has 0 or 1 element
        }

        // Find the middle point and divide the list into two halves
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        
        int mid = list.size() / 2;

        for (int i = 0; i < mid; i++) {
            left.add(list.get(i)); // Add the first half of the list to the left
        }

        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i)); // Add the second half to the right
        }

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(list, left, right);
    }

    private static void merge(LinkedList<Integer> result, LinkedList<Integer> left, LinkedList<Integer> right) {
        result.clear(); // Clear the original list to store sorted elements

        int i = 0, j = 0;

        // Merge the two sorted lists
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i++)); // Add from left list
            } else {
                result.add(right.get(j++)); // Add from right list
            }
        }

        // Add remaining elements from the left list
        while (i < left.size()) {
            result.add(left.get(i++));
        }

        // Add remaining elements from the right list
        while (j < right.size()) {
            result.add(right.get(j++));
        }
    }
}
