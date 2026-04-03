class Solution {
    int[][] directions = new int[][]{
            {-1,0}, {1,0}, {0,1}, {0,-1}
    };
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int islands = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j) {
        grid[i][j] = '0';
        for(int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj]=='1') {
                dfs(ni, nj);
            }
        }
    }
}
