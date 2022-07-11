package 二叉树;

import com.sun.source.tree.Tree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc144_preorder {
    //根 左 右
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            if(pop.right != null){
                stack.add(pop.right);
            }
            if(pop.left != null){
                stack.add(pop.left);
            }
        }
        return ans;
    }
}
