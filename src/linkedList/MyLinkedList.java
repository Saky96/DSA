package linkedList;

public class MyLinkedList<T> {

    static class Node<N> {
        N data;
        Node<N> next;

        public Node(N data) {
            this.data = data;
        }

        public N getData() {
            return data;
        }

        public void setData(N data) {
            this.data = data;
        }

        public Node<N> getNext() {
            return next;
        }

        public void setNext(Node<N> next) {
            this.next = next;
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "data=" + data +
//                    ", next=" + next +
//                    '}';
//        }
    }

    public Node<T> head = null;
    public Node<T> tail = null;


    public static void main(String[] args) {
        MyLinkedList<Integer> ls = new MyLinkedList<>();
        ls.add(10);
        ls.add(20);
        ls.add(40);

//        ls.insert(30, 0);
//        ls.display();
//        ls.delete(0);
//        ls.display();
//        ls.reverseLinkedList();
//        ls.display();
//        ls.removeVal(20);

        MyLinkedList<String> ls2 = new MyLinkedList<>();
        ls2.add("Sanjay");
        ls2.add("Sangeeta");
        ls2.add("Saksham");
        ls2.add("Shaurya");

        ls2.insert("Satpal", 0);
        ls2.insert("Geeta", 1);
//        ls2.display();
//        System.out.println(ls2.reverseLinkedList(ls2.head));
//        ls2.display();

        MyLinkedList<Integer> ls3 = new MyLinkedList<>();
        ls3.add(1);
        ls3.add(2);
//        ls3.add(3);
//        ls3.add(2);
//        ls3.add(1);
//        ls3.removeVal(2);
//        System.out.println(ls3.findMidInLinkedList());
//        System.out.println(ls3.findPalindromeInLinkedList());

        MyLinkedList<Integer> ls4 = new MyLinkedList<>();
        ls4.add(1);
        ls4.add(2);
        ls4.add(3);
        ls4.add(4);
        ls4.add(5);
        ls4.add(6);
        ls4.add(7);
        ls4.tail.next = ls4.head.next.next;
        System.out.println(ls4.tail.next.data);
        System.out.println(ls4.isCycle().data);
        System.out.println(ls4.detectCycleNode(ls4.isCycle()).data);
    }

    void add(T data){
        Node<T> newNode = new Node<>(data);

        //Checks if the list is empty
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
        }
        tail = newNode;
    }

    void display(){
        Node<T> curr = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of linked list: ");
        while (curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println(" ");
    }

    void insert(T data, int pos) {
        Node<T> toBeAdded = new Node<>(data);
        if (pos == 0) {
            toBeAdded.next = head;
            head = toBeAdded;
            return;
        }
        Node<T> prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }

        toBeAdded.next = prev.next;
        prev.next = toBeAdded;
    }

    void delete(int pos){
        if(pos == 0){
            head = head.next;
            return;
        }

        Node<T> prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
    }

    Node<T> reverseLinkedList(Node<T> head){
        Node<T> cur = head;
        Node<T> prev = null;

        while (cur != null){
            Node<T> temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

//        System.out.println(prev);
        this.head = prev;
        return prev;
    }

    Node<T> findMidInLinkedList(){
        Node<T> fast = this.head;
        Node<T> slow = this.head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    boolean findPalindromeInLinkedList(){
        if(head == null){
            return true;
        }
        Node<T> cur = this.head;
        Node<T> mid = findMidInLinkedList();
        Node<T> last = reverseLinkedList(mid);

        while (last != null){
            if(cur.data != last.data){
                return false;
            }

            cur = cur.next;
            last = last.next;
        }

        return true;
    }

    void removeVal(T val){
        //Approach1
        //         ListNode fakeHead = new ListNode(-1);
//         fakeHead.next = head;
//         ListNode cur = head, prev = fakeHead;

//         while(cur != null){

//             if(cur.val == val){
//                 prev.next = cur.next;
//             }
//             else{
//                 prev = prev.next;
//             }
//                 cur = cur.next;
//         }

//         return fakeHead.next;


        //Approach2
        Node<T> prev = new Node<>(null);
        prev.next = head;
        Node<T> cur = prev;

        while(cur.next != null){
            if(cur.next.data == val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }

        }
        System.out.println(prev.next);
//        return head;
    }

    Node<T> isCycle(){

        Node<T> slow = this.head;
        Node<T> fast = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.data == slow.data){
                return slow;
            }
        }
        return null;
    }

    Node<T> detectCycleNode(Node<T> intersect){
        Node<T> cur = this.head;
        Node<T> meet = intersect;

        if(meet != null){
            while (cur != meet){
                cur = cur.next;
                meet = meet.next;
            }

            return cur;
        }
        return null;
    }


}


