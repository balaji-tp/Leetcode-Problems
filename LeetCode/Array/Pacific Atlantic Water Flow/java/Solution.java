import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        
        for (int c = 0; c < n; c++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, c);
            dfs(heights, atlantic, Integer.MIN_VALUE, m - 1, c);
        }
        for (int r = 0; r < m; r++) {
            dfs(heights, pacific, Integer.MIN_VALUE, r, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, r, n - 1);
        }

        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int prevHeight, int r, int c) {
        int m = heights.length, n = heights[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return;  

        visited[r][c] = true;

        
        dfs(heights, visited, heights[r][c], r + 1, c);
        dfs(heights, visited, heights[r][c], r - 1, c);
        dfs(heights, visited, heights[r][c], r, c + 1);
        dfs(heights, visited, heights[r][c], r, c - 1);
    }
}
