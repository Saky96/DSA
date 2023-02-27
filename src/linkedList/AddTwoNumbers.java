package linkedList;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1=
//        addTwoNumbers();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode n1 = l1;
        // ListNode n2 = l2;
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        // l3.val = 0;
        // l3.next = null;

        int carry = 0;
        int result = 0;

        while(l1 != null || l2 != null || carry != 0){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            int temp = 0;
            if(sum > 10){
                carry = carry + 1;
                temp = sum % 10;
                // l3.val = temp;
                l3.next = new ListNode(temp);
            }
            else{
                carry = 0;
                // l3.val = sum;
                l3.next = new ListNode(sum);
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return l3.next;
    }
}
