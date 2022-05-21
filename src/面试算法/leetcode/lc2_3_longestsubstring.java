package 面试算法.leetcode;

import java.util.HashMap;

public class lc2_3_longestsubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int ans = 1;
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        dp[0] = 1;
        for(int i = 1; i < s.length(); i++){
            char cur = s.charAt(i);
            int where = -1;
            if(map.containsKey(cur)){
                where = map.get(cur);
            }
            int curAns = Math.min(i-where, dp[i-1]+1);
            ans = Math.max(ans, curAns);

            map.put(cur, i);
            dp[i] = curAns;
        }
        return ans;
    }
}
