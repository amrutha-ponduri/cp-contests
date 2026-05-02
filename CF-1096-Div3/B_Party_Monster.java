import java.util.*;

public class B_Party_Monster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- != 0) {
            int len = sc.nextInt();
            sc.nextLine();
            String seq = sc.nextLine();
            int open = 0;
            for (char ch : seq.toCharArray()) {
                if (ch == '(') {
                    open++;
                } else {
                    open--;
                }
            }

            if (open == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            
        }
        sc.close();
    }
}