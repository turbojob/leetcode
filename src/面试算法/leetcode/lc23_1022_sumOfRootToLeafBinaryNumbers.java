package 面试算法.leetcode;

import 面试算法.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lc23_1022_sumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        process(root, new StringBuilder(), ans);
        int ret = 0;
        for(int i : ans){
            ret += i;
        }
        return ret;
    }

    public void process(TreeNode root, StringBuilder tmp, List<Integer> ans){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            tmp.append(root.val);
            ans.add(Binary2Ten(tmp));
            tmp.deleteCharAt(tmp.length()-1);
            return;
        }

        tmp.append(root.val);
        process(root.left, tmp, ans);
        tmp.deleteCharAt(tmp.length()-1);

        tmp.append(root.val);
        process(root.right, tmp, ans);
        tmp.deleteCharAt(tmp.length()-1);


    }

    public int Binary2Ten(StringBuilder c){
        StringBuilder s = new StringBuilder(c);
        if(s.length() == 0){
            return 0;
        }
        int ans = 0;
        int base = 1;
        while( s.length() != 0 ){

            boolean cur = s.charAt(s.length()-1) == '1' ? true : false;
            if(cur){
                ans += base;
            }
            base = base * 2;
            s.deleteCharAt(s.length()-1);
        }
        return ans;
    }
}
