package 程序员代码面试指南.chapter1;

import java.util.Scanner;
import java.util.Stack;
//cd 6, lc剑指offer 09
public class c02_towStackQueue {
    static class CQueue {
        Stack<Integer> store;
        Stack<Integer> watch;
        public CQueue() {
            store = new Stack<>();
            watch = new Stack<>();
        }
        public int peekHead(){
            if(watch.isEmpty()){
                while(!store.isEmpty()){
                    watch.add(store.pop());
                }
            }
            return watch.peek();
        }
        public void appendTail(int value) {
            store.add(value);
        }

        public int deleteHead() {
            if(watch.isEmpty()){
                while(!store.isEmpty()){
                    watch.add(store.pop());
                }
            }
            if(watch.isEmpty()) return -1;
            return watch.pop();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String[] arr = new String[a];
        CQueue queue = new CQueue();
        in.nextLine();
        for(int i = 0; i < a; i++){
            arr[i] = in.nextLine();
        }
        for(int i = 0; i < a; i++){
            String cur = arr[i];
            if(cur.equals("peek")){
                System.out.println(queue.peekHead());
            }else if(cur.equals("poll")){
                queue.deleteHead();
            }else if(cur.charAt(0) == 'a'){
                String[] info = cur.split(" ");
                int v = Integer.parseInt(info[1]);
                queue.appendTail(v);
            }
        }
    }

}
