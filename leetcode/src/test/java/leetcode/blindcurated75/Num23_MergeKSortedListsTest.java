package leetcode.blindcurated75;

import leetcode.model.ListNode;
import org.junit.Test;

public class Num23_MergeKSortedListsTest {

    @Test
    public void mergeKLists() {
        ListNode[] listNodes = {
                ListNode.Factory.create(1, 4, 5),
                ListNode.Factory.create(1, 3, 4),
                ListNode.Factory.create(2, 6)};
        Num23_MergeKSortedLists solve = new Num23_MergeKSortedLists();
        ListNode merged = solve.mergeKLists(listNodes);

        System.out.println(merged);
    }


    @Test
    public void mergeKLists2() {
        ListNode[] listNodes = {
                ListNode.Factory.create(-2, -1, -1, -1)};
        Num23_MergeKSortedLists solve = new Num23_MergeKSortedLists();
        ListNode merged = solve.mergeKLists(listNodes);

        System.out.println(merged);
    }
}