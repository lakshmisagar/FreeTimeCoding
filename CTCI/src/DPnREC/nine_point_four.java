// 9.4 Write a method to return all subsets of a set.

package DPnREC;

import java.util.ArrayList;

public class nine_point_four {

static /*	private static void mysubset(int set[], int subsetSize, int index) {
		if (subsetSize >= set.length || index+1 >= set.length)
			return;
		for (int i = index + 1; i < set.length - (subsetSize - 1); i++) {
			int count = 0;
			System.out.print("{");
			List<Integer> l = new ArrayList<Integer>();
			while (count < subsetSize) {
				l.add(set[i + count]);
				count++;
			}
			System.out.print(set[index]);
			for (int j = 0; j < l.size(); j++) {
				System.out.print("," + l.get(j));
			}
			System.out.println("}");
		}
		index++;
		mysubset(set, subsetSize, index);
		subsetSize++;
		mysubset(set, subsetSize, 0);
	}*/

	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index){
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else{
			allsubsets = getSubsets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	public static void main(String args[]) {
		int[] data = { 1, 2, 3,4,5 };
		//int subsetSize = 1;
		
		ArrayList<Integer> l= new ArrayList<Integer>();
		for(int i=0;i<data.length;i++){
			l.add(data[i]);
		}
		ArrayList<ArrayList<Integer>> al = getSubsets(l, 0);
		for(int i=0;i<al.size();i++){
			System.out.println(i+":   "+al.get(i));
		}
		//mysubset(data, subsetSize, 0);
	}
}
