class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int leftMax = 0, rightMax = len - 1;

        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        leftSum[0] = nums[0];
        rightSum[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            int j = len - i - 1;
            int leftS = leftSum[i - 1];
            int rightS = rightSum[j + 1];
            leftSum[i] = leftS + nums[i];
            rightSum[j] = rightS + nums[j];
            if (leftSum[i] >= leftSum[leftMax]) {
                leftMax = i;
            }
            if (rightSum[j] >= rightSum[rightMax]) {
                rightMax = j;
            }
        }
        int leftMaxSum = leftSum[leftMax];
        int rightMaxSum = rightSum[rightMax];
        for (int i = leftMax - 1; i >= 0; i--) {
            int a = leftSum[i], b = leftSum[i + 1];
            if (a < 0) {
                leftMaxSum = Math.max(leftMaxSum, leftSum[leftMax] - a);
            }
        }
        for (int i = rightMax + 1; i < len; i++) {
            int a = rightSum[i], b = rightSum[i - 1];
            if (a < 0) {
                rightMaxSum = Math.max(rightMaxSum, rightSum[rightMax] - a);
            }
        }
        return Math.max(leftMaxSum, rightMaxSum);
    }
}
