import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Step 2: Iterate through the unique numbers and check for their consecutive counterparts
        int maxLen = 0;
        for (int num : counts.keySet()) {
            // Check if 'num + 1' exists in the frequency map
            if (counts.containsKey(num + 1)) {
                // If it exists, the length of the harmonious subsequence
                // using only 'num' and 'num + 1' is the sum of their counts.
                int currentLen = counts.get(num) + counts.get(num + 1);
                // Update the maximum length found so far
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
            }
        }

        // Step 3: Return the final maximum length
        return maxLen;
    }
}
