package substringprob;

import java.util.Scanner;

public class subString {
	
	   public static void main(String args[])
	   {
	      String input, sub;
	      int i, j, len;
	 
	      Scanner in = new Scanner(System.in);
	      System.out.println("Enter a string to print it's all substrings");
	      input  = in.nextLine();
	 
	      len = input.length();   
	 
	      System.out.println("Substrings of \""+input+"\" are :-");
	 
	      for( j = 0 ; j < len ; j++ )
	      {
	         for( i = 1 ; i <= len-j ; i++ )
	         {
	            sub = input.substring(j, j+i);
	            System.out.println(sub);
	         }
	      }
	      
	      
	   }
	}
	
