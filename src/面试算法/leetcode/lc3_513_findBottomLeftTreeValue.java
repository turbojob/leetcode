package 面试算法.leetcode;


import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class lc3_513_findBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        return bfs(root);
    }
    public int bfs(TreeNode root){
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int ans = -1;
        while(!list.isEmpty()){
            int size = list.size();
            for(int i = 0; i < size; i++){
                TreeNode poll = list.pollFirst();
                if(i == 0){
                    ans = poll.val;
                }
                if(poll.left != null)
                    list.addLast(poll.left);
                if(poll.right != null)
                    list.addLast(poll.right);
            }
        }
        return ans;
    }
}
