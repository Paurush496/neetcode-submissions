class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int barL = height[l], barR = height[r], min = Math.min(barL, barR);
        int indexL = l, indexR = r;
        int totalTrappedWater = 0, currBucket = 0, barArea = 0;
        while (l < r) {
            boolean isLSmall = min == barL;
            int currHt = isLSmall ? height[l] : height[r];
            if (currHt < min) {
                barArea += currHt;
            } else {
                int length = Math.max(isLSmall ? l - indexL - 1 : indexR - r - 1, 0);
                totalTrappedWater += (min * length - barArea);
                if (isLSmall) {
                    barL = currHt;
                    indexL = l;
                } else {
                    barR = currHt;
                    indexR = r;
                }
                min = Math.min(barL, barR);
                currBucket = min * (r - l - 1);
                barArea = 0;
            }
            if (min == barL) l++;
            else r--;
        }
        totalTrappedWater += (currBucket - barArea);
        return totalTrappedWater;
    }
}
