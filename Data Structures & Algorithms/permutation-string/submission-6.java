class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> bigFreq = new HashMap<>();
        int diff = s2.length() - s1.length(), window = 0;
        for (char ch : s1.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; 
        (i <= diff || window > 0) && i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (freq.containsKey(ch)) {
                bigFreq.put(ch, bigFreq.getOrDefault(ch, 0) + 1);
                window++;
            } else {
                window = 0;
                bigFreq = new HashMap<>();
            }
            if (window == s1.length()) {
                if (bigFreq.equals(freq)) {
                    return true;
                } else {
                    char left = s2.charAt(i - window + 1);
                    bigFreq.put(left, bigFreq.get(left) - 1);
                    window--;
                }
            }
        }
        return false;
    }
}
