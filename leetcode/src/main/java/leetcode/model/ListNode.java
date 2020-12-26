package leetcode.model;

import leetcode.Num19_RemoveNthNodeFromEndofList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


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

    public static class Factory {
        private ListNode head;
        private ListNode tail;

        public Factory append(int val) {
            ListNode node = new ListNode(val);
            if(head==null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            return this;
        }

        public ListNode build() {
            return head;
        }

        public static ListNode create(int... vals) {
            Factory factory = new Factory();
            for (int val : vals) {
                factory.append(val);
            }
            return factory.build();
        }
    }
}
