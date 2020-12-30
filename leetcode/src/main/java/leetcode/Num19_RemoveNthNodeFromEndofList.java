package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Num19_RemoveNthNodeFromEndofList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode tempNext = next;
            while (tempNext!=null) {
                sb.append(" -> ").append(tempNext.val);
                tempNext = tempNext.next;
            }
            return sb.toString();
        }
    }

    // O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // skip n nodes
        for (int i = 0; i < n+1; i++) {
            first = first.next;
        }
        while (first!=null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    // O(n)
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head.next==null && n>0) {
//            return null;
//        }
//        ListNode lastNNodesHead = head;
//        int count = 1;
//
//        ListNode current = head;
//
//        while (current.next!=null) {
//            current = current.next;
//            if(count>n) {
//                lastNNodesHead = lastNNodesHead.next;
//            }
//            count ++;
//        }
//
//        if(n==count) {
//            return head.next;
//        } else {
//            lastNNodesHead.next =  lastNNodesHead.next.next;
//            return head;
//        }
//    }


    // O(2n)
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int count = 1;
//        ListNode current = head;
//        while(current.next!=null) {
//            current = current.next;
//            count++;
//        }
//
//
//        current = head;
//        for (int i = 0; i < count-(n+1); i++) {
//            current = current.next;
//        }
//
//        current.next = current.next.next;
//
//        return head;
//    }
}
