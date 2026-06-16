class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chIndex = new int[256];
        int l = 0, max = 0;
        char[] chArray = s.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            int pos = chIndex[chArray[i]];
            if (pos != 0 && pos > l) {
                l = pos;
            }
            chIndex[chArray[i]] = i + 1;
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}
