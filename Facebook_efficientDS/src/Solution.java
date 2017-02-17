class DoubleLLNode{
	int data;
	int minHeapIndex;
	int maxHeapIndex;
	DoubleLLNode next,prev;
}

class DoubleLLNode newLNode(int data){
	DoubleLLNode node = new DoubleLLNode();
	node.
}
class List{
	DoubleLLNode head;
}

class MinHeap{
	int size;
	int capacity;
	DoubleLLNode doubleLLlNode;
}

class MaxHeap{
	int size;
	int capacity;
	DoubleLLNode doubleLLNode;
}

class MyDs{
	MinHeap minHeap;
	MaxHeap maxHeap;
	List list;
}

class CreateMyDs{
	
	
}
public class Solution {
	public static MyDs createMyDs(int capacity) {
		MyDs myDs = new MyDs();
		myDs.minHeap = createMinHeap(capacity);
		myDs.maxHeap = createMaxHeap(capacity);
		myDs.list = createList();
		return myDs;
	}

	private static List createList() {
		List list = new List();
		list.head = null;
		return list;
	}

	private static MaxHeap createMaxHeap(int capacity) {
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.size = 0;
		maxHeap.capacity = capacity;
		maxHeap.doubleLLNode = new DoubleLLNode();
		return maxHeap;
	}

	private static MinHeap createMinHeap(int capacity) {
		MinHeap minHeap = new MinHeap();
		minHeap.size = 0;
		minHeap.capacity = capacity;
		minHeap.doubleLLlNode = new DoubleLLNode();
		return minHeap;
	}
	

	private static void Insert(MyDs myDs, int ) {
		DoubleLLNode node = new DoubleLLNode();
	}
	
	public static void main(String[] args) {
		MyDs myDs = createMyDs(10);
		Insert(myDs, 10);
	    /*Insert(myDS, 20);
	    Insert(myDS, 30);
	    Insert(myDS, 40);
	    Insert(myDS, 50);*/
	}

}
