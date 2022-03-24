package TwoPointers;

public class EX12_ShortestWindowSort {
//    Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
//            Example 1:
//
//    Input: [1, 2, 5, 3, 7, 10, 9, 12]
//    Output: 5
//    Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
//    Example 2:
//
//    Input: [1, 3, 2, 0, -1, 7, 10]
//    Output: 5
//    Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
//    Example 3:
//
//    Input: [1, 2, 3]
//    Output: 0
//    Explanation: The array is already sorted
//    Example 4:
//
//    Input: [3, 2, 1]
//    Output: 3
//    Explanation: The whole array needs to be sorted.

    public static int sort(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while( start < arr.length-1 && arr[start] <= arr[start+1]  ){
            start++;
        }
        if (start == arr.length-1){
            return 0;
        }
        while( end >0  && arr[end] >= arr[end-1]  ){
            end--;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        while (start > 0 && arr[start-1]> min){
            start--;
        }
        while (end < arr.length -1 && arr[end +1]< max){
            end++;
        }
        return end - start +1;
    }

    public static void main(String[] args) {
        System.out.println(sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(sort(new int[] { 1, 2, 3 }));
        System.out.println(sort(new int[] { 3, 2, 1 }));
    }
}
