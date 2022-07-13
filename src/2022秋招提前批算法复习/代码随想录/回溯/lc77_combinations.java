package 回溯;

import java.util.ArrayList;
import java.util.List;

public class lc77_combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> choose = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            choose.add(i);
        }
        process(ans, new ArrayList<>(), choose, k);
        return  ans;
    }
    public void process(List<List<Integer>> ans, List<Integer> tmp, List<Integer> choose, int k){
        if(k == 0 || choose.isEmpty()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        int size = choose.size();
        for(int i = 0; i < size; i++){
            int cur = choose.get(i);
            choose.remove(i);
            tmp.add(cur);
            process(ans, tmp, choose, k-1);
            tmp.remove(tmp.size()-1);
            choose.add(i, cur);
        }
    }
}