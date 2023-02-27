package stacks;

class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

public class LinkedListStack {
    Node head;
    int size;

    public LinkedListStack() {
        this.head = null;
        this.size = 0;
    }

    void push(int data){
        Node node = new Node(data, null);
        Node temp = head;
        head = node;
        head.next = temp;
        size ++;
    }

    int pop() throws Exception {
        if(head == null){
            throw new Exception("Stack Underflow");
        }
        Node result = head;
        head = head.next;
        size --;
        return result.data;
    }

    int peek() throws Exception{
        if(head == null){
            throw new Exception("Stack is Empty");
        }

        return head.data;
    }

    Boolean isEmpty(){
        return head == null;
    }

    void display(){
        if(head == null){
            System.out.println("[]");
        }
        Node temp = head;
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
        LinkedListStack st = new LinkedListStack();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.display();
        st.pop();
        st.display();

    }

}
