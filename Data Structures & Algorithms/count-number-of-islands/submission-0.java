class Solution {
    int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    char[][] grid;
    
    public int numIslands(char[][] grid) {
        int islands = 0;
        this.grid = grid;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int i, int j) {
        grid[i][j] = '0';
        for(int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[i].length && grid[newRow][newCol] == '1') {
                dfs(newRow, newCol);
            } 
        }
    }
}
