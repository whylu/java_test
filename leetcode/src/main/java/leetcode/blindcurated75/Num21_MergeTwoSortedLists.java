package leetcode.blindcurated75;

import leetcode.model.ListNode;

public class Num21_MergeTwoSortedLists {

//    //recursive
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1==null) {
//            return l2;
//        }
//        if(l2==null) {
//            return l1;
//        }
//        if(l1.val<l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }


    // iterative
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while(head1!=null && head2!=null) {
            if(head1.val<head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;

            }
            tail = tail.next;
        }

        if(head1==null) {
            tail.next = head2;
        }
        if(head2==null) {
            tail.next = head1;
        }

        return head.next;
    }
}
