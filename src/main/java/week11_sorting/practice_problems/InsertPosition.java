package data_structures;

public class InsertPosition {
    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 2)); // 1[cite: 33]
    }
}