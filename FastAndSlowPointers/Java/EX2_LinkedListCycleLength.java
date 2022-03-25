package FastAndSlowPointers;
//Problem 1: Given the head of a LinkedList with a cycle, find the length of the cycle.
public class EX2_LinkedListCycleLength {
    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
    //In my solution I counted the slow pointer beforehand and got the same result
    public static int findCycleLength(ListNode head) {
        ListNode slow= head;
        ListNode fast = head;
        int count = 0;
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow= slow.next.next;
            count ++;
            if (fast == slow){
                return count;
            }
        }
        return count;
    }
    // site example of the solution
//    public static int findCycleLength(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null or fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            if (slow == fast) // found the cycle
//                return calculateLength(slow);
//        }
//        return 0;
//    }
//
//    private static int calculateLength(ListNode slow) {
//        ListNode current = slow;
//        int cycleLength = 0;
//        do {
//            current = current.next;
//            cycleLength++;
//        } while (current != slow);
//        return cycleLength;
//    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: "
                + findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: "
                +findCycleLength(head));
    }
}
