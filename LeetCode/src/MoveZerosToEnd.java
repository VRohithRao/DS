/**
 * Created by Rohith Vallu on 11/2/2015.
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZerosToEnd {
    public static void moveZeroes(int[] a) {

        int i=0,j=0;
        while(j<a.length){
            if(a[i]!=0){
                i++;
                j++;
            }else if(a[i]==0 && a[j]!=0){

                a[i]=a[j];
                a[j]=0;

            }else{
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes(a);
        for(int i=0;i<a.length;i++)
            System.out.print(" "+a[i]);
    }
}
