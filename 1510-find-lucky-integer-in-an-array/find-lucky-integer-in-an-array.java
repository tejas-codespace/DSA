class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];  // arr[i] ≤ 500
        
        for (int num : arr) {
            freq[num]++;
        }
        
        int ans = -1;
        for (int i = 1; i <= 500; i++) {
            if (freq[i] == i) {
                ans = i;  // keep the largest lucky integer
            }
        }
        
        return ans;
    }
}

