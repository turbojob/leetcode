package 程序员代码面试指南.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class c08_maximalRectangle {
    //lc 剑指40  cd16
    public int numSubmat(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[] info = new int[n];
        //先处理 第一行
        //info[i] 表示 当前行来说， 他的高度是多少
        for (int i = 0; i < m; i++){
            int[] line = matrix[i];
            if(i == 0){
                for(int j=0;j<n;j++){
                    info[j] = line[j]-'0';
                }
            }else{
                for(int j=0;j<n;j++){
                    info[j] = line[j]-'0' == 0 ?0 : info[j] + line[j]-'0';
                }
            }

            int[][] right = right(info);
            for(int a = 0; a < right.length; a++){
                int[] cur = right[a];
                if(cur[1] == -1){
                    cur[1] = n;
                }
                ans = Math.max(ans, info[a] * (cur[1] - cur[0] - 1));
            }
        }
        return  ans;
    }
    public int maximalRectangle(String[] matrix) {
        int ans = 0;
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length();
        int[] info = new int[n];
        //先处理 第一行
        //info[i] 表示 当前行来说， 他的高度是多少
        for (int i = 0; i < m; i++){
            String line = matrix[i];
            if(i == 0){
                for(int j=0;j<n;j++){
                    info[j] = line.charAt(j)-'0';
                }
            }else{
                for(int j=0;j<n;j++){
                    info[j] = info[j] == 0 ?0 : info[j] + line.charAt(j)-'0';
                }
            }

            int[][] right = right(info);
            for(int a = 0; a < right.length; a++){
                int[] cur = right[a];
                if(cur[1] == -1){
                    cur[1] = n;
                }
                ans = Math.max(ans, info[a] * (cur[1] - cur[0] - 1));
            }
        }
        return  ans;

    }
    public static int[][] right(int[] arr){
        //最近 并且比 arr[i]小的位置
        Stack<Integer> stack = new Stack<>();
        int[][] info = new int[arr.length][2];
        for(int i =0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
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
}
