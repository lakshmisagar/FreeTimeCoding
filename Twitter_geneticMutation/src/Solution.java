///https://leetcode.com/problems/minimum-genetic-mutation/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int geneticMutation(String start, String end, String[] bank) {
        //start and end strings are same , so no mutation
    	if(start.equals(end)) return 0;
        //copy bank array data to hashset
    	char[] geneChoice = new char[]{'A', 'C', 'G', 'T'};
    	
    	Queue<String> queue = new LinkedList<String>();
    	queue.offer(start);
        
    	HashSet<String> hashSet_bank = new HashSet<String>();
        HashSet<String> checked = new HashSet<String>();
    	checked.add(start);
        
    	for(String str: bank){
        	hashSet_bank.add(str);
        }
        int index = 0;
        
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            
            while(queueSize > 0) {
            
            	String current = queue.poll();
                if(current.equals(end)) return index;
                
                char[] cur_Arr = current.toCharArray();
                
                for(int i = 0; i < cur_Arr.length; i++) {
                    char oldstring = cur_Arr[i];
                    
                    for(char c: geneChoice) {
                    	cur_Arr[i] = c;
                        String next = new String(cur_Arr);
                        if(hashSet_bank.contains(next) && !checked.contains(next)) {
                        	queue.offer(next);
                        	checked.add(next);
                        }
                    }
                    //copy oldstring to currentarray
                    cur_Arr[i] = oldstring;
                }
                
                queueSize--;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
		String start = "AAAAACCC";
		String end = "AACCCCCC";
		String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
		System.out.println(geneticMutation(start,end,bank));
	}
}
