package com.linkedLists;

public class MyLinkedList {

	/*
	 * Designing a linked list 
	 */
	
	//inner class node- this is the actual node- the mylinkedlist class is reponsible for 
	//connecting the nodes - via the references 
	public class Node{
		
		int val;
		Node next;
	
		//the constructor
		public Node(int data) {
			this.val = data;
		}
	
	}
	
	//initialising the values
	public Node head;
	public int size;
	//Node tail; //could leave this out tho- as we reference everything from the head no
	
	
	//contsructor for the linked list class- initialise length and head to 0- only need 2 fields here
	public MyLinkedList() {
		this.head=null;
		this.size=0;
	}
	
	//gets the indexth element in the linked list
	public int get(int index) {
		
		//edge conditions
		if(index<0 || index>=size) {
			return -1;
		}
		
		//temp node (starting at head) to traverse the nodes until index node is met
		Node temp = head;
		
		//make the temp node the next node until index node is met
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
		
		//returns the value of the node at desired index
		return temp.val;
	}
	
	//add new node as head of the linked list
	public void addAtHead(int val) {
		
		//initialise the new node with the value val
		Node newNode = new Node(val);
		//setting the new nodes next reference as the current head of the linked list
		newNode.next = this.head;
		
		//set the head of this linked list to new node
		this.head = newNode;
		
		//side increments when new node is added
		size++;
	}
	
	//add element to the end of the linked list (traverse through all then add at end)
	public void addAtTail(int val) {
		
		//initialise new node with the required value
		Node newNode = new Node(val);
		
		//edge case where we have an empty linked list
		if(this.size==0) {
			head = newNode;
		}else {
			//traverse the list until getting to the end node- when the reference to the next node is null
			Node temp = head; //starting traversal at head node
			for(int i=0; i<this.size-1; i++) {
				temp = temp.next;
			}
			//at the last node, adding the next node as new node
			temp.next=newNode;
		}
		
		//increment the size
		size++;
		
	}
	
	public void addAtIndex(int index, int val) {
		
		//edge case- adding at index =0- sam as add at head
		if(index==0) {
			this.addAtHead(val);
			//increment the size
			size++;
		}else if (index>this.size) {
			
		}
		else{
			//initialise new node
			Node newNode = new Node(val);
			Node prev = head;
			Node next;
			
			//get the node at the index and the prev node by traversing the linked list
			for(int i=0; i<index-1; i++) {
				prev = prev.next;
			}
			//inserting the new node between the prev and next nodes (where next node is at the index)
			next = prev.next;
			prev.next = newNode;
			newNode.next=next;
			//increment the size
			size++;
		}
	}
	
	public void deleteAtIndex(int index) {
		
		//taking care of edge case- when deleting at index 0
		if(index==0) {
			//set the head to the next node in the linked list
			head=head.next;
			//decrementing the size of the linked list
			size--;
		}else if (index>=this.size) {
			
		}else{
			
			//traversing the linked list to get to the node to the left of the one 
			//we want to delete- starting from head node
			Node prev = head;
			for(int i=0; i<index -1; i++) {
				prev = prev.next;
			}
			//making the prev node attach to the node after the indexed node (making it deleted
			//from the data structure)
			if(index==size-1) { //edge case where we are deleting from the tail
				prev.next=null;
			}else {
				prev.next=prev.next.next;
			}
			//decrementing the size of the linked list
			size--;
		}
		
		
		
	}
	
	
	public static void main(String args[]) {
		
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(2);
		System.out.println("index:0, val: "+ myLinkedList.get(0));
		myLinkedList.deleteAtIndex(1);
		System.out.println("size: "+ myLinkedList.size);
		
		//myLinkedList.deleteAtIndex(3);
		System.out.println("index 1, val: "+ myLinkedList.get(1));
//		System.out.println("index:1, val: "+ myLinkedList.get(1));
//		System.out.println("================");
//		myLinkedList.addAtIndex(1, 2);
//		System.out.println(myLinkedList.get(0));
//		System.out.println(myLinkedList.get(1));
//		System.out.println(myLinkedList.get(2));
		
//		myLinkedList.addAtHead(3);
//		myLinkedList.addAtHead(4);
//		myLinkedList.addAtHead(5);
//		myLinkedList.addAtIndex(1, 10);
//		
//		System.out.println(myLinkedList.get(0));
//		System.out.println(myLinkedList.get(1));
//		System.out.println(myLinkedList.get(2));
//		System.out.println(myLinkedList.get(3));
//		
//		System.out.println("----------------------");
//		
//		myLinkedList.deleteAtIndex(3);
//		System.out.println(myLinkedList.get(0));
//		System.out.println(myLinkedList.get(1));
//		System.out.println(myLinkedList.get(2));
//		System.out.println("size: "+ myLinkedList.size);
//		
//		System.out.println("----------------------");
//		myLinkedList.addAtIndex(0, 19);
//		System.out.println(myLinkedList.get(0));
//		System.out.println(myLinkedList.get(1));
//		System.out.println(myLinkedList.get(2));
//		System.out.println(myLinkedList.get(3));
//		
//		myLinkedList.addAtIndex(3, 200);
//		System.out.println(myLinkedList.get(4));
		//fix edge case- at at last index
		
		//System.out.println(myLinkedList.tail);
		
	}
	
}
