import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class Solution {
	
	public static void main(String[] args) {
		Vector<String> s1 = new Vector<String>(); 
		Vector<String> s2 = new Vector<String>(); 
		s1.add("I");
		s1.add("Love");
		s1.add("My");
		s1.add("India");
		
		s2.add("I");
		s2.add("Love");
		s2.add("America");
		//s2.add("America");
		ArrayList<String> l = findString(s1,s2);
		for(int i =0;i<l.size();i++){
			System.out.println(l.get(i));
		}
	}

	private static ArrayList<String> findString(Vector<String> s1, Vector<String> s2) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<s1.size();i++){
			if(map.containsKey(s1.get(i))){
				map.put(s1.get(i), map.get(s1.get(i))+1);
				//list.remove(s1.get(i));
			}else{
				map.put(s1.get(i),1);
				//list.add(s1.get(i));
			}
		}
		for(int i=0;i<s2.size();i++){
			if(map.containsKey(s2.get(i))){
				map.put(s2.get(i), map.get(s2.get(i))+1);
				//list.remove(s2.get(i));
			}else{
				map.put(s2.get(i),1);
				//list.add(s2.get(i));
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) { 
				if(entry.getValue()==1){
					list.add(entry.getKey());
				}
			}
		return list;
	}
}
*/

class Solution{

public static void main(String[] args){

	Vector<String> vector1 = new Vector<String>();
	Vector<String> vector2 = new Vector<String>();

	vector1.add("I");
	vector1.add("Love");
	vector1.add("India");
	vector2.add("I");
	vector2.add("Love");
	vector2.add("America");
	

	ArrayList<String> list = new ArrayList<String>();
	list = finddistinct(vector1,vector2);
	for(int i=0;i<list.size();i++){
		System.out.println(list.get(i));
	}
}

private static ArrayList<String> finddistinct(Vector<String> s1, Vector<String> s2){
HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
ArrayList<String> list = new ArrayList<String>();
for(int i=0;i<s1.size();i++){
	if(hashmap.containsKey(s1.get(i))){
		hashmap.put(s1.get(i),hashmap.get(s1.get(i))+1);
		}else{
		hashmap.put(s1.get(i),1);
		}
	}
for(int i=0;i<s2.size();i++){
	if(hashmap.containsKey(s2.get(i))){
		hashmap.put(s2.get(i),hashmap.get(s2.get(i))+1);
		}else{
		hashmap.put(s2.get(i),1);
		}
	}
for(Map.Entry<String, Integer> entry : hashmap.entrySet()){
	if(entry.getValue()==1){
		list.add(entry.getKey());
		}
	}
	return list;
 }
}