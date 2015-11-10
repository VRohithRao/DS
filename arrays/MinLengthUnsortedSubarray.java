/**
 * Created by Rohith Vallu on 10/24/2015.
 *
 * Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this
 * subarray makes the whole array sorted.
 *
 */

/*
* Steps:
*
* 1: Find the candidate unsorted subarray
* a) Scan from left to right and find the first element which is greater than the next element. Let s be the index of
* such an element
* b)Scan from right to left and find the first element (first in right to left order) which is smaller than the
* next element (next in right to left order).
*
* 2: Check whether sorting the candidate unsorted subarray makes the complete array sorted or not. If not,
* then include more elements in the subarray.
* a) Find the minimum and maximum values in arr[s..e].
* b)Find the first element (if there is any) in arr[0..s-1] which is greater than min, change s to index of this element.
* c)Find the last element (if there is any) in arr[e+1..n-1] which is smaller than max, change e to index of this element.
* */
public class MinLengthUnsortedSubarray {

    //  Time Complexity O(n)
    public static void unsortedSubArray(int arr[],int n){
        int s = 0, e = n-1, i, max, min;

        // step 1(a) of above algo
        for (s = 0; s < n-1; s++)
        {
            if (arr[s] > arr[s+1])
                break;
        }
        if (s == n-1)
        {
            System.out.println("The complete array is sorted");
            return;
        }

        // step 1(b) of above algo
        for(e = n - 1; e > 0; e--)
        {
            if(arr[e] < arr[e-1])
                break;
        }

        // step 2(a) of above algo
        max = arr[s]; min = arr[s];
        for(i = s + 1; i <= e; i++)
        {
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }

        // step 2(b) of above algo
        for( i = 0; i < s; i++)
        {
            if(arr[i] > min)
            {
                s = i;
                break;
            }
        }

        // step 2(c) of above algo
        for( i = n -1; i >= e+1; i--)
        {
            if(arr[i] < max)
            {
                e = i;
                break;
            }
        }
        System.out.println(" The unsorted subarray which makes the given array sorted lies between the indees "+ s+" "+ e);
        return;
    }


    public static void main(String[] args) {
        int i[] = {10,12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int j[] ={0, 1, 15, 25, 6, 7, 30, 40, 50};
        unsortedSubArray(i,i.length);
        unsortedSubArray(j,j.length);
    }
}
