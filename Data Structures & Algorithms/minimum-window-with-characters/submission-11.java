class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>(), sf = new HashMap<>();
        int len = t.length(), found = 0, l = -1, r = 0;
        String res = "";
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (sf.getOrDefault(curr, 0) < freq.getOrDefault(curr, 0)) {
                found++;
                if (l == -1) l = i;
            }
            if (freq.containsKey(curr)) {
                sf.put(curr, sf.getOrDefault(curr, 0) + 1);
            }
            if (found == len) {
                r = i;
                if (r - l + 1 < res.length() || res.length() == 0) {
                    res = s.substring(l, r + 1);
                }
                char lCh = s.charAt(l);
                sf.put(lCh, sf.getOrDefault(lCh, 0) - 1);
                if (sf.get(lCh) < freq.get(lCh)) found--;
                while (++l < r) {
                    lCh = s.charAt(l);
                    if (!freq.containsKey(lCh)) continue;
                    else if (sf.getOrDefault(lCh, 0) - 1 >= freq.getOrDefault(lCh, 0)) {
                        sf.put(lCh, sf.getOrDefault(lCh, 0) - 1);
                    } else break;
                }
                if (found == len && r - l + 1 < res.length()) {
                    res = s.substring(l, r + 1);
                }
            }
        }
        return res;
    }
}
