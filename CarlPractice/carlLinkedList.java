package CarlPractice;

import java.awt.*;

class carlLinkedList {
	public static void main(String[] args) {
		//1 --> 2 -->6 --> 3 --> 4 --> 5 --> 6}
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
//		head.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
		
		// 203. 移除链表元素
//		ListNode answer = removeElements(head, 6);
		
		// 24. 两两交换链表中的节点
//		ListNode answer = swapPairs(head);
		
		// 19. 删除链表的倒数第 N 个结点
		ListNode answer = removeNthFromEnd(head, 1);
		
		// Answer output
		ListNode cur = answer;
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
	// Link: https://leetcode.cn/problems/design-linked-list/
	
	// 单链表
	class MySingleLinkedList {
		
		//size存储链表元素的个数
		int size;
		//虚拟头结点
		ListNode head;
		
		public MySingleLinkedList() {
			size = 0;
			head = new ListNode(0);
		}
		
		// 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
		public int get(int index) {
			//如果index非法，返回-1
			if (index < 0 || index > size) {
				return -1;
			}
			
			ListNode cur = head;
			//包含一个虚拟头节点，所以查找第 index+1 个节点
			for (int i = 0; i < index; i++){
				cur = cur.next;
			}
			return cur.val;
		}
		
		// 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
		public void addAtHead(int val) {
			addAtIndex(0, val);
		}
		
		// 将值为 val 的节点追加到链表的最后一个元素。
		public void addAtTail(int val) {
			addAtIndex(size, val);
			
		}
		
		// 在链表中的第 index 个节点之前添加值为 val  的节点。
		// 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
		// 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。

		public void addAtIndex(int index, int val) {
			if (index > size) {
				return;
			}
			if (index < 0) {
				index = 0;
			}
			size ++;
			ListNode pred = head;
			for (int i = 0; i < index; i++) {
				pred = pred.next;
			}
			
			ListNode toAdd = new ListNode(val);
			toAdd.next = pred.next;
			pred.next = toAdd;
			
		}
		
		//如果索引 index 有效，则删除链表中的第 index 个节点。
		public void deleteAtIndex(int index) {
			if (index < 0 || index >= size) {
				return;
			}
			size--;
			ListNode pred = head;
			for (int i = 0; i < index; i ++) {
				pred = pred.next;
			}
			pred.next = pred.next.next;
		}
	}
	
	// 双链表
	class MyLinkedList {
		class ListNode {
			int val;
			ListNode next,prev;
			ListNode(int x) {val = x;}
		}
		
		int size;
		ListNode head,tail;//Sentinel node
		
		/** Initialize your data structure here. */
		public MyLinkedList() {
			size = 0;
			head = new ListNode(0);
			tail = new ListNode(0);
			head.next = tail;
			tail.prev = head;
		}
		
		/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
		public int get(int index) {
			if(index < 0 || index >= size){return -1;}
			ListNode cur = head;
			
			// 通过判断 index < (size - 1) / 2 来决定是从头结点还是尾节点遍历，提高效率
			if(index < (size - 1) / 2){
				for(int i = 0; i <= index; i++){
					cur = cur.next;
				}            
			}else{
				cur = tail;
				for(int i = 0; i <= size - index - 1; i++){
					cur = cur.prev;
				}
			}
			return cur.val;
		}
		
		/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
		public void addAtHead(int val) {
			ListNode cur = head;
			ListNode newNode = new ListNode(val);
			newNode.next = cur.next;
			cur.next.prev = newNode;
			cur.next = newNode;
			newNode.prev = cur;
			size++;
		}
		
		/** Append a node of value val to the last element of the linked list. */
		public void addAtTail(int val) {
			ListNode cur = tail;
			ListNode newNode = new ListNode(val);
			newNode.next = tail;
			newNode.prev = cur.prev;
			cur.prev.next = newNode;
			cur.prev = newNode;
			size++;
		}
		
		/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
		public void addAtIndex(int index, int val) {
			if(index > size){return;}
			if(index < 0){index = 0;}
			ListNode cur = head;
			for(int i = 0; i < index; i++){
				cur = cur.next;
			}
			ListNode newNode = new ListNode(val);
			newNode.next = cur.next;
			cur.next.prev = newNode;
			newNode.prev = cur;
			cur.next = newNode;
			size++;
		}
		
		/** Delete the index-th node in the linked list, if the index is valid. */
		public void deleteAtIndex(int index) {
			if(index >= size || index < 0){return;}
			ListNode cur = head;
			for(int i = 0; i < index; i++){
				cur = cur.next;
			}
			cur.next.next.prev = cur;
			cur.next = cur.next.next;
			size--;
		}
	}
	
	/**
	* Your MyLinkedList object will be instantiated and called as such:
	* MyLinkedList obj = new MyLinkedList();
	* int param_1 = obj.get(index);
	* obj.addAtHead(val);
	* obj.addAtTail(val);
	* obj.addAtIndex(index,val);
	* obj.deleteAtIndex(index);
	*/
	
	
	// 206.反转链表
	// Link：https://leetcode.cn/problems/reverse-linked-list/
	
	public ListNode reverse (ListNode cur, ListNode pre) {
		if (cur == null) return pre;
		ListNode temp = cur.next;
		cur.next = pre;
		return reverse (temp, cur);
	}
	
	
	public ListNode reverseList(ListNode head) {
		return reverse(head, null);
	}
	
	// 24. 两两交换链表中的节点
	// Link: https://leetcode.cn/problems/swap-nodes-in-pairs/
	
	public static ListNode swapPairs(ListNode head) {
		
		// Step 1: cur 指向虚拟头节点
		ListNode dummyH = new ListNode(0);
		dummyH.next = head;
		ListNode cur = dummyH;
		
		
		while(cur.next != null && cur.next.next != null) {
			ListNode temp = cur.next; // 缓存第二位
			ListNode temp2 = cur.next.next.next;
			cur.next = cur.next.next;
			cur.next.next = temp;
			temp.next = temp2;
			cur = cur.next.next;
		}
		return dummyH.next;
		
		}
		
	// ！！ 递归解法
	public static ListNode swapPairs2(ListNode head) {
		// base case 提交退出
		if (head == null || head.next == null) return head;
		// 获取当前节点的下一个节点
		ListNode next = head.next;
		// 进行递归
		ListNode newNode = swapPairs(next.next);
		// 这里进行交换
		next.next = head;
		head.next = newNode;
		return next;
	}
		
	// 19.删除链表的倒数第N个节点
	// Link: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode cur = dummyNode;
		int len = 0, i = 0;
	
		while (cur.next != null) {
			cur = cur.next;
			len ++;
		}
		System.out.println(len);
		
		cur = dummyNode;
		while (cur.next != null) {      
			if (i == (len - n)) {
				cur.next = cur.next.next;
				break;
			} else {
				cur = cur.next;
				i++;
			}
		}
		
		return dummyNode.next;
		
		}
	
	// 双指针思路
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode slow = dummy, fast = dummy;
		
		// 先让快指针找到需要删除的node
		while (n-- > 0) {
			fast = fast.next;
		}
		
		//记住 待删除节点slow的上一节点
		ListNode prev = null;
		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		// 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
		prev.next = slow.next;
		// 释放 待删除节点slow 的next指针, 这句删掉也能AC
		slow.next = null;
		
		return dummy.next;
	}

			
	
	
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
		
		if (lenA < lenB) {
			int tempL = lenA;
			lenA = lenB;
			lenB = tempL;
			
			ListNode temp = curA;
			curA = curB;
			curB = temp;
		}
		
		// Step3: 求长度差, 让curA和curB在同一起点上（末尾位置对齐）
		int gap = lenA - lenB;
		while (gap-- > 0) {
			curA = curA.next;
		}
		
		// Step4: 遍历curA 和 curB，遇到相同则直接返回
		while (curA != null) {
			if (curA == curB) {
				return curA;
			}
			curA = curA.next;
			curB = curB.next;
		}
		
		return null;
	}
	
	
	// 142. 环形链表 II
	// Link: https://leetcode.cn/problems/linked-list-cycle-ii/
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) { // 表示有环
				ListNode index1 = fast;
				ListNode index2 = head;
				// 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
				while (index1 != index2) {
					index1 = index1.next;
					index2 = index2.next;
				}
				return index1;
			}
		}
		
		return null;
	}
	
}