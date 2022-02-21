package SlidingWindow;

import java.util.HashMap;
//Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.
//
//        Example 1:
//
//        Input: String="aabccbb", k=2
//        Output: 5
//        Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
//        Example 2:
//
//        Input: String="abbcb", k=1
//        Output: 4
//        Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
//        Example 3:
//
//        Input: String="abccde", k=1
//        Output: 3
//        Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
public class EX7_FindLongestRepeatSubstringWiCharacterReplace {


//    This problem follows the Sliding Window pattern, and we can use a similar dynamic sliding window strategy as discussed in Longest Substring with Distinct Characters. We can use a HashMap to count the frequency of each letter.
//
//    We will iterate through the string to add one letter at a time in the window.
//    We will also keep track of the count of the maximum repeating letter in any window (let’s call it maxRepeatLetterCount).
//    So, at any time, we know that we do have a window with one letter repeating maxRepeatLetterCount times; this means we should try to replace the remaining letters.
//    If the remaining letters are less than or equal to k, we can replace them all.
//
//    If we have more than k remaining letters, we should shrink the window as we cannot replace more than k letters.
//
//    While shrinking the window, we don’t need to update maxRepeatLetterCount (hence, it represents the maximum repeating count of ANY letter for ANY window). Why don’t we need to update this count when we shrink the window? Since we have to replace all the remaining letters to get the longest substring having the same letter in any window, we can’t get a better answer from any other window even though all occurrences
//    of the letter with frequency maxRepeatLetterCount is not in the current window.

    public static int findLength(String str, int k){
        int start = 0;
        int maxLen = 0;
        int maxRep = 0;
        HashMap<Character,Integer> counter =new HashMap<>();
        for (int end = 0; end <str.length() ; end++) {
            char nextChar = str.charAt(end);
            counter.put(nextChar, counter.getOrDefault(nextChar,0)+1);
            maxRep = Math.max(maxRep,counter.get(nextChar));

            if (end - start +1 - maxRep>k){
                char firstChar = str.charAt(start);
                counter.put(firstChar,counter.get(firstChar)-1);
                start += 1;

            }
        maxLen= Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }
}
