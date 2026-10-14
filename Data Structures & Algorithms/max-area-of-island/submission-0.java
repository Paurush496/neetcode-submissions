class Solution {
    static final int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0)
                    continue;
                int island = 0;
                ArrayDeque<int[]> land = new ArrayDeque<>();
                land.push(new int[]{i, j});
                island++;
                grid[i][j] = 0;
                while (!land.isEmpty()) {
                    int[] cell = land.pop();
                    int r = cell[0], c = cell[1];
                    for (int[] STEP : MOVE) {
                        int nr = r + STEP[0], nc = c + STEP[1];
                        if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length && grid[nr][nc] == 1) {
                            land.push(new int[]{nr, nc});
                            island++;
                            grid[nr][nc] = 0;
                        }
                    }
                }
                result = Math.max(result, island);
            }
        }
        return result;
    }
}
