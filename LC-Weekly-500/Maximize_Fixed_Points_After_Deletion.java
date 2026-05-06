import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Maximize_Fixed_Points_After_Deletion {

    private int findLB(int target, ArrayList<Integer> nums) {
        int low = 0, high = nums.size() - 1;
        int lb = nums.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) >= target) {
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lb;
    }

    public int maxFixedPoints(int[] nums) {
        ArrayList<int[]> chosen = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= i) {
                chosen.add(new int[]{i - nums[i], nums[i]});
            }
        }

        Collections.sort(chosen, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        ArrayList<Integer> sequence = new ArrayList<>();
        for (int[] c : chosen) {
            int pos = findLB(c[1], sequence);
            if (pos == sequence.size()) {
                sequence.add(c[1]);
            } else {
                sequence.set(pos, c[1]);
            }
        }

        return sequence.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Maximize_Fixed_Points_After_Deletion mfpad = new Maximize_Fixed_Points_After_Deletion();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(mfpad.maxFixedPoints(nums));
    }
}
