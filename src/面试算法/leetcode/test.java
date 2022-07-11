package 面试算法.leetcode;

import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;

public class test {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        long j = 63003;
        System.out.println("j*j="+j*j);
        long ans = j * j;
        System.out.println("ans="+ans);
    }
    public int consecutiveNumbersSum(int n) {
        int cnt = 0;
        // sum[i...j] == n
        // 枚举 j
        for (int j = 1; j <= n; ++j) {
            // sum[1...j]
            BigInteger all = BigInteger.valueOf(j).multiply(BigInteger.valueOf(j+1)).divide(BigInteger.valueOf(2));
            // 二分寻找i.
            int l = 0, h = j;
            while (l <= h) {

                int m = (l + h) / 2;
                // sum[1...i]
                BigInteger pre = BigInteger.valueOf(m).multiply(BigInteger.valueOf(m+1)).divide(BigInteger.valueOf(2));

                if (all.subtract(pre).equals(BigInteger.valueOf(n))) {
                    cnt++;
                    break;
                } else if (all.subtract(pre).compareTo( BigInteger.valueOf(n)) < 0) {
                    //1 2 3 4 5
                    //15 - 3 > n
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return cnt;
    }
}
