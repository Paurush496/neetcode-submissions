class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int helfTarget = target / 2, halfTargetIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > helfTarget) {
                halfTargetIndex = i;
                break;
            }
        }
        int f = halfTargetIndex, j = Math.max(0, halfTargetIndex - 1);
        while (f < numbers.length && j >= 0) {
            int sum = numbers[f] + numbers[j];
            if (sum == target) {
                result[0] = j + 1;
                result[1] = f + 1;
                break;
            } else if (sum > target) {
                j--;
            } else {
                f++;
            }
        }
        return result;
    }
}
