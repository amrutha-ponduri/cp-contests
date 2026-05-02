import java.util.*;

public class C_Snowfall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- != 0) {
            int n = sc.nextInt();
            int []arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            ArrayList<Integer> result = new ArrayList<>();
            ArrayList<Integer> divBySix = new ArrayList<>();
            ArrayList<Integer> divByTwo = new ArrayList<>();
            ArrayList<Integer> divByThree = new ArrayList<>();
            ArrayList<Integer> remaining = new ArrayList<>();

            
            for (int i = 0; i < n; i++) {
                int rem = arr[i] % 6;
                if (rem == 0) {
                    divBySix.add(arr[i]);
                } else if (rem == 2 || rem == 4) {
                    divByTwo.add(arr[i]);
                } else if (rem == 3) {
                    divByThree.add(arr[i]);
                } else {
                    remaining.add(arr[i]);
                }
            }

            result.addAll(divBySix);
            if (divByTwo.size() > divByThree.size()) {
                result.addAll(divByTwo);
                 result.addAll(remaining);
                result.addAll(divByThree);
            } else {
                result.addAll(divByThree);
                result.addAll(remaining);
                result.addAll(divByTwo);
            }

            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}