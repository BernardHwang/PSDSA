import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PartitionSorted {
    public static void numArray1PartitionSorted(ArrayList<Integer> numArrayList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 4;

        
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> fullList = new ArrayList<>(numArrayList.subList(0, totalSize));
            int startIndex = i * partitionSize;
            int endIndex = (i + 1) * partitionSize;

            // Handle the last partition
            if (i == 3) {
                endIndex = totalSize;
            }

            // Extract the partition
            List<Integer> partition = fullList.subList(startIndex, endIndex);
            Collections.sort(partition);

            // Final step: Sort the entire list
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(fullList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer: " + (endFull - startFull) + " ms\n");
        }
    }

    public static void numArray2PartitionSorted(ArrayList<Integer> numArrayList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 4;

        // Define partition pairs to be sorted
        int[][] pairs = {
            {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}
        };

        for (int[] pair : pairs) {
            List<Integer> fullList = new ArrayList<>(numArrayList.subList(0, totalSize));

            for (int i : pair) {
                int startIndex = i * partitionSize;
                int endIndex = (i + 1) * partitionSize;

                // Handle the last partition
                if (i == 3) {
                    endIndex = totalSize;
                }

                // Extract the partition
                List<Integer> partition = fullList.subList(startIndex, endIndex);
                Collections.sort(partition);
            }
            System.out.println(fullList);
            // Final step: Sort the entire list
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(fullList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer after sorting partitions " + (pair[0] + 1) + " and " + (pair[1] + 1) + ": " + (endFull - startFull) + " ms");
        }
    }

    public static void numArray3PartitionSorted(ArrayList<Integer> numArrayList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 4;
    
        // Define combinations of 3 partitions out of 4
        int[][] triples = {
            {0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}
        };
    
        for (int[] triple : triples) {
            List<Integer> fullList = new ArrayList<>(numArrayList.subList(0, totalSize));
    
            for (int i : triple) {
                int startIndex = i * partitionSize;
                int endIndex = (i + 1) * partitionSize;

                // Handle the last partition
                if (i == 3) {
                    endIndex = totalSize;
                }
    
                // Extract the partition
                List<Integer> partition = fullList.subList(startIndex, endIndex);
                Collections.sort(partition);
            }
    
            // Final step: Sort the entire list
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(fullList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer after sorting partitions " + (triple[0] + 1) + ", " + (triple[1] + 1) + ", and " + (triple[2] + 1) + ": " + (endFull - startFull) + " ms");
        }
    }

    public static void numArray4PartitionSorted(ArrayList<Integer> numArrayList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 4;

        ArrayList<Integer> fullList = new ArrayList<>(numArrayList.subList(0, totalSize));
        for (int i = 0; i < 4; i++) {
            
            int startIndex = i * partitionSize;
            int endIndex = (i + 1) * partitionSize;

            // Handle the last partition
            if (i == 3) {
                endIndex = totalSize;
            }

            // Extract the partition
            List<Integer> partition = fullList.subList(startIndex, endIndex);
            Collections.sort(partition);
        }
        // Final step: Sort the entire list
        long startFull = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullList);
        long endFull = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer after sorting each partition individually: " + (endFull - startFull) + " ms\n");
    }

    public static void numLinked1PartitionSorted(LinkedList<Integer> numLinkedList) {

        int totalSize = 1000000;
        int partitionSize = totalSize / 4;

        for (int i = 0; i < 4; i++) {
            LinkedList<Integer> fullList = new LinkedList<>(numLinkedList.subList(0, totalSize));
            int startIndex = i * partitionSize;
            int endIndex = (i + 1) * partitionSize;

            // Handle the last partition
            if (i == 3) {
                endIndex = totalSize;
            }

            // Extract the partition
            List<Integer> partition = fullList.subList(startIndex, endIndex);
            Collections.sort(partition);

            // Final step: Sort the entire list
            Node nodeList = SortingAlgorithms.assignNode(fullList);
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(nodeList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (1M) linkedlist Integer: " + (endFull - startFull) + " ms\n");
        }
    }

    public static void numLinked2PartitionSorted(LinkedList<Integer> numLinkedList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 4;

        // Define partition pairs to be sorted
        int[][] pairs = {
            {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}
        };

        for (int[] pair : pairs) {
            List<Integer> fullList = new LinkedList<>(numLinkedList.subList(0, totalSize));

            for (int i : pair) {
                int startIndex = i * partitionSize;
                int endIndex = (i + 1) * partitionSize;

                // Handle the last partition
                if (i == 3) {
                    endIndex = totalSize;
                }

                // Extract the partition
                List<Integer> partition = fullList.subList(startIndex, endIndex);
                Collections.sort(partition);
            }
            System.out.println(fullList);
            // Final step: Sort the entire list
            Node nodeList = SortingAlgorithms.assignNode(fullList);
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(nodeList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (1M) linkedlist Integer after sorting partitions " + (pair[0] + 1) + " and " + (pair[1] + 1) + ": " + (endFull - startFull) + " ms");
        }
    }

    public static void numLinked3PartitionSorted(LinkedList<Integer> numLinkedList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 4;
    
        // Define all possible combinations of 3 partitions out of 4
        int[][] triples = {
            {0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}
        };
    
        for (int[] triple : triples) {
            LinkedList<Integer> fullList = new LinkedList<>(numLinkedList.subList(0, totalSize));
    
            for (int i : triple) {
                int startIndex = i * partitionSize;
                int endIndex = (i + 1) * partitionSize;

                // Handle the last partition
                if (i == 3) {
                    endIndex = totalSize;
                }
    
                // Extract the partition
                List<Integer> partition = fullList.subList(startIndex, endIndex);
                Collections.sort(partition);
            }
    
            // Final step: Sort the entire list
            Node nodeList = SortingAlgorithms.assignNode(fullList);
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(nodeList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (1M) linkedlist Integer after sorting partitions " + (triple[0] + 1) + ", " + (triple[1] + 1) + ", and " + (triple[2] + 1) + ": " + (endFull - startFull) + " ms");
        }
    }

    public static void numLinked4PartitionSorted(LinkedList<Integer> numLinkedList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 4;

        ArrayList<Integer> fullList = new ArrayList<>(numLinkedList.subList(0, totalSize));
        for (int i = 0; i < 4; i++) {
            
            int startIndex = i * partitionSize;
            int endIndex = (i + 1) * partitionSize;

            // Handle the last partition
            if (i == 3) {
                endIndex = totalSize;
            }

            // Extract the partition
            List<Integer> partition = fullList.subList(startIndex, endIndex);
            Collections.sort(partition);
        }
        // Final step: Sort the entire list
        Node nodeList = SortingAlgorithms.assignNode(fullList);
        long startFull = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(nodeList);
        long endFull = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) linkedlist Integer after sorting each partition individually: " + (endFull - startFull) + " ms\n");
    }

    public static void wordArray1PartitionSorted(ArrayList<String> wordArrayList) {
        int totalSize = 100000;
        int partitionSize = totalSize / 4;

        for (int i = 0; i < 4; i++) {
            ArrayList<String> fullList = new ArrayList<>(((ArrayList<String>) wordArrayList).subList(0, totalSize));
            int startIndex = i * partitionSize;
            int endIndex = (i + 1) * partitionSize;

            // Handle the last partition
            if (i == 3) {
                endIndex = totalSize;
            }

            // Extract the partition
            List<String> partition = fullList.subList(startIndex, endIndex);
            Collections.sort(partition);

            // Final step: Sort the entire list
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(fullList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (100000k) arraylist String: " + (endFull - startFull) + " ms\n");
        }
    }

    public static void wordArray2PartitionSorted(ArrayList<String> wordArrayList) {
        int totalSize = 100000;
        int partitionSize = totalSize / 4;

        // Define partition pairs to be sorted
        int[][] pairs = {
            {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}
        };

        for (int[] pair : pairs) {
            List<String> fullList = new ArrayList<>(wordArrayList.subList(0, totalSize));

            for (int i : pair) {
                int startIndex = i * partitionSize;
                int endIndex = (i + 1) * partitionSize;

                // Handle the last partition
                if (i == 3) {
                    endIndex = totalSize;
                }

                // Extract the partition
                List<String> partition = fullList.subList(startIndex, endIndex);
                Collections.sort(partition);
            }
            System.out.println(fullList);
            // Final step: Sort the entire list
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(fullList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (100000k) arraylist String after sorting partitions " + (pair[0] + 1) + " and " + (pair[1] + 1) + ": " + (endFull - startFull) + " ms");
        }
    }

    public static void wordArray3PartitionSorted(ArrayList<String> wordArrayList) {
        int totalSize = 100000;
        int partitionSize = totalSize / 4;
    
        // Define combinations of 3 partitions out of 4
        int[][] triples = {
            {0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}
        };
    
        for (int[] triple : triples) {
            List<String> fullList = new ArrayList<>(wordArrayList.subList(0, totalSize));
    
            for (int i : triple) {
                int startIndex = i * partitionSize;
                int endIndex = (i + 1) * partitionSize;

                // Handle the last partition
                if (i == 3) {
                    endIndex = totalSize;
                }
    
                // Extract the partition
                List<String> partition = fullList.subList(startIndex, endIndex);
                Collections.sort(partition);
            }
    
            // Final step: Sort the entire list
            long startFull = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(fullList);
            long endFull = System.currentTimeMillis();
            System.out.println("Elapsed Time for sorting entire (100000k) arraylist String after sorting partitions " + (triple[0] + 1) + ", " + (triple[1] + 1) + ", and " + (triple[2] + 1) + ": " + (endFull - startFull) + " ms");
        }
    }

    public static void wordArray4PartitionSorted(ArrayList<String> wordArrayList) {
        int totalSize = 100000;
        int partitionSize = totalSize / 4;

        ArrayList<String> fullList = new ArrayList<>(wordArrayList.subList(0, totalSize));
        for (int i = 0; i < 4; i++) {
            
            int startIndex = i * partitionSize;
            int endIndex = (i + 1) * partitionSize;

            // Handle the last partition
            if (i == 3) {
                endIndex = totalSize;
            }

            // Extract the partition
            List<String> partition = fullList.subList(startIndex, endIndex);
            Collections.sort(partition);
        }
        // Final step: Sort the entire list
        long startFull = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullList);
        long endFull = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (100000k) arraylist String after sorting each partition individually: : " + (endFull - startFull) + " ms\n");
    }

    public static void numArrayHalfSorted(ArrayList<Integer> numArrayList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 2;

        // First case: Sort the first half
        ArrayList<Integer> fullArrayList = new ArrayList<>(numArrayList.subList(0, totalSize));
        List<Integer> firstArrayHalf = fullArrayList.subList(0, partitionSize);
        Collections.sort(firstArrayHalf);

        // Final step: Sort the entire list
        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullArrayList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer after sorting first half: " + (end - start) + " ms");

        // Second case: Sort the second half
        fullArrayList = new ArrayList<>(numArrayList.subList(0, totalSize));
        List<Integer> secondArrayHalf = fullArrayList.subList(partitionSize, totalSize);
        Collections.sort(secondArrayHalf);

        // Final step: Sort the entire list again
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullArrayList);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer after sorting second half: " + (end - start) + " ms");
    }
    
    public static void numArray75PercentSorted(ArrayList<Integer> numArrayList) {
        int totalSize = 1000000;
        int partitionSize = (int) (totalSize * 0.75);

        // First case: Sort the first 75%
        ArrayList<Integer> fullArrayList = new ArrayList<>(numArrayList.subList(0, totalSize));
        List<Integer> first75Percent = fullArrayList.subList(0, partitionSize);
        Collections.sort(first75Percent);

        // Final step: Sort the entire list
        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullArrayList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer after sorting first 75%: " + (end - start) + " ms");

        // Second case: Sort the last 75%
        fullArrayList = new ArrayList<>(numArrayList.subList(0, totalSize));
        List<Integer> last75Percent = fullArrayList.subList(totalSize - partitionSize, totalSize);
        Collections.sort(last75Percent);

        // Final step: Sort the entire list again
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullArrayList);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer after sorting last 75%: " + (end - start) + " ms");
    }

    public static void numArray100PercentSorted(ArrayList<Integer> numArrayList) {
        int totalSize = 1000000;

        ArrayList<Integer> fullList = new ArrayList<>(numArrayList.subList(0, totalSize));
        Collections.sort(fullList);

        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) arraylist Integer after 100000% sorted: " + (end - start) + "ms\n");
    }

    public static void numLinkedHalfSorted(LinkedList<Integer> numLinkedList) {
        int totalSize = 1000000;
        int partitionSize = totalSize / 2;
        // First case: Sort the first half
        LinkedList<Integer> fullLinkedList = new LinkedList<>(numLinkedList.subList(0, totalSize));
        List<Integer> firstLinkedHalf = fullLinkedList.subList(0, partitionSize);
        Collections.sort(firstLinkedHalf);

        // Final step: Sort the entire list
        Node nodeList = SortingAlgorithms.assignNode(fullLinkedList);
        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(nodeList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) linkedlist Integer after sorting first half: " + (end - start) + " ms");

        // Second case: Sort the second half
        fullLinkedList = new LinkedList<>(numLinkedList.subList(0, totalSize));
        List<Integer> secondLinkedHalf = fullLinkedList.subList(partitionSize, totalSize);
        Collections.sort(secondLinkedHalf);

        // Final step: Sort the entire list again
        nodeList = SortingAlgorithms.assignNode(fullLinkedList);
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(nodeList);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) linkedlist Integer after sorting second half: " + (end - start) + " ms");
    }
    
    public static void numLinked75PercentSorted(LinkedList<Integer> numLinkedList) {
        int totalSize = 1000000;
        int partitionSize = (int) (totalSize * 0.75);

        // First case: Sort the first 75%
        ArrayList<Integer> fullArrayList = new ArrayList<>(numLinkedList.subList(0, totalSize));
        List<Integer> first75Percent = fullArrayList.subList(0, partitionSize);
        Collections.sort(first75Percent);

        // Final step: Sort the entire list
        Node nodeList = SortingAlgorithms.assignNode(fullArrayList);
        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(nodeList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) linkedlist Integer after sorting first 75%: " + (end - start) + " ms");

        // Second case: Sort the last 75%
        fullArrayList = new ArrayList<>(numLinkedList.subList(0, totalSize));
        List<Integer> last75Percent = fullArrayList.subList(totalSize - partitionSize, totalSize);
        Collections.sort(last75Percent);

        // Final step: Sort the entire list again
        nodeList = SortingAlgorithms.assignNode(fullArrayList);
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(nodeList);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) Linkedlist Integer after sorting last 75%: " + (end - start) + " ms");
    }

    public static void numLinked100PercentSorted(LinkedList<Integer> numLinkedList) {
        int totalSize = 1000000;

        ArrayList<Integer> fullList = new ArrayList<>(numLinkedList.subList(0, totalSize));
        Collections.sort(fullList);

        Node nodeList = SortingAlgorithms.assignNode(fullList);
        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(nodeList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (1M) linkedlist Integer after 100000% sorted: " + (end - start) + "ms\n");
    }

    public static void wordArrayHalfSorted(ArrayList<String> wordArrayList) {
        int totalSize = 100000;
        int partitionSize = totalSize / 2;

        // First case: Sort the first half
        ArrayList<String> fullArrayList = new ArrayList<>(wordArrayList.subList(0, totalSize));
        List<String> firstArrayHalf = fullArrayList.subList(0, partitionSize);
        Collections.sort(firstArrayHalf);

        // Final step: Sort the entire list
        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullArrayList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (100000k) arraylist String after sorting first half: " + (end - start) + " ms");

        // Second case: Sort the second half
        fullArrayList = new ArrayList<>(wordArrayList.subList(0, totalSize));
        List<String> secondArrayHalf = fullArrayList.subList(partitionSize, totalSize);
        Collections.sort(secondArrayHalf);

        // Final step: Sort the entire list again
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullArrayList);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (100000k) arraylist String after sorting second half: " + (end - start) + " ms");
    }
    
    public static void wordArray75PercentSorted(ArrayList<String> wordArrayList) {
        int totalSize = 100000;
        int partitionSize = (int) (totalSize * 0.75);

        // First case: Sort the first 75%
        ArrayList<String> fullArrayList = new ArrayList<>(wordArrayList.subList(0, totalSize));
        List<String> first75Percent = fullArrayList.subList(0, partitionSize);
        Collections.sort(first75Percent);

        // Final step: Sort the entire list
        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullArrayList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (100000k) arraylist String after sorting first 75%: " + (end - start) + " ms");

        // Second case: Sort the last 75%
        fullArrayList = new ArrayList<>(wordArrayList.subList(0, totalSize));
        List<String> last75Percent = fullArrayList.subList(totalSize - partitionSize, totalSize);
        Collections.sort(last75Percent);

        // Final step: Sort the entire list again
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullArrayList);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (100000k) arraylist String after sorting last 75%: " + (end - start) + " ms");
    }

    public static void wordArray100PercentSorted(ArrayList<String> wordArrayList) {
        int totalSize = 100000;

        ArrayList<String> fullList = new ArrayList<>(wordArrayList.subList(0, totalSize));
        Collections.sort(fullList);

        long start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(fullList);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for sorting entire (100000k) arraylist String after 100000% sorted: " + (end - start) + "ms\n");
    }
}

