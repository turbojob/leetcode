package 面试算法.leetcode;

import java.util.LinkedList;
import java.util.List;

public class lc12_658_finfKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = arr.length;
        int l = 0, r=n-1;
        int ans = -1;
        while(l <= r){
            //找 小于等于这个值 最右的位置
            int mid = l + (r-l)/2;
            if(arr[mid] <= x){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        if(ans == -1) ans = 0;
        l = ans;r = ans+1;

        while(l >= 0 && r < n){
            if(k == 0)
                break;
            int p1 = Math.abs(arr[l]-x);
            int p2 = Math.abs(x-arr[r]);
            if(p1 <= p2){
                list.addFirst(arr[l--]);
            }else{
                list.addLast(arr[r++]);
            }
            k--;
        }
        while(k> 0 && l >= 0){
            k--;
            list.addFirst(arr[l--]);
        }
        while(k > 0 && r < n){
            k--;
            list.addLast(arr[r++]);
        }
        return list;

    }
}
