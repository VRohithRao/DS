/**
 * Created by Rohith Vallu on 10/23/2015.
 *
 * Given an array arr[] of integers, find out the difference between any two elements such that larger element appears
 * after the smaller number in arr[].
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is
 * [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
 *


 */



public class MaxDiffLargerEleAppearsAfterSmaller {
    public static int maxDiff(int a[]){
        int left = 0; int right = a.length-1;
        int crossPointer =0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(left<right){
            if(a[right]> max)
                max = a[right];
            if(a[left] < min && left <= crossPointer)
                min = a[left];
            if(a[left]>max){
                max = a[left];
                crossPointer = left;
            }


            left++;
            right--;
        }

        return max-min;
    }

    public static void main(String[] args) {
        int i[] = {7, 9, 5, 6, 3, 2};//{2, 3, 10, 6, 4, 8, 1}; //{ -80,70, 1, 60, 85,-75,};
        System.out.print(maxDiff(i));
    }
}
