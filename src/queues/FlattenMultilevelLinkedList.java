package queues;

import java.util.ArrayDeque;
import java.util.Queue;

// Data structure to represent a special linked list node with an
// additional `down` pointer
class Node2d
{
    int data;
    Node2d next;
    Node2d down;

    Node2d(int data) {
        this.data = data;
    }
}

public class FlattenMultilevelLinkedList {

    // Utility function to print a list with `down` and `next` pointers
    public static void printOriginalList(Node2d head)
    {
        if (head == null) {
            return;
        }

        System.out.print(" " + head.data + " ");

        if (head.down != null)
        {
            System.out.print("[");
            printOriginalList(head.down);
            System.out.print("]");
        }

        printOriginalList(head.next);
    }

    public static void main(String[] args)
    {
        // create individual nodes and link them together later
        Node2d one = new Node2d(1);
        Node2d two = new Node2d(2);
        Node2d three = new Node2d(3);
        Node2d four = new Node2d(4);
        Node2d five = new Node2d(5);
        Node2d six = new Node2d(6);
        Node2d seven = new Node2d(7);
        Node2d eight = new Node2d(8);
        Node2d nine = new Node2d(9);
        Node2d ten = new Node2d(10);
        Node2d eleven = new Node2d(11);
        Node2d twelve = new Node2d(12);
        Node2d thirteen = new Node2d(13);
        Node2d fourteen = new Node2d(14);
        Node2d fifteen = new Node2d(15);

        // set head node
        Node2d head = one;

        // set next pointers
        one.next = four;
        four.next = fourteen;
        fourteen.next = fifteen;
        five.next = nine;
        nine.next = ten;
        seven.next = eight;
        eleven.next = thirteen;

        // set down pointers
        one.down = two;
        two.down = three;
        four.down = five;
        five.down = six;
        six.down = seven;
        ten.down = eleven;
        eleven.down = twelve;

        System.out.println("The original list is :");
        printOriginalList(head);

        head = flattenList(head);
        System.out.println("\n\nThe flattened list is :");
        printFlattenedList(head);
    }

    private static void printFlattenedList(Node2d head) {
        if (head == null) {
            return;
        }
        Node2d cur = head;
        while (cur != null){
            System.out.println(cur.data);
//            cur = cur.down;
            cur = cur.next;
        }
    }

    private static Node2d flattenList(Node2d head) {
        Queue<Node2d> nq = new ArrayDeque<>();
        Node2d cur = head;

        if(head == null){
            return null;
        }

        while(cur != null){
// -----------------------------------------down first approach-----------------------------------------

//            //last node is reached
//            if(cur.down == null){
//                //deque the front node and set it as the next node of the current node
//                cur.down = nq.poll();
//            }
//
//            //if the current node has a child
//            if(cur.next != null){
//                nq.offer(cur.next);
//            }
//
//            cur = cur.down;

// -----------------------------------------next first approach-----------------------------------------
            //last node is reached
            if(cur.next == null){
                //deque the front node and set it as the next node of the current node
                cur.next = nq.poll();
            }

            //if the current node has a child
            if(cur.down != null){
                nq.offer(cur.down);
            }

            cur = cur.next;

        }

        return head;
    }
}
