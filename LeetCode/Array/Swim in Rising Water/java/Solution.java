import java.util.*;

class Solution {
    static class Cell implements Comparable<Cell> {
        int r, c, cost;
        Cell(int r, int c, int cost) { this.r = r; this.c = c; this.cost = cost; }
        public int compareTo(Cell o) { return Integer.compare(this.cost, o.cost); }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        boolean[][] seen = new boolean[n][n];
        pq.offer(new Cell(0, 0, grid[0][0]));
        
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int r = cur.r, c = cur.c, cost = cur.cost;
            if (seen[r][c]) continue;
            seen[r][c] = true;
            if (r == n - 1 && c == n - 1) return cost; 
            
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (seen[nr][nc]) continue;
                int newCost = Math.max(cost, grid[nr][nc]);
                pq.offer(new Cell(nr, nc, newCost));
            }
        }
        return -1; 
    }
}

    
