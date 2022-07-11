package 二叉树;

import util.TreeNode;

public class lc404_leftNodeSum {
    public static int sumOfLeftLeaves(TreeNode root) {
        return  process(root);
    }
    public static int process(TreeNode root){
        //返回root 这个树下 左叶子和
        if(root == null ){
            return 0;
        }
        if(root.left == null){
            return process(root.right);
        }
        if(root.left.left == null && root.left.right == null){
            return root.left.val + process(root.right);
        }
        //此时 root一定有左树
        int p1 = process(root.left);
        int p2 = process(root.right);
        return  p1 + p2;
    }
}