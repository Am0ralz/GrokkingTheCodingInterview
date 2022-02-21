package SlidingWindow;

import java.util.HashMap;
//Given a string, find the length of the longest substring in it with no more than K distinct characters.
//
//        Example 1:
//
//        Input: String="araaci", K=2
//        Output: 4
//        Explanation: The longest substring with no more than '2' distinct characters is "araa".
//        Example 2:
//
//        Input: String="araaci", K=1
//        Output: 2
//        Explanation: The longest substring with no more than '1' distinct characters is "aa".
//        Example 3:
//
//        Input: String="cbbebi", K=3
//        Output: 5
//        Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
//        Example 4:
//
//        Input: String="cbbebi", K=10
//        Output: 6
//        Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
public class EX4_FindLongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0)
            throw new IllegalArgumentException();

        int start = 0, longLen = Integer.MIN_VALUE;
        HashMap<Character,Integer> counter = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char nextChar = str.charAt(end);
            counter.put(nextChar, counter.getOrDefault(nextChar,0)+1);
            while(counter.size()> k){

                char firstChar = str.charAt(start);
                //removing the character fromn counter
                counter.put( firstChar, counter.get(firstChar)-1);
                if(counter.get(firstChar)==0){
                    //removes character from counter to make sure it dofirstCharesnt get counted when we call size
                    counter.remove(firstChar);
                }
                start+=1;
            }
            longLen = Math.max(longLen, end - start +1);

        }
    return longLen;

    }
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));
    }
}
