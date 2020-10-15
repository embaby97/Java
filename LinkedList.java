/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Alaa
 */

import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {

    /**
     * @param args the command line arguments
     */
       public static  Node insert(Node head,int data) {
        //Complete this method
        if(head == null)
        return new Node( data);
    else if(head.next == null){
            head.next = new Node(data);
        }
    else{
        insert(head.next,data);
    }


        return head;
    }

	public static void display(Node head) {
        System.out.print("Your inputs: ");    
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }
        
   public static void main(String args[]) {
        System.out.print("Enter number of inputs: ");
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
    
}

    
