package 二叉树;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc145_postorder {
    public List<Integer> postorderTraversal(TreeNode root) {
    //根 左 右 --》 左 右 根
        if(root == null) return  new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        Stack<Integer> ans = new Stack<>();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            if(pop.left != null){
                stack.add(pop.left);
            }
            if(pop.right != null){
                stack.add(pop.right);
            }
        }
        List<Integer> ret = new ArrayList<>();
        while (!ans.isEmpty()){
            ret.add(ans.pop());
        }
        return  ret;

    }
}
