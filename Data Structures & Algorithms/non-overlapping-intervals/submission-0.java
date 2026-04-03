class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] prevInterval = intervals[0];
        int count = 0;
        for(int i=1;i<intervals.length;i++) {
            int[] currInterval = intervals[i];
            if(currInterval[0] < prevInterval[1]) {
                count++;
            } else {
                prevInterval = currInterval;
            }
        }
        return count;
    }
}