
public class ReserveAlgoForArrayRotation {
	public static void reverseArrayMyApproach(int[] a, int d){
		int temp = 0;
		for(int i=0;i<a.length;i++){
			temp = a[i];
			a[i] = a[d];
			a[d] = temp;
			if(d != a.length -1)
				d++;
		}
		
		for(int j = 0; j<a.length;j++)
			System.out.print(a[j]);
	}
	
	public static void leftRotateG2G(int[] a,int d,int n){
		 reverseAlgoG2GApproach(a,0,d-1);
		 reverseAlgoG2GApproach(a,d,a.length-1);
		 reverseAlgoG2GApproach(a,0,a.length-1);
		 
		 for(int j = 0; j<a.length;j++)
			System.out.print(a[j]);
	}


	public static int[] reverseAlgoG2GApproach(int[] a,int start,int n){

		int temp = 0;
		int end = n;
		while(start<end){
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
		
		return a;
	}

	// juggling algorithm
	public static void leftRotate(int arr[], int d, int n)
	{

		int i, j, k, temp;
		for (i = 0; i < gcd(d, n); i++)
		{
    /* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while(true)
			{
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}

		for(int m = 0; m<arr.length;m++)
			System.out.print(arr[m]);
	}

	public static int gcd(int a,int b)
	{
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
	}

	public static void main(String args[]){
		int i[] =  {1,2,3,4,5,6,7};
		reverseArrayMyApproach(i,2);
		System.out.println("");
		leftRotateG2G(i,2,i.length);
		System.out.println("");
		leftRotate(i,2,i.length);
	}
}
