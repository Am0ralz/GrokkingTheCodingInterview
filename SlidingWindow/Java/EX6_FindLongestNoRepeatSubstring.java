package SlidingWindow;

import java.util.HashMap;
//Given a string, find the length of the longest substring, which has all distinct characters.
//
//        Example 1:
//
//        Input: String="aabccbb"
//        Output: 3
//        Explanation: The longest substring with distinct characters is "abc".
//        Example 2:
//
//        Input: String="abbbb"
//        Output: 2
//        Explanation: The longest substring with distinct characters is "ab".
//        Example 3:
//
//        Input: String="abccde"
//        Output: 3
//        Explanation: Longest substrings with distinct characters are "abc" & "cde".
public class EX6_FindLongestNoRepeatSubstring {

    public static int findLength(String str) {
        int start = 0;
        int maxLen = 0;
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char nextChar = str.charAt(end);
            counter.put(nextChar, counter.getOrDefault(nextChar,0)+1);
            while (counter.get(nextChar) >1){
                char firstChar = str.charAt(start);
                counter.put(firstChar,counter.get(firstChar)-1);
                if(counter.get(firstChar) ==0 ){
                    counter.remove(firstChar);
                }
                start += 1;
            }
            maxLen = Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + findLength("abbbb"));
        System.out.println("Length of the longest substring: " + findLength("abccde"));
    }
}
