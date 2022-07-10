package 面试算法.leetcode;

import 面试算法.util.TreeNode;

public class lc27_572_isSubTree {
    public boolean isSubtree(TreeNode a, TreeNode b) {
        if(a == null || b == null){
            return a == b;
        }
        if(a.val == b.val){
            return isSameTree(a, b) || isSubtree(a.left, b) || isSubtree(a.right, b);
        }
        return isSubtree(a.left, b) || isSubtree(a.right, b);
    }

    public boolean isSameTree(TreeNode a, TreeNode b){
        if(a == null || b == null){
            return a == b;
        }
        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
