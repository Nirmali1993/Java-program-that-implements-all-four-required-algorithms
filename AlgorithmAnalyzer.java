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
    
    
