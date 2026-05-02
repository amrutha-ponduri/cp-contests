import java.util.*;

public class E_It_All_Went_Sideways {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- != 0) {
            int n = sc.nextInt();
            int []heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }

            Stack<Integer> stack = new Stack<>();
            int []minCoverage = new int[n]; 
            Arrays.fill(minCoverage, 1);

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                    minCoverage[i] += minCoverage[stack.peek()];
                    stack.pop();
                }
                stack.push(i);
            }

            int maxIndex = 0;

            for (int i = 0; i < n; i++) {
                if (minCoverage[i] >= minCoverage[maxIndex]) {
                    maxIndex = i;
                }
            }

            heights[maxIndex] -= 1;
            int minRight = heights[n - 1];
            long total = 0;
            for (int i = n - 1; i >= 0; i--) {
                minRight = Math.min(minRight, heights[i]);
                total += Math.max(0, heights[i] - minRight);
            }

            System.out.println(total);
        }
        sc.close();
    }
}