class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;
        
        List<String> substrings = new ArrayList<>();
        int count = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            
            if (count == 0) {
                // Recursively process the inner part of the special string
                substrings.add("1" + makeLargestSpecial(s.substring(start + 1, i)) + "0");
                start = i + 1;
            }
        }
        
        // Sort substrings in descending order to get lexicographically largest
        Collections.sort(substrings, Collections.reverseOrder());
        
        StringBuilder result = new StringBuilder();
        for (String sub : substrings) {
            result.append(sub);
        }
        
        return result.toString();
    }
}
