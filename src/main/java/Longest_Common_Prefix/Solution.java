package Longest_Common_Prefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder prefix = new StringBuilder();

        int maxPrefixLength = 200;

        if (strs.length == 1) {
            return strs[0];
        }

        try {
            for (int i = 0; i < maxPrefixLength; i++) {
                Character previous = null;
                for (String str :
                        strs) {
                    Character current = str.charAt(i);
                    if (current != previous && previous != null) {
                        return prefix.toString();
                    }
                    previous = current;
                }
                prefix.append(previous);
            }
            return prefix.toString();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return prefix.toString();
        }
    }
}
