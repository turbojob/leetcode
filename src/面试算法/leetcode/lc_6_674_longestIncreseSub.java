package 面试算法.leetcode;

public class lc_6_674_longestIncreseSub {
    public int findLengthOfLCIS(int[] nums) {
        int last = 1;
        int n = nums.length;
        int ans = 1;
        for(int i=1; i < n; i++){
            if(nums[i] > nums[i-1]){
                last = last + 1;
            }else{
                last = 1;
            }
            ans = Math.max(ans, last);
        }
        return ans;
    }
}
