class Solution {
    char[][] board;
    String word;
    int wordLen;
    int[][] directions = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        wordLen = word.length();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    boolean exist = dfs(i, j, 0, visited);
                    if(exist) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, boolean[][] visited) {
        if(board[i][j] != word.charAt(index)) return false;
        if(index == wordLen-1) return true;
        visited[i][j] = true;
        for(int[] dir : directions) {
            int ni = dir[0] + i;
            int nj = dir[1] + j;
            if(ni >= 0 && ni < board.length && nj >=0 && nj < board[i].length && !visited[ni][nj]) {
                if(dfs(ni, nj, index+1, visited)) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
