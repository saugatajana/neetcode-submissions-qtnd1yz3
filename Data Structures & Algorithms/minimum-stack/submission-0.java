class Pair {
    int val;
    int min;
    Pair(int val) {
        this.val = val;
        this.min = val;
    }
}
class MinStack {
    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        Pair pair = new Pair(val);
        if(!stack.isEmpty() && stack.peek().min < val) {
            pair.min = stack.peek().min;
        }
        stack.push(pair);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
