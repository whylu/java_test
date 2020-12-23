package practice;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree {

    static class Node {

        private int id;
        private Node left;
        private Node right;
        private int depth = 1;

        public Node(int id) {
            this.id = id;
        }

        // breadth first traversal
        public static int minDepthBreathFirst(Node node) {
            if (node == null) {
                return 0;
            }
            if (node.isLeaf()) {
                return node.depth;
            }

            Deque<Node> queue = new LinkedList<>();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            while (!queue.isEmpty()) {
                node = queue.pop();
                if (node.isLeaf()) {
                    return node.depth;
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            return node.depth;
        }

        public static int minDepthDepthFirst(Node node) {
            if (node == null) {
                return 0;
            }
            return minDepthDepthFirst(node, Integer.MAX_VALUE);
        }


        private static int minDepthDepthFirst(Node node, int min) {
            if (node.isLeaf()) {
                return node.depth;
            }

            if(node.left!=null) {
                int leftMin = minDepthDepthFirst(node.left, min);
                if(min > leftMin) {
                    min = leftMin;
                }
            }
            if(node.right!=null) {
                int rightMin = minDepthDepthFirst(node.right, min);
                if(min> rightMin) {
                    min = rightMin;
                }
            }
            return min;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        public Node setLeft(Node left) {
            left.depth = this.depth + 1;
            this.left = left;
            return left;
        }

        public Node setRight(Node right) {
            right.depth = this.depth + 1;
            this.right = right;
            return right;
        }
    }
}
