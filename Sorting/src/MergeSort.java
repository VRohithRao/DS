/**
 * Created by Rohith Vallu on 10/22/2015.
 */
public class MergeSort {
    public static void mergeSort(int[] a,int[] temp,int left, int right){
        int mid = 0;
        if(right>left){
            mid = (right+left)/2;

            mergeSort(a,temp,left,mid);
            mergeSort(a,temp,mid+1,right);

            merge(a,temp,left,right,mid);
        }
    }

    public static void merge(int[] a,int[] temp,int left, int right,int mid){
        int i,j,k;
        i=left;
        j = mid;
        k = left;

        while((i<=mid-1) && j<=right){
            if(a[i]<=a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        while(i<=mid-1)
            temp[k++] = a[i++];
        while(j<=right)
            temp[k++] = a[j++];

        for(int m = left; m<right;m++)
            a[m] = temp[m];
    }

    public static void main(String args[]){
        int i[] = {2,4,1,3,5};
        int j[] = new int[i.length];
        mergeSort(i, j, 0, i.length - 1);

        for(int k = 0;k< i.length;k++)
            System.out.print(i[k]);
    }
}
