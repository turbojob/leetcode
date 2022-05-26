package 程序员代码面试指南.chapter1;

import java.util.Scanner;
import java.util.Stack;

public class c03_reorderAStackUsingProcess {
    //cd7
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i< n; i++){
            stack.add(in.nextInt());
        }

        f2(stack);


        while(!stack.isEmpty()){
            System.out.printf(stack.pop()+" ");
        }
    }
    //返回栈底的元素 并将栈底元素移除
    public static int f1(Stack<Integer> s){
        int pop = s.pop();
        if(s.isEmpty()) return  pop;
        int ans = f1(s);
        s.add(pop);
        return ans;
    }
    public static void f2(Stack<Integer> s){
        if(s.size() <= 1){
            return ;
        }
        int last = f1(s);
        f2(s);
        s.add(last);
    }
}
