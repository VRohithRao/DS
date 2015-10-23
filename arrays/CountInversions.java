/**
 * Created by Rohith Vallu on 10/22/2015.
 */
public class CountInversions {

    public static int countInversionByMergeSort(int a[],int temp[],int left,int right){
        int mid = 0, inversion = 0;
        if(right>left) {
            mid = (left + right) / 2;
            inversion = countInversionByMergeSort(a,temp, left, mid);
            inversion += countInversionByMergeSort(a,temp, mid + 1, right);
            inversion += merge(a,temp,left,mid+1,right);
        }
        return inversion;
    }

    public static int merge(int a[],int temp[],int left,int mid,int right){
        int i,j,k,inversion = 0;
        i = left;
        j = mid;
        k = left;

        while ((i<=mid-1) && j<=right){
            if(a[i]<=a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
                inversion = inversion + (mid-i);
            }
        }

        while (i<=mid-1)
            temp[k++] = a[i++];


        while(j<=right)
            temp[k++] = a[j++];


        for(int m = left; m<=right;m++)
            a[m] = temp[m];

        return inversion;
    }
    public static void main(String args[]){
        int i[] = {2,4,1,3,5};
        int j[] = new int[i.length];
        System.out.println(countInversionByMergeSort(i, j, 0, i.length - 1));

        for(int k = 0;k< i.length;k++)
            System.out.print(i[k]);
    }
}
