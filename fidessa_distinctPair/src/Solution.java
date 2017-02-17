import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class Solution {

	private static int getNumberOfPairs(int[] arr, int k) {

		/*Arrays.sort(arr);
		int count = 0;
		int l = 0,r = 0;

		
		HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
		
		while(r <arr.length){
			if(hashMap.containsKey(r) && hashMap.containsValue(true)){
				count++;
				r++;
				l++;
			}else{
				if(arr[r]-arr[l] == k){
					r++;
					l++;
					count++;
					hashMap.put(r, true);
				}else if(arr[r]-arr[l] < k){
					r++;
				}else{
					l++;
				}
			}
		}
		
		return count;*/
		
		//////////////////// O(n) ////////////////////////
		
	/*	HashSet<Integer> hashSet = new HashSet<Integer>();
		for(int i =0;i<arr.length;i++){
			hashSet.add(arr[i]);
		}
		int count =0;
		Iterator<Integer> iterator = hashSet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			if(hashSet.contains(iterator.next()-k)){
				count++;
			}
		}
		return count;
*/
		////////////////////// O(n log n) //////////////////////////////////////////
	int count = 0;
	Arrays.sort(arr);
	int l =0;
	int r =0;
	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	
	while(r < arr.length){
		if(arr[r]-arr[l]==k){
			r++;
			l++;
			count++;
			if(!hashMap.containsKey(arr[l])){
				hashMap.put(arr[l], arr[r]);
			}
		}else if(arr[r]-arr[l]<k){
			r++;
		}else{
			l++;
		}
		
	}
	
	return count;
	
	//////////////////CPP //////////////////////////////
	/* Returns count of pairs with difference k in arr[] of size n. */
	
	/////////////////HASH MAP CPP /////////////////////////////////////
	int countPairsWithDiffK(int arr[], int n, int k)
	{
		int count = 0; // Initialize count

		// Initialize empty hashmap.
		bool hashmap[MAX] = {false};

		// Insert array elements to hashmap
		for (int i = 0; i < n; i++)
			hashmap[arr[i]] = true;

		for (int i = 0; i < n; i++)
		{
			int x = arr[i];
			if (hashmap[x - k])
				count++;
			if (hashmap[x + k])
				count++;
			hashmap[x] = false;
		}
		return count;
	}
	
	
	//////////////////////pointer///////////////////////////////////
	int countPairsWithDiffK(int arr[], int n, int k)
	{
		int count = 0;
		sort(arr, arr+n); // Sort array elements

		int l = 0;
		int r = 0;
		while(r < n)
		{
			if(arr[r] - arr[l] == k)
			{
				count++;
				l++;
				r++;
			}
			else if(arr[r] - arr[l] > k)
				l++;
			else // arr[r] - arr[l] < sum
				r++;
		} 
		return count;
	}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,3,3,2,5,4,4}; 1,2,3,3,4,4,5}
		int k = 1;
		System.out.println(getNumberOfPairs(arr,k));
	}

	
}
