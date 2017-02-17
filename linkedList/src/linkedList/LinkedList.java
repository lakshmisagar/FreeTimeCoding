package linkedList;

public class LinkedList {

		static NodeBlock head;
		static class NodeBlock {
			int value;
			NodeBlock next;
			NodeBlock(int data) {
				value = data;
				next = null;
			}
		}

		void deleteNode(int delVal) {
			
			while(head.value>delVal){
				head = head.next;
				System.gc();
			}
			NodeBlock cur = head;
			NodeBlock prev = cur;
			
			while(cur!=null){
				if(cur.value > delVal){
					prev.next = cur.next;
					System.gc();
					cur=cur.next;
				}else{
				prev = cur;
				cur=cur.next;
				}
			}
		}
			


		/* Utility function to print a linked list */
		void printList(NodeBlock head) {
			while (head != null) {
				System.out.print(head.value + " ");
				head = head.next;
			}
			System.out.println("");
		}

		public static void main(String[] args) {
			LinkedList list = new LinkedList();
			list.head = new NodeBlock(12);
			list.head.next = new NodeBlock(15);
			list.head.next.next = new NodeBlock(10);
			list.head.next.next.next = new NodeBlock(11);
			list.head.next.next.next.next = new NodeBlock(5);
			list.head.next.next.next.next.next = new NodeBlock(6);
			list.head.next.next.next.next.next.next = new NodeBlock(2);
			list.head.next.next.next.next.next.next.next = new NodeBlock(3);

			System.out.println("Given Linked List :");
			list.printList(head);
			System.out.println("");
			
			// Let us delete the node with value 10
			System.out.println("Deleting value greater than 11 ");
			list.deleteNode(11);

			/*System.out.println("Modified Linked list :");
			list.printList(head);
			System.out.println("");

			// Lets delete the first node
			System.out.println("Deleting first Node");
			list.deleteNode(head, head);
			System.out.println("Modified Linked List");*/
			list.printList(head);

		}
	}

