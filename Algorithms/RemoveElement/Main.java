package Algorithms.RemoveElement;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] numbers = {3, 2, 2, 3};
        int val = 3;
        int newLength = solution.removeElement(numbers, val);
        
        System.out.println("New length after removing " + val + ": " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
