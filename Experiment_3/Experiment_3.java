import java.util.*;

public class Experiment_3 {

    static List<List<String>> result = new ArrayList<>();
    static char[][] board;
    static int n;

    static int[] colmn, diag1, diag2;

    static boolean isSafe(int x, int y) {
        return colmn[y] == 0 &&
               diag1[x - y + n - 1] == 0 &&
               diag2[x + y] == 0;
    }

    static void solve(int row) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 'Q';
                colmn[col] = diag1[row - col + n - 1] = diag2[row + col] = 1;

                solve(row + 1);

                board[row][col] = '.';
                colmn[col] = diag1[row - col + n - 1] = diag2[row + col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        colmn = new int[n];
        diag1 = new int[2 * n];
        diag2 = new int[2 * n];

        solve(0);

        for (List<String> sol : result) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
// // Time complexity : n!    for isSafe : O(1)