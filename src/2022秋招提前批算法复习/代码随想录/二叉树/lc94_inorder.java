package 二叉树;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc94_inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return  new ArrayList<>();

        //把左的全部压入栈里
        //弹出的时候，如果有右 也进入栈
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.add(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return  ans;

    }
}
