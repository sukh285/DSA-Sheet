public class FindDuplicateNumber2 {

    public static int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];          // Move one step
            fast = nums[nums[fast]];     // Move two steps
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;  // or fast (they meet at the duplicate)
    }

    public static void main(String[] args) {
        // Test Case 1: Simple case with duplicate 2
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Test Case 1: " + findDuplicate(nums1));  // Output: 2

        // Test Case 2: Duplicate at the beginning
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Test Case 2: " + findDuplicate(nums2));  // Output: 3

        // Test Case 3: Duplicate at the end
        int[] nums3 = {1, 4, 6, 3, 2, 5, 6};
        System.out.println("Test Case 3: " + findDuplicate(nums3));  // Output: 6

        // Test Case 4: Large array with duplicate
        int[] nums4 = {8, 7, 1, 10, 17, 15, 18, 11, 16, 9, 19, 12, 5, 14, 3, 4, 2, 13, 6, 18};
        System.out.println("Test Case 4: " + findDuplicate(nums4));  // Output: 18

        // Test Case 5: All elements same
        int[] nums5 = {2, 2, 2, 2, 2};
        System.out.println("Test Case 5: " + findDuplicate(nums5));  // Output: 2
    }
}