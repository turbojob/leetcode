package 面试算法.leetcode;

public class lc5_98_validIsBST {

    public boolean isValidBST(TreeNode root) {
        Info c = process(root);
        return c.isBST;
    }
    class Info{
        long max, min;
        boolean isBST;
        public Info(long a, long b, boolean c){
            max = a; min = b;
            isBST = c;
        }
    }

    public Info process(TreeNode t){
        if(t == null){
            return new Info(Long.MIN_VALUE, Long.MAX_VALUE,  true);
        }
        Info left = process(t.left);
        Info right = process(t.right);
        long cur =(long)t.val;
        long max = Math.max(Math.max(cur, left.max), right.max);
        long min = Math.min(Math.min(cur, left.min), right.min);
        boolean isValid = left.max<cur && cur < right.min && left.isBST && right.isBST;
        return new Info(max, min, isValid);

    }
}
