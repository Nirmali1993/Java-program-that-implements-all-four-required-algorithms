import java.util.Arrays;
import java.util.Random;

public class AlgorithmAnalyzer {
    
    // Member 1: Linear Search Implementation
    public static class LinearSearchAnalyzer {
        public static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        
        public static void analyzeLinearSearch() {
            System.out.println("\n=== Member 1: Linear Search ===");
            System.out.println("Algorithm: Linear Search");
            System.out.println("Input Size | Time (ms)");
            System.out.println("----------------------");
            
            int[] sizes = {100, 500, 1000};
            
            for (int size : sizes) {
                int[] arr = generateRandomArray(size);
                int target = arr[size / 2]; // Search for middle element
                
                long startTime = System.nanoTime();
                linearSearch(arr, target);
                long endTime = System.nanoTime();
                
                double timeMs = (endTime - startTime) / 1_000_000.0;
                System.out.printf("%-10d | %.4f\n", size, timeMs);
            }
        }
    }

    // Member 2: Binary Search Implementation
    public static class BinarySearchAnalyzer {
        public static int binarySearch(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
        
        public static void analyzeBinarySearch() {
            System.out.println("\n=== Member 2: Binary Search ===");
            System.out.println("Algorithm: Binary Search (after sorting)");
            System.out.println("Input Size | Time (ms)");
            System.out.println("----------------------");
            
            int[] sizes = {100, 500, 1000};
            
            for (int size : sizes) {
                int[] arr = generateRandomArray(size);
                Arrays.sort(arr); // Sort first for binary search
                int target = arr[size / 2]; // Search for middle element
                
                long startTime = System.nanoTime();
                binarySearch(arr, target);
                long endTime = System.nanoTime();
                
                double timeMs = (endTime - startTime) / 1_000_000.0;
                System.out.printf("%-10d | %.4f\n", size, timeMs);
            }
        }
    }

    // Member 3: Bubble Sort Implementation
    public static class BubbleSortAnalyzer {
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        
        public static void analyzeBubbleSort() {
            System.out.println("\n=== Member 3: Bubble Sort ===");
            System.out.println("Algorithm: Bubble Sort");
            System.out.println("Input Size | Time (ms)");
            System.out.println("----------------------");
            
            int[] sizes = {100, 500, 1000};
            
            for (int size : sizes) {
                int[] arr = generateRandomArray(size);
                
                long startTime = System.nanoTime();
                bubbleSort(arr);
                long endTime = System.nanoTime();
                
                double timeMs = (endTime - startTime) / 1_000_000.0;
                System.out.printf("%-10d | %.2f\n", size, timeMs);
            }
        }
    }
    // Member 4 (22ug3-0591): Quick Sort Implementation
    public static class QuickSortAnalyzer {
        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }
        
        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    // Swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            
            // Swap pivot
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            
            return i + 1;
        }
        
        public static void analyzeQuickSort() {
            System.out.println("\n=== Member 4: Quick Sort ===");
            System.out.println("Algorithm: Quick Sort");
            System.out.println("Input Size | Time (ms)");
            System.out.println("----------------------");
            
            int[] sizes = {100, 500, 1000};
            
            for (int size : sizes) {
                int[] arr = generateRandomArray(size);
                
                long startTime = System.nanoTime();
                quickSort(arr, 0, arr.length - 1);
                long endTime = System.nanoTime();
                
                double timeMs = (endTime - startTime) / 1_000_000.0;
                System.out.printf("%-10d | %.2f\n", size, timeMs);
            }
        }
    }
    
    // Utility method to generate random arrays
    public static int[] generateRandomArray(int size) {
        Random rand = new Random(42); // Fixed seed for consistency
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
    
    // Main method to run all analyses
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("   CIT300 Algorithm Performance Analysis       ");
        System.out.println("   Graded Practical Assignment 3                 ");
        System.out.println("╚════════════════════════════════════════════════╝");
        
        // Run each member's analysis
        LinearSearchAnalyzer.analyzeLinearSearch();
        BinarySearchAnalyzer.analyzeBinarySearch();
        BubbleSortAnalyzer.analyzeBubbleSort();
        QuickSortAnalyzer.analyzeQuickSort();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Analysis Complete!");
        System.out.println("=".repeat(50));
    }
}
    
