package Algorithms.SingleNumber;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] numbers = {4, 1, 2, 1, 2};
        System.out.println("Single number is: " + solution.SingleNumber(numbers));
        
        int[] numbers2 = {2, 2, 1};
        System.out.println("Single number is: " + solution.SingleNumber(numbers2));
    }
}
