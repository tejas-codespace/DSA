import java.util.*;

class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int row, col;
    private int[][] grid;

    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 0;
    }

    private boolean dfs(int x, int y) {
        if (x == row - 1) return true;
        grid[x][y] = 1;
        for (int[] direction : directions) {
            int newX = x + direction[0], newY = y + direction[1];
            if (isValid(newX, newY) && dfs(newX, newY)) return true;
        }
        return false;
    }

    private boolean canCross(int day, int[][] cells) {
        grid = new int[row][col];
        for (int i = 0; i <= day; ++i) grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        for (int i = 0; i < col; ++i)
            if (grid[0][i] == 0 && dfs(0, i)) return true;
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;
        int left = 0, right = cells.length - 1, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(mid, cells)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result + 1;
    }
}