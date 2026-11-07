package data_structures;

import java.util.HashSet;

public class PairSumUnsorted {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9)); // true
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));       // false
    }
}