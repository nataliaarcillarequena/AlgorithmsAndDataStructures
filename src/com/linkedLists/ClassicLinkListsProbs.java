package com.linkedLists;

import com.linkedLists.MyLinkedList.Node;

public class ClassicLinkListsProbs {


	/*
	 * problem statement: given the head of a singly linked list, reverse the list and return the 
	 * reversed list
	 */
	public ListNode reverseList(ListNode head) {
		
		ListNode headToBe = head;
		ListNode prevHead;
		ListNode newHead=null;
		
		//edge case where 1 node in the linked list
        if(head!=null && head.next ==null){
            return head;
        }
		
		while(head !=null && head.next!=null) {
			prevHead=headToBe;
			headToBe=head.next;
			head.next=headToBe.next;
			newHead = headToBe;
			newHead.next=prevHead;
		}
		
		return newHead;
	}
	
	/*
	 * problem statement: given the head of a linked list and an integer val, remove all the nodes of the 
	 * linked list that has Node.val==val, and return the new head 
	 */
	public ListNode removeElements(ListNode head, int val) {
		
		//get rid of any node which have value val, essentially getting to the 
		//first node where the value is not val 
		while(head!=null && head.val==val) {
			head=head.next;
		}
		
		ListNode traversingNode = head;
		
		//starting from a head which does not have value=val and checking 
		//if each next node will have value val, if so then remove that node 
		//by pointing reference to the node after that 
		//traversing through the linked list otherwise 
		while(traversingNode!=null && traversingNode.next!=null) {
			
			if(traversingNode.next.val==val) {
				traversingNode.next=traversingNode.next.next;
			}else {
				traversingNode=traversingNode.next;
			}
			
		}
		
		return head;
	}
	
	
	
	public static void main(String args[]) {
		
		MyLinkedList linkedList = new MyLinkedList();
		
		linkedList.addAtHead(5);
		linkedList.addAtHead(4);
		linkedList.addAtHead(8);
		
		System.out.println(linkedList.get(0));
		System.out.println(linkedList.get(1));
		System.out.println(linkedList.get(2));
		System.out.println("----------------");
		
		System.out.println(linkedList.head);
		Node originalHead = linkedList.head;
		Node myNode = originalHead.next;
		System.out.println(linkedList.get(0));
		System.out.println(linkedList.get(1));
		System.out.println(linkedList.get(2));
		
		
	}
	
}
