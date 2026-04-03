class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort( intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int i=1;i<intervals.length;i++) {
            int[] curr = intervals[i];
            int[] prev = merged.get(merged.size()-1);
            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                merged.add(curr);
            }
        }
        int[][] res = new int[merged.size()][2];
        for(int i=0;i<merged.size();i++) {
            res[i] = new int[]{merged.get(i)[0], merged.get(i)[1]};
        } 
        return res;
    }
}
