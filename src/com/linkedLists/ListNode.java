package com.linkedLists;

public class ListNode {

	public int val;	//default access modifiers (can be used inside the same package)
	public ListNode next;
	
	public ListNode(){}
	
	public ListNode(int data){
		this.val = data;
	}
	
	public ListNode(int val, ListNode next){
		this.val=val;
		this.next=next;
	}
	
	
}
