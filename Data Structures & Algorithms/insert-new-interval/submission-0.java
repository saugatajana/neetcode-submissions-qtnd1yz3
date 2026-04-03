class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        boolean isInserted = false;
        for(int[] currInterval : intervals) {
            if(!isInserted && newInterval[0] < currInterval[0]) {
                merged.add(newInterval);
                merged.add(currInterval);
                isInserted = true;
            } else {
                merged.add(currInterval);
            }
        }
        if(!isInserted) merged.add(newInterval);

        List<int[]> finalMergedList = new ArrayList<>();
        finalMergedList.add(merged.get(0));
        for(int i=1;i<merged.size();i++) {
            int[] currInterval = merged.get(i);
            int[] prevInterval = finalMergedList.get(finalMergedList.size()-1);
            if(currInterval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            } else {
                finalMergedList.add(currInterval);
            }
        }
        int[][] res = new int[finalMergedList.size()][];
        for(int i=0;i<finalMergedList.size();i++) {
            res[i] = finalMergedList.get(i);
        }
        return res;
    }
}
