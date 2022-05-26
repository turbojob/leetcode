package 面试算法.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class lc11_699_fallingSquare {

    public List<Integer> fallingSquares(int[][] positions) {
        HashMap<Integer, Integer> info = reOrder(positions);
        List<Integer> list = new ArrayList<>();
        SegmentTree sg = new SegmentTree(info.size());
        for(int[] a : positions){
            int from = a[0];
            from = info.get(from);
            int height = a[1];
            int to = a[0] + a[1] - 1;
            to = info.get(to);
            int max = sg.queryMax(from, to, 1, 1, info.size());
            sg.change(from, to, max + height, 1, 1, info.size());
            max = sg.queryMax(1, info.size(), 1, 1, info.size());
            list.add(max);

        }
        return list;
    }
    class SegmentTree{

        int[] max;
        int[] update;
        boolean[] change;

        public SegmentTree(int n){

            n++;
            update = new int[n<<2];
            max = new int[n << 2];
            change = new boolean[n << 2];
        }
        public void pushUp(int rt){
            int l = max[rt<<1];
            int r = max[rt<<1|1];
            max[rt] = Math.max(max[rt<<1], max[rt<<1|1]);
        }
        public void pushDown(int rt, int ln, int rn){
            if(change[rt]){
                change[rt<<1] = true;
                change[rt<<1|1] = true;
                update[rt<<1] = update[rt];
                update[rt<<1|1] = update[rt];
                change[rt] = false;

                max[rt<<1] = update[rt];
                max[rt<<1|1] = update[rt];
                update[rt] = 0;
            }
        }
        public void change(int L, int R, int C, int rt, int l, int r){
            if(L <= l && r <= R){
                update[rt] = C;
                change[rt] = true;
                max[rt] = C;
                return;
            }
            int mid = l + (r-l)/2;
            pushDown(rt, mid-l+1, r-mid);
            if(L <= mid){
                change(L, R, C, rt<<1,l, mid);
            }
            if(R >= mid+1){
                change(L, R, C, rt<<1|1, mid+1, r);
            }
            pushUp(rt);
        }
        public int queryMax(int L, int R, int rt, int l, int r){
            if(L <= l && r <= R){
                return max[rt];
            }
            int mid = l + (r-l)/2;
            int p1=Integer.MIN_VALUE, p2 = Integer.MIN_VALUE;
            pushDown(rt, mid-l+1, r-mid);
            if(L <= mid){
                p1 = queryMax(L, R, rt<<1,l, mid);
            }
            if(R >= mid+1){
                p2 = queryMax(L, R, rt<<1|1, mid+1, r);
            }
            pushUp(rt);
            return Math.max(p1, p2);
        }
    }

    public HashMap<Integer, Integer> reOrder(int[][] positions){
        TreeSet<Integer> set = new TreeSet<>();
        for(int[] a : positions){
            set.add(a[0]);
            set.add(a[0]+a[1]-1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int i : set){
            map.put(i, ++index);
        }
        return map;
    }
}
