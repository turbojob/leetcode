package 二叉树;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc637_levelAvg {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
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
            int curSize = 0;
            double all = 0;
            for(int i : cur){
                curSize++;
                all+= i;
            }
            ans.add(all * 1.0 / curSize);
        }
        return  ans;
    }
}
