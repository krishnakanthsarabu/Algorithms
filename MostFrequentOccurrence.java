package code.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentOccurrence {
    /*  Most Frequent Occurrence
     *
     *  Time Complexity:
     *  Auxiliary Space Complexity:
     */
    public static char mostFrequentOccurrence(String str) {
      String lowerString = str.toLowerCase();
      Map<Character, Integer> letters = new HashMap<Character, Integer>();
      char mostFrequent = str.charAt(0);
      char currentChar;
      int maxCount = 0;

      for (int i = 0; i < lowerString.length(); i++) {
        currentChar = lowerString.charAt(i);
        if (letters.get(currentChar) != null) {
          letters.put(currentChar, letters.get(currentChar)+1);
        } else {
          letters.put(currentChar, 1);
        }
          if (letters.get(currentChar) > maxCount) {
            mostFrequent = currentChar;
            maxCount = letters.get(currentChar);
          }
      }

    

      return mostFrequent;
    }


    public static void printUnorderedPairs(int[] arr) {
     for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
          System.out.println(arr[i] + "," + arr[j]);
        }
      }
    }

    public static void main(String[] args) {
       // System.out.println(mostFrequentOccurrence("krkuggggggishnka"));
//        int[] arr={1,2,3,4,5};
//       printUnorderedPairs(arr);
        String sentence="d;lkslkfmdfdlkmkdsfp;oo4385430";
        System.out.println(sentence.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase());
        
    }
}
