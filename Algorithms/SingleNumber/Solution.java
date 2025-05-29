package Algorithms.SingleNumber;

public class Solution {

    public int SingleNumber(int[] numbers) {
        int result = 0;
        for (int num:numbers) {
            result ^= num; // 1^1 = 0, 1^3 = 1
        }
        return result;
    }
}
