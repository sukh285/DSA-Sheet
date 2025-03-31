
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]); // Use absolute value to handle markings
            if (nums[num] < 0) {
                return num; // Already marked? It's the duplicate!
            }
            nums[num] = -nums[num]; // Mark as visited by negating
        }
        return -1; // Should never reach here (problem guarantees a duplicate)
    }

    public static void main(String[] args) {
        // Test Case 1: Simple case with duplicate 2
        int[] nums1 = { 1, 3, 4, 2, 2 };
        System.out.println("Test Case 1: " + findDuplicate(nums1)); // Output: 2

        // Test Case 2: Duplicate at the beginning
        int[] nums2 = { 3, 1, 3, 4, 2 };
        System.out.println("Test Case 2: " + findDuplicate(nums2)); // Output: 3

        // Test Case 3: Duplicate at the end
        int[] nums3 = { 1, 4, 6, 3, 2, 5, 6 };
        System.out.println("Test Case 3: " + findDuplicate(nums3)); // Output: 6

        // Test Case 4: Large array with duplicate
        int[] nums4 = { 8, 7, 1, 10, 17, 15, 18, 11, 16, 9, 19, 12, 5, 14, 3, 4, 2, 13, 6, 18 };
        System.out.println("Test Case 4: " + findDuplicate(nums4)); // Output: 18
    }
}
