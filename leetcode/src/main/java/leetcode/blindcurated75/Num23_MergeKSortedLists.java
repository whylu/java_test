package leetcode.blindcurated75;

import leetcode.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class Num23_MergeKSortedLists {


    // use PriorityQueue
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            while (node!=null) {
                queue.add(node);
                node = node.next;
            }
        }
        if(queue.isEmpty()) {
            return null;
        }
        ListNode poll = queue.poll();
        poll.next = null;
        ListNode head = poll;
        ListNode tail = head;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            poll.next = null;
            tail.next = poll;
            tail = tail.next;
        }
        return head;
    }

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Merge k Sorted Lists.
    //Memory Usage: 40.6 MB, less than 60.96% of Java online submissions for Merge k Sorted Lists.
//    // divide and conquer
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length==0) {
//            return null;
//        }
//        int interval = 1;
//        while (interval<lists.length) {
//            for (int i = 0; i < lists.length; i+=interval*2) {
//                if(i+interval<lists.length) {
//                    lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
//                }
//            }
//            interval *= 2;
//        }
//        return lists[0];
//    }
//
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

}
