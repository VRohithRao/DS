import java.util.Arrays;

/**
 * Created by Rohith Vallu on 10/26/2015.
 */
public class RemoveDupFromSortedArray {
    public static int removeDuplicates(int[] A) {
        if (A.length < 2)
            return A.length;

        int j = 0;
        int i = 1;

        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }

    //        System.out.print(A.length);
    //        for(int im=0;im<A.length;im++)
    //            System.out.println(A[im]);
        return j + 1;
    }
    // Create an array with all unique elements
    public static int[] removeDuplicatesNCreateArray(int[] A) {
        if (A.length < 2)
            return A;

        int j = 0;
        int i = 1;

        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }

        int[] B = Arrays.copyOf(A, j + 1);

        return B;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3};
        System.out.println(removeDuplicates(arr));
        int[] j = removeDuplicatesNCreateArray(arr);
        for(int m = 0;m<j.length;m++)
            System.out.println(j[m]);

    }
}
