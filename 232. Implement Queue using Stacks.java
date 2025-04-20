import java.util.Stack;

class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {

        st1 = new Stack<>();
        st2 = new Stack<>();

    }

    public void push(int x) {

        while (!st1.empty()) {
            int data = st1.pop();
            st2.push(data);
        }
        st1.push(x);
        while (!st2.empty()) {
            int data = st2.pop();
            st1.push(data);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        } else {
            return st1.pop();
        }

    }

    public int peek() {
        if (empty()) {
            return -1;
        } else {
            return st1.peek();
        }
    }

    public boolean empty() {
        return st1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */