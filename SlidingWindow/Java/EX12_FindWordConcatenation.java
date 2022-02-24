package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EX12_FindWordConcatenation {

    // my solutions similair to previous solutions
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        int match = 0;
        int start =0;
        int len = words[0].length();
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String  , Integer> pattCount = new HashMap<>();
        for (String word: words) {

                pattCount.put(word,pattCount.getOrDefault(word,0)+1);

            }

        for (int end = 0; end < str.length(); end+=len) {
            String nextWord = str.substring(end,end+len);
            pattCount.put(nextWord,pattCount.get(nextWord)-1);

            if (pattCount.get(nextWord)== 0){
                    match += 1;
                }
            if (match == pattCount.size()) {
                result.add(start);
            }
            if(end >= len *( words.length-1)){
                String firstWord = str.substring(start,start+len);
                start += len;
                    if(pattCount.get(firstWord) ==0){
                        match--;
                    }
                    pattCount.put(firstWord,pattCount.get(firstWord)+1);
            }

        }
        return result;
    }
    //Solution found on educative
//    public static List<Integer> findWordConcatenation(String str, String[] words) {
//        Map<String, Integer> wordFrequencyMap = new HashMap<>();
//        for (String word : words)
//            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
//
//        List<Integer> resultIndices = new ArrayList<Integer>();
//        int wordsCount = words.length, wordLength = words[0].length();
//
//        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
//            Map<String, Integer> wordsSeen = new HashMap<>();
//            for (int j = 0; j < wordsCount; j++) {
//                int nextWordIndex = i + j * wordLength;
//                // get the next word from the string
//                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
//                if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
//                    break;
//
//                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map
//
//                // no need to process further if the word has higher frequency than required
//                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
//                    break;
//
//                if (j + 1 == wordsCount) // store index if we have found all the words
//                    resultIndices.add(i);
//            }
//        }
//
//        return resultIndices;
//    }
    public static void main(String[] args) {
        List<Integer> result = findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}
