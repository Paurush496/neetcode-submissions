class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int min = 0, max = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
            if (min <= num && num <= max) {
                continue;
            } else if (numSet.contains(num + 1) && num + 1 == min) {
                min = num;
            } else if (numSet.contains(num - 1) && num - 1 == max) {
                max = num;
            }

            int f = num + 1, b = num - 1;
            while (numSet.contains(f) || numSet.contains(b)
                && min != f && max != b) {
                if (numSet.contains(f)) {
                    f++;
                }
                if (numSet.contains(b)) {
                    b--;
                }
            }
            int currLcsLength = f - b - 1;
            if (max - min + 1 <= currLcsLength) {
                max = f - 1;
                min = b + 1;
            }
        }
        return max - min + 1;
    }
}
