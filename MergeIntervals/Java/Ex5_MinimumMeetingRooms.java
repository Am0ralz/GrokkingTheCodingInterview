package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
//Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
//
//        Example 1:
//
//        Meetings: [[1,4], [2,5], [7,9]]
//        Output: 2
//        Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
//        occur in any of the two rooms later.
//        Example 2:
//
//        Meetings: [[6,7], [2,4], [8,12]]
//        Output: 1
//        Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
//        Example 3:
//
//        Meetings: [[1,4], [2,3], [3,6]]
//        Output:2
//        Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
//        hold all the meetings.
//
//        Example 4:
//
//        Meetings: [[4,5], [2,3], [2,4], [3,5]]
//        Output: 2
//        Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].

public class Ex5_MinimumMeetingRooms {
    //my solution using sliding window
    public static int findMinimumMeetingRooms(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(meetings));
        int count = 1;
        int result= 1;
        int start = 0;
        for (int end = 1; end < meetings.length  ; end++) {
            if (meetings[end][0] < meetings[end-1][1]){
                count++;
            }else{
                count =1;
            }
            while(count > 2 && meetings[start][1] <= meetings[end][0] ){
                    count --;
                    start ++;
                }
            result = Math.max(count,result);
            }

        return result;
    }


    public static void main(String[] args) {
        int [][] arr1 = {{1,4}, {2,5}, {7,9}};
        int [][] arr2 = {{6,7}, {2,4}, {8,12}};
        int [][] arr3 = {{1,4}, {2,3},{3,6}};
        int [][] arr4 = {{4,5}, {2,3},{2,4},{3,5}};
        System.out.println(findMinimumMeetingRooms(arr1));
        System.out.println(findMinimumMeetingRooms(arr2));
        System.out.println(findMinimumMeetingRooms(arr3));
        System.out.println(findMinimumMeetingRooms(arr4));
    }
}
