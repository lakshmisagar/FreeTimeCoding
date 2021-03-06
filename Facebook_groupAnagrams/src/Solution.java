import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Solution {

	private static ArrayList<ArrayList<String>> group(ArrayList<String> list){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrayList = new ArrayList<String>();
		
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(int i=0;i<list.size();i++){
			arrayList = new ArrayList<String>();
			if(map.containsKey(getStringCode(list.get(i)))){
				arrayList.addAll(map.get(getStringCode(list.get(i))));
			}
			arrayList.add(list.get(i));
			map.put(getStringCode(list.get(i)),arrayList);
		}
		for (Map.Entry<String, ArrayList<String>> entry: map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
		
	}

	private static String getStringCode(String string) {
		int[] alphabet = new int[26];
		for(int i=0;i<string.length();i++){
			int index = string.charAt(i)-'a';
			alphabet[index]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < alphabet.length; i++){
			if(alphabet[i] > 0){
				char appc = (char)('a'+i);
				sb.append(appc+String.valueOf(alphabet[i]));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("sagar");
		list.add("asgar");
		list.add("ragas");
		list.add("srini");
		list.add("inisr");
		ArrayList<ArrayList<String>> result = group(list);
		for(int i=0;i<result.size();i++){
		   for(int j =0;j<result.get(i).size();j++){
			   System.out.print(result.get(i).get(j)+"   ");
		   }
		   System.out.println();
		}
	}
}
