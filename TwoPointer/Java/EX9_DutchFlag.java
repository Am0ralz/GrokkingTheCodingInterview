package TwoPointers;

import java.util.Arrays;
//Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
//
//        The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
//
//        Example 1:
//
//        Input: [1, 0, 2, 1, 0]
//        Output: [0 0 1 1 2]
//        Example 2:
//
//        Input: [2, 2, 0, 1, 2, 0]
//        Output: [0 0 1 2 2 2 ]
public class EX9_DutchFlag {

    public static void sort(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int i = 0;
        while (i <= r){
            if (arr[i] < 1){
                 int temp = arr[l];
                 arr[l] = arr[i];
                 arr[i] = temp;
                 l++;
                 i++;
            }else if( arr[i] > 1){
                int temp = arr[r];
                arr[r] = arr[i];
                arr[i] = temp;
                r--;
            }else{
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
    }

