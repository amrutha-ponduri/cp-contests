import java.util.Arrays;
import java.util.Scanner;

public class Maximize_Fixed_Points_After_Deletion {
    public static int maxFixedPoints(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return findMaxFixedPoints(0, 0, nums, memo);
    }

    private static int findMaxFixedPoints(int i, int shift, int[] nums, int[][] memo) {
        if (i == nums.length) {
            return 0;
        }
        if (memo[i][shift] != -1) {
            return memo[i][shift];
        }
        // delete
        int way1 = findMaxFixedPoints(i + 1, shift + 1, nums, memo);
        // keep
        int way2 = (nums[i] == i - shift ? 1 : 0) + findMaxFixedPoints(i + 1, shift, nums, memo);
        memo[i][shift] = Math.max(way1, way2);
        return memo[i][shift];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxFixedPoints(nums));
    }
}
