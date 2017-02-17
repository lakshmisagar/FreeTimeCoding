package pyramid;
public class pyramid {
	private static void printSteps(int val) {

		/*int row = 0;
		int n = 0;
		for(int i=1;i<=val;i++){
			if(n<val){
			row++;
			for(int x = 1;x<=row;x++){
				n = n+1;
				if(n==val && x<row){
					row=row-1;
					System.out.println(row);
					return;
				}
			}
		}
		}
		
		System.out.println(row);*/
		int size = 4;
		int []coins= new int[]{1,2,3,4};
		for(int a=0; a<size; a++){
            int row = 0;
		    int n = 0;
            System.out.println(coins[a]);
            for(int i=1;i<=coins[a];i++){
                if(n<coins[a]){
                row++;
                for(int x = 1;x<=row;x++){
                    n = n+1;
                    if(n==coins[a] && x<row){
                        row=row-1;
                //		System.out.println(row);
                        return;
                    }
                }
              }
            }
		//System.out.println(row);
       }
	}
	
	public static void main(String[] args) {

		//SOLUTION 1
		printSteps(5);
		
		//SOLUTION 2
		//System.out.println((-1+Math.sqrt(1+8*6))/2);
	}

	
	

}
