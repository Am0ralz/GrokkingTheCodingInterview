package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EX8_SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        int start = 0;
        int product = 1;
        List<List<Integer>> results = new ArrayList<>();
        for (int end = 0; end < arr.length; end++) {

                product *= arr[end];


            while (product >= target && start < arr.length){
                product /= arr[start];
                start ++;
            }
            List<Integer> tempList = new LinkedList<>();
//    take the newly added number and added to the list then adds the old number ot the list
//     and then add the subarray to the list
            for (int i = end; i >= start; i--) {
                tempList.add(0, arr[i]);
                results.add(new ArrayList<>(tempList));
            }
        }
        return results;

    }



        public static void main(String[] args) {
            System.out.println(
                   findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
            System.out.println(
                    findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
        }

}
