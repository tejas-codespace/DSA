class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        for (int i = 0; i < n.length(); i++) {
            // Convert char to int by subtracting '0'
            int currentDigit = n.charAt(i) - '0';
            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
            }
            // Optimization: if we find 9, we can return immediately
            if (maxDigit == 9) return 9;
        }
        return maxDigit;
    }
}
