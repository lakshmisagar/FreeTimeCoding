import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	
    public static int[] intersect(int[] nums1, int[] nums2) {
    	if(nums1.length==0 || nums2.length==0)return new int[]{};
    	//
    	List<Integer> list = new ArrayList<Integer>();
    	int index = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums1.length;i++){
			if(map.containsKey(nums1[i])){
				int count = map.get(nums1[i]);
				map.put(nums1[i], ++count);
			}else{
				map.put(nums1[i], 1);
			}
		}
		for(int i =0;i<nums2.length;i++){
			if(map.containsKey(nums2[i])){
			int count = map.get(nums2[i]);
			if(count>0){
				map.put(nums2[i], --count);
				list.add(nums2[i]);
				index++;
			}
			}
		}
		int result[] = new int[list.size()];
		for(int i=0;i<list.size();i++){
			result[i]=list.get(i);
		}
		return result;
        
    }
    
    public static void main(String[] args) {
		int array1[] = {1,2,2,1};
		int array2[] = {2,2};
		int result[] = intersect(array1,array2);
		for(int i = 0; i<result.length;i++){
			System.out.println(result[i]);
		}
	}
}