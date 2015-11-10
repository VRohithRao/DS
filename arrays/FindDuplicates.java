/**
 * Created by Rohith Vallu on 10/26/2015.
 *
 * Steps:
 * traverse the list for i= 0 to n-1 elements
 * {
 * check for sign of A[abs(A[i])] ;
 *      if positive then
 *          make it negative by   A[abs(A[i])]=-A[abs(A[i])];
 *      else  // i.e., A[abs(A[i])] is negative
 *          this   element (ith element of list) is a repetition
 * }
 */
public class FindDuplicates {

    // Time Complexity : O(n) Space : O(1)
    public static void findDuplicates(int arr[]){
        int i;

        for (i = 0; i < arr.length; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print("  "+ Math.abs(arr[i]));
        }
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3 };
        int i[] = {1, 2, 3, 1, 3, 6, 6}; // the problem assumes the elements in array should not exceed array length.
        findDuplicates(i);

    }
}
