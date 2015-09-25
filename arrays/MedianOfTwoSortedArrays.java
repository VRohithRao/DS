/*
	1) Calculate the medians m1 and m2 of the input arrays ar1[] 
	   and ar2[] respectively. 
	   Example :
	   ar1[] = {1, 12, 15, 26, 38}
   	   ar2[] = {2, 13, 17, 30, 45}
   	   
	2) If m1 and m2 both are equal then we are done.
	     return m1 (or m2)
	     
	3) If m1 is greater than m2, then median is present in one 
	   of the below two subarrays.
	    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
	    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
	4) If m2 is greater than m1, then median is present in one    
	   of the below two subarrays.
	   a)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
	   b)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
	5) Repeat the above process until size of both the subarrays 
	   becomes 2.
	6) If size of the two arrays is 2 then use below formula to get 
	  the median.
	    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
*/

public class MedianOfTwoSortedArrays {
	
	public static void medianofTwoArrays(int array1[], int array2[]){
		
	}
	public static int getMedian(int array[]){
		int n = array.length;
		
		if(n % 2 == 0)
			return (array[n/2] + array[n/2-1])/2;
		else
			return array[n/2];
		
	}
	
	public static void main(String args[]){
		int i[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		
	}
}
