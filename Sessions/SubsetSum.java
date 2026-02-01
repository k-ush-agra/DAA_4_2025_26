package Sessions;

public class SubsetSum {

    boolean solve(int[] arr, int i, int sum, int curr) {
        if (curr == sum) {
            return true;
        }

        if (i >= arr.length || curr > sum) {
            return false;
        }

        
        if (solve(arr, i + 1, sum, curr + arr[i])) {
            return true;
        }

        
        return solve(arr, i + 1, sum, curr);
    }

    public boolean isSubsetSum(int[] arr, int sum) {
        return solve(arr, 0, sum, 0);
    }
}
