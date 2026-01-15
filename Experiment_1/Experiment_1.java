import java.util.*;

public class Experiment_1 {

    static long operationCount = 0;
    static int maxDepth = 0;

    static void complexRec(int n, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        if (n <= 2) {
            operationCount++;
            return;
        }

        int p = n;
        while (p > 0) {
            operationCount++;
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = i ^ p;
                operationCount++;
            }
            p >>= 1;
        }

        int[] small = new int[n];
        for (int i = 0; i < n; i++) {
            small[i] = i * i;
            operationCount++;
        }

        reverseArray(small);

        complexRec(n / 2, depth + 1);
        complexRec(n / 2, depth + 1);
        complexRec(n / 2, depth + 1);
    }

    private static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
            operationCount++;
        }
    }

    public static void main(String[] args) {
        int n = 16;

        long startTime = System.nanoTime();
        complexRec(n, 1);
        long endTime = System.nanoTime();

        System.out.println("Input size n = " + n);
        System.out.println("Total operations = " + operationCount);
        System.out.println("Maximum recursion depth = " + maxDepth);
        System.out.println("Execution time (ms) = " + (endTime - startTime) / 1_000_000.0);
    }
}
// master theorem case 1 applies 
// T(n) = 3T(n/2) + O(n log n)
// T(n) = Θ(n^(log_2 3)) = Θ(n^1.585)