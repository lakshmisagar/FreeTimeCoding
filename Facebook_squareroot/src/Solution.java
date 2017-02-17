
public class Solution {

	
	private static int findSquareRootOf(int x) {
		
		if(x==0||x==1)return x;
		
		int start = 1;
		int end = x/2;
		int result = 0;
		
		while(start<=end){
			int mid = (start+end)/2;
			if(mid*mid==x)return mid;
			if(mid*mid>x){
				end = mid-1;
			}else{
				start = mid+1;
				end = x/2;
				result = mid;
			}
		}

		return result;
		
	}	
	
public static void main(String[] args) {
	System.out.println(findSquareRootOf(11));
}


}
