import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class CheckForPairInArrayAsSumofNumX {
	
	/*
	 * Sorting Approach. Use inbuilt sort method which uses merge sort.
	 * After the sort is done just use two pointers one to first and one to last index 
	 * of the array
	*/	
	public int findPairForGivenNumBySort(int a[],int number){
		Arrays.sort(a);
		int firstIndex = 0;
		int lastIndex = a.length-1;
		
		while(firstIndex<lastIndex){
			if(a[lastIndex]+a[firstIndex] == number){
				return 1;
			}else if(a[lastIndex]+a[firstIndex] < number){
				firstIndex++;
			}else{
				lastIndex--;
			}
		}
		return 0;
	}
	/*
	 * Use of HashMap. Take a Boolean HashMap and register the element in the HashMap.
	 * If the Num - Arr[i] exists in HashMap then return true
	*/
	public int findPairForGivenNumByHashMap(int a[],int number){
		HashMap check = new HashMap();
		
		for(int i=0;i<a.length;i++){
			if(check.containsKey(number - a[i])){
				return 1;
			}
			check.put(a[i], 1);
		}
		
		return 0;
	}
	public static void main(String args[]){
		CheckForPairInArrayAsSumofNumX checkPair = new CheckForPairInArrayAsSumofNumX();
		int[] a = {1, 4, 45, 6, 10, -8};
		System.out.println(checkPair.findPairForGivenNumBySort(a, 16));
		System.out.println(checkPair.findPairForGivenNumByHashMap(a, 16));
	}
}
/*
findPairForGivenNumBySort(a,16) has complexity O(nlogn) because of the merge sort
findPairForGivenNumBySort(a,16) has complexity O(n) because of hashmap search.
*/
