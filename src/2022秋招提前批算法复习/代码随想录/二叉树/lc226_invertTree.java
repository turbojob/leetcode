package 二叉树;

import com.sun.source.tree.Tree;
import util.TreeNode;

public class lc226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        return process(root);
    }
    public TreeNode process(TreeNode root){
        if(root == null) return  null;
        TreeNode r =  process(root.right);
        TreeNode l = process(root.left);
        root.left = r;
        root.right = l;
        return  root;
    }
}