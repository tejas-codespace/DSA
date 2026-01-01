import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Iterate from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, increment it and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the current digit is 9, set it to 0 and continue to the next digit (carry over)
            digits[i] = 0;
        }
        
        // If we reach here, it means all digits were 9 (e.g., [9,9,9])
        // We need a new array with an extra digit at the beginning
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // Set the first digit to 1
        // Other digits remain 0 (default value for int array)
        return newDigits;
    }
}

// Example Usage (for testing):
// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int[] digits1 = {1, 2, 3};
//         int[] result1 = sol.plusOne(digits1);
//         System.out.println(Arrays.toString(result1)); // Output: [1, 2, 4]

//         int[] digits2 = {4, 3, 2, 1};
//         int[] result2 = sol.plusOne(digits2);
//         System.out.println(Arrays.toString(result2)); // Output: [4, 3, 2, 2]

//         int[] digits3 = {9};
//         int[] result3 = sol.plusOne(digits3);
//         System.out.println(Arrays.toString(result3)); // Output: [1, 0]

//         int[] digits4 = {9, 9};
//         int[] result4 = sol.plusOne(digits4);
//         System.out.println(Arrays.toString(result4)); // Output: [1, 0, 0]
//     }
// }
