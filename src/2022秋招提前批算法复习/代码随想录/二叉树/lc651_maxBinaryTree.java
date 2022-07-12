package 二叉树;

import util.TreeNode;

public class lc651_maxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return process(nums, 0, nums.length-1);
    }
    public TreeNode process(int[] arr, int l, int r){
        if(l == r) return new TreeNode(arr[l]);
        if(l > r) return null;
        int root = findMax(arr,l, r);
        TreeNode ans = new TreeNode(arr[root]);
        ans.left = process(arr, l, root-1);
        ans.right = process(arr, root+1, r);
        return ans;

    }
    public int findMax(int[] arr, int l, int r){
        int ans = l, max = arr[l];
        for(int i = l+1; i <= r; i++){
            if(arr[i] > max){
                max = arr[i];
                ans = i;
            }
        }
        return ans;
    }
}