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
    // Optimized for ArrayList
    public static <T extends Comparable<T>> void selectionSort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the elements
            if (minIndex != i) {
                T temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }

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

    // Optimized for LinkedList
    public static Node selectionSort(Node head) {
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

    public static <T extends Comparable<T>> void combSort(List<T> list) {
        int n = list.size();
        int gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            // Calculate next gap value
            gap = gap <= 1 ? 1: (gap*10/13);

            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false;

            // Compare all elements with the current gap
            for (int i = 0; i < n - gap; i++) {
                if (list.get(i).compareTo(list.get(i + gap)) > 0) {
                    // Swap the elements
                    T temp = list.get(i);
                    list.set(i, list.get(i + gap));
                    list.set(i + gap, temp);

                    // Set swapped to true to indicate that swapping happened
                    swapped = true;
                }
            }
        }
    }
    // Comb sort for Linked List by swapping nodes
    public static Node combSort(Node head) {
        if (head == null) return null;

        int n = getSize(head);
        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            // Calculate next gap value
            gap = (gap * 10) / 13;
            if (gap < 1) gap = 1;

            Node left = head;
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                Node right = getNodeAt(head, i + gap);

                if (left.data > right.data) {
                    // Swap the data
                    int temp = left.data;
                    left.data = right.data;
                    right.data = temp;
                    swapped = true;
                }
                left = left.next;
            }
        }
        return head;
    }

    @SuppressWarnings("unchecked")
    // Counting Sort for ArrayList (Generic)
    public static <T extends Comparable<T>> void countingSort(List<T> list) {
        if (list.isEmpty()) return;

        // Check if the list contains integers
        if (list.get(0) instanceof Integer) {
            countingSortIntegers((List<Integer>) list);
        } else if (list.get(0) instanceof String) {
            countingSortStrings((List<String>) list);
        }
    }

    // Specialized Counting Sort for Integer List
    private static void countingSortIntegers(List<Integer> list) {
        if (list.isEmpty()) return;

        // Find the maximum and minimum value in the list
        int max = Collections.max(list);
        int min = Collections.min(list);

        // Create a count array to store count of individual elements
        int[] count = new int[max - min + 1];

        // Store the count of each element in the count array
        for (int num : list) {
            count[num - min]++;
        }

        // Update the original list with sorted elements
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                list.set(index++, i + min);
                count[i]--;
            }
        }
    }

    // Specialized Counting Sort for String List (Radix-like for Characters)
    private static void countingSortStrings(List<String> list) {
        if (list.isEmpty()) return;

        int maxLen = 0;

        // Find the maximum length of the strings
        for (String str : list) {
            maxLen = Math.max(maxLen, str.length());
        }

        // Sort based on each character position (radix sort approach)
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            countingSortByCharacter(list, pos);
        }
    }

    private static void countingSortByCharacter(List<String> list, int pos) {
        int[] count = new int[257];  // 256 for ASCII + 1 for possible empty position
        List<String> output = new ArrayList<>(Collections.nCopies(list.size(), ""));

        // Store count of occurrences of each character
        for (String str : list) {
            int charIndex = pos < str.length() ? (int) str.charAt(pos) : 0;
            count[charIndex + 1]++;
        }

        // Compute the cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Place the elements in sorted order
        for (String str : list) {
            int charIndex = pos < str.length() ? (int) str.charAt(pos) : 0;
            output.set(count[charIndex]++, str);
        }

        // Copy the sorted elements back to the original list
        for (int i = 0; i < list.size(); i++) {
            list.set(i, output.get(i));
        }
    }

    // Counting Sort for LinkedList of integers
    public static Node countingSort(Node head) {
        if (head == null) return null;

        // Find the max and min values in the LinkedList
        int max = head.data, min = head.data;
        Node current = head;
        while (current != null) {
            if (current.data > max) max = current.data;
            if (current.data < min) min = current.data;
            current = current.next;
        }

        int[] count = new int[max - min + 1];
        current = head;

        // Populate the count array
        while (current != null) {
            count[current.data - min]++;
            current = current.next;
        }

        // Rebuild the linked list with sorted values
        current = head;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                current.data = i + min;
                current = current.next;
                count[i]--;
            }
        }

        return head;
    }

    private static int getSize(Node head) {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    private static Node getNodeAt(Node head, int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current != null) {
                current = current.next;
            } else {
                return null;
            }
        }
        return current;
    }
}
