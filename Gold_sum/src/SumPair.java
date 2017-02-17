import java.util.HashMap;
import java.util.Map;
//http://www.sandeep-kulkarni.com/practice-questions/array_strings/count-pairs-with-given-sum/
//http://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html
public class SumPair {

	private static void printPairs(int[] arr, int sum) {
		if(arr.length < 2)return; 
/*		Set<Integer> set = new HashSet<Integer>(array.length); 
		for(int val : array){
			int req = sum - val; 
			if(!set.contains(req)){ 
				set.add(val); 
				}else { 
					count++;
					System.out.printf("(%d, %d) %n", val, req); 
					} 
			}
*/		
		
		Map<Integer,Integer> h_map = new HashMap<Integer, Integer>();
		for(int val : arr){
			if(!h_map.containsKey(val)){
				h_map.put(val, 1);
			}else{
				int count = h_map.get(val);
				h_map.put(val, count + 1);
			}
		}
 
		int setCount = 0;
		for(int arrVal : arr){
			int req = sum - arrVal; 
			if(h_map.containsKey(req)){
				setCount=setCount + h_map.get(req);	
				if(req == arrVal){
					setCount=setCount-1;
				}
			}
		}
		System.out.println(setCount/2);
		}
	
	public static void main(String[] args) {
		//int length = 5;
		int[] randoms = new int/*[length]*/[]{1,2,3,4,5}; 
		/*for(int i=0; i<length; i++){
			randoms[i] = i+1(int) (Math.random()*15); ;
			}*/
		
		printPairs(randoms,6);
	}
}
