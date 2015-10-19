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
		int[] temp = new int[a.length];
		temp[0] = sum[0];

		for(int i=1;i<a.length;i++){
			sum[i] = Math.max(a[i],sum[i-1] + a[i]);
			max_so_far = Math.max(max_so_far, sum[i]);

			if(a[i] > sum[i-1] + a[i] ) {
				temp = new int[a.length];
				temp[i] = a[i];
			}
			if(i==a.length-1 && sum[i-1] > sum[i]){
				temp[i] = 0;
			}else{
				temp[i] = a[i];
			}
		}
		System.out.println(max_so_far);

		for(int m = 0; m<temp.length;m++) {
			System.out.print(temp[m] + " ");
		}
	}
	public static void main(String args[]){
		int j[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		int i[] =  {-2,-4,5,-2,3,-5,6};
		subarraySimple(i);
		System.out.println();
		subarrayDP(j);
		System.out.println();
		subarrayDP(i);
	}
}
