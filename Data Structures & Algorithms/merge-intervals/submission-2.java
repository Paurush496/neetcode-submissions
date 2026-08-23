class Solution {
    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> longest = new HashMap<>();
        List<Integer[]> result = new ArrayList<>();
        int min = intervals[0][0], max = intervals[0][1];
        
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (end == 0) {
                    result.add(new Integer[]{0, 0});
                    continue;
            }
            longest.put(start, Math.max(longest.getOrDefault(start, 0), end));
            if (start < min)
                min = start;
            if (end > max)
                max = end;
        }
        
        int[] currInterval = new int[2];
        for (int i = min; i <= max; i++) {
            if (longest.containsKey(i)) {
                if (i > currInterval[1]) {
                    if (currInterval[1] != 0) {
                    result.add(new Integer[]{currInterval[0], currInterval[1]});
                    }
                    currInterval[0] = i;
                    currInterval[1] = longest.get(i);
                } else if (longest.get(i) > currInterval[1])
                    currInterval[1] = longest.get(i);
            }
        }
        result.add(new Integer[]{currInterval[0], currInterval[1]});
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            Integer[] in = result.get(i);
            res[i] = new int[]{in[0], in[1]};
        }
        return res;
    }
}
