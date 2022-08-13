package CarlPractice;

import java.awt.*;

class carlLinkedList {
	public static void main(String[] args) {
		//1 --> 2 -->6 --> 3 --> 4 --> 5 --> 6}
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(6);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		// 203. 移除链表元素
		ListNode answer1 = removeElements(head, 6);
		
		
		// Answer output
		ListNode cur = answer1;
		while (cur != null) {
			System.out.print(cur.val + ", ");
			cur = cur.next;
		}

		
	}
	
	// 单链表的定义
	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {};
		
		ListNode (int val) {
			this.val = val;
		}
		
		ListNode (int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	// 203. 移除链表元素
	// link: https://leetcode.cn/problems/remove-linked-list-elements/
	
	/**
	* 原链表删除元素
	* 时间复杂度 O(n)
	* 空间复杂度 O(1)
	*/
	public static ListNode removeElements(ListNode head, int val) {
		
		if (head == null) {
			return head;
		}
			
		while (head != null && head.val == val) {
			head = head.next;
		}
			
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		
		return head;
		
	}
	
	/**
	* 添加虚节点方式
	* 时间复杂度 O(n)
	* 空间复杂度 O(1)
	*/
	
	public static ListNode removeElements2(ListNode head, int val) {
		
		if (head == null) {
			return head;
		}
		
		ListNode dHead = new ListNode (-1, head); //创建虚拟首节点
		ListNode cur = dHead;
		
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		
		return dHead.next;
		
	}
	
	// 707. 设计链表
	// Link: 
	
	
	
	
	// 面试题 02.07. 链表相交
	// Link: https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		int lenA = 0, lenB = 0;
		ListNode curA = headA;
		ListNode curB = headB;
		
		// Step 1: 计算链条的长度
		while (curA != null) {
			lenA ++;
			curA = curA.next;
		}
		
		while (curB != null) {
			lenB ++;
			curB= curB.next;
		}
		
		// step2: swap 让curA为最长链表的头，lenA为其长度
		curA = headA;
		curB = headB;
		
		if (lenA > lenB) {
			int tempL = lenA;
			lenA = lenB;
			lenB = tempL;
			
			ListNode temp = curA;
			curA = curB;
			curB = temp;
		}
		
		// Step3: 求长度差, 让curA和curB在同一起点上（末尾位置对齐）
		int gap = lenA - lenB;
		
		// Step4: 遍历curA 和 curB，遇到相同则直接返回
		while (gap-- > 0) {
			if (curA == curB) {
				return curA;
			}
			curA = curA.next;
			curB = curB.next;
		}
		
		return null;
	}
	
}