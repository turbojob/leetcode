package 程序员代码面试指南.chapter1;
//对应牛客cd5  lc155

import java.util.Scanner;
import java.util.Stack;

public class c01_getMinStack {
    static class MinStack {
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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String[] arr = new String[a];
        MinStack min = new MinStack();
        in.nextLine();
        for(int i = 0; i < a; i++){
            arr[i] = in.nextLine();
        }
        for(int i = 0; i < a; i++){
            String cur = arr[i];
            if(cur.equals("pop")){
                min.pop();
            }else if(cur.charAt(0) == 'p'){
                String[] split = cur.split(" ");
                int v = Integer.parseInt(split[1]);
                min.push(v);
            }else if(cur.charAt(0) == 'g'){
                System.out.println(min.getMin());
            }
        }
    }
}
