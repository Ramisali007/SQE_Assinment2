package test;

public class TextProcessor {
 public boolean areAnagrams(String str1, String str2) {
     char[] arr1 = str1.toCharArray();
     char[] arr2 = str2.toCharArray();
     java.util.Arrays.sort(arr1);
     java.util.Arrays.sort(arr2);
     return java.util.Arrays.equals(arr1, arr2);
 }

 public String reverseWords(String sentence) {
     String[] words = sentence.split(" ");
     StringBuilder reversed = new StringBuilder();
     for (int i = words.length - 1; i >= 0; i--) {
         reversed.append(words[i]).append(" ");
     }
     return reversed.toString().trim();
 }
}
