package DPnREC;

import java.util.ArrayList;

public class nine_point_six_paranthesis {

	public static void addParen(ArrayList<String> list, int leftRem,int rightRem,char[] str,int count){
		if(leftRem <0 || rightRem < leftRem)return;
		if(leftRem ==0 && rightRem ==0){
			String s = String.copyValueOf(str);
			list.add(s);
		}else{
			if(leftRem>0){
				str[count] = '(';
				addParen(list, leftRem-1, rightRem, str, count+1);
			}
			if(rightRem > leftRem){
				str[count]=')';
				addParen(list, leftRem, rightRem-1, str, count+1);
			}
		}
	}
	
	public static void main(String[] args) {
		char[] str = new char[3*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, 3, 3	, str, 0);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
