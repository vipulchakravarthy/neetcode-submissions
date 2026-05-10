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
        if (intervals.size() == 0) {
            return 0;
        }
        int n = intervals.size();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        for(int i = 0; i < n; i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int rooms = 0;
        int res = 0;
        int startPointer = 0;
        int endPointer = 0;
        while(startPointer < n) {
            if(startTimes[startPointer] < endTimes[endPointer]) {
                startPointer++;
                rooms++;
            } else {
                endPointer++;
                rooms--;
            }

            res = Math.max(res, rooms);
        }

        return res;
    }
}
