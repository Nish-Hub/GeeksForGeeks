import java.util.Arrays;

/* 
 * Attempt 1 : 
 * Time complexity : O(2n) (Worst)
 * Space complexity : O(1) (Worst)
 * Time taken for Small data size : 164 ms
 * 
 * TODO : 
 * 1. Work on duplicate values - duplicate max , second max
 * 2. test case with size < 
 * 3. Large test case complexity - > 10000,1000000 array elements
 * 4. int will not work for bigger data size
 * 5. Output needs to be printed with Case
 * 6. Needs to add Scanner 
 * 7. Need to read input from a csv file
 */

public class MaximumProductPair_1 {

	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4} ;
		
		long startTime = System.currentTimeMillis();
		triggerAlgo(arr);
		System.out.println("Algo time "+(System.currentTimeMillis() - startTime));
	}
	
	static void triggerAlgo(int[] arr){
		
		
		int[] result=new int[2];  // Space - O(1)
		
		setInitialResultArray(arr,result);
		
		for(int i= 2; i<arr.length;i++) // Time - O(n)
			setConsecutiveResultArray(arr, i, result); // Time - O(2)
		 

		Arrays.stream(result).forEach(System.out::println);

	}
	
	/*
	 * Starting with 2nd index now to check for each index if the max and second max 
	 * in our result array is as per the array values
	 */
	static void setConsecutiveResultArray(int[] arr,int i,int[] result){
		int k=0;
		
		// If the next index is greater than max in the result, swap all
		if(Math.abs(result[k])<arr[i]){
			
			result[0] = result[1];  // stores second max
			result[1] = arr[i];  // stores max
			
		}
		// If the next index is greater than or equal to max in the result, check for second max
			else if(Math.abs(result[k])>=arr[i]){
				// swap only if the current array pointer s greater than the second max
				result[0] = (Math.abs(result[0])>arr[i])? result[0]:arr[i];
				
		}
			
	
	}
	
	/*
	 * 	First time, this is going to set the result array with max and second max where 
	 * 0th index is second max and 1st index is max
	 */
	static void setInitialResultArray(int[] arr,int[] result){
		
		// arr[k],arr[(k>arr.length-1 ?(arr.length-1):(k+1))]
		
		if(null!=result && result.length==0 && (Math.abs(arr[0])>Math.abs(arr[1]))){
			
			result[0] = arr[1];  // stores second max
			result[1] = arr[0];  // stores max
			
		}
	}
}
