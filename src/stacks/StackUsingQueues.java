package stacks;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueues {

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    void push(int n){
//            while(!q1.isEmpty()){
//                q2.offer(q1.remove());
//            }

            q2.offer(n);

            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
    }

    int pop(){
        return q1.poll();
    }

    public static void main(String[] args) {
        StackUsingQueues s = new StackUsingQueues();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);
//        s.pop();
//        s.pop();
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    @Override
    public String toString() {
        return "StackUsingQueues{" +
                "q1=" + q1 +
                ", q2=" + q2 +
                '}';
    }
}
