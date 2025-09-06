class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip processing same elements
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            // use hash set to find pairs that sum to -nums[i]
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -nums[i] - nums[j];
                
                if (seen.contains(complement)) {
                    resultSet.add(Arrays.asList(nums[i], complement, nums[j]));
                }
                
                seen.add(nums[j]);
            }
        }
        
        return new ArrayList<>(resultSet);
    }
}