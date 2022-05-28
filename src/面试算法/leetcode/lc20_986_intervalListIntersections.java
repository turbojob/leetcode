package 面试算法.leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc20_986_intervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //i  AB的大的
        //j  AB的小的
        //如果满足 i <= j ==>就是一个答案
        List<int[]> ans = new ArrayList<>();

        for(int m = 0; m < firstList.length; m++)
            for(int n = 0; n < secondList.length; n++){
                int[] a1 = firstList[m];
                int[] a2 = secondList[n];
                int l = Math.max(a1[0], a2[0]);
                int r = Math.min(a1[1], a2[1]);
                if(l <= r){
                    ans.add(new int[]{l, r});
                }
            }
        int[][] ret = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            ret[i] = ans.get(i);
        }
        return ret;
    }
}
