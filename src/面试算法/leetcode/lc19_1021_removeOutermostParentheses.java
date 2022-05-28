package 面试算法.leetcode;

public class lc19_1021_removeOutermostParentheses {
    public String removeOuterParentheses(String s) {
        return process(s, 0).toString();
    }
    public StringBuilder process(String s, int index){
        //当前来到index位置  处理s串
        //index一定是 左括号
        //返回 从index位置出发  去掉()后
        int n = s.length();
        if(index >= n){
            return new StringBuilder();
        }
        int has = -1;

        StringBuilder sb = new StringBuilder();
        while(has != 0){
            index++;
            if(s.charAt(index) == '('){
                sb.append('(');
                has--;
            }else{
                sb.append(')');
                has++;
            }

        }
        sb.deleteCharAt(sb.length()-1);
        //index 来到对应的有括号位置
        StringBuilder next = process(s, index+1);
        sb.append(next);
        return sb;
    }
}
