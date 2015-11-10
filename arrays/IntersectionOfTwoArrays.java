import java.util.Arrays;

/**
 * Created by Rohith Vallu on 10/21/2015.
 *
 * For the sorted arrays, it is very easy and straightforward.
 * All we need to take is two pointers starting from first of the arrays and print if a1[i] == a2[j].
 * Duplicates are automatically handled because of this.
 * This is done in O(n)
 *
 * Code below is for the unsorted arrays.
 */
public class IntersectionOfTwoArrays {

    public static void printIntersectionFirstMethod(int arr1[], int arr2[])
    {
        int m =0, n = 0;
        // Before finding intersection, make sure arr1[0..m-1] is smaller
        if(arr1.length<=arr2.length) {
            Arrays.sort(arr1);
            m = arr1.length;
            n = arr2.length;
            for (int i=0; i<n; i++)
                if (binarySearch(arr1, 0, m-1, arr2[i]) != -1)
                    System.out.print(arr2[i] +" ");

        }
        else {
            Arrays.sort(arr2);
            m =arr2.length;
            n = arr1.length;
            for (int i=0; i<n; i++)
                if (binarySearch(arr2, 0, m-1, arr1[i]) != -1)
                    System.out.print(arr1[i] +" ");
        }
        // Search every element of bigger array in smaller array
        // and print the element if found

    }

    public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l)
        {
            int mid = (l+r)/2;

            // If the element is present at the middle itself
            if (arr[mid] == x)  return mid;

            // If element is smaller than mid, then it can only be present
            // in left subarray
            if (arr[mid] > x) return binarySearch(arr, l, mid-1, x);

            // Else the element can only be present in right subarray
            return binarySearch(arr, mid+1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

    //    Not to use this as the main method. Above one is good.
    public static void printIntersectionSecondMethod(int arr1[], int arr2[]){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0,j=0;
        while(i< arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] +" ");
                i++;
                j++;
            }
            else if(arr1[i]>arr2[j])
                j++;
            else if(arr2[i]<arr2[j])
                i++;

        }
    }

    public static void main(String args[]){
        int i[] = {6,7,2,3}; // duplicate

        int j[] = {8,3,2,6,9,2};
        printIntersectionFirstMethod(i, j);
        System.out.println();
        printIntersectionSecondMethod(i, j);
    }
}
