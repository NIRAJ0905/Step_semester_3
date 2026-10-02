package polymorphism_practice_problems;

import java.util.Scanner;

abstract class Question {
    protected String text, correct, student;
    protected int points;

    public Question(String text, String correct, String student, int points) {
        this.text = text; this.correct = correct; this.student = student; this.points = points;
    }

    public abstract double grade();
    public abstract String getTypeName();
}

class MCQQuestion extends Question {
    public MCQQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    @Override public double grade() { return student.trim().equalsIgnoreCase(correct.trim()) ? points : 0.0; }
    @Override public String getTypeName() { return "MCQ"; }
}

class TFQuestion extends Question {
    public TFQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    @Override public double grade() { return student.trim().equalsIgnoreCase(correct.trim()) ? points : 0.0; }
    @Override public String getTypeName() { return "TF"; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    @Override public double grade() {
        String[] keywords = correct.split(",");
        int matchCount = 0;
        for (String kw : keywords) {
            String cleanKw = kw.trim();
            if (!cleanKw.isEmpty() && student.toLowerCase().contains(cleanKw.toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        else if (matchCount == 1) return points * 0.50;
        return 0.0;
    }
    @Override public String getTypeName() { return "ESSAY"; }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        Question[] questions = new Question[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String qText = parts[1];
            String[] rest = parts[2].trim().split(" ");
            String correct = rest[0].replace("\"", "");
            // Handle quoted vs unquoted student answer
            String student = "";
            int points = 0;
            if (line.contains("\"\"")) {
                // handle edge case if needed
            }
            // Simple parsing assuming standard format
            // Let's use a robust token parser or regex if needed.
            // For standard sample inputs:
            // Type "Text" "Correct" "Student" Points
            int firstQuote = line.indexOf('"');
            int secondQuote = line.indexOf('"', firstQuote + 1);
            String t = line.substring(0, firstQuote).trim();
            String qTxt = line.substring(firstQuote + 1, secondQuote);
            
            int thirdQuote = line.indexOf('"', secondQuote + 1);
            int fourthQuote = line.indexOf('"', thirdQuote + 1);
            String corr = line.substring(thirdQuote + 1, fourthQuote);

            int fifthQuote = line.indexOf('"', fourthQuote + 1);
            int sixthQuote = line.indexOf('"', fifthQuote + 1);
            String stud = line.substring(fifthQuote + 1, sixthQuote);

            int pts = Integer.parseInt(line.substring(sixthQuote + 1).trim());

            if (t.equals("MCQ")) questions[i] = new MCQQuestion(qTxt, corr, stud, pts);
            else if (t.equals("TF")) questions[i] = new TFQuestion(qTxt, corr, stud, pts);
            else if (t.equals("ESSAY")) questions[i] = new EssayQuestion(qTxt, corr, stud, pts);
        }
        scanner.close();

        double totalScore = 0;
        for (Question q : questions) {
            double score = q.grade();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getTypeName(), score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }
}