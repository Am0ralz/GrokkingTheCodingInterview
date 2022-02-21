package SlidingWindow;

import java.util.HashMap;

public class EX9_FindStringPermutation {
//    public static boolean findPermutation(String str, String pattern) {
//        // TODO: Write your code here
//        int start = 0;
//        HashMap<Character,Integer> permu = new HashMap<>();
//        HashMap<Character,Integer> counter =new HashMap<>();
//        for (int i = 0; i < pattern.length(); i++) {
//            permu.put(pattern.charAt(i),permu.getOrDefault(pattern.charAt(i),0)+1);
//        }
//        for (int end = 0; end < str.length(); end++) {
//            char nextChar = str.charAt(end);
//            counter.put(nextChar,counter.getOrDefault(nextChar,0)+1);
//            if (end >= pattern.length()-1){
//                if (counter.equals(permu)){
//                    return true;
//                }
//                char firstChar = str.charAt(start);
//                counter.put(firstChar,counter.get(firstChar)-1);
//                if(counter.get(firstChar)==0){
//                    counter.remove(firstChar);
//                }
//                start += 1;
//            }
//
//        }
//        return false;
//    }

    public static boolean findPermutation(String str, String pattern) {
        int start = 0;
        int match = 0;
        HashMap<Character,Integer> permu = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            permu.put(pattern.charAt(i),permu.getOrDefault(pattern.charAt(i),0)+1);
        }
        // our goal is to match all the characters from the 'permu' with the current window
        // try to extend the range [Start, End]
        for (int end = 0; end < str.length(); end++) {
            char nextChar = str.charAt(end);

            if (permu.containsKey(nextChar)) {
                // decrement the frequency of the matched character
                permu.put(nextChar, permu.get(nextChar) - 1);
                if (permu.get(nextChar) == 0) {
                    match += 1;
                }
            }

            if (match == permu.size()){
            return true;}

            if(end >= pattern.length()-1){
                char firstChar = str.charAt(start);

                if(permu.containsKey(firstChar)){
                if(permu.get(firstChar)== 0)  {
                     match --;
                }

                permu.put(firstChar, permu.get(firstChar)+1);
                }
                start += 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
    }
}
