import java.util.Arrays;


public class Solution {

	public static void main(String[] args){
		findgreater(12345);
		findsmallest("10987598023");
	}

	private static void findgreater(int num) {
		int i,j;
		char[] numb = (""+num).toCharArray();
		int n = numb.length;
		
		for(i=n-1 ; i>0 ; i--){
			if(numb[i]>numb[i-1]){
				break;
			}
		}
		
		if(i==0){
			System.out.println(" Not possible");
			return;
		}
		
		int x = Character.getNumericValue(numb[i-1]);
		int smallest = i;
		
		for(j=i+1; j<n; j++){
			if(numb[j]>x && numb[j]<numb[smallest]){
				smallest = j;
			}
		}
		
		numb = swap(numb,smallest,i-1);
		
		Arrays.sort(numb, i, n);
		
		System.out.println(numb);
		return;
	}

	private static void findsmallest(String num) {
		int i,j;
		char[] numb = (""+num).toCharArray();
		int n = numb.length;
		
		for(i=n-1 ; i>0 ; i--){
			if(Character.getNumericValue(numb[i])<Character.getNumericValue(numb[i-1])){
				break;
			}
		}
		
		if(i==0){
			System.out.println(" Not possible");
			return;
		}
		
		int x = Character.getNumericValue(numb[i-1]);
		int largest = i;
		
		for(j=i+1; j<n; j++){
			if(Character.getNumericValue(numb[j])<x && Character.getNumericValue(numb[j])>Character.getNumericValue(numb[largest])){
				largest = j;
			}
		}
		
		numb = swap(numb,largest,i-1);
		
		Arrays.sort(numb, i, n);
		
		int firstPointer = i;
		int secondPointer = n-1;
		while(firstPointer < secondPointer){
			char temp1 = numb[firstPointer];
			numb[firstPointer] = numb[secondPointer];
			numb[secondPointer] = temp1;
			firstPointer++;
			secondPointer--;
		}
		
		System.out.println(numb);
		
		return;
	}
	
	private static char[] swap(char[] numb, int x, int y) {
		char x_char = numb[x];
		char y_char = numb[y];
		numb[y] = x_char;
		numb[x] = y_char;
		return numb;
	}
	
	
	///////////////////////Smallest using INT ////////////////////////////////////
/*	private static void findsmallest(int num) {
		int i,j;
		char[] numb = (""+num).toCharArray();
		int n = numb.length;
		int[] numbers = new int[numb.length];
		for(int k = 0; k < numb.length; k++){
			numbers[k] = Character.getNumericValue(numb[k]);
		}
		for(i=n-1 ; i>0 ; i--){
			if(numbers[i]<numbers[i-1]){
				break;
			}
		}
		//i position
		if(i==0){
			System.out.println(" Not possible");
			return;
		}
		
		int x = numbers[i-1];
		int largest = i;
		
		for(j=i+1; j<n; j++){
			if(numbers[j]<x && numbers[j]>numbers[largest]){
				largest = j;
			}
		}

		int temp = numbers[largest];
		numbers[largest] = numbers[i-1];
		numbers[i-1] = temp;
		
		//numb = swap(numb,largest,i-1);
		
		Arrays.sort(numbers, i, n);
		int firstPointer = i;
		int secondPointer = n-1;
		while(firstPointer < secondPointer){
			int temp1 = numbers[firstPointer];
			numbers[firstPointer] = numbers[secondPointer];
			numbers[secondPointer] = temp1;
			firstPointer++;
			secondPointer--;
		}
		//String s = numb.toString().substring(i, n);
		//StringBuilder rev = new StringBuilder(s).reverse();
		//String result = numb.toString().substring(0, i)+rev;
		
		//System.out.println(result);
		int newnum = 0;
		for(int m = 0; m < numbers.length; m++){
			newnum = newnum*10 + numbers[m];
		}
		System.out.println(newnum);
		return;
	}*/
}
