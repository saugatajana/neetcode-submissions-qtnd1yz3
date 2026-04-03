class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
            '{' , '}' ,
             '[' ,']', 
             '(', ')'
             );
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '(' || c == '[') {
                stack.push(map.get(c));
            } else {
                if(stack.isEmpty() || stack.peek() != c) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
