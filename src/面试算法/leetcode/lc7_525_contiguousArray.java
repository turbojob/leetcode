package 面试算法.leetcode;

import java.util.HashMap;

public class lc7_525_contiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        //问题转化成 找累加和为0  最长
        int[] dp = new int[n];
        int ans = 0;
        dp[0] = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(dp[0], 0);

        for(int i = 1; i < n; i++){
            dp[i] = dp[i-1]+ nums[i];
            if(dp[i] == 0){
                ans = Math.max(i+1, ans);
            }else{
                if(map.containsKey(dp[i])){
                    ans = Math.max(ans, i-map.get(dp[i]));
                }else{
                    map.put(dp[i], i);
                }
            }

        }
        return ans;
        //i+1 ... j == dp[j] - dp[i]
        //changdu  j-(i+1) - 1 = j-i - 2

    }
}
