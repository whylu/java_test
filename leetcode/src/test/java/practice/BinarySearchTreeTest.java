package practice;

import org.junit.Test;

import static practice.BinarySearchTree.Node;

public class BinarySearchTreeTest {

    @Test
    public void minDepthBreathFirst() {
        Node n1 = new Node(1);
        Node n2 = n1.setLeft(new Node(2));
        Node n3 = n1.setRight(new Node(3));

        Node n4 = n2.setLeft(new Node(4));
        Node n5 = n2.setRight(new Node(5));
        Node n6 = n3.setRight(new Node(6));

        Node n7 = n4.setLeft(new Node(7));

        int i = Node.minDepthBreathFirst(n1);
        System.out.println(i);
    }

    @Test
    public void minDepthDepthFirst() {
        Node n1 = new Node(1);
        Node n2 = n1.setLeft(new Node(2));
        Node n3 = n1.setRight(new Node(3));

        Node n4 = n2.setLeft(new Node(4));
        Node n5 = n2.setRight(new Node(5));
        Node n6 = n3.setRight(new Node(6));

        Node n7 = n4.setLeft(new Node(7));

        int i = Node.minDepthDepthFirst(n1);
        System.out.println(i);
    }


}