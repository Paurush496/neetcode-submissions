class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Map<Character, Character> brackets = Map.of('(',')','{','}','[',']');
        ArrayDeque<Character> stack = new ArrayDeque();
        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (brackets.get(stack.peekFirst()) == c) {
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }
}
