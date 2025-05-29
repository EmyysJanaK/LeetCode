package Algorithms.LongestCommonPrefix;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"flower", "flow", "float"}; 
        String longestPrefix = solution.longestCommanPrefix(strings);
        System.out.println("The longest common prefix is: " + longestPrefix);
    }
}
