package com.practice.forkjointask;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeExample {

    public static void main(String[] args) {

        AtomicInteger integer = new AtomicInteger(10);
        integer.addAndGet(1);


        Node treeRootNode = new Node();
        treeRootNode.data = 10;

        Node node1 = new Node();
        node1.data = 19;

        Node node2 = new Node();
        node2.data = 18;

        Node node3 = new Node();
        node3.data = 17;
        node3.left = node2;
        node3.right = node1;

        treeRootNode.left = node3;

        node1 = new Node();
        node1.data = 11;

        node2 = new Node();
        node2.data = 12;

        node3 = new Node();
        node3.data = 13;
        node3.left = node2;
        node3.right = node1;
        treeRootNode.right = node3;

        //Print DFS, inorder
        executeDFS(treeRootNode);

        //Print BFS
        executeBFS(treeRootNode);
    }

    private static void executeBFS(Node treeRootNode) {
        Queue<Node> treeTraversal = new LinkedList<>();
        treeTraversal.offer(treeRootNode);
        System.out.println("BFS-------------------");
        while(!treeTraversal.isEmpty()) {
            Node node = treeTraversal.poll();
            System.out.println("Data " + node.data);
            if(node.left != null) {
                treeTraversal.offer(node.left);
            }
            if (node.right != null) {
                treeTraversal.offer(node.right);
            }
        }
    }

    private static void executeDFS(Node treeRootNode) {
        if(treeRootNode == null)
            return;
        executeDFS(treeRootNode.left);
        System.out.println("Data " + treeRootNode.data);
        executeDFS(treeRootNode.right);
    }


    static class Node {
        int data;
        Node left;
        Node right;
    }


}
