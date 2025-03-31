import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            
            // Merge all overlapping intervals
            while (i + 1 < intervals.length && currentEnd >= intervals[i + 1][0]) {
                currentEnd = Math.max(currentEnd, intervals[i + 1][1]);
                i++;
            }
            
            merged.add(new int[]{currentStart, currentEnd});
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        // Test Case 1: Basic overlapping intervals
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Test Case 1:");
        printIntervals(merge(intervals1));
        // Expected: [[1,6],[8,10],[15,18]]

        // Test Case 2: All intervals overlap
        int[][] intervals2 = {{1,4},{4,5}};
        System.out.println("\nTest Case 2:");
        printIntervals(merge(intervals2));
        // Expected: [[1,5]]

        // Test Case 3: No overlaps
        int[][] intervals3 = {{1,2},{3,4},{5,6}};
        System.out.println("\nTest Case 3:");
        printIntervals(merge(intervals3));
        // Expected: [[1,2],[3,4],[5,6]]

        // Test Case 4: Single interval
        int[][] intervals4 = {{1,4}};
        System.out.println("\nTest Case 4:");
        printIntervals(merge(intervals4));
        // Expected: [[1,4]]

        // Test Case 5: Complex overlapping
        int[][] intervals5 = {{1,4},{0,4}};
        System.out.println("\nTest Case 5:");
        printIntervals(merge(intervals5));
        // Expected: [[0,4]]
    }

    // Helper method to print intervals
    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }
}