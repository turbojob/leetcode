package 面试算法.leetcode;

public class lc21_198_rob {
    public int rob(int[] nums) {
        int n = nums.length;
        return processDP(nums);
    }
    public int process(int[] arr, int i){
        int n = arr.length;
        if(i == n-1){
            return arr[n-1];
        }
        if(i >= n){
            return 0;
        }
        int p1 = process(arr, i+1);
        int p2 = arr[i] + process(arr, i+2);
        return Math.max(p1, p2);

    }

    public int processDP(int[] arr){


        int n = arr.length;
        if(n == 1){
            return arr[0];
        }else if(n == 2){
            return Math.max(arr[0], arr[1]);
        }
        int[] dp = new int[n];
        dp[n-1] = arr[n-1];
        dp[n-2] = Math.max(arr[n-1], arr[n-2]);
        for(int i = n-3; i>=0; i--){
            int p1 = dp[i+1];
            int p2 = arr[i] +dp[i+2];
            dp[i] = Math.max(p1, p2);
        }
        return dp[0];

    }
}
