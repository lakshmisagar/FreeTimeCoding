package DPnREC;
public class nine_point_one_CTCI{

private static int possibleways(int n,int[] arr){
	if(n == 0){
		arr[n-1] = 0;
		return 0;
	}
	if(n == 1){
		arr[n-1] = 1;
		return 1;
	}
	if(n == 2){
		arr[n-1] = 2;
		return 2;
	}
	if(n == 3) {
		arr[n-1] = 4;
		return 4;
	}
	if(arr[n-1] == 0){
		arr[n-1] = possibleways(n-1,arr)+possibleways(n-2,arr)+possibleways(n-3,arr);
	}
	return arr[n-1];
}

public static void main(String args[]){
	int size= 5;
	int array[]= new int[size];
	System.out.println(possibleways(size,array));
}

}