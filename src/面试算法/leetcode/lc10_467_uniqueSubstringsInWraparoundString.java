package 面试算法.leetcode;

public class lc10_467_uniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        int[] box = new int[26];
        int[] dp = new int[n];
        //dp i 表示  当前位置为结尾 最长的 子串长度是多少
        box[p.charAt(0) - 'a'] = 1;
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            if(quickCheck(p.charAt(i-1), p.charAt(i))){
                dp[i] = dp[i-1] + 1;
                box[p.charAt(i)- 'a'] = Math.max(dp[i], box[p.charAt(i)- 'a']);
            }else{
                dp[i] = 1;
                box[p.charAt(i)- 'a'] = Math.max(dp[i], box[p.charAt(i)- 'a']);
            }
        }
        int sum = 0;
        for(int i = 0; i < 26; i++){
            sum += box[i];
        }
        return sum;
    }
    public boolean quickCheck(char a, char b){
        if( a == 'z') return b == 'a';
        return a - b + 1 ==0;
    }
}
