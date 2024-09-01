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
