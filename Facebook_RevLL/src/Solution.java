class LinkedList{
	
	Node head;

	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}	

	private static Node reverse(Node head){
		Node prev = null;
		Node temp = head;
		Node cur = head;
		
		while(cur!=null){
			cur = cur.next;
			temp.next = prev;
			prev = temp;
			temp = cur;
		}
		return prev;
	}
	

	private static void recursiveRev(Node head2) {
			if(head2.next==null)return;
				head2 = head2.next;
				recursiveRev(head2);
				System.out.println(head2.data);
	}
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);
		
		Node head = reverse(list.head);
		
		Node tmp = head;
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
		
		recursiveRev(head);
	}

}