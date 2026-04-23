class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            int l = s.length();
            sb.append(l).append(".").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i < str.length()) {
            String lengthStr = str.substring(i, str.indexOf(".", i));
            String s = null;
            if (Integer.parseInt(lengthStr) == 0) {
                s = "";
            } else {
                int stringBeginIndex = i + lengthStr.length() + 1;
                int stringEndIndex = stringBeginIndex + Integer.parseInt(lengthStr);
                s = str.substring(stringBeginIndex, stringEndIndex);
            }
            result.add(s);
            i += s.length() + lengthStr.length() + 1;
        }
        return result;
    }
}
