package MergeIntervals;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
//Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
//
//        Example 1:
//
//        Intervals: [[1,4], [2,5], [7,9]]
//        Output: [[1,5], [7,9]]
//        Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
//        one [1,5].
public class EX1_MergeIntervals {
        // this solution was from leetcode. I find this was easier to understand and more relocatable
        // to interview questions
        public static int[][] merge(int[][] intervals) {
            //here we are sorting by the first number in the interval
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            // create linked list to keep track of the merged intervals
            LinkedList<int[]> merged = new LinkedList<>();
            for (int[] interval : intervals) {
                // if the list of merged intervals is empty or if the current
                // interval does not overlap with the previous, simply append it.
                if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                    merged.add(interval);
                }
                // otherwise, there is overlap, so we merge the current and previous
                // intervals.
                else {
                    // we increased the interval if the last number in the previous interval is less than the last
                    // number in the new overlapping interval
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                }
            }
            // we convert the linked list in to an array with a set size
            return merged.toArray(new int[merged.size()][]);
        }

        // this is the solution from design gurus. I dont quiet like it since most interviews would have you starting
    // from a basic array
//    public static List<Interval> merge(List<Interval> intervals) {
//        if (intervals.size() < 2)
//            return intervals;
//
//        // sort the intervals by start time
//        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
//
//        List<Interval> mergedIntervals = new LinkedList<Interval>();
//        Iterator<Interval> intervalItr = intervals.iterator();
//        Interval interval = intervalItr.next();
//        int start = interval.start;
//        int end = interval.end;
//
//        while (intervalItr.hasNext()) {
//            interval = intervalItr.next();
//            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
//                end = Math.max(interval.end, end);
//            } else { // non-overlapping interval, add the previous interval and reset
//                mergedIntervals.add(new Interval(start, end));
//                start = interval.start;
//                end = interval.end;
//            }
//        }
//        // add the last interval
//        mergedIntervals.add(new Interval(start, end));
//
//        return mergedIntervals;
//    }

    public static void main(String[] args) {
            int [][] arr1 = {{1,4}, {2,5}, {7,9}};
            int [][] arr2 = {{6,7}, {2,4}, {5,9}};
            int [][] arr3 = {{1,4}, {2,6}, {3,5}};
        System.out.print("Merged intervals: ");
        System.out.println((Arrays.deepToString(merge(arr1))));
        System.out.print("Merged intervals: ");
        System.out.println((Arrays.deepToString(merge(arr2))));
        System.out.print("Merged intervals: ");
        System.out.println((Arrays.deepToString(merge(arr3))));

    }
}
