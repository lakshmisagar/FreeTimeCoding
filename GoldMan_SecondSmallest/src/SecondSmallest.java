
public class SecondSmallest {

private static void FindSecondSmall(int[] arr) {
	
	int length = arr.length;
	if(length<2)return;
	int smallest = Integer.MAX_VALUE;
	int SecondSmall = Integer.MAX_VALUE;
	
	for(int i=0;i<length;i++){
        if (smallest>arr[i]){
            SecondSmall = smallest;
            smallest = arr[i];
        }else if ( (SecondSmall>arr[i]) && (smallest!=arr[i]) ){
            SecondSmall = arr[i];
        }
	}
   /* if (second == Integer.MAX_VALUE)
        System.out.println("There is no second" +
                           "smallest element");
    else*/
        System.out.println(SecondSmall);
	
	
}
	public static void main(String[] args) {
		int arr[] = {12, 13, 1, 10, 34, 1};
        FindSecondSmall(arr);
	}

	
}
