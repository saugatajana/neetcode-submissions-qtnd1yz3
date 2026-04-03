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
        int len = intervals.size();
        int start[] = new int[len];
        int end[] = new int[len];
        for(int i=0;i<len;i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0, e = 0;
        int count = 0, rooms = 0;
        while(s < len) {
            if(start[s] < end[e]) {
                count++;
                s++;
            } else {
                e++;
                count--;
            }
            rooms = Math.max(rooms, count);
        }
        return rooms;
    }
}
