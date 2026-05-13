import java.util.*;

public class DPalindromex {

    private static boolean isPalindrome(int []arr, int l, int r) {
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private static int[] findRange(int []arr, int i) {
        int l = i - 1, r = i + 1;
        int n = arr.length;
        while (l >= 0 && r < n && arr[l] == arr[r]) {
            l--;
            r++;
        }
        return new int[]{l + 1, r - 1};
    }

    private static int findMEX(int []arr, int l, int r) {
        int []copy = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            copy[i - l] = arr[i];
        }

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != i && copy[i] < copy.length && copy[copy[i]] != copy[i]) {
                // swap arr[i] with arr[arr[i]]
                int temp = copy[copy[i]];
                copy[copy[i]] = copy[i];
                copy[i] = temp;
                i--;
            }
        }

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != i) {
                return i;
            }
        }
        return copy.length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- != 0) {
            int n = 2 * sc.nextInt();
            int []arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int zeroL = -1, zeroR = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    if (zeroL == -1) {
                        zeroL = i;
                    } else {
                        zeroR = i;
                    }
                }
            }

            int maxMEX = 0;

            // choose zeroL as the center of a palindrome
            // choose zeroR as the center of a plaindrome
            // chose a plaindrome including [zeroL, zeroR]
            int []range1 = findRange(arr, zeroL);
            maxMEX = Math.max(findMEX(arr, range1[0], range1[1]), maxMEX);
            int []range2 = findRange(arr, zeroR);
            maxMEX = Math.max(findMEX(arr, range2[0], range2[1]), maxMEX);
            
            boolean isPal = isPalindrome(arr, zeroL, zeroR);
            if (isPal) {
                int l = zeroL, r = zeroR;
                while (l >= 0 && r < n && arr[l] == arr[r]) {
                    l--;
                    r++;
                }
                int mex = findMEX(arr, l + 1, r - 1);
                maxMEX = Math.max(mex, maxMEX);
            }

            System.out.println(maxMEX);
        }
        sc.close();
    }
}