class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int row = 0; row < board.length; row += 3) {
            for (int col = 0; col < board.length; col += 3) {
                Set<Character> blockNums = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char num = board[i][j];
                        if (num != '.'
                            && !(rows[i].add(num) && cols[j].add(num) 
                            && blockNums.add(num))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
