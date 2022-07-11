import java.util.ArrayList;
import java.util.List;

public class lc46_permutations {
    //全排列
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> rest = new ArrayList<>();
        for(int i : nums){
            rest.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        process(ans, new ArrayList<>(), nums, 0, rest);
        return  ans;
    }
    //当前来到i 位置做选择
    //还剩余哪些可以选择的
    public void process(List<List<Integer>> ans, List<Integer> curChoice, int[] arr, int cur, List<Integer> rest){
        int n = arr.length;
        if( cur == n ){
            ans.add(new ArrayList<>(curChoice));
            return;
        }
        int size = rest.size();
        for(int i = 0; i < size; i++){
            int val = rest.get(i);
            curChoice.add(val);
            rest.remove(i);
            process(ans, curChoice, arr, cur+1, rest);
            rest.add(i, val);
            curChoice.remove(curChoice.size()-1);
        }

    }
}
