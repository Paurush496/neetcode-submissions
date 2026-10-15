class Solution {
    static final int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        Set<Integer>[] nodes =
            Stream.generate(HashSet<Integer>::new).limit(ROWS * COLS).toArray(Set[] ::new);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                for (int[] step : moves) {
                    int nr = i + step[0], nc = j + step[1];
                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS)
                        continue;
                    int currNode = i * COLS + j;
                    int newNode = nr * COLS + nc;

                    Set<Integer> currLinks = nodes[currNode];
                    Set<Integer> newLinks = nodes[newNode];

                    if (heights[nr][nc] < heights[i][j]) {
                        nodes[currNode].add(newNode);
                    } else if (heights[nr][nc] == heights[i][j]) {
                        nodes[currNode].add(newNode);
                        nodes[newNode].add(currNode);
                    } else {
                        nodes[newNode].add(currNode);
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            boolean foundPacific = false, foundAtlantic = false;
            boolean[] visited = new boolean[ROWS * COLS];
            ArrayDeque<Integer> dfs = new ArrayDeque<>();
            dfs.push(i);
            visited[i] = true;

            while (!dfs.isEmpty()) {
                int node = dfs.pop();
                int row = node / COLS, col = node % COLS;
                if (row == 0 || col == 0)
                    foundPacific = true;
                if (row == ROWS - 1 || col == COLS - 1)
                    foundAtlantic = true;
                if (foundPacific && foundAtlantic) {
                    result.add(List.of(i / COLS, i % COLS));
                    break;
                }
                for (int next : nodes[node]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        dfs.push(next);
                    }
                }
            }
        }
        return result;
    }
}
