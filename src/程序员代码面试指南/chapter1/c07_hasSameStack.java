package 程序员代码面试指南.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class c07_hasSameStack {
    public static int[][] right(int[] arr){
        //最近 并且比 arr[i]小的位置
        Stack<List<Integer>> stack = new Stack<>();
        int[][] info = new int[arr.length][2];
        for(int i =0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]){
                List<Integer> list = stack.pop();
                for(int poll : list){
                    int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                    info[poll][0] = left;
                    info[poll][1] = i;
                }
            }
            if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]){
                stack.peek().add(i);
            }else{
                List<Integer> li = new ArrayList<>();
                li.add(i);
                stack.add(li);
            }
        }
        while(!stack.isEmpty()){
            List<Integer> list = stack.pop();
            for(int poll : list){
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                info[poll][0] = left;
                info[poll][1] = -1;
            }
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
