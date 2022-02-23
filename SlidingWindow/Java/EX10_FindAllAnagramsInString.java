package SlidingWindow;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EX10_FindAllAnagramsInString {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        // TODO: Write your code here
        HashMap<Character,Integer> pattCount = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            pattCount.put(letter, pattCount.getOrDefault(letter, 0) + 1);
        }
        int start= 0;
        int match=0;
        for (int end = 0; end < str.length() ; end++) {
            char nextChar = str.charAt(end);
            if (pattCount.containsKey(nextChar)){
                pattCount.put(nextChar,pattCount.get(nextChar)-1);

                if (pattCount.get(nextChar)==0){
                    match += 1;
                    if (match == pattCount.size()) {
                        resultIndices.add(start);
                    }
                }

            }
            if(end >=pattern.length()-1){
               char firstChar = str.charAt(start);
               start++;

               if (pattCount.containsKey(firstChar)){
                   if (pattCount.get(firstChar)==0){
                       match--;
                   }
               pattCount.put(firstChar,pattCount.get(firstChar)+1);}
            }

        }
        return resultIndices;
    }

    public static void main(String[] args) {
     System.out.println(findStringAnagrams("ppqp", "pq"));
    System.out.println(findStringAnagrams("abbcabc", "abc"));
}
}
