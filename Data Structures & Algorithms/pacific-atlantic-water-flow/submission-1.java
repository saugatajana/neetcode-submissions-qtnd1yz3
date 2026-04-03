class Solution {
    int[][] directions = new int[][]{
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        //top row 
        for(int j=0;j<n;j++) {
            dfs(0, j, pac, heights);
        }
        

        //left col
        for(int i=0;i<m;i++) {
            dfs(i, 0, pac, heights);
        }

        //bottom row 
        for(int j=0;j<n;j++) {
            dfs(m-1, j, atl, heights);
        }
        

        // right col
        for(int i=0;i<m;i++) {
            dfs(i, n-1, atl, heights);
        }

        //Create the list 
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(pac[i][j] && atl[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;

    }

    private void dfs(int i, int j, boolean[][] visited, int[][] heights) {
        if(visited[i][j]) return;
        visited[i][j] = true;
        for(int[] dir : directions) {
            int ni = dir[0] + i;
            int nj = dir[1] + j;
            if(ni >=0 && ni < heights.length && nj >=0 && nj < heights[0].length && heights[ni][nj] >= heights[i][j]) {
                dfs(ni, nj, visited, heights);
            }
        }

    }
}