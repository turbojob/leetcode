package 二叉树;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc107_level2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<List<Integer>> ans = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode pop = queue.pollFirst();
                cur.add(pop.val);
                if(pop.left != null)
                    queue.addLast(pop.left);
                if(pop.right != null)
                    queue.addLast(pop.right);
            }
            ans.add(cur);
        }
        while(!ans.isEmpty()){
            ret.add(ans.pop());
        }
        return  ret;
    }
}
