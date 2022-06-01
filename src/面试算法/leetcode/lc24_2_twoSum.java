package 面试算法.leetcode;
import 面试算法.util.*;
public class lc24_2_twoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = new ListNode(0);
        p1.next = l1;

        ListNode p2 = new ListNode(0);
        p2.next = l2;

        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        int hasOne = 0;
        while(p1.next != null && p2.next != null){
            int next = hasOne + p1.next.val + p2.next.val;
            hasOne = next / 10;
            next = next % 10;
            cur.next = new ListNode(next);

            p1 = p1.next;p2=p2.next;cur=cur.next;
        }

        while(p1.next != null){
            int next = hasOne + p1.next.val;
            hasOne = next / 10;
            next = next % 10;
            cur.next = new ListNode(next);

            p1 = p1.next;cur=cur.next;
        }

        while(p2.next != null){
            int next = hasOne + p2.next.val;
            hasOne = next / 10;
            next = next % 10;
            cur.next = new ListNode(next);

            p2 = p2.next;cur=cur.next;
        }
        if(hasOne == 1){
            cur.next = new ListNode(1);
        }
        return ans.next;
    }
}
