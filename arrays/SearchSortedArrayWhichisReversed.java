
public class SearchSortedArrayWhichisReversed {
	public static int recursiveSearch(int[] a, int key){
		int left = 0;
		int right = a.length - 1;
		return binarySearch(a,left,right,key);
	}
	private static int binarySearch(int[] a, int left, int right, int key) {
		// TODO Auto-generated method stub
		if(left>right)
			return -1;
		
		int mid = left + ((right - left) / 2);
		System.out.println(mid +":"+ a[mid]);
		
		if(key == a[mid])
			return mid;
		
		if(a[left] <= a[mid]){
			if(a[mid] > key && key >= a[left]){
				return binarySearch(a,left,mid-1,key);
			}else{
				return binarySearch(a, mid+1, right, key);
			}
		}else{
			if(a[mid] > key && key >= a[left]){
				return binarySearch(a,left,mid-1,key);
			}else{
				return binarySearch(a, mid+1, right, key);
			}
//			if(key>a[mid] && key <= a[right]){
//				return binarySearch(a, mid+1, right, key);
//			}else{
//				return binarySearch(a, left, mid-1, key);
//			}
		}
	}
	
	public static void main(String args[]){
		int i[] = {6,7,2,3,4};
		
		System.out.print(recursiveSearch(i,4));
	}
}
