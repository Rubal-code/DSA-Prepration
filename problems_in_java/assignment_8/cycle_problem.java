import java.io.*;
import java.util.*;

public class Solution {
    static class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static boolean has_cycle(Node head){
        if(head == null){
            return false;
        }
        Node slow=head;
        Node fast=head;
        
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
            return true;
        }
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;
        System.out.println(has_cycle(head));
    }
}