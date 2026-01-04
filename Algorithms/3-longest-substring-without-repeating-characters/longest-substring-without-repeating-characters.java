import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0; 
        int[] charIndexArray = new int[128]; // ASCII character set

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            left = Math.max(left, charIndexArray[currentChar]);
            charIndexArray[currentChar] = right + 1; 
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}