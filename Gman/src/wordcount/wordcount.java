package wordcount;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class wordcount {

	
	public static void getCount(String s) {
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i = 0; i < s.length(); i++) {
	        char l = s.charAt(i);
	        Integer count = map.get(l);
	        if (count == null) count = 0;
	        map.put(l, count + 1);
	    }
	    Set<Character> keys = map.keySet();
	    for (Character c : keys) {
	        System.out.print(c + map.get(c) );
	    }
	}
	
	public static void main(String[] args) {
		getCount("Sagar");
		
	}
	
}
