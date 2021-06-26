package LINKED_LIST;

public class LinkedList{
    Node head;
    
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next = null;
        }
    }

    public void push(int new_data){
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node prev_node,int new_data){

        if(prev_node == null){
            System.out.println("ERROR");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
        
    }

    public void printList(){
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
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
        list1.insertAfter(second,10);
        list1.printList();
    }
}