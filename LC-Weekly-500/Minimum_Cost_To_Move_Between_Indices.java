import java.util.ArrayList;

public class Minimum_Cost_To_Move_Between_Indices {
    public int[] minCost(int[] nums, int[][] queries) {
        ArrayList<int[]> edges = new ArrayList<>();
        int n = nums.length;
        int[] prefCost = new int[n];
        int[] suffCost = new int[n];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                suffCost[i] = 1;
            } else if (i == nums.length - 1) {
                prefCost[i] = 1;
            } else {
                if (nums[i] - nums[i - 1] > nums[i + 1] - nums[i]) {
                    prefCost[i] = nums[i] - nums[i - 1];
                    suffCost[i] = 1;
                } else {
                    suffCost[i] = nums[i + 1] - nums[i];
                    prefCost[i] = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            prefCost[i] += prefCost[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffCost[i] += suffCost[i + 1];
        }

        int[] result = new int[queries.length];
        int i = 0;

        for (int[] q : queries) {
            int u = q[0], v = q[1];
            int cost = 0;
            if (u < v) {
                cost = suffCost[u] - suffCost[v];
            } else {
                cost = prefCost[u] - prefCost[v];
            }
            result[i++] = cost;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
