package LINKED_LIST;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    public void push(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
        return;
    }

    public void insertAfter(Node prev_node, int new_data) {

        if (prev_node == null) {
            System.out.println("ERROR");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
        return;
    }

    public void insertAtEnd(int new_data) {
        Node new_node = new Node(new_data);
        Node n = head;
        if (head == null) {
            head = new_node;
            return;
        }
        while (n.next != null) {
            n = n.next;
        }

        n.next = new_node;
        return;
    }

    public void deleteNode(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;
        return;
    }

    public void deleteNodeAtPostion(int position) {
        if (head == null) {
            return;
        }

        Node temp = head;
        if (position == 0) {
            head = head.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            return;
        }

        Node next = temp.next.next;
        temp.next = next;

    }

    public void deleteList() {
        head = null;
    }

    public int getLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // iteration
    public boolean searchNode(Node head, int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                System.out.println("FOUND");
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // recursion
    public boolean searchNodeRecursion(Node head, int x) {
        if (head == null) {
            return false;
        }
        if (head.data == x) {
            return true;
        }
        return searchNode(head.next, x);
    }

    // iterative
    public int getNth(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        assert (false);
        return 0;
    }

    // recursive
    static int getNthRecursive(Node head, int index) {
        int count = 0;
        if (head == null) {
            return 0;
        }
        if (count == index) {
            return head.data;
        }

        return getNthRecursive(head.next, index - 1);

    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        list1.head.next = second;
        second.next = third;
        list1.push(4);
        list1.insertAfter(second, 10);
        list1.insertAtEnd(90);
        list1.deleteNode(10);
        list1.deleteNodeAtPostion(3);
        int length = list1.getLength();
        System.out.println(length);
        list1.searchNode(list1.head, 4);
        list1.printList();
        list1.deleteList();

    }
}