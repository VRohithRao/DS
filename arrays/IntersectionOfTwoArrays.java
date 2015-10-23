import java.util.Arrays;

/**
 * Created by Rohith Vallu on 10/21/2015.
 */
public class IntersectionOfTwoArrays {
    public static void printIntersection(int arr1[], int arr2[])
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
            int mid = l + (r - l)/2;

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

    public static void main(String args[]){
        int i[] = {6,7,2,3,2}; // duplicate
        final String xyz= "a";
        System.out.println(xyz);
        int j[] = {8,3,2,6,9,2};
        printIntersection(i, j);
    }
}
