import java.util.*;

public class FItJustKeepsGoingSideways {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- != 0) {
            int n = sc.nextInt();
            int []heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }
            int max = heights[0];
            for (int h : heights) {
                max = Math.max(h, max);
            }

            long []heightCnt = new long[max + 1];
            for (int height : heights) {
                heightCnt[1] += 1;
                if (height + 1 <= max) {
                    heightCnt[height + 1] -= 1;
                }
            }

            for (int i = 1; i <= max; i++) {
                heightCnt[i] += heightCnt[i - 1];
            }

            long []initPositions = new long[max + 1];
            for (int i = 0; i < n; i++) {
                int h = heights[i];
                initPositions[1] += i;
                if (h + 1 <= max) {
                    initPositions[h + 1] -= i;
                }
            }

            for (int i = 1; i <= max; i++) {
                initPositions[i] += initPositions[i - 1];
            }


            // after titlitng all shift to right
            long []finalPositions = new long[max + 1];
            for (int i = 1; i <= max; i++) {
                long cnt = heightCnt[i];
                finalPositions[i] += cnt * n - cnt * (cnt + 1) / 2;
            }

            long maxShiftDist = Math.max(0, -n + heightCnt[heights[0]]);
            int maxInd = 0;
            for (int i = 1; i < n; i++) {
                // how much right shift is done if the current block is removed
                // count[currHeight] -= 1
                // final positions and initial positions vary
                long currShiftDist = i - (n - heightCnt[heights[i]]);
                if (currShiftDist > maxShiftDist) {
                    maxShiftDist = currShiftDist;
                    maxInd = i;
                }
            }

            int maxH = heights[maxInd];
            finalPositions[maxH] -= (n - heightCnt[maxH]);
            initPositions[maxH] -= maxInd;
            long totalShift = 0;
            for (int i = 1; i <= max; i++) {
                totalShift += finalPositions[i] - initPositions[i];
            }

            System.out.println(totalShift);
        }
        sc.close();
    }
}