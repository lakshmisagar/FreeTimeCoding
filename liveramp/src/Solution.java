import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {
	public static String ans(int a, int b, int c, int d){
		List<Integer> list = new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		int hr1=-1,hr2=-1,min1=-1,min2=-1;
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
		
		 for (int i = 0; i < list.size(); i++) {
            if(isHour1(list.get(i))){
            	hr1=i;
            	break;
            }
		 }
		 if(hr1==-1)return "NOT POSSIBLE";
		 for (int i = 0; i < list.size(); i++) {
	            if(i!= hr1 && isHour2(list,list.get(i),hr1)){
	            	hr2=i;
	            	break;
	            }
			 }
		 if(hr2==-1)return "NOT POSSIBLE";
		 for (int i = 0; i < list.size(); i++) {
	            if(isMin1(list.get(i))){
	            	if(i!= hr1){
	            		if(i!=hr2){
	            			min1=i;
	    	            	break;
	            		}
	            	}
	            }
			 }
		 if(min1==-1)return "NOT POSSIBLE";
		 for (int i = 0; i < list.size(); i++) {
	            if(i!= hr1){
	            	if(i!=hr2){
	            		if(i!=min1){
	            			min2=i;
	    	            	break;
	            	}
	            }
	            }
			 }
		 //System.out.println(list.get(hr1)+""+list.get(hr2));
		 return list.get(hr1)+""+list.get(hr2)+":"+list.get(min1)+""+list.get(min2);
	}
	private static boolean isHour1(int val){
		if(val==0||val==1||val==2)return true;
		return false;
	}
	private static boolean isHour2(List<Integer> list, int val,int hr1){
		if(list.get(hr1)== 2){
			if(val==0||val==1||val==2 ||val==3)return true;
		}else{
			return true;
		}
		return false;
	}
	private static boolean isMin1(int val){
		if(val>=0 && val<=5)return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.print(ans(3,0,7,0));
	}
}
