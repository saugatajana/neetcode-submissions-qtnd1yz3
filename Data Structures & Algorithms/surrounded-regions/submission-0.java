class Solution {
    int[][] directions = new int[][]{
        {-1,0},{1,0},{0,1},{0,-1}
    };
    char[][] board;
    public void solve(char[][] board) {
        this.board = board;
        //First row
        for(int j=0;j<board[0].length;j++) {
            if(board[0][j] == 'O') {
                dfs(0, j, board, 'O', 'B');
            }
        }
        //last row
        int lastRow = board.length-1;
        for(int j=0;j<board[0].length;j++) {
            if(board[lastRow][j] == 'O') {
                dfs(lastRow, j, board, 'O', 'B');
            }
        }

        //first col
        for(int i=0;i<board.length;i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, board, 'O', 'B');
            }
        }

        //last col
        int lastCol = board[0].length-1;
        for(int i=0;i<board.length;i++) {
            if(board[i][lastCol] == 'O') {
                dfs(i, lastCol, board, 'O', 'B');
            }
        }

        //Check all the other place
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O') {
                    dfs(i, j, board, 'O', 'X');
                }
            }
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, char c, char replaceChar) {
        board[i][j] = replaceChar;
        for(int[] dir : directions) {
            int ni = dir[0] + i;
            int nj = dir[1] + j;
            if(ni>=0 && ni < board.length && nj >=0 && nj < board[0].length && board[ni][nj] == c) {
                dfs(ni, nj, board, c, replaceChar);
            }
        }
    }
}