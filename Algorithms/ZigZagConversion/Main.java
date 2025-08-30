public class Main {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1 (Original)
        testZigZagConversion(solution, "PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        
        // Test case 2 (Different number of rows)
        testZigZagConversion(solution, "PAYPALISHIRING", 4, "PINALSIGYAHRPI");
        
        // Test case 3 (Single row)
        testZigZagConversion(solution, "PAYPALISHIRING", 1, "PAYPALISHIRING");
        
        // Test case 4 (Your new test case)
        testZigZagConversion(solution, "ABCDEFGHIJKLMN", 5, "AIBHJCGKDFLNEM");
    }
    
    private static void testZigZagConversion(Solution solution, String input, int numRows, String expected) {
        String result = solution.convert(input, numRows);
        boolean passed = result.equals(expected);
        System.out.println("Test with \"" + input + "\" and " + numRows + " rows:");
        System.out.println("Result: " + result);
        System.out.println("Expected: " + expected);
        System.out.println("Test " + (passed ? "PASSED" : "FAILED") + "\n");
    }
}
