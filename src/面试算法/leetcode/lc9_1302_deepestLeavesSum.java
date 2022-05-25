package 面试算法.leetcode;

import 面试算法.util.TreeNode;

import java.util.LinkedList;

public class lc9_1302_deepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root == null){
            return 0;
        }
        list.addFirst(root);
        while(!list.isEmpty()){
            int size = list.size();
            ans = 0;
            for(int i = 0; i < size; i++){
                TreeNode poll = list.pollLast();
                ans += poll.val;
                if(poll.left != null){
                    list.addFirst(poll.left);
                }
                if(poll.right != null){
                    list.addFirst(poll.right);
                }
            }
        }
        return ans;
    }
}
