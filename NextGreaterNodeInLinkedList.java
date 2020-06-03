import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/ 1019. Next
 * Greater Node In Linked List
 */

public class NextGreaterNodeInLinkedList {
    public static int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        while (head != null) {
            A.add(head.val);
            head = head.next;
        }
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < res.length; ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i)) {
                res[stack.pop()] = A.get(i);
            }
            stack.push(i);
        }
        return res;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        ListNode _1 = new ListNode(5);
        ListNode _0 = new ListNode(1);
        ListNode head = new ListNode(2);
        head.next = _0;
        _0.next = _1;
        System.out.println(Arrays.toString(nextLargerNodes(head)));
    }
}