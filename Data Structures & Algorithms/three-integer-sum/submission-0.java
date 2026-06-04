class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        Set<String> sortedOrder = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                int target = 0 - nums[i] - nums[j];
                for (int k = j + 1; k < size; k++) {
                    if (nums[k] == target) {
                        List<Integer> res = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(res);
                        String key = "";
                        for (int a : res) {
                            key += "#" + a;
                        }
                        if (!sortedOrder.contains(key)) {
                            result.add(res);
                            sortedOrder.add(key);
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }
}
