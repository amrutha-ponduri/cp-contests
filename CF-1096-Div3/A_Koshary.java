import java.util.*;

public class A_Koshary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- != 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (a % 2 == 1 && b % 2 == 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        sc.close();
    }
}