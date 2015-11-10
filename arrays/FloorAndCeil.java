/**
 * Created by Rohith Vallu on 10/24/2015.
 */


public class FloorAndCeil {

    /* We use binary search in this method. Complexity is O(logn). Instead of returning the element or -1 we return
    * index or -1. This we can print ceil and floor of x using the index
    */
    public static int CeilSearch( int[] arr,int low,int high,int x){
        int mid = 0;

        /* Edge cases */
        /* BEGIN */

        if(x <= arr[low])
            return low;
        if(x > arr[high])
            return -1;

        /* END */

        mid = (low + high)/2;  /* low + (high - low)/2 */

        /* If x is same as middle element, then return mid */
        if(arr[mid] == x)
            return mid;

        /* If x is greater than the last element, then return -1 */
        if(x > arr[high])
            return -1;

        /* If x is greater than arr[mid], then either arr[mid + 1]
            is ceiling of x or ceiling lies in arr[mid+1...high]
        */
        else if(arr[mid] < x)
        {
            if(mid + 1 <= high && x <= arr[mid+1])
                return mid + 1;
            else
                return CeilSearch(arr, mid + 1, high, x);
        }

        /* If x is smaller than arr[mid], then either arr[mid]
             is ceiling of x or ceiling lies in arr[mid-1...high] */
        else
        {
            if(mid - 1 >= low && x > arr[mid-1])
                return mid;
            else
                return CeilSearch(arr, low, mid - 1, x);
        }
    }

    public static void main(String[] args) {
        int i[] = {1,3,5,7,10};
        int x = 11;
        int index = CeilSearch(i, 0, i.length - 1, x);
        if (index == -1)
            System.out.println(index);
        else {
            if(index !=0) // to print the floor as we have ceil index.
                System.out.println(i[index-1]+" "+i[index]);
            else
                System.out.println(i[index]);

        }
    }
}
