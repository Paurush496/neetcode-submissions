class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nos = new Stack();
        for (String s : tokens) {
            switch(s) {
                case "+":
                    nos.push(nos.pop() + nos.pop());
                    break;
                case "-":
                    int l = nos.pop(), r = nos.pop();
                    nos.push(r - l);
                    break;
                case "*":
                    nos.push(nos.pop() * nos.pop());
                    break;
                case "/":
                    int l1 = nos.pop(), r1 = nos.pop();
                    nos.push(r1 / l1);
                    break;
                default:
                    nos.push(Integer.valueOf(s));
                    break;
            }
        }
        return nos.pop();
    }
}
