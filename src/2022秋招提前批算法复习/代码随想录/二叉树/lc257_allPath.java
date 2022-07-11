package 二叉树;

import com.sun.source.tree.Tree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lc257_allPath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        process(new ArrayList<>(), root, ans);
        return  ans;
    }
    //当前来到cur做选择，沿途的答案放到sb
    public void process(List<Integer> sb, TreeNode cur, List<String> ans){
        if(cur == null){
            return;
        }
        if(cur.left == null && cur.right == null ){
            sb.add(cur.val);
            StringBuilder s = new StringBuilder();
            for(int i : sb){
                s.append(String.valueOf(i));
                s.append('-');
                s.append('>');
            }
            s.deleteCharAt(s.length()-1);
            s.deleteCharAt(s.length()-1);
            ans.add(s.toString());
            sb.remove(sb.size()-1);
            return;
        }
        if(cur.left != null){
            sb.add(cur.val);
            process(sb, cur.left, ans);
            sb.remove(sb.size()-1);
        }
        if(cur.right != null){
            sb.add(cur.val);
            process(sb, cur.right, ans);
            sb.remove(sb.size()-1);
        }
    }
}