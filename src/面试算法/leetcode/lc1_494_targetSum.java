package 面试算法.leetcode;

import java.util.HashMap;

/*
https://leetcode.cn/problems/target-sum/
给定一个数组arr，你可以在每个数字之前决定+或者-但是必须所有数字都参与
再给定一个数target
请问最后算出target的方法数
 */
public class lc1_494_targetSum {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int tar = 3;
        System.out.println(findTargetSumWays(arr, tar));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            nums[i] = nums[i] < 0 ? -nums[i] : nums[i];
            sum += nums[i];
        }
        if( target>0&&target>sum || target<0&&target< -sum ){
            return 0;
        }
        if(((sum+target)  & 1) == 1){
            return 0;
        }
        int aim = (sum+target)/2;
        //return process2(nums, 0, aim);
        return process2dpPress(nums, aim);
        //return findTargetSumWays1(nums, target);
    }
    //方式1：f(index, rest) 当前来到index位置，累加出rest的方法数 返回
    //      加入缓存->dp
    public static int findTargetSumWays1(int[] nums, int target) {
        return process1withCache(nums, 0, target, new HashMap<>());
    }
    public static int process1(int[] arr, int index, int rest){
        int n = arr.length;

        //来到最后位置 判断rest 是不是 0
        if( index == n ){
            return rest == 0 ? 1 : 0;
        }
        int p1 = process1(arr, index+1, rest+arr[index]);
        int p2 = process1(arr, index+1, rest - arr[index]);
        return  p1+p2;
    }
    //REST 范围 是 每个最小相加->每个位置最大相加
    //方案1：提前统计出范围
    //方案2：hash表存
    public static int process1withCache(int[] arr, int index, int rest, HashMap<Integer, HashMap<Integer, Integer>> map){
        int n = arr.length;

        //来到最后位置 判断rest 是不是 0
        if( index == n ){
            return rest == 0 ? 1 : 0;
        }
        if(map.containsKey(index) && map.get(index).containsKey(rest)){
            return map.get(index).get(rest);
        }
        int p1 = process1withCache(arr, index+1, rest+arr[index], map);
        int p2 = process1withCache(arr, index+1, rest - arr[index], map);
        if(!map.containsKey(index)){
            map.put(index, new HashMap<>());
        }
        map.get(index).put(rest, p1+p2);
        return  p1+p2;
    }

    //方式2：
    //1、所有的数 正负没有关系，全变成正数也可以
    //2、如果target大于 所有的累加和，肯定不可以
    //3、假设所有去取+的集合 为P，取-的为N
    //当前来到index位置  剩下target需要处理   要或者不要
    public static int process2(int[] arr, int index, int target){
        int n = arr.length;
        if(target < 0){
            return 0;
        }
        if(index == n){
            return target == 0 ? 1 : 0;
        }
        int p1 = process2(arr, index+1, target);
        int p2 = process2(arr, index+1, target-arr[index]);
        return p1 + p2;
    }
    public static int process2dp(int[] arr, int target){
        int[][] dp = new int[arr.length+1][target+1];
        //dp[i][j] 表示 从i位置出发  剩下target要求 的方法数
        //来到n位置 越界 0返回1中可能性
        dp[arr.length][0] = 1;
        for(int i = arr.length-1; i >= 0; i--){
            int cur = arr[i];
            for(int j = 0; j <= target; j++){
                int p1 = dp[i+1][j];
                int p2 = 0;
                if(j - cur >= 0){
                    p2 = dp[i+1][j-cur];
                }
                dp[i][j] = p1+p2;
            }
        }
        return dp[0][target];
    }
    public static int process2dpPress(int[] arr, int target){
        //int[][] dp = new int[arr.length+1][target+1];
        //dp[i][j] 表示 从i位置出发  剩下target要求 的方法数
        //来到n位置 越界 0返回1中可能性
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = arr.length-1; i >= 0; i--){
            int cur = arr[i];
            for(int j = target; j >= 0; j--){
                int p1 = dp[j];
                int p2 = 0;
                if(j - cur >= 0){
                    p2 = dp[j-cur];
                }
                dp[j] = p1+p2;
            }
        }
        return dp[target];
    }
}
