public class B_Minimum_Flips_To_Make_CoherentBinaryString {
    public int minFlips(String s) {
        int r = 0, len = s.length();
        int count1 = 0, count0 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;
            } else {
                count0++;
            }
        }
        int way1 = count1 - 1;
        if (s.charAt(0) == '1') {
            count1--;
        }
        if (s.charAt(len - 1) == '1') {
            count1--;
        }
        int way2 = count1;
        int way3 = count0;
        int result = Math.min(way1, Math.min(way2, way3));
        return Math.max(result, 0);
    }

    public static void main(String[] args) {

    }
}
