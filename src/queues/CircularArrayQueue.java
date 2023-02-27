package queues;

import java.util.Arrays;

public class CircularArrayQueue {
    int n;
    int[] a;
    int front, rear;

    CircularArrayQueue(int n){
        this.n = n;
        this.a = new int[n];
        this.front = -1;
        this.rear = -1;
    }

    void enqueue(int data) throws Exception {
        if(((rear + 1) % n) == front){
            throw new Exception("Queue is full");
        }

        if(front  == -1){
            front = 0;
        }

        rear = (rear + 1) % n;
        a[rear] = data;
//        return data;
    }

    int dequeue() throws Exception{
        if((front == -1 )){
            throw new Exception("Queue is Already empty");
        }
        int res = a[front];
        a[front] = 0;

        if(front == rear){
            front = rear = -1;
        }
        else {
            front = (front + 1) % n;
        }
        return res;
    }


    public static void main(String[] args) throws Exception {
        CircularArrayQueue caq = new CircularArrayQueue(4);
        caq.enqueue(4);
        System.out.println(Arrays.toString(caq.a));
//        caq.dequeue();
        caq.enqueue(5);
        System.out.println(Arrays.toString(caq.a));
        caq.dequeue();
        caq.enqueue(6);
        System.out.println(Arrays.toString(caq.a));
        caq.dequeue();
        caq.enqueue(7);
        System.out.println(Arrays.toString(caq.a));
        caq.dequeue();
        System.out.println(Arrays.toString(caq.a));
        caq.enqueue(8);
        caq.enqueue(8);
        System.out.println(Arrays.toString(caq.a));


//        caq.dequeue();
//        caq.dequeue();
//        caq.dequeue();


//        caq.dequeue();
    }
}
