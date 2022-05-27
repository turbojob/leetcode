package 面试算法.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc17_1711面试_findClosestLcci {
    public int findClosestHashMap(String[] words, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);

            }else{
                map.get(words[i]).add(i);
            }
        }
        List<Integer> p1 = map.get(word1);
        List<Integer> p2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < p2.size(); i++){
            int cur = p2.get(i);
            int k1 = binarySearchLessCase(p1, cur);
            int k2 = binarySearchMoreCase(p1, cur);
            if(k1 == -1){
                k1 = 0;
            }
            if(k2 == -1){
                k2 = p1.size()-1;
            }
            ans = Math.min(ans, Math.min  (Math.abs(  cur-p1.get(k1)),  Math.abs(cur-p1.get(k2))  )  );
        }
        return ans;
    }
    public int binarySearchLessCase(List<Integer> list, int val){
        int n = list.size();
        int l =0, r = n-1;
        int ans = -1;
        //<=val 最右侧的位置
        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid)  <= val){
                ans = mid;
                l = mid+ 1;
            }else{
                r = mid - 1;
            }
        }
        //全都比val大  交给 主函数决定
        return ans;
    }
    public int binarySearchMoreCase(List<Integer> list, int val){
        int n = list.size();
        int l =0, r = n-1;
        int ans = -1;
        //<=val 最右侧的位置
        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid)  >= val){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        //全都比val大  交给 主函数决定
        return ans;
    }

    public int findClosestTwoPointer(String[] words, String word1, String word2){
        int p1 = -1, p2 = -1;
        int ans =Integer.MAX_VALUE;
        for(int i = 0; i < words.length;i++){
            String s = words[i];
            if(s.equals(word1)){
                p1 = i;
            }
            if(s.equals(word2)){
                p2 = i;
            }
            if(p1 != -1 && p2 != -1){
                ans = Math.min(ans, Math.abs(p1-p2));
            }
        }
        return ans;
    }
}
