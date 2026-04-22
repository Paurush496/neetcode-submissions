class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numLookup = new HashMap<>();
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            int difference = target - nums[i];
            Integer value = numLookup.get(difference);
            if (value != null) {
                if (i < value) {
                    result[0] = i;
                    result[1] = value;
                } else {
                    result[0] = value;
                    result[1] = i;
                }
                break;
            } else {
                numLookup.putIfAbsent(nums[i], i);
            }
        }
        return result;
    }
}
