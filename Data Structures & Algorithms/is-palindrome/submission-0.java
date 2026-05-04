class Solution {
    public boolean isPalindrome(String s) {
        int stringSize = s.length();
        int i = 0, j = stringSize - 1;
        String alphanumericRegex = "[a-zA-Z0-9]";
        while(i <= j) {
            String iChar = String.valueOf(s.charAt(i));
            String jChar = String.valueOf(s.charAt(j));
            if (!iChar.matches(alphanumericRegex)) {
                i++;
            } else if (!jChar.matches(alphanumericRegex)) {
                j--;
            } else if (!iChar.equalsIgnoreCase(jChar)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
