import java.util.ArrayList;
import java.util.Stack;

public class solution {

	static String result = "";

	public static void main(String[] args) {
		// String s = Scanner.nextLine();
		String s = "(AB)C(G(DE)F)|SS";
		parse(s);
	}

	private static void parse(String s) {
		System.out.println(s);
		String[] tokens = s.split("\\|");

		String expr = tokens[0];
		String seq = tokens[1];

		String expr_WithoutSpace = expr.replaceAll("\\s", "");
		String seq_WithoutSpace = seq.replaceAll("\\s", "");
		System.out.println("expr is :" + expr_WithoutSpace);
		System.out.println("seq is:" + seq_WithoutSpace);

		int Scount = 0;
		int Rcount = 0;
		for (int i = 0; i < tokens[1].length() - 1; i++) {
			if (seq_WithoutSpace.charAt(i) == 'S') {
				Scount++;
			} else if (seq_WithoutSpace.charAt(i) == 'R') {
				Rcount++;
			}
		}
		if (Scount > 0)
			simplify(expr_WithoutSpace);
		if(Rcount>0 && Rcount%2!=0)
			reverse(result);
	}

	private static void reverse(String simplifiedString) {
		result = new StringBuilder(simplifiedString).reverse().toString();
		//find all occurances of left bracket from begining
		ArrayList<Integer> leftBracket = new ArrayList<Integer>();
		ArrayList<Integer> rightBracket = new ArrayList<Integer>();
		for (int i = -1; (i = result.indexOf('(', i + 1)) != -1; ) {
			leftBracket.add(i);
		} 
		for (int i = -1; (i = result.indexOf(')', i + 1)) != -1; ) {
			rightBracket.add(i);
		} 
		StringBuilder newResult = new StringBuilder(result);
		for(int index:leftBracket){
			newResult.setCharAt(index, ')');
		}
		for(int index:rightBracket){
			newResult.setCharAt(index, '(');
		}
		result = newResult.toString();
		
		System.out.println("FINAL:"+result);
	}

	private static void simplify(String expr_WithoutSpace) {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = expr_WithoutSpace.toCharArray();
		int i = 0;
		int end = 0;
		for(int k=0;k<expr_WithoutSpace.length();k=end+2){
			i=k;
			while (i < expr_WithoutSpace.length() && arr[i] != '(') {
				result += arr[i];
				System.out.println(result);
				i++;
			}
			int start = i;
			if (start >= expr_WithoutSpace.length())	return ;			
			System.out.println(result);
			stack.push(arr[start]);
			i++;
			while (!stack.isEmpty()) {
				if (arr[i] == '(') {
					stack.push(arr[i]);
				} else if (arr[i] == ')') {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					// result += arr[i];
					i++;
				}
			}
			i--;
			end = i--;
			//if (end < 1)
				//return expr_WithoutSpace;
			String newStr = expr_WithoutSpace.substring(start + 1, end + 1);
			//System.out.println(newStr);
			if(start!=0){
				result += "(";
				simplify(newStr);
				result += ")";
			}else{
				simplify(newStr);
			}
			System.out.println(result);
		}
		return ;
	}

}