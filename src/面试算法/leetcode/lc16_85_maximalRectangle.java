package 面试算法.leetcode;

import java.util.Stack;

public class lc16_85_maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        String[] aim = new String[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < matrix[0].length; j++){
                sb.append(matrix[i][j]);
            }
            aim[i] = sb.toString();
        }

        return maximalRectangle(aim);
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
                    info[j] = line.charAt(j)-'0' == 0 ?0 : info[j] + line.charAt(j)-'0';
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
    public int[][] right(int[] arr){
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
