class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length, x = len / 2, l = 0, r = len - 1;
        while (r - l > 1) {
            int mid = nums[x];
            if (mid == target) {
                return x;
            } else if (mid < target) {
                l = x;
                x = x + ((r - l)/2);
            } else {
                r = x;
                x = x - ((r - l)/2);
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}
