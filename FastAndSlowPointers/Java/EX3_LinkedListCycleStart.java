package FastAndSlowPointers;
//Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.

//If we know the length of the LinkedList cycle, we can find the start of the cycle through the following steps:
//
//        Take two pointers. Let’s call them pointer1 and pointer2.
//        Initialize both pointers to point to the start of the LinkedList.
//        We can find the length of the LinkedList cycle using the approach discussed in  LinkedList Cycle. Let’s assume that the length of the cycle is ‘K’ nodes.
//        Move pointer2 ahead by ‘K’ nodes.
//        Now, keep incrementing pointer1 and pointer2 until they both meet.
//        As pointer2 is ‘K’ nodes ahead of pointer1, which means, pointer2 must have completed one loop in the cycle when both pointers meet. Their meeting point will be the start of the cycle.
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
public class EX3_LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        // find the length of the cycle
        while(fast != null && fast.next != null  ){
            slow = slow.next;
            fast = fast.next.next;
            count++;
            if (fast == slow){
                break;
            }
        }
        slow = head;
        fast = head;
        //make the distance of the fast pointer equal to length
        while(count>0 ){
            fast = fast.next;
            count --;
        }
        //find where they meet
        while(slow != fast){
            slow= slow.next;
            fast = fast.next;
        }
        return slow;

    }
    // the creator did it this way but im not sure why they didnt count in the beginning
//    public static ListNode findCycleStart(ListNode head) {
//        int cycleLength = 0;
//        // find the LinkedList cycle
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            if (slow == fast) { // found the cycle
//                cycleLength = calculateCycleLength(slow);
//                break;
//            }
//        }
//
//        return findStart(head, cycleLength);
//    }
//
//    private static int calculateCycleLength(ListNode slow) {
//        ListNode current = slow;
//        int cycleLength = 0;
//        do {
//            current = current.next;
//            cycleLength++;
//        } while (current != slow);
//
//        return cycleLength;
//    }
//
//    private static ListNode findStart(ListNode head, int cycleLength) {
//        ListNode pointer1 = head, pointer2 = head;
//        // move pointer2 ahead 'cycleLength' nodes
//        while (cycleLength > 0) {
//            pointer2 = pointer2.next;
//            cycleLength--;
//        }
//
//        // increment both pointers until they meet at the start of the cycle
//        while (pointer1 != pointer2) {
//            pointer1 = pointer1.next;
//            pointer2 = pointer2.next;
//        }
//
//        return pointer1;
//    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " +
                findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " +
                findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " +
                findCycleStart(head).value);
    }
}
