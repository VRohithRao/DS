/**
 * Created by Rohith Vallu on 10/17/2015.
 */
public class RearrangeNegPos {
//    int[] array;
//    public RearrangeNegPos(int[] arrA) {
//        this.array = arrA;
//    }


    private static void rearrangeElementsWithExtraSpace(int array[]) {
        int [] temp = new int[array.length];
        int k =0;
        for(int i =0; i<array.length;i++){
            if(array[i]<0){
                temp[k++] = array[i];
            }
        }

        for(int i =0; i<array.length;i++){
            if(array[i]>0){
                temp[k++] = array[i];
            }
        }


        for(int i =0; i<temp.length;i++){
            System.out.print(temp[i] + " ");
        }

    }

    /**
     * Method 2 - Swapping : O(n^2)
     *
     */

    private static void rearrangeBySwapping(int array[]){
        int i=0, j=0;
        while(j < array.length){
            while(array[i] < 0)
                i++;
            j = i;
            while(j< array.length && array[j] > 0)
                j++;

            if(j == array.length)
                break;
            for(int k = j ; k > i; k--){
                int temp = array[k-1];
                array[k-1] = array[k];
                array[k] = temp;
            }
        }

        for (int i1 = 0; i1 < array.length; i1++)
            System.out.print(" " + array[i1]);
    }


    //    Method 3 : O(nlogn)


    public static void divideGroups(int low, int high,int[] array) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        divideGroups(low, mid,array);
        divideGroups(mid + 1 , high,array);
        merge(low, mid, high,array);


    }

    public static void merge(int low, int mid, int high,int[] array) {
        int l = low;
        int k = mid + 1;
        while (l <= mid && array[l] <= 0)
            l++;
        while (k <= high && array[k] <= 0)
            k++;
        reverse(l, mid,array);
        reverse(mid + 1, k - 1,array);
        reverse(l, k - 1,array);
    }

    public static void reverse(int x, int y,int[] array) {
        while (y > x) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
            x++;
            y--;
        }
    }


    public static void main(String args[]) {
        int[] a = { 3,-4,5,-2};//{ 1,5, -10,2,5,7,-11 };
        divideGroups(0, a.length - 1,a);
        for (int i = 0; i < a.length; i++)
            System.out.print(" " + a[i]);

        System.out.println(" ");
        int[] b = { 3-4,5,7,-2,-1,-40,5,-2};
        rearrangeElementsWithExtraSpace(b);

        System.out.println(" ");
        int[] c = { 3-4,5,7,-2,-1,-40,5,-2};
        rearrangeBySwapping(c);


    }
}
