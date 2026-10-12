class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '1') continue;
                islands++;
                Deque<int[]> stack = new ArrayDeque<>();
                stack.push(new int[]{i, j});
                grid[i][j] = '0';              // mark visited when pushed
                while (!stack.isEmpty()) {
                    int[] cur = stack.pop();
                    for (int[] d : dirs) {
                        int r = cur[0] + d[0], c = cur[1] + d[1];
                        if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length
                                && grid[r][c] == '1') {
                            grid[r][c] = '0';
                            stack.push(new int[]{r, c});
                        }
                    }
                }
            }
        }
        return islands;
    }
}