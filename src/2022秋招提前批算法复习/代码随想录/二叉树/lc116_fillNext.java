package 二叉树;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc116_fillNext {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {

        LinkedList<Node> queue = new LinkedList<>();
        if(root == null) return root;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Node> curLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node pop = queue.pollFirst();
                curLevel.add(pop);
                if(pop.left != null)
                    queue.addLast(pop.left);
                if(pop.right != null)
                    queue.addLast(pop.right);
            }

            for(int i = 0; i < curLevel.size()-1; i++){
                curLevel.get(i).next = curLevel.get(i+1);
            }
        }
        return  root;
    }
}