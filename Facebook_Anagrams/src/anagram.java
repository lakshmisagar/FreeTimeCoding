import java.util.Arrays;


public class anagram {

	  public static boolean isAnagram(String s, String t) {
	        if(s.length()!=t.length()) return false;
	        
	        int[] aplhabet = new int[26];
	        
	        for(int i=0;i<s.length();i++){
	            aplhabet[s.charAt(i)-'a']++;
	        }
	        
	        for(int i=0;i<t.length();i++){
	            aplhabet[t.charAt(i)-'a']--;
	        }
	        
	         for(int i=0;i<26;i++){
	            if(aplhabet[i]!=0) return false;
	        }
	        
	        return true;
	      
	    }

	       public static void main(String[] args) {
			boolean check = isAnagram("sagar","ragas");
			System.out.println(check);
		}
}
