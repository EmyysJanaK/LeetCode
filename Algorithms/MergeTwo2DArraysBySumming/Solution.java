package MergeTwo2DArraysBySumming;

public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int maxCol = 0;
        for (int[] num : nums1) {
            maxCol = Math.max(maxCol, num[0]);
        }
        for (int[] num : nums2) {
            maxCol = Math.max(maxCol, num[0]);
        }

        int[][] result = new int[maxCol + 1][2];

        for (int[] num : nums1) {
            result[num[0]][0] = num[0];
            result[num[0]][1] += num[1];
        }

        for (int[] num : nums2) {
            result[num[0]][0] = num[0];
            result[num[0]][1] += num[1];
        }

        int count = 0;
        for (int i = 0; i <= maxCol; i++) {
            if (result[i][1] != 0) {
                count++;
            }
        }

        int[][] merged = new int[count][2];
        int index = 0;
        for (int i = 0; i <= maxCol; i++) {
            if (result[i][1] != 0) {
                merged[index][0] = result[i][0];
                merged[index][1] = result[i][1];
                index++;
            }
        }

        return merged;
    }
}
