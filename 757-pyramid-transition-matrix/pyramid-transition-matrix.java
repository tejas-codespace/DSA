class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> transitions = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            transitions.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom, transitions);
    }

    private boolean solve(String currentRow, Map<String, List<Character>> transitions) {
        if (currentRow.length() == 1) {
            return true;
        }

        List<String> nextRows = new ArrayList<>();
        generateNextRows(currentRow, 0, new StringBuilder(), nextRows, transitions);

        for (String nextRow : nextRows) {
            if (solve(nextRow, transitions)) {
                return true;
            }
        }

        return false;
    }

    private void generateNextRows(String currentRow, int index, StringBuilder nextRowBuilder, List<String> nextRows, Map<String, List<Character>> transitions) {
        if (index == currentRow.length() - 1) {
            nextRows.add(nextRowBuilder.toString());
            return;
        }

        String key = currentRow.substring(index, index + 2);
        if (!transitions.containsKey(key)) {
            return; // This path is a dead end
        }

        for (char c : transitions.get(key)) {
            nextRowBuilder.append(c);
            generateNextRows(currentRow, index + 1, nextRowBuilder, nextRows, transitions);
            nextRowBuilder.deleteCharAt(nextRowBuilder.length() - 1); // Backtrack
        }
    }
}