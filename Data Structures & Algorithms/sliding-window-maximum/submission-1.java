class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int result[] = new int[nums.length - k + 1];
        PriorityQueue<Integer> q = new PriorityQueue(k, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                result[i - k] = q.peek();
                q.remove(nums[i - k]);
            }
            q.add(nums[i]);
        }
        result[nums.length - k] = q.peek();
        return result;
    }
}
