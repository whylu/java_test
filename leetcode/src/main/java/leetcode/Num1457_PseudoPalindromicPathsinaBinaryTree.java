package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num1457_PseudoPalindromicPathsinaBinaryTree {


    // Accepted
    public int pseudoPalindromicPaths (TreeNode root) {

        Deque<Integer> pathNumbers = new LinkedList<>();

        return traceDown(root, pathNumbers);
    }

    private int traceDown(TreeNode node, Deque<Integer> pathNumbers) {
        pathNumbers.add(node.val);
        int sum = 0;
        if(node.left==null && node.right==null) {
            int palindrome = isPalindrome(pathNumbers);
            pathNumbers.pollLast();
            return palindrome; // 0 or 1
        }
        if (node.left!=null) {
            sum += traceDown(node.left, pathNumbers);
        }
        if (node.right!=null) {
            sum += traceDown(node.right, pathNumbers);
        }
        pathNumbers.pollLast();
        return sum;
    }

    protected int isPalindrome(Deque<Integer> pathNumbers) {
        int[] numbers = new int[10];
        pathNumbers.forEach(number-> numbers[number] ++);
        int oddCounter = 0;
        for (int number : numbers) {
            if(number%2==1) {
                oddCounter++;
            }
        }
        return oddCounter==1||oddCounter==0? 1: 0;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}