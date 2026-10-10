import java.util.Arrays;

public class Problem8 {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        k = k % n;
        String[] rotated = new String[n];
        
        for (int i = 0; i < n; i++) {
            int newIndex = (int) ((i + k) % n);
            rotated[newIndex] = names[i];
        }
        return rotated;
    }
}