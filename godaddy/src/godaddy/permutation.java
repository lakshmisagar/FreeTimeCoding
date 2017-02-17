package godaddy;

import java.util.Arrays;


public class permutation {
	
	public static void main(String[] args) {
		nextGreatest("ab");
	}

	private static void nextGreatest(String string) {
		int i,j;
		int n = string.length();
		for (i = string.length()-1; i>0 ; i--){
			if(string.charAt(i) > string.charAt(i-1)){
				break;
			}
		}

		if(i == 0){
			System.out.println("no answer");
			return;
		}
		
		int small = i;
		char x = string.charAt(i-1);
		
		for( j = i+1; j<string.length(); j++){
			if(string.charAt(j)> x && string.charAt(j)<string.charAt(small)){
				small = j;
			}
		}
		
		char[] charString = string.toCharArray();
		
		char temp  = charString[small];
		charString[small]  = charString[i-1];
		charString[i-1] = temp;
		
		string = String.valueOf(charString);
		
		String sub = string.substring(i);
		char[] chars = sub.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        string = string.substring(0,i)+sorted;
		System.out.println(string);
	}

}
