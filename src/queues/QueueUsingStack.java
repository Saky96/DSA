package queues;

import java.util.Arrays;
import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int n){
        s1.push(n);
    }

    int pop(){
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
//        s1.clear();
        int ele = s2.pop();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
//        s2.clear();
        return ele;
    }

    int peek(){
        return s1.get(0);
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();

        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println(q.peek());
        q.push(4);
        q.pop();
        q.pop();
        System.out.println(q);
        System.out.println(q.peek());
    }

    @Override
    public String toString() {
        return "QueueUsingStack{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                '}';
    }
}
