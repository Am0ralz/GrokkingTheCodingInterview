package SlidingWindow;

import java.util.HashMap;

public class EX11_MinimumWindowpatternSubstring {
//    Given a string and a pattern, find the smallest substring in the given string which has all the character occurrences of the given pattern.
//
//   Example 1:
//    Input: String="aabdec", Pattern="abc"
//    Output: "abdec"
//    Explanation: The smallest substring having all characters of the pattern is "abdec"
//    Example 2:
//
//    Input: String="aabdec", Pattern="abac"
//    Output: "aabdec"
//    Explanation: The smallest substring having all character occurrences of the pattern is "aabdec"
//    Example 3:
//
//    Input: String="abdbca", Pattern="abc"
//    Output: "bca"
//    Explanation: The smallest substring having all characters of the pattern is "bca".
//    Example 4:
//
//    Input: String="adcad", Pattern="abc"
//    Output: ""
//    Explanation: No substring in the given string has all characters of the pattern.
public static String findSubstring(String str, String pattern) {
    HashMap<Character,Integer> pattCount =new HashMap<>();
    int start = 0;
    int match = 0;
    int rstart =0;
    int rend =0;
    //could have used length +1
    int max = Integer.MAX_VALUE;

    for (int i = 0; i < pattern.length(); i++) {
        char letter = pattern.charAt(i);
        pattCount.put(letter,pattCount.getOrDefault(letter,0)+1);

    }
    for (int end = 0; end < str.length(); end++) {
        char nextChar = str.charAt(end);
        if (pattCount.containsKey(nextChar)){
            pattCount.put(nextChar,pattCount.get(nextChar)-1);
            if (pattCount.get(nextChar)==0){
                match +=1;
            }
        }
           while (match == pattCount.size()){
              // could have use the max to get the end point for the substring
                if (max >  end - start +1){
                    max = end - start +1;
                    rend = end;
                    rstart = start;
                }
                char firstChar = str.charAt(start);
                start += 1;
                if (pattCount.containsKey(firstChar)){
                    if(pattCount.get(firstChar)== 0){
                        match--;
                    }
                    pattCount.put(firstChar, pattCount.get(firstChar)+1);

               }
           }


    }
    return max == Integer.MAX_VALUE? "":str.substring(rstart,rend+1);
}
//public static String findSubstring(String str, String pattern) {
//    int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
//    Map<Character, Integer> charFrequencyMap = new HashMap<>();
//    for (char chr : pattern.toCharArray())
//        charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
//
//    // try to extend the range [windowStart, windowEnd]
//    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
//        char rightChar = str.charAt(windowEnd);
//        if (charFrequencyMap.containsKey(rightChar)) {
//            charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
//            if (charFrequencyMap.get(rightChar) >= 0) // count every matching of a character
//                matched++;
//        }
//
//        // shrink the window if we can, finish as soon as we remove a matched character
//        while (matched == pattern.length()) {
//            if (minLength > windowEnd - windowStart + 1) {
//                minLength = windowEnd - windowStart + 1;
//                subStrStart = windowStart;
//            }
//
//            char leftChar = str.charAt(windowStart++);
//            if (charFrequencyMap.containsKey(leftChar)) {
//                // note that we could have redundant matching characters, therefore we'll decrement the
//                // matched count only when a useful occurrence of a matched character is going out of the window
//                if (charFrequencyMap.get(leftChar) == 0)
//                    matched--;
//                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
//            }
//        }
//    }
//
//    return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
//}
    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("aabdec", "abac"));
        System.out.println(findSubstring("abdbca", "abc"));
        System.out.println(findSubstring("adcad", "abc"));
    }
}
