import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        // Calculate the remainder of the total sum when divided by p
        // Use long to prevent overflow during sum calculation if needed,
        // but intermediate sums modulo p will fit in int.
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int remainder = (int) (totalSum % p);

        // If the total sum is already divisible by p, no removal needed.
        if (remainder == 0) {
            return 0;
        }

        // Use a hash map to store the first occurrence of each prefix sum remainder.
        // Key: current prefix sum remainder modulo p
        // Value: index where that remainder was last seen
        Map<Integer, Integer> prefixMap = new HashMap<>();
        // Initialize the map with a prefix sum of 0 at index -1.
        prefixMap.put(0, -1);

        int currentRemainder = 0;
        int minLen = nums.length; // Initialize min length to maximum possible length

        for (int i = 0; i < nums.length; i++) {
            currentRemainder = (currentRemainder + nums[i]) % p;
            
            // We are looking for a prefix that, when removed (by finding a previous 
            // prefix with a specific remainder), leaves a total sum divisible by p.
            // Specifically, we need to find a previous prefix with remainder `targetRemainder`.
            int targetRemainder = (currentRemainder - remainder + p) % p;

            if (prefixMap.containsKey(targetRemainder)) {
                // We found a matching prefix. The length of the subarray between 
                // the previous index and the current index is a candidate for removal.
                int currentSubarrayLength = i - prefixMap.get(targetRemainder);
                minLen = Math.min(minLen, currentSubarrayLength);
            }

            // Update the map with the current prefix remainder and its index.
            prefixMap.put(currentRemainder, i);
        }

        // If minLen is the length of the entire array, it means we must 
        // remove the whole array to satisfy the condition, which is not allowed.
        if (minLen == nums.length) {
            return -1;
        }

        return minLen;
    }
}
