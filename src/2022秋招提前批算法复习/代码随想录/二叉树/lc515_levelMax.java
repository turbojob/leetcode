package 代码随想录.二叉树;

import 代码随想录.util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import util.*;
public class lc515_levelMax {
    public List<Integer> largestValues(util.TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<util.TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++){
                util.TreeNode pop = queue.pollFirst();
                cur.add(pop.val);
                max = Math.max(max, pop.val);
                if(pop.left != null)
                    queue.addLast(pop.left);
                if(pop.right != null)
                    queue.addLast(pop.right);
            }
            ans.add(max);
        }
        return  ans;
    }
}