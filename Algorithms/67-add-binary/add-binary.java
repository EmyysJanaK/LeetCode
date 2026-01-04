import java.math.BigInteger;
// simple solution using BigInteger class

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1; 
        int j = b.length() - 1; 
        int carry = 0; 

        while (i >= 0 || j >= 0 || carry > 0) { 
            int sum = carry; //
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}

// best optimized solution

class Solution1 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); 
        int i = a.length() - 1; // pointer for string a
        int j = b.length() - 1; // pointer for string b
        int carry = 0; 

        /*
            
        */
        while (i >= 0 || j >= 0 || carry > 0) { 
            int sum = carry; //
            if (i >= 0) {
                sum += a.charAt(i) - '0';// converting char to int minus ascii value of '0'
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';// converting char to int minus ascii value of '0'
                j--;
            }
            result.append(sum % 2); //
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}

/*
3. Longest Substring Without Repeating Characters - solution using sliding window technique optimized
Given a string s, find the length of the longest substring without repeating characters.

*/

// optimized solution using sliding window technique

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0; 
        java.util.Map<Character, Integer> charIndexMap = new java.util.HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

//sliding window technique optimized

class Solution3 {
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



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; 
            } else {
                current = current.next; 
            }
        }

        return head;
        
    }
}