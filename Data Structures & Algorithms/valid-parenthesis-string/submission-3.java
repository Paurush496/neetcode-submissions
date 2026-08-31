class Solution {
    public boolean checkValidString(String s) {
        ArrayDeque<Integer> leftPara = new ArrayDeque<>();
        ArrayDeque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftPara.push(i);
            else if (ch == '*')
                star.push(i);
            else if (!leftPara.isEmpty())
                leftPara.pop();
            else if (!star.isEmpty())
                star.pop();
            else return false;
        }
        while(!leftPara.isEmpty() && !star.isEmpty()) {
            if (star.peekFirst() > leftPara.peekFirst()) {
                star.pop();
                leftPara.pop();
            } else return false;
        }
        return leftPara.isEmpty();
    }
}
