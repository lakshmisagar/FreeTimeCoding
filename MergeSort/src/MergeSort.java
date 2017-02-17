import java.util.Random;


public class MergeSort {
	 private static int[] arr;
	 private static int[] temp;

	 private static void mergesort(int low, int high) {
	        if (low < high) {
	        		int mid = (low + high) / 2;
	        		mergesort(low, mid);
	        		mergesort(mid+1, high);
	        		merge(low, mid, high);
	            }
	      }
	 
	 private static void merge(int low, int mid, int high) {
		 int i = low, left = low, right = mid+1, k;
		 
		 //Copy logically from left and right to Temp array
	     while((left <= mid) && (right <= high)) {
	          if(arr[left] <= arr[right]){
	        	  	temp[i] = arr[left];
	        	  	left++; 
	        	 }else{
	        		 temp[i] = arr[right];
	        		 right++;
	        	 }
	          i++;
	       }
	     
	     //Copy rest of the data to temp
	       if (left > mid){
	    	   for (k = right; k<=high; k++) {
	                  temp[i] = arr[k]; i++;
	    	   	}
	       	}else{
	       		for(k=left; k<=mid; k++) {
	                temp[i] = arr[k]; i++;
	            }
	       }
	       
	       //Copy from temp arr to origional arr
	       for (k=low; k<=high; k++){
	    	   arr[k] = temp[k];
	       }
	  }

public static void main(String[] args) {
	 int size = 10;
	 arr = new int[size];
     temp = new int[size];
     Random random = new Random();
     for(int i=0; i<size; i++){ 
        arr[i] = random.nextInt(size*10); 
        System.out.println(arr[i]);
     }
     System.out.println("SOLUTION");
     mergesort(0,size-1);
     for(int i=0; i<size; i++){ 
         System.out.println(arr[i]);
      }
}
}
