class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> listIntervals = new ArrayList<>();
        boolean hasInserted = false;
        for (int i = 0; i < intervals.length; i++) {
            int newStart = newInterval[0];
            int newEnd = newInterval[1];
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (hasInserted || newStart > currEnd) {
                listIntervals.add(intervals[i]);
                continue;
            } else {
                if (newEnd < currStart) {
                    listIntervals.add(newInterval);
                    listIntervals.add(intervals[i]);
                } else {
                    int mergedEnd = Math.max(newEnd, currEnd);
                    while (i + 1 < intervals.length && mergedEnd >= intervals[i + 1][0]) {
                        mergedEnd = Math.max(mergedEnd, intervals[++i][1]);
                    }
                    listIntervals.add(new int[]{Math.min(newStart, currStart), mergedEnd});
                }
                hasInserted = true;
            }
        }
        if (!hasInserted) listIntervals.add(newInterval);
        return listIntervals.toArray(new int[listIntervals.size()][]);
    }
}
