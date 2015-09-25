import java.util.Arrays;

/*
 * 9.1 (CCI)
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
 */

/**
 * 
 * @author RamnathReddyMedikonda
 *
 */

public class MergeTwoSortedArrays {
	
	public int[] mergeTwoSortedArrays(int[] firstArray, int[] secondArray) {
		if (secondArray == null || firstArray == null)
			return null;
		if (secondArray.length == 0)
			return firstArray;
		
		int i = firstArray.length - secondArray.length - 1 ;
		int j = secondArray.length - 1;
		int end = firstArray.length - 1;
		
		while (i >= 0 && j >= 0) {
			if (firstArray[i] > secondArray[j]) {
				firstArray[end--] = firstArray[i--];
			}
			else if (firstArray[i] <= secondArray[j]) {
				firstArray[end--] = secondArray[j--];
			}
		}
		// We check this condition to make sure that we iterate through all the elements of j without leaving any element till the end
		// In this case, we are merging j into i so we need to make sure we are checking all the elements in j.
		while (j >= 0)
			firstArray[end--] = secondArray[j--];
		
		return firstArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] firstArray = new int[15];
		for (int i = 0, j = 1; i < 10; i++, j = j + 2)
			firstArray[i] = j;
		
		int[] secondArray = {2, 4, 6, 8, 30};
		System.out.println("First Arrays is: " + Arrays.toString(firstArray));
		System.out.println("Second Array is: " + Arrays.toString(secondArray));
		MergeTwoSortedArrays mergeObject = new MergeTwoSortedArrays();
		
		System.out.println("First Array after merging: " + Arrays.toString(mergeObject.mergeTwoSortedArrays(firstArray, secondArray)));
	}
}
