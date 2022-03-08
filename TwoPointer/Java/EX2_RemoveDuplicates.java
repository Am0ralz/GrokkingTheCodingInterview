package TwoPointers;
//Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
//
//        Example 1:
//
//        Input: [2, 3, 3, 3, 6, 9, 9]
//        Output: 4
//        Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
//        Example 2:
//
//        Input: [2, 2, 2, 11]
//        Output: 2
//        Explanation: The first two elements after removing the duplicates will be [2, 11].
public class EX2_RemoveDuplicates {
    public static int remove(int[] arr){
        // is the right number and keep track of the last number that not a duplicate.
        int nextNonDuplicate = 1;

        for (int right = 1; right < arr.length; right++) {

            if(arr[nextNonDuplicate -1] != arr[right]){
                arr[nextNonDuplicate] = arr[right];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(remove(arr));
    }
}
