class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int totalY = 0; // Count of 'Y's in the entire string
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                totalY++;
            }
        }

        int minPenalty = totalY; // Initial penalty for closing at hour 0 (all 'Y's count)
        int bestHour = 0;         // Hour 0 gives initial minPenalty
        int currentPenalty = totalY; // Penalty if closed at hour 0

        // Iterate from hour 1 to n (potential closing points)
        for (int j = 1; j <= n; j++) {
            // Update penalty based on the character at the previous hour (j-1)
            if (customers.charAt(j - 1) == 'Y') {
                // If 'Y' at j-1: Customers were present (before j), now shop is closed there (no penalty for 'Y' after j).
                // Penalty decreases by 1.
                currentPenalty--;
            } else { // customers.charAt(j-1) == 'N'
                // If 'N' at j-1: No customers (before j), shop was open (no penalty). Now shop is closed at j-1, so this 'N' adds 1 to penalty.
                // Penalty increases by 1.
                currentPenalty++;
            }

            // Check if this new penalty is the minimum found so far
            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                bestHour = j; // Found a new minimum, record this hour
            }
        }

        return bestHour;
    }
}
