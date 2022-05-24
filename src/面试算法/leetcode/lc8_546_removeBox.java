package 面试算法.leetcode;

public class lc8_546_removeBox {
    int[] arr;
    public int removeBoxes(int[] boxes) {
        arr = boxes;
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++){
                    dp[i][j][k] = -1;
                }
        return processCache(0, arr.length-1, 0, dp);
    }
    //f(L, R, k)
    //在l...r 进行删除  并且L前面有k个【L】字符
    public int process(int l, int r, int k){
        if(l > r){
            return 0;
        }
        //CASE 1  前面k个  只和当前L  进行消除
        int p1 = process(l+1, r, 0) + (k+1)*(k+1);
        for(int i = l+1; i <= r; i++){
            if(arr[l]  == arr[i]){
                //1  2222 1
                //把他俩之间的 消除后，变成i位置开始，前面k+1个1的情况
                int p2 = process(l+1, i-1, 0) + process(i, r, k+1);
                p1 = Math.max(p1, p2);
            }
        }
        return p1;
    }
    public int processCache(int l, int r, int k, int[][][] dp){
        if(l > r){
            return 0;
        }
        if(dp[l][r][k] != -1){
            return dp[l][r][k];
        }
        //CASE 1  前面k个  只和当前L  进行消除
        int p1 = processCache(l+1, r, 0, dp) + (k+1)*(k+1);
        for(int i = l+1; i <= r; i++){
            if(arr[l]  == arr[i]){
                //1  2222 1
                //把他俩之间的 消除后，变成i位置开始，前面k+1个1的情况
                int p2 = processCache(l+1, i-1, 0, dp) + processCache(i, r, k+1, dp);
                p1 = Math.max(p1, p2);
            }
        }
        dp[l][r][k] = p1;
        return p1;
    }
}
