package 程序员代码面试指南.chapter1;

import java.util.LinkedList;
import java.util.Scanner;

public class c05_slideWindowMax {
    //lc239 cd15
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), w = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        int[] ans = maxSlidingWindow(nums, w);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];

        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for(int i = 0; i <nums.length; i++){
            while(!list.isEmpty() && nums[list.peekLast()] <= nums[i]){
                list.pollLast();
            }
            list.addLast(i);
            if(list.peekFirst() == i-k){
                list.pollFirst();
            }
            if(i >= k-1){
                ans[index++] = nums[list.peekFirst()];
            }
        }
        return  ans;
    }
}
