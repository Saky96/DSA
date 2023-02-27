package queues;

class Node{
    int data;
    queues.Node next;

    Node(int data){
        this.data = data;
//        this.next = next;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "data=" + data +
//                ", next=" + next +
//                '}';
//    }
}

public class LinkedListQueue {
    Node front, rear;

    void enqueue(int data){
        Node newNode = new Node(data);

        if(front == null){
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() throws Exception {
        if(front == null){
            throw new Exception("Queue is already empty");
        }
        int result = front.data;
        front = front.next;
        return result;
    }

    void display(){
        if(front == null){
            System.out.println("[]");
        }
        Node temp = front;
        System.out.print("[");
        while (temp != null){
            if(temp.next == null){
                System.out.print(temp.data);
            }
            else {
                System.out.print(temp.data+", ");
            }
            temp = temp.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(55);
        queue.enqueue(78);
        queue.enqueue(86);
        queue.enqueue(91);
        queue.display();
        System.out.println(queue.dequeue());
        queue.display();
    }
}
