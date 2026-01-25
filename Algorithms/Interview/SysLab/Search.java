/*
 you are given an
array [gas, gasoline, car, crowd, crowded, crown] and if you search for 
crow you should output crowd, crowded and crown if you search c you 
should output car, crowd, crowded, crown

what data structure will you use to store the array and how will you search it

*/

public class Search {

    // Trie Node definition
    static class TrieNode {
        java.util.Map<Character, TrieNode> children = new java.util.HashMap<>();
        boolean isEndOfWord = false;
    }

    // Trie class
    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.isEndOfWord = true;
        }

        // Find all words with the given prefix
        public java.util.List<String> startsWith(String prefix) {
            java.util.List<String> result = new java.util.ArrayList<>();
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return result;
                }
                node = node.children.get(c);
            }
            collectAllWords(node, new StringBuilder(prefix), result);
            return result;
        }

        // Helper to collect all words from a given node
        private void collectAllWords(TrieNode node, StringBuilder prefix, java.util.List<String> result) {
            if (node.isEndOfWord) {
                result.add(prefix.toString());
            }
            for (java.util.Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                prefix.append(entry.getKey());
                collectAllWords(entry.getValue(), prefix, result);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    // Search using Trie
    public static void searchWithTrie(String[] arr, String prefix) {
        Trie trie = new Trie();
        for (String word : arr) {
            trie.insert(word);
        }
        java.util.List<String> matches = trie.startsWith(prefix);
        for (String match : matches) {
            System.out.println(match);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"gas", "gasoline", "car", "crowd", "crowded", "crown"};
        String prefix1 = "crow";
        String prefix2 = "c";

        System.out.println("Search results for prefix: " + prefix1);
        searchWithTrie(arr, prefix1);

        System.out.println("\nSearch results for prefix: " + prefix2);
        searchWithTrie(arr, prefix2);

        //maximum substring without repeating characters
        String testString = "abcabcbb";
        System.out.println("\nLongest substring without repeating characters in \"" + testString + "\": " + longestSubstringActual(testString));
    }

    public static void suggest(String[] arr, String prefix) {
        for (String i : arr ) {
            if (i.startsWith(prefix)) {
                System.out.println(i);
            }
        }
    }

    /*
     among a subtring given find the lingest substring with no repeating letters using data structures
     using hashset
     1. create a hashset to store characters
        2. iterate through the string and for each character check if it is in the hashset
        3. if it is not in the hashset add it to the hashset and update the max length
        4. if it is in the hashset remove characters from the start of the substring until the repeating character is removed
        5. return the max length
        6. time complexity O(n)
    */
   // not longest lenegth but longest substring using Hashmap



    // longest substring using hashset vs hashmap - 
    //resoan for using hashset is that we only need to know if the character exists in the current window or not.

   public static String longestSubstringActual(String s) {
        int maxLength = 0;
        int left = 0;// to track the start of the current substring
        int start = 0; // to track the starting index of the longest substring
        java.util.HashSet<Character> set = new java.util.HashSet<>(); 

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left; // update starting index
            }
        }
        return s.substring(start, start + maxLength); // return the longest substring
    }
    // difference between using hashmap and hashset is that hashmap stores the index of the character
    // while hashset only stores the character itself
    // with hashmap we can directly jump to the index of the repeating character
    // while with hashset we have to remove characters one by one until the repeating character is removed.
    public static int longestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left); // move left pointer
            }
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    //in an array, after a particular element all proceeding elements are bad versions. How to find the first bad version
    // binary search approach
    public static int firstBadVersion(int n, java.util.function.IntPredicate isBadVersion) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion.test(mid)) {
                right = mid; // first bad version is in the left half
            } else {
                left = mid + 1; // first bad version is in the right half
            }
        }
        return left; // left is the first bad version
    }
    
    
    
}




