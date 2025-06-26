import java.util.Arrays;
import java.util.Collections;

public class NonOverlappingIntervals {
    /*
     * Given an array of N intervals in the form of (start[i], end[i]), where
     * start[i] is the starting point of the interval and end[i] is the ending point
     * of the interval, return the minimum number of intervals that need to be
     * removed to make the remaining intervals non-overlapping.
     */
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        /*
         * Output : 1
         * 
         * Explanation : You can remove the interval [1, 3] to make the remaining
         * interval non overlapping.
         */
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        for (int i[] : intervals) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println(MaximumNonOverlappingIntervals(intervals));
    }

    public static int MaximumNonOverlappingIntervals(int[][] arr) {
        if (arr.length == 1) {
            return 0;
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int currStart = arr[0][0];
        int currEnd = arr[0][1];
        int ans = 0;

        for (int i = 1; i < arr.length; i++) {
            int newStart = arr[i][0];
            int newEnd = arr[i][1];

            if (newStart < currEnd) {
                ans++;
                continue;
            }
            currStart = newStart;
            currEnd = newEnd;
        }

        return ans;
    }

}
