import java.util.Arrays;

class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int firstCost = nums[0];
        
        // Extract the remaining elements starting from index 1
        int[] remaining = new int[n - 1];
        for (int i = 1; i < n; i++) {
            remaining[i - 1] = nums[i];
        }
        
        // Sort to find the two smallest values
        Arrays.sort(remaining);
        
        // The result is the first element + the two smallest remaining elements
        return firstCost + remaining[0] + remaining[1];
    }
}

