public class A_ScoreValidator {
    public int[] scoreValidator(String[] events) {
        int score = 0, counter = 0;
        for (String eve : events) {
            if (eve.equals("W")) {
                counter++;
            } else if (eve.equals("WD") || eve.equals("NB")) {
                score++;
            } else {
                score += Integer.parseInt(eve);
            }
            if (counter == 10) {
                return new int[]{score, counter};
            }
        }
        return new int[]{score, counter};
    }

    public static void main(String[] args) {

    }
}
