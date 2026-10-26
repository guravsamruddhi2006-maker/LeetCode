class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[][] directions = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(i, j, grid, directions);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int i, int j, int[][] grid,
                     int[][] directions) {
        long sum = grid[i][j];
        grid[i][j] = 0;

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < grid.length &&
                nj >= 0 && nj < grid[0].length &&
                grid[ni][nj] > 0) {
                sum += dfs(ni, nj, grid, directions);
            }
        }

        return sum;
    }
}