/*
 * The changing condition for dynamic programming is "We should ignore
 * the sum of the previous n-1 elements if nth element is greater than the sum."
*/

public class LargestSumContiguousSubarray {
	public static void subarraySimple(int[] a){
		int max_so_far = a[0], max_here = a[0];
		
		for(int i=1;i<a.length;i++){
			max_here = Math.max(a[i],max_here + a[i]);
			max_so_far = Math.max(max_so_far, max_here);
		}
		System.out.println(max_so_far);
	}
	public static void subarrayDP(int[] a){
		int max_so_far = a[0];
		int[] sum = new int[a.length];
		sum[0] = a[0];
		
		for(int i=1;i<a.length;i++){
			sum[i] = Math.max(a[i],sum[i-1] + a[i]);
			max_so_far = Math.max(max_so_far, sum[i]);
		}
		System.out.println(max_so_far);
	}
	public static void main(String args[]){
		int i[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		subarraySimple(i);
		subarrayDP(i);
	}
}
