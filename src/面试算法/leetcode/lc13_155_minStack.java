package 面试算法.leetcode;

import java.util.Stack;

public class lc13_155_minStack {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            if(stack.isEmpty()){
                minStack.add(val);
            }else{
                minStack.add(Math.min(minStack.peek(), val));
            }
            stack.add(val);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
