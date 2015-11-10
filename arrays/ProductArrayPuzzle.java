/**
 * Created by Rohith Vallu on 10/24/2015.
 *
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal
 * to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).

    Example:
    arr[] = {10, 3, 5, 6, 2}
    prod[] = {180, 600, 360, 300, 900}

 */

public class ProductArrayPuzzle {
    public static void product(int[] arr){
        int n = arr.length;
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        int prod[] = new int[arr.length];
        left[0] = 1;
        right[n-1] = 1;
        for(int i = 1; i < n; i++)
            left[i] = arr[i-1]*left[i-1];

        /* Construct the right array */
        for(int j = n-2; j >=0; j--)
            right[j] = arr[j+1]*right[j+1];

        /* Construct the product array using
            left[] and right[] */
        for (int i=0; i<n; i++) {
            prod[i] = left[i] * right[i];
            System.out.print(prod[i]+ " ");
        }


    }

    public static void main(String[] args) {
        int i[] = {10, 3, 5, 6, 2};
        product(i);
    }

}
