package MergeIntervals;

import java.util.Arrays;
import java.util.LinkedList;
//Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
//
//        Example 1:
//
//        Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
//        Output: [[1,3], [4,7], [8,12]]
//        Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
//        Example 2:
//
//        Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
//        Output: [[1,3], [4,12]]
//        Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
//        Example 3:
//
//        Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
//        Output: [[1,4], [5,7]]
//        Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
public class EX2_InsertInterval {
//    public static int[][] merge(int[][] intervals, int [] newInterval) {
//        LinkedList<int[]> merged = new LinkedList<>();
//        int i = 0;
//        while(newInterval[0]> intervals[i][1] ){
//            merged.add(intervals[i]);
//            i++;
//        }
//        if (! (newInterval[1] < intervals[i][0])){
//            if (newInterval[0] > intervals[i][0]){
//                newInterval[0] = intervals[i][0];
//            }
//            if(newInterval[1] < intervals[i][1])
//                newInterval[1] = intervals[i][1];
//        }
//        merged.add(newInterval);
//        i++;
//        while( i< intervals.length){
//            // if the list of merged intervals is empty or if the current
//            // interval does not overlap with the previous, simply append it.
//            if ( merged.getLast()[1] < intervals[i][0]) {
//                merged.add(intervals[i]);
//            }
//            // otherwise, there is overlap, so we merge the current and previous
//            // intervals.
//            else {
//                // we increased the interval if the last number in the previous interval is less than the last
//                // number in the new overlapping interval
//                merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
//            }
//            i++;
//        }
//        return merged.toArray(new int[merged.size()][]);
//    }
    // the solution from design gurus
public static int[][] merge(int[][] intervals, int [] newInterval) {
    LinkedList<int[]> merged = new LinkedList<>();
        int i = 0;
        while(i < intervals.length && newInterval[0]> intervals[i][1] ){
            merged.add(intervals[i]);
            i++;
        }
    while(i < intervals.length && intervals[i][0]  <= newInterval[1] ) {
        newInterval[0] =Math.min(newInterval[0],intervals[i][0]);
        newInterval[1] =Math.max(newInterval[1],intervals[i][1]);
        i++;
    }
    // insert the newInterval
    merged.add(newInterval);
    while( i< intervals.length){
        merged.add(intervals[i]);
        i++;
    }
    return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {
        int [][] arr1 = {{1,3}, {5,7}, {8,12}};
        int [][] arr2 = {{1,3}, {5,7}, {8,12}};
        int [][] arr3 = {{1,3}, {5,7}};
        System.out.print("Merged intervals: ");
        System.out.println((Arrays.deepToString(merge(arr1, new int[]{4, 6}))));
        System.out.print("Merged intervals: ");
        System.out.println((Arrays.deepToString(merge(arr2, new int[]{4, 10}))));
        System.out.print("Merged intervals: ");
        System.out.println((Arrays.deepToString(merge(arr3, new int[]{1, 4}))));

    }
    }

