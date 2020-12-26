package leetcode.blindcurated75;

import leetcode.model.ListNode;
import org.junit.Test;

public class Num21_MergeTwoSortedListsTest {

    @Test
    public void mergeTwoLists() {
        ListNode list1 = ListNode.Factory.create(1, 2, 4);
        ListNode list2 = ListNode.Factory.create(1, 3, 4);
        System.out.println(list1);
        System.out.println(list2);

        Num21_MergeTwoSortedLists solve = new Num21_MergeTwoSortedLists();
        ListNode result = solve.mergeTwoLists(list1, list2);
        System.out.println(result);
    }
}