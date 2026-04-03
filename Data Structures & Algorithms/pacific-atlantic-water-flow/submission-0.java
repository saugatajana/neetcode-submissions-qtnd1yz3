class Solution {
    int[][] directions = new int[][]{
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pac = new HashSet<>();
        Set<String> atl = new HashSet<>();
        //top row 
        for(int j=0;j<heights[0].length;j++) {
            dfs(0, j, pac, heights);
        }
        

        //left col
        for(int i=0;i<heights.length;i++) {
            dfs(i, 0, pac, heights);
        }

        //bottom row 
        for(int j=0;j<heights[0].length;j++) {
            dfs(heights.length-1, j, atl, heights);
        }
        

        // right col
        for(int i=0;i<heights.length;i++) {
            dfs(i, heights[0].length-1, atl, heights);
        }

        //Find the common sets
        Set<String> common = new HashSet<>(pac);
        common.retainAll(atl);

        //Create the list 
        List<List<Integer>> res = new ArrayList<>();
        for(String rc : common) {
            String[] rcArr = rc.split("_");
            int r = Integer.valueOf(rcArr[0]);
            int c = Integer.valueOf(rcArr[1]);
            List<Integer> list = new ArrayList<>();
            list.add(r);
            list.add(c);
            res.add(list);
        }
        return res;

    }

    private void dfs(int i, int j, Set<String> set, int[][] heights) {
        String key = i + "_" + j;
        set.add(key);
        for(int[] dir : directions) {
            int ni = dir[0] + i;
            int nj = dir[1] + j;
            String newKey = ni + "_" + nj;
            if(ni >=0 && ni < heights.length && nj >=0 && nj < heights[0].length && heights[ni][nj] >= heights[i][j] && !set.contains(newKey)) {
                dfs(ni, nj, set, heights);
            }
        }

    }
}