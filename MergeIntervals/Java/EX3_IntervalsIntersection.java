package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.
//
//        Example 1:
//
//        Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
//        Output: [2, 3], [5, 6], [7, 7]
//        Explanation: The output list contains the common intervals between the two lists.
//        Example 2:
//
//        Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
//        Output: [5, 7], [9, 10]
//        Explanation: The output list contains the common intervals between the two lists.

public class EX3_IntervalsIntersection {
    public static List<int[]> merge(int [][] arr1, int [][] arr2) {
        List<int[]> results =new ArrayList<>();

      int i = 0;
      int j = 0;
      int a;
      int b;
      while(i < arr1.length && j < arr2.length){
          if(arr1[i][1] > arr2[j][0] && arr1[i][0] <= arr2[j][1]){
            a = Math.max(arr1[i][0],arr2[j][0]);
            b = Math.min(arr1[i][1],arr2[j][1]);
            results.add(new int[]{a, b});
            i++;
          }
          else if(arr1[i][1] < arr2[j][0] ){
              i++;
          }else{
              j++;
          }
      }

    return results;
    }
    public static void main(String[] args) {
        int [][] arr1 = {{1,3}, {5,6}, {7,9}};
        int [][] arr3 ={{2, 3},{5, 7}};
        int [][] arr2 = {{1,3}, {5,7}, {9,12}};
        int [][] arr4 ={{5, 10}};

        System.out.print("Merged intervals: ");
        System.out.println((Arrays.deepToString(merge(arr1, arr3).toArray())));
        System.out.print("Merged intervals: ");
        System.out.println((Arrays.deepToString(merge(arr2, arr4).toArray())));


    }
}
