/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int size = intervals.size();
        int[] open = new int[size];
        int[] closed = new int[size];
        for(int i=0;i<size;i++) {
            open[i] = intervals.get(i).start;
            closed[i] = intervals.get(i).end;
        }
        Arrays.sort(open);
        Arrays.sort(closed);
        int count = 0, meetingRooms = 0;
        int start = 0, end = 0;
        while(start < size) {
            if(open[start] < closed[end]) {
                count++;
                start++;
            } else {
                count--;
                end++;
            }
            meetingRooms = Math.max(meetingRooms, count);
        }
        return meetingRooms;
    }
}
