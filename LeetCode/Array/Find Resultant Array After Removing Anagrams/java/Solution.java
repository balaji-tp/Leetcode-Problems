import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevSorted = "";

        for (String word : words) {
            // Sort the current word
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sortedWord = new String(arr);

            // If it's not an anagram of the previous word, keep it
            if (!sortedWord.equals(prevSorted)) {
                result.add(word);
                prevSorted = sortedWord;
            }
        }
        return result;
    }
}
