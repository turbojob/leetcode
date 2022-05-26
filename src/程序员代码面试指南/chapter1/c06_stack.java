package 程序员代码面试指南.chapter1;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class c06_stack {
    public static int[][] right(int[] arr){
        //最近 并且比 arr[i]小的位置
        Stack<Integer> stack = new Stack<>();
        int[][] info = new int[arr.length][2];
        for(int i =0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int poll = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                info[poll][0] = left;
                info[poll][1] = i;
            }
            stack.add(i);
        }
        while(!stack.isEmpty()){
            int poll = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            info[poll][0] = left;
            info[poll][1] = -1;
        }
        return info;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = in.nextInt();
        }

        int[][] ans = right(arr);
        for(int[] cur : ans){
            System.out.println(cur[0]+" "+cur[1]);
        }
    }
}
