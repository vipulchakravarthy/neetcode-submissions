class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;

        for(int j = 1; j < intervals.length; j++) {
            if(intervals[i][1] >= intervals[j][0]) {
                intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                i++;
                intervals[i] = intervals[j];
            }
        }

        return Arrays.copyOf(intervals, i+1);
    }
}
