package 二叉树;

import com.sun.source.tree.Tree;
import util.TreeNode;

import javax.swing.tree.TreeCellRenderer;

public class lc101_symmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return  true;
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode l, TreeNode r){
        if(l == null && r == null) return  true;
        if(l == null && r != null || l != null && r == null) return  false;
        return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
    public boolean isSameTree(TreeNode l, TreeNode r){
        if(l == null && r == null) return  true;
        if(l == null && r != null || l != null && r == null) return  false;
        return l.val == r.val && isSameTree(l.left, r.left) && isSameTree(l.right, r.right);
    }
}