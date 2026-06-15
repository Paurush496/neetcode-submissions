class Solution {
    public int maxProfit(int[] prices) {
        int min = 0, max = 0, diff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= prices[min]) {
                min = i;
            } else {
                max = i;
            }
            if (max > min) {
                int dif = prices[max] - prices[min];
                diff = Math.max(dif, diff);
            }
        }
        return diff;
    }
}
