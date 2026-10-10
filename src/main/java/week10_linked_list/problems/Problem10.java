public class Problem10 {
    public static int[] busiestRow(int[][] grid) {
        int maxTotal = -1;
        int bestRow = 0;
        
        for (int i = 0; i < grid.length; i++) {
            int currentTotal = 0;
            for (int val : grid[i]) {
                currentTotal += val;
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = i;
            }
        }
        return new int[] { bestRow, maxTotal };
    }
}