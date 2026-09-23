package week7_encapsulation.practice_problems;

public class Scorecard {
    private final boolean[] results; // Private array[cite: 6]
    private int answerCount;          // Counter for recorded answers[cite: 6]

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions]; // Fixed size[cite: 6]
        this.answerCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (answerCount < results.length) {
            results[answerCount] = isCorrect;
            answerCount++;
        } else {
            System.out.println("Cannot record: all question slots filled."); //[cite: 6]
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++; // Count of true values[cite: 6]
            }
        }
        return score; // Returns count, never the raw array[cite: 6]
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Total Score: " + sc.getScore()); // 3[cite: 6]
    }
}