package 二叉树;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc104_maxDepth {
    public int maxDepth(TreeNode root) {
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) return level;
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
            level++;
        }
        return  level;
    }
}