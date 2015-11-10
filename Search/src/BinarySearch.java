/**
 * Created by Rohith Vallu on 10/24/2015.
 *
 * The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Logn).
 * We basically ignore half of the elements just after one comparison.
 *
 * 1) Compare x with the middle element.
 * 2) If x matches with middle element, we return the mid index.
 * 3) Else If x is greater than the mid element, then x can only lie in right half subarray after the mid element.
 * So we recur for right half.
 * 4) Else (x is smaller) recur for the left half.
 *
 */
public class BinarySearch {
    public static int binarySearch(int a[],int x, int left,int right){
        int mid = 0;
        if(left<right){
            mid = (left+right)/2;

            if(x==a[mid])
                return x;
            else if(x>a[mid])
                return binarySearch(a,x,mid+1,right);
            else if(x<a[mid])
                return binarySearch(a,x,left,mid);


        }
        return 0;
    }
    public static void main(String[] args) {
        int i[] = {2,3,4,5,6};
        System.out.print(binarySearch(i,7,0,i.length-1));
    }
}
