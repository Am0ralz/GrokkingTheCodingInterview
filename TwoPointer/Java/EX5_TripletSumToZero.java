package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

//Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
//
//        Example 1:
//
//        Input: [-3, 0, 1, 2, -1, 1, -2]
//        Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
//        Explanation: There are four unique triplets whose sum is equal to zero.
//        Example 2:
//
//        Input: [-5, 2, -1, -2, 3]
//        Output: [[-5, 2, 3], [-2, -1, 3]]
//        Explanation: There are two unique triplets whose sum is equal to zero.

public class EX5_TripletSumToZero {
//    To follow a similar approach, first, we will sort the array and then iterate through it taking one number at a time.
//    Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X + Y + Z == 0X+Y+Z==0.
//    At this stage, our problem translates into finding a pair whose sum is equal to “-X−X”
//            (as from the above equation Y + Z == -XY+Z==−X).
//
//    Another difference from Pair with Target Sum is that we need to find all the unique triplets. To handle this, we have
//    to skip any duplicate number. Since we will be sorting the array, so all the duplicate numbers will be next to each
//    other and are easier to skip.
    public static ArrayList<ArrayList<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int l = i+1;
            int r = arr.length -1;

            while(l<r){
                if(arr[l] + arr[r] < Math.abs(arr[i])){
                    l++;
                }else if (arr[l] + arr[r] > Math.abs(arr[i])){
                    r--;
                }else{
                    result.add(new ArrayList<>(Arrays.asList(arr[i] , arr[l] ,arr[r]) ));
                        l++;
                        r--;
                        while (arr[l] == arr[l-1]){
                            l++;
                        }
                        while(arr[r] == arr[r+1]){
                            r--;
                        }
                    }
                }
            }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(
                new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
