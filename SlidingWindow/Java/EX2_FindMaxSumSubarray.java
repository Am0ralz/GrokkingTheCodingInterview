package SlidingWindow;

import java.util.Arrays;
//Given an array of positive numbers and a positive number ‘k,’
// find the maximum sum of any contiguous subarray of size ‘k’.
//Example 1:
//        Input: [2, 1, 5, 1, 3, 2], k=3
//        Output: 9
//        Explanation: Subarray with maximum sum is [5, 1, 3].
//Example 2:
//
//        Input: [2, 3, 4, 1, 5], k=2
//        Output: 7
//        Explanation: Subarray with maximum sum is [3, 4].
public class EX2_FindMaxSumSubarray {
    //Brute Force Method
    //time complexity will be O(N*K)O(N∗K)
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    //Sliding Window Technique
    //The time complexity of the above algorithm will be O(N)O(N).
    //The algorithm runs in constant space O(1)O(1).
    public static int findMaxSumSubArray1(int k, int[] arr) {
    int ans = Integer.MIN_VALUE;
    int start = 0, sum = 0;
    for (int end = 0; end<arr.length; end++){
        sum += arr[end];
        if(end >= k-1){
            ans = Math.max(sum, ans);
            sum-=arr[start];
            start++;
        }

    }
    return ans;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray1(2, new int[]{2, 3, 4, 1, 5}));
    }
}
