public class Problem6 {
    public static int[] attendanceSummary(int[] days) {
        int presentCount = 0;
        int maxStreak = 0;
        int currentStreak = 0;
        
        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        return new int[] { presentCount, maxStreak };
    }
}