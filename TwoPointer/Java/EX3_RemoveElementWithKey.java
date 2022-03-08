package TwoPointers;

import java.util.Arrays;

//Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all
// instances of ‘key’ in-place and return the new length of the array.
//
//        Example 1:
//
//        Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
//        Output: 4
//        Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
//        Example 2:
//
//        Input: [2, 11, 2, 2, 1], Key=2
//        Output: 2
//        Explanation: The first two elements after removing every 'Key' will be [11, 1]
public class EX3_RemoveElementWithKey {
//    My solution when trying to figure it out
//    public static int remove(int[] arr, int key) {
//        int r= 1;
//        int count =0;
//        for (int l = 0; l <arr.length ; l++){
//
//            if (arr[l] == key){
//                count++;
//                if (r < arr.length && arr[r] != key )  {
//                    arr[l] = arr[r];
//                    arr[r] = key;
//                    r++;
//                }
//                while(r < arr.length && arr[r] == key)
//                r++;
//            }
//
//        }
//      return count  ;
//}
//  Two Pointer solution to solving the problem
    public static int remove(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }

        return nextElement;
    }

    public static void main(String[] args) {
        System.out.println(remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3},3));
    }
}
