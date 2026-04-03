class Solution {
    int[][] directions = new int[][]{
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int maxArea = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, 1));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int count) {
        grid[i][j] = 0;
        int area = 1;
        for(int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1) {
                area += dfs(ni, nj, area+1);
            }
        }
        return area;
    }
}
