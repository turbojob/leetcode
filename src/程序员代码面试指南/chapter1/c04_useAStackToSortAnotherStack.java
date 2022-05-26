package 程序员代码面试指南.chapter1;

import java.util.Scanner;
import java.util.Stack;

public class c04_useAStackToSortAnotherStack {
    //cd 13
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for(int i = n-1; i >=0; i--){
            stack.add(arr[i]);
        }

        process(stack);

        while (!stack.isEmpty()) {
            System.out.printf(stack.pop() + " ");
        }
    }
    public static void process(Stack<Integer> stack){
        Stack<Integer> help= new Stack<>();
        //开始help放着 最大的值
        //如果比他 小 直接进
        //比他大  把help全倒进stack里 放入
        //help【2 3 4 6 7】
        //   栈顶-------栈底
        while(!stack.isEmpty()){
            int poll = stack.pop();
            if(help.isEmpty()){
                help.add(poll);
            }else{
                while( !help.isEmpty() && poll > help.peek()){
                    stack.add(help.pop());
                }
                help.add(poll);
            }
        }
        while(!help.isEmpty()){
            stack.add(help.pop());
        }
    }

}
