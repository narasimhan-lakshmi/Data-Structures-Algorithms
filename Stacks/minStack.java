// LC 225

class MinStack {
    Stack<Long> st = new Stack <Long>();
    Long mini;

    public MinStack() {

         mini = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long val1 = Long.valueOf(val);
        if(st.isEmpty()){
            mini = val1;
            st.push(val1);
        }
        else{
            if(val1<mini){
                st.push(2*val1 - mini);
                mini = val1;
            }
            else{
                st.push(val1);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        else{
            Long val = st.pop();
            if(val<mini){
                mini = 2*mini - val;
            }
        }
    }
    
    public int top() {
        Long val = st.peek();
        if(val<mini){
            return mini.intValue();
        }
        return val.intValue();
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/*
Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/