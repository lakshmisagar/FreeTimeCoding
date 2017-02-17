import java.util.ArrayList;
import java.util.List;

public class Solution{
static List<Integer> l = new ArrayList<Integer>();
public static void findMagic(int[]array,int index){
	if(index>=array.length)return;
	if(array[index] == index)l.add(index);
	findMagic(array,++index);
	}


/*public static void findMagic(int[]array,int start,int end,int mid){
	if(start<0 || end>array.length)return;
	if(mid<0 || mid>array.length)return;
	if(start==end){
		if(array[start]==start){
			l.add(start);
		}
		return;
	}
	if(array[mid] == mid){
		l.add(mid);
		findMagic(array,start,mid-1,start+mid/2);
		findMagic(array,mid+1,end,start+end/2);
	}else if(array[mid] < mid){
		findMagic(array,start,mid-1,start+mid/2);
	}else{
		findMagic(array,mid+1,end,start+end/2);
	}
	return;
}*/
public static void main(String args[]){
	int[] array = {2,2,4,4,4,5,5,7};
	findMagic(array,0);
	for(int i=0;i<l.size();i++){
		System.out.println(l.get(i));
	}
}

}