class Solution {
    static final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenFruits = new LinkedList<>();
        int freshFruits = 0, minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2)
                    rottenFruits.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    freshFruits++;
            }
        }

        while (!rottenFruits.isEmpty()) {
            int rotten = rottenFruits.size();
            boolean rot = false;
            for (int i = rotten; i > 0; i--) {
                int[] rottenFruit = rottenFruits.poll();
                int r = rottenFruit[0], c = rottenFruit[1];
                for (int[] step : move) {
                    int nr = r + step[0], nc = c + step[1];
                    if (nr >= grid.length || nr < 0 || nc >= grid[nr].length || nc < 0 || grid[nr][nc] != 1)
                        continue;
                    rot = true;
                    grid[nr][nc] = 2;
                    rottenFruits.offer(new int[]{nr, nc});
                    freshFruits--;
                }
            }
            if (rot)
                minutes++;
        }
        return freshFruits == 0 ? minutes : -1;
    }
}
