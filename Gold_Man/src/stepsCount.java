//ARRAY//http://algorithms.tutorialhorizon.com/dynamic-programming-stairs-climbing-puzzle/
//MAP//http://stackoverflow.com/questions/12255193/count-number-of-possible-paths-up-ladder

import java.util.HashMap;
import java.util.Map;

public class stepsCount {

	private static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	static {
	    map.put(1, 1);
	    map.put(2, 2);
	}
	
	private static int stepWays(int stepCount) {
		if (map.containsKey(stepCount)) return map.get(stepCount);
		
	    int decrement, double_decrement;
	    if (map.containsKey(stepCount-1)){
	    	decrement = map.get(stepCount-1);
	    }else{
	    	decrement = stepWays(stepCount-1);
	        map.put(stepCount-1,decrement);
	    }
	    if (map.containsKey(stepCount-2)){
	        double_decrement= map.get(stepCount-2);
	    }else {
	        double_decrement=stepWays(stepCount-2);
	        map.put(stepCount-2,double_decrement);
	    }

	    return decrement+double_decrement;
	}
	
	public static void main(String[] args) {
		System.out.println(stepWays(10000));
	}

}
