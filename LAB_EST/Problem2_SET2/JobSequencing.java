package LAB_EST.Problem2_SET2;

import java.util.*;

class Job {
    int deadline, profit;

    Job(int d, int p) {
        deadline = d;
        profit = p;
    }
}

class JobSequencing {

    public static void main(String[] args) {

        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};

        int n = deadline.length;

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int d : deadline)
            maxDeadline = Math.max(maxDeadline, d);

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int count = 0, totalProfit = 0;

        for (int i = 0; i < n; i++) {

            for (int j = jobs[i].deadline; j > 0; j--) {

                if (slots[j] == -1) {
                    slots[j] = i;
                    count++;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("Jobs done: " + count);
        System.out.println("Max Profit: " + totalProfit);
    }
}