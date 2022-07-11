package 代码随想录.二叉树;

import 代码随想录.util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc429_Nlevel {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node pop = queue.pollFirst();
                cur.add(pop.val);
                for( Node child : pop.children){
                    queue.addLast(child);
                }
            }
            ans.add(cur);
        }
        return  ans;
    }
}