package TwoPointers;
//Problem Statement
//
//        Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
//
//        Example 1:
//
//        Input: [-2, -1, 0, 2, 3]
//        Output: [0, 1, 4, 4, 9]
//        Example 2:
//
//        Input: [-3, -1, 0, 1, 2]
//        Output: [0, 1, 1, 4, 9]
public class EX4_SortArraySquares {
//    Since the numbers at both ends can give us the largest square,
//    an alternate approach could be to use two pointers starting
//    at both ends of the input array. At any step, whichever
//    pointer gives us the bigger square, we add it to the result
//    array and move to the next/previous number according to the pointer.
    public static int[] makeSquares(int[] arr) {
        int l=0;
        int r = arr.length-1;
        int index = r;
        int [] result= new int[arr.length];
        while (l<r){
            if(Math.pow(arr[l],2 ) < Math.pow(arr[r],2)){
                result[index] = (int) Math.pow(arr[r],2);
                r--;
            }else{
                result[index] = (int) Math.pow(arr[l],2);
                l++;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
