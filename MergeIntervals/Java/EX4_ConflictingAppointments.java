package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class EX4_ConflictingAppointments {
    public static boolean canAttendAllAppointments(int[][] intervals) {
        //here we are sorting by the first number in the interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length -1 ; i++) {
            if (intervals[i][1] > intervals[i+1][0]){
            return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [][] arr1 = {{1,4}, {2,5}, {7,9}};
        int [][] arr2 = {{6,7}, {2,4}, {8,12}};
        int [][] arr3 = {{4,5}, {2,3},{3,6}};

        System.out.println(canAttendAllAppointments(arr1));
        System.out.println(canAttendAllAppointments(arr2));
        System.out.println(canAttendAllAppointments(arr3));
    }
}
