package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
//
//        Example 1:
//
//        Input: [4, 1, 2, -1, 1, -3], target=1
//        Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
//        Explanation: Both the quadruplets add up to the target.
//        Example 2:
//
//        Input: [2, 0, -1, 1, -2, 2], target=2
//        Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
//        Explanation: Both the quadruplets add up to the target.
public class EX10_QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < arr.length-3; i++) {
            for (int j = i+1; j < arr.length-2; j++) {
                int left = j+1;
                int right = arr.length -1;
                while (left < right){

                    if(arr[i] + arr[j] + arr[left] + arr[right] <target){
                        left++;
                    }else if (arr[i] + arr[j] + arr[left] + arr[right] >target){
                        right--;
                    }else{
                        results.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                        left ++;
                        right --;
                        while(left < right && arr[left] == arr[left -1]){
                            left++;
                        }
                        while(left < right && arr[right] == arr[right +1]){
                            right--;
                        }
                    }

                }
            }
        }
        return results;
    }
    public static void main(String[] args) {
        System.out.println(
                searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(
               searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
