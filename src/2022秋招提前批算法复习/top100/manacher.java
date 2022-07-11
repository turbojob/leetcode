public class manacher {
    public static void main(String[] args) {
        System.out.println(manacher("a"));
    }
    public static String manacher(String s){
        char[] arr = getManacherString(s);
        int C = -1, R = -1, pos = -1;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int[] pArr = new int[n];
        for(int i = 0; i < n; i++){
            pArr[i] = i < R ? Math.min(pArr[2*C-i], R - i) : 1;
            while (i + pArr[i] < n && i - pArr[i] >= 0){
                if(arr[i+pArr[i]] == arr[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if(pArr[i] > max){
                max = pArr[i];
                pos = i;
            }
            if(i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        // 0 1 2 3 4 5
        //   1 2 3 2 1
        //     pos = 3  max = 3
        for(int i = pos - max + 1; i <= pos+max-1; i++){
            if(arr[i] != '#') ans.append(arr[i]);
        }
        return  ans.toString();
    }
    public static char[] getManacherString(String s){
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append('#');
        }
        return  sb.toString().toCharArray();
    }
}
