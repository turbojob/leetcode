package 面试算法.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class lc25_547_numOfProvince {
    static class UnionFind{
        HashMap<Integer, Integer> fatherMap;
        HashMap<Integer, Integer> sizeMap;
        int size;
        public UnionFind(int n){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            size = n;
            for(int i = 0; i < n; i++){
                fatherMap.put(i, i);
                sizeMap.put(i, 1);
            }
        }
        public boolean isSameSet(int i, int j){
            return findFather(i) == findFather(j);
        }
        public void union(int i, int j){
            if(!isSameSet(i, j)){
                int f1 = findFather(i), f2 = findFather(j);
                int s1 = sizeMap.get(f1), s2 = sizeMap.get(f2);
                int max = s1 > s2 ? f1 : f2;
                int min = max == f1 ? f2 : f1;

                fatherMap.put(min, max);
                sizeMap.put(max, sizeMap.get(min)+sizeMap.get(max));
                sizeMap.remove(min);
                //sizeMap.put(min, 0);
                size--;
            }
        }
        public int getSize(){
            return size;
        }
        public int findFather(int i){
            int cur = i;
            Stack<Integer> stack = new Stack<>();
            while(fatherMap.get(cur) != cur){
                stack.add(cur);
                cur = fatherMap.get(cur);
            }

            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(), cur);
            }
            return cur;
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }

        return uf.getSize();
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,1,1},{1,1,1}};
        int ans = findCircleNum(arr);
        System.out.println(ans);
    }
}
