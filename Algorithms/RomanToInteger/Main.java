package Algorithms.RomanToInteger;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String romanNumeral = "IV"; // Example Roman numeral
        int integerValue = solution.romanToInt(romanNumeral);
        System.out.println("The integer value of " + romanNumeral + " is: " + integerValue);
    }
}
