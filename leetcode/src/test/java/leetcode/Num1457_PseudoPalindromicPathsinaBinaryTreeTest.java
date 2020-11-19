package leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.*;

public class Num1457_PseudoPalindromicPathsinaBinaryTreeTest {

    Num1457_PseudoPalindromicPathsinaBinaryTree t = new Num1457_PseudoPalindromicPathsinaBinaryTree();
    @Test
    public void isPalindrome() {

        Deque<Integer> pathNumbers = new LinkedList<>();
        pathNumbers.add(1);
        pathNumbers.add(2);
        pathNumbers.add(3);
        assertThat(t.isPalindrome(pathNumbers)).isEqualTo(0);

        pathNumbers.clear();
        pathNumbers.add(2);
        pathNumbers.add(1);
        pathNumbers.add(1);
        assertThat(t.isPalindrome(pathNumbers)).isEqualTo(1);

        pathNumbers.clear();
        pathNumbers.add(1);
        pathNumbers.add(2);
        pathNumbers.add(3);
        pathNumbers.add(1);
        pathNumbers.add(2);
        assertThat(t.isPalindrome(pathNumbers)).isEqualTo(1);
        pathNumbers.add(3);
        assertThat(t.isPalindrome(pathNumbers)).isEqualTo(1);
    }
}