
public class maxSubArray {
	
	public static void main(String[] args) {
		/*int maxIndex = -1;
		int array[] = {-2,1,-3,4,-1,2,1,-5,4};
		
		int maxResult = 0;
		int tempResult = 0;
		for(int i = 0;i<array.length;i++){
			if(tempResult+array[i]>0){
				tempResult = tempResult+array[i];
				if(maxResult<tempResult){
					maxResult = tempResult;
					maxIndex = i;
				}
			}
		}
		
		if(maxResult == -1){
			maxIndex = array[0];
			for(int i = 1;i<array.length;i++){
			if(array[i]<maxIndex){
				maxIndex = array[i];
			}
		}

		}
		int sum =0;
		
		for(int i = maxIndex;sum<=maxResult;i--){
			sum = sum+array[i];
		}
		
	}
*/
		int maxIndex = -1;
		int array[] = {-2,-1};
			
			int maxResult = 0;
			int tempResult = 0;
			for(int i = 0;i<array.length;i++){
				if(tempResult+array[i]>0){
					tempResult = tempResult+array[i];
					if(maxResult<tempResult){
						maxResult = tempResult;
						maxIndex = i;
					}
				}else{
				    tempResult = 0;
				}
			}
			
			if(maxResult == 0){
				maxResult = array[0];
				for(int i = 1;i<array.length;i++){
				if(array[i]>maxResult){
					maxResult = array[i];
				    }
			    }
			}
		//	return maxResult;
			System.out.println(maxResult);
	}
}
