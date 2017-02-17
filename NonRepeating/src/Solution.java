import java.util.HashMap;
import java.util.Map;


public class Solution {

	 public static int singleNumber(int[] nums) {
	        /*HashMap<String,Integer> map = new HashMap<String,Integer>();
	        
	        for(int i = 0;i<nums.length;i++){
	            if(map.get(nums[i])==null){
	                map.put(String.valueOf(nums[i]),1);
	            }else{
	                int count = map.get(nums[i]);
	                map.put(String.valueOf(nums[i]),count++);
	            }
	        }
	        for(Map.Entry<String,Integer> entry: map.entrySet() ){
	        	//System.out.println(entry.getKey()+"  "+entry.getValue());
	            if(entry.getValue()==1)return I ;
	        }
	        return -1;*/
		 int ans =0;
		    
		    int len = nums.length;
		    for(int i=0;i!=len;i++){
		    	System.out.println(ans+" XOR "+nums[i]);
		        ans ^= nums[i];
		        System.out.println(ans);
		    }
		    
		    return ans;
	    }
	 
	 public static void main(String[] args) {
		 int arr[]={2,30,2};
		 System.out.println(singleNumber(arr));
	}
}
