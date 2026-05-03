public class Count_Indices_With_Opposite_Parity {
    public int[] countOppositeParity(int[] nums) {
        int[] result = new int[nums.length];
        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[i] = oddCount;
                evenCount--;
            } else {
                result[i] = evenCount;
                oddCount--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
