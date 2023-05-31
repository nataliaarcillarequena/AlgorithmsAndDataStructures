package com.linkedLists;

import com.linkedLists.MyLinkedList.Node;

public class TwoPointers {
	
	/*
	 * Question: Find out if a linked lists contains a cycle  
	 */
	
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 * This has been created in the class MyLinkedList
	 */
	
	public boolean hasCycle(Node head) {
		
		//need to take care of egde case where there is only 1 node- cannot set the fast pointer- but if its a cycle then can do this-
		//make if else condition 
		
		//starting the slow pointer at the head of the linked list and the fast pointer 1 node ahead of the slow
		//but if both start at head then this problem is eliminated- there can be just 1 node (with/without a cycle)
		Node slowPointer = head;
		Node fastPointer= head;
		
		//stop when head.next==null, this means there is no cycle in the linked list- the tail has been reached 
		try {
			while(fastPointer.next!=null && fastPointer!=null) {
			
				//making the fast pointer take 2 steps each iteration and slow pointer takes 1
				slowPointer= slowPointer.next;
				fastPointer=fastPointer.next.next;
				if(slowPointer==fastPointer) {
					return true;
				}
			}
		} catch (NullPointerException e) {
			return false;  //this try catch handles an empty linked list (0 nodes) given as an input, 
			//or instead could of done a check on if head==null and head.next==null 
		}
		
		return false;
	}
	
	/*
	 * question: given the head of the linked list, find the node where the cycle begins 
	 * (do not modify the linked list)- do this independent of the method above
	 * method: using the Floyd's cycle detection algorithm  
	 * could save memory by using if condition on head and head.next (to check if its null) instead of using 
	 * try catch block, also instead of having the nested while loops, could break at the if condition and 
	 * bring the 2nd while loop out and proceed
	 */
	public Node detectCycle(Node head) {
		
		Node slowPointer = head;
		Node fastPointer= head;
		
		//try catch for null pointer
		try {
			while(fastPointer.next!=null && fastPointer!=null) {
			
				//making the fast pointer take 2 steps each iteration and slow pointer takes 1
				slowPointer= slowPointer.next;
				fastPointer=fastPointer.next.next;
				
				if(slowPointer==fastPointer) {
					
					//start from the head and traverse until the start of the cycle is reached
					//when the other pointer traverses the rest of the cycle- back to the beginning
					slowPointer=head;
					
					while(slowPointer!=fastPointer) {
						slowPointer=slowPointer.next;
						fastPointer=fastPointer.next;
					}
					
					return slowPointer;
				}
			}
		} catch (NullPointerException e) {
			return null;
		}
		
		return null;
	}
	
	/*
	 * Question: given the heads of two singly linked lists, return the node at which the two lists intersect
	 * if no intersection, return null.
	 * method: comparing each node in 1 list to each node in the other list
	 */
	public Node getIntersectionNode(Node headA, Node headB) {
		
		//Node p1=headA;
		Node p2=headB;
		
		//edge condition- when both linked lists intersect at the beginning 
		if(headA.next==null || headB.next==null){
			if(headA==headB){
				return headA;
		    }else if(headA.next==headB){
		    	return headB;
		    }else if(headA==headB.next){
		    	return headA;
		    }
		}
		
		while(headA!=null && headA.next!=null) {
			
			while(headB!=null && headB.next!=null) {
				if(headA==headB){
                    return headA; //this is intersection node if both lists are the same 
                }else if(headA.next==headB.next) {
					return headA.next; //this is the intersection node
				}
				headB=headB.next;
			}
			if(headB.next==null) {
				headB=p2;
			}
			headA=headA.next;
		}
		
		return null;
	}
	
	/*
	 * Question: given the head of a linked list, remove the nth mode from the end of the list
	 * and return its head 
	 * method: doing with 1 pass of the linked list using 2 pointers separated by n-1 steps,
	 * when the front pointer gets to the end of the linked list, the pointer behind will be 
	 * on the (n-1)th node, so now it can skip the nth node via slowPointer.next = SlowPointer.next.next,
	 * effectively removing the nth node from the linked list 
	 */
	public Node removeNthFromEnd(Node head, int n) {
		
		Node pointerAhead = head;
		Node pointerBehind = head;
		
		for(int i=0; i<n; i++) {
			pointerAhead=pointerAhead.next;
		}
		
		//edge case, for when we have a linked list of 1 node and n=1 (outputs an empty linked list when n=1
		//is removed so head=null- which is the same as head.next of the original linked list; null)
		 if(pointerAhead==null){
	            return head.next;
	        }
		
		while(pointerAhead!=null && pointerAhead.next!=null) {
			pointerBehind=pointerBehind.next;
			pointerAhead=pointerAhead.next;
		}
		
		pointerBehind.next=pointerBehind.next.next;
		
		return head;
	}
	
	public static void main(String args[]) {
		
		MyLinkedList linkedList = new MyLinkedList();
		
		linkedList.addAtHead(5);
		linkedList.addAtHead(4);
		linkedList.addAtHead(8);
		linkedList.addAtHead(1);
		linkedList.addAtHead(4);
		
		//making the cycle 
//		Node node=linkedList.head;
//		//traversing to the end of the linked list (starting from head node)
//		for(int i=0; i<linkedList.size-1; i++) {
//			node = node.next;
//		}
//		//at the last node, making reference to the 2nd node (index = 1)
//		node.next=linkedList.head.next;
		
		System.out.println(linkedList.get(0));
		System.out.println(linkedList.get(1));
		System.out.println(linkedList.get(2));
		System.out.println(linkedList.get(3));
		System.out.println(linkedList.get(4));
		//System.out.println(linkedList.get(3));
		
		TwoPointers twoPointers = new TwoPointers();
//		
//		System.out.println(twoPointers.hasCycle(node));
//		
//		//the same node refernces printed below
//		System.out.println(twoPointers.detectCycle(node));
//		System.out.println(node);
//		System.out.println(node.next); //different node reference printed- good 
	
		MyLinkedList linkedList2 = new MyLinkedList();
		
		linkedList2.addAtHead(3);
		linkedList2.addAtHead(17);
		linkedList2.addAtHead(19);
		linkedList2.addAtHead(1);
		linkedList2.addAtHead(6);
		linkedList2.addAtHead(5);
		linkedList2.head.next.next.next=linkedList.head.next.next;
		linkedList2.head.next.next.next.next=linkedList.head.next.next.next;
		linkedList2.head.next.next.next.next.next=linkedList.head.next.next.next.next;
		linkedList2.head.next.next=linkedList.head.next.next;
		System.out.println("==============");
		System.out.println(linkedList2.get(0));
		System.out.println(linkedList2.get(1));
		System.out.println(linkedList2.get(2));
		
		
		Node theNode = twoPointers.getIntersectionNode(linkedList.head, linkedList2.head);
		System.out.println(theNode);
		System.out.println(linkedList.get(2));
		System.out.println(theNode);
		
	}
	
}
