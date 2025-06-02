package Algorithms.ValidParanthesis;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String test1 = "()";
        String test2 = "([{}])";
        String test3 = "([)]"; 
     

        System.out.println(solution.isValid(test1));
        System.out.println(solution.isValid(test3));
    }
}
