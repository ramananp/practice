/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 206. Reverse Linked List
 */

public class ReversingLinkedList {
    
    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        ListNode _1 = new ListNode(3);
        ListNode _0 = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = _0;
        _0.next = _1;
        System.out.println(reverse(head).val);
    }

}