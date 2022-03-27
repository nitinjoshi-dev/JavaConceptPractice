package com.practice.forkjointask;

public class LinkedListExample {

    public static void main(String[] args) {
        Node root = null;
        Node prevNode = null;
        for(int i = 10; i< 20; i++) {
            Node currentNode = new Node();
            currentNode.setData(i);
            if(root == null) {
                root = currentNode;
            }
            if(prevNode != null) {
                prevNode.setNextPointer(currentNode);
            }
            prevNode = currentNode;
        }
        Node node = root;
        while(node != null) {
            System.out.println("Data " + node.getData());
            node = node.getNextPointer();
        }

    }

    static class Node {
        int data;
        Node nextPointer;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNextPointer() {
            return nextPointer;
        }

        public void setNextPointer(Node nextPointer) {
            this.nextPointer = nextPointer;
        }
    }


}
