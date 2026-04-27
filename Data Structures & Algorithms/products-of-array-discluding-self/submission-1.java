class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arraySize = nums.length;
        int[] result = Arrays.copyOf(nums, arraySize);
        for (int i = 1; i < arraySize; i++) {
            result[i] = result[i - 1] * nums[i];
        }
        int product = 1;
        for (int i = arraySize - 1; i > 0; i--) {
            result[i] = result[i - 1] * product;
            product *= nums[i];
        }
        result[0] = product;
        return result;
    }
}
