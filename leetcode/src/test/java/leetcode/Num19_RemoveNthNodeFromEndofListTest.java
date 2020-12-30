package leetcode;

import org.junit.Test;

import static leetcode.Num19_RemoveNthNodeFromEndofList.ListNode;

public class Num19_RemoveNthNodeFromEndofListTest {

    @Test
    public void test1() {
        Num19_RemoveNthNodeFromEndofList s = new Num19_RemoveNthNodeFromEndofList();

        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5
                                        )))));
        ListNode listNode = s.removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }


    @Test
    public void test2() {
        Num19_RemoveNthNodeFromEndofList s = new Num19_RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        ListNode listNode = s.removeNthFromEnd(head, 1);
        System.out.println(listNode);
    }

    @Test
    public void test3() {
        Num19_RemoveNthNodeFromEndofList s = new Num19_RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1,
                new ListNode(2));
        ListNode listNode = s.removeNthFromEnd(head, 2);
        System.out.println(listNode); // 2
    }


    @Test
    public void test4() {
        Num19_RemoveNthNodeFromEndofList s = new Num19_RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(3)));
        ListNode listNode = s.removeNthFromEnd(head, 1);
        System.out.println(listNode); // 1 -> 2
    }

    @Test
    public void test5() {
        Num19_RemoveNthNodeFromEndofList s = new Num19_RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1,
                new ListNode(2));
        ListNode listNode = s.removeNthFromEnd(head, 1);
        System.out.println(listNode); // 1
    }


}