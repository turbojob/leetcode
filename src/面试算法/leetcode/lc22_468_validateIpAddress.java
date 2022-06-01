package 面试算法.leetcode;

public class lc22_468_validateIpAddress {
    public String validIPAddress(String queryIP) {
        int pre = preString(queryIP);
        if(queryIP.length() == 0){
            return "Neither";
        }
        if(queryIP.charAt(queryIP.length()-1) == '.')
            return "Neither";
        if(pre == -1){
            return "Neither";
        }else if(pre == 4){

            String[] split = queryIP.split("\\.");
            if(split.length != 4){
                return "Neither";
            }
            for(String cur : split){
                boolean query = checkNumIsValid(cur, 4);
                if(!query){
                    return "Neither";
                }
            }
            return "IPv4";
        }else{
            String[] split = queryIP.split("\\:");
            if(split.length != 8){
                return "Neither";
            }
            for(String cur : split){
                boolean query = checkNumIsValid(cur, 6);
                if(!query){
                    return "Neither";
                }
            }
            return "IPv6";
        }
    }
    public int preString(String s){
        //预处理   不可能返回-1
        //冒号符合4  返回4
        //符合6  返回6
        int cntDot = 0;
        int cntMao = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '.'){
                cntDot++;
            }else if( cur == ':'){
                cntMao++;
            }
        }
        if(cntDot==3 && cntMao == 0){
            return 4;
        }else if(cntMao == 7 && cntDot == 0){
            return 6;
        }else{
            return -1;
        }
    }
    public boolean checkNumIsValid(String s, int maxLen){
        if(s.length() > maxLen)
            return false;

        if(maxLen == 4){
            if(s.length() > 1 && s.charAt(0) == '0'){
                return false;
            }
            if(s.length() > 4)
                return false;
            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);
                if(cur< '0' || cur > '9'){
                    return false;
                }
            }
            //todo
            if(s == "") return false;
            int trans = Integer.valueOf(s);
            if(trans >= 0 && trans <= 255){
                return true;
            }
            return false;
        }else{
            if(s.length() == 0 || s.length() > 4){
                return false;
            }
            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);
                boolean isValid = (cur >= '0' && cur <= '9') ||
                        (cur >= 'a' && cur <= 'f') || (cur >= 'A' && cur <= 'F');
                if(!isValid)
                    return false;
            }
            return true;
        }
    }
}
