//9.5 Write a method to compute all permutations of a string

package DPnREC;

import java.util.ArrayList;

public class nine_point_five {

/*	private static ArrayList<String> getPermutation(String str) {
		if (str == null)
			return null;
		ArrayList<String> perm = new ArrayList<String>();
		if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char first = str.charAt(0);
		String rem = str.substring(1);// remove 1st char [1 - n]
		ArrayList<String> words = getPermutation(rem);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				perm.add(s);
			}
		}
		return perm;
	}

	private static String insertCharAt(String word, char first, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + first + end;
	}*/

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++) {
				String prefix_include_i = prefix + str.charAt(i);
				String left_i = str.substring(0, i);
				String right_i = str.substring(i + 1, n);
				String exclude_i =  left_i+right_i ;
				permutation(prefix_include_i, exclude_i);
			}
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		/* ArrayList<String> l = */permutation("", s);
		/*
		 * for(int i=0;i<l.size();i++){ System.out.println(i+":   "+l.get(i)); }
		 */
	}

}
