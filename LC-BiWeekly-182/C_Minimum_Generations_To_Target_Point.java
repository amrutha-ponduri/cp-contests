import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class C_Minimum_Generations_To_Target_Point {
    public int minGenerations(int[][] points, int[] target) {
        HashSet<String> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        ArrayList<int[]> p = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            String s = points[i][0] + " " + points[i][1] + " " + points[i][2];
            if (!visited.contains(s)) {
                queue.add(new int[]{points[i][0], points[i][1], points[i][2]});
                visited.add(s);
                p.add(points[i]);
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<int[]> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == target[0] && curr[1] == target[1] && curr[2] == target[2]) {
                    return level;
                }
                for (int[] x : p) {
                    int[] newP = new int[]{(curr[0] + x[0]) / 2, (curr[1] + x[1]) / 2, (curr[2] + x[2]) / 2};
                    String s = newP[0] + " " + newP[1] + " " + newP[2];
                    if (!visited.contains(s)) {
                        visited.add(s);
                        queue.add(newP);
                        temp.add(newP);
                    }
                }
            }
            p.addAll(temp);
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
