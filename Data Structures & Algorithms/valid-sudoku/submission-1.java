class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, boolean[]> rows = new HashMap<>();
        HashMap<Integer, boolean[]> cols = new HashMap<>();
        HashMap<Integer, boolean[]> sq = new HashMap<>();
        for (int i = 0; i < 9; i++){
            rows.put(i, new boolean[10]);
            cols.put(i, new boolean[10]);
            sq.put(i, new boolean[10]);
        }
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                // checks if empty space
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                //checks colomns
                if (cols.get(j)[num]) return false;
                cols.get(j)[num] = true;
                // checks rows
                if (rows.get(i)[num]) return false;
                rows.get(i)[num] = true;
                // checks squares, calculation IMPORTANT
                int row = i/3;
                int col = j/3;
                int f = row * 3 + col;
                if (sq.get(f)[num]) return false;
                sq.get(f)[num] = true;
            }
        }
        return true;
    }
}
