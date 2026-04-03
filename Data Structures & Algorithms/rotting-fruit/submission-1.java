class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][] {
            {-1,0},{1,0},{0,-1},{0,1}
        };
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j] == 1) freshOranges++;
            }
        }
        int minute = 0;
        while(!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            minute++;
            for(int i=0;i<size;i++) {
                int[] curr = queue.poll();
                for(int[] direction : directions) {
                    int ni = curr[0] + direction[0];
                    int nj = curr[1] + direction[1];
                    if(ni >= 0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 1) {
                            grid[ni][nj] = 2;
                            queue.offer(new int[]{ni, nj});
                            freshOranges--;
                    }
                }
            }
        }
        return freshOranges > 0 ? -1 : minute;
    }
}