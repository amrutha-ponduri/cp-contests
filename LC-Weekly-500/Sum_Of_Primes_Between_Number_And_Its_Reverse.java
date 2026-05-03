public class Sum_Of_Primes_Between_Number_And_Its_Reverse {

    public int sumOfPrimesInRange(int n) {
        int rev = 0, temp = n;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }

        int min = Math.min(n, rev), max = Math.max(n, rev);
        int sum = 0;

        for (int i = min; i <= max; i++) {
            boolean notPrime = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    notPrime = true;
                    break;
                }
            }
            if (!notPrime && i != 1) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
