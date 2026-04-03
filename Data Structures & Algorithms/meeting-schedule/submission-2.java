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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        for(int i=1;i<intervals.size();i++) {
            Interval currInterval = intervals.get(i);
            Interval prevInterval = intervals.get(i-1);
            if(currInterval.start < prevInterval.end) return false;
        }
        return true;
    }
}
