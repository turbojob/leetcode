package 面试算法.leetcode;

public class lc4_1139_largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {

        //普通的遍历
        //预处理加速：每一个位置 左侧有多少个1  下侧有多少个1
        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] down = new int[m][n];
        for(int i = m-1; i >= 0; i--){

            if(i == m-1){
                for(int j = 0; j < n; j++)
                    down[i][j] = grid[i][j] == 1 ? 1: 0;
            }else{
                for(int j = 0; j < n; j++)
                    down[i][j] = grid[i][j] == 1 ? 1+down[i+1][j] : 0;
            }
            left[i][0] = grid[i][0] == 1 ? 1: 0;
            for(int j = 1; j < n; j++){
                left[i][j] = grid[i][j] == 1 ? 1+ left[i][j-1] : 0;
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int maxLen =  Math.min(m-i, n-j);
                for(int a = 1; a <= maxLen; a++){
                    int p = i+a-1, q = j+a-1;
                    if(p >= m || q >= n){
                        break;
                    }
                    if(down[i][j] >= a && down[i][j+a-1] >= a && left[i][j+a-1] >= a && left[i+a-1][j+a-1] >= a){
                        ans = Math.max(ans, a*a);
                    }
                }
            }
        }

        return ans;
    }

}
