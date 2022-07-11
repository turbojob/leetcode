package 面试算法.leetcode;

import 面试算法.util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc26_429_NTreeLevel {
    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> list = new LinkedList<>();
        if(root == null) return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            List<Integer> cur = new ArrayList<>();
            for(int i =0; i < size; i++){
                Node poll = list.pollFirst();
                cur.add(poll.val);
                if(poll.children != null){
                    for(Node child : poll.children){
                        list.addLast(child);
                    }
                }
            }
            ans.add(cur);
        }

        return ans;
    }
}
