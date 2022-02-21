package SlidingWindow;

import java.util.Arrays;
//Given an array, find the average of all subarrays of ‘K’ contiguous elements in it.
public class EX1_FindAverages {


    //Bruce Force Solution
    //1.	For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
    //2.	The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
    //3.	For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
    //Time complexity: Since for every element of the input array, we are calculating
    // the sum of its next ‘K’ elements, the time complexity of
    // the above algorithm will be O(N*K)O(N∗K) where ‘N’ is the
    // number of elements in the input array.
    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        for (int i = 0; i <= arr.length - K; i++) {
            // find sum of next 'K' elements
            double sum = 0;
            for (int j = i; j < i + K; j++)
                sum += arr[j];
            result[i] = sum / K; // calculate average
        }

        return result;
    }
    //Sliding Window Technique:
    //Step1: We add all the number from 0 - k-1
    //step2: Save the average of the first numbers
    //Step3: Substract the first number
    //Step4: increment Window start so it can keep track of the first number
    //step5: Add the next number in the array
    //Step6: Repeat these steps until we reach the last set of numbers

//    public static double[] findAverages1(int K, int[] arr) {
//        double[] result = new double[arr.length - K + 1];
//        double windowSum = 0;
//        int windowStart = 0;
//        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
//            windowSum += arr[windowEnd]; // add the next element
//            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
//            if (windowEnd >= K - 1) {
//                result[windowStart] = windowSum / K; // calculate the average
//                windowSum -= arr[windowStart]; // subtract the element going out
//                windowStart++; // slide the window ahead
//            }
//        }
//
//        return result;
//    }


    public static void main(String[] args) {
        double[] result = findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }

}
