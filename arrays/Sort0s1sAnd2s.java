/**
 * Created by Rohith Vallu on 10/24/2015.
 */
public class Sort0s1sAnd2s {

    public static void dutchNationalFlag(int a[]){
        int low =0;
        int mid = 0;
        int high = a.length-1;
        while(mid<=high){
            if(a[mid] ==0){
                swap(low++,mid++,a);
            }else if(a[mid] == 1) {
                mid++;
            }else{
                swap(mid,high--,a);
            }

        }

        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");

    }
    public static void swap(int low,int mid,int a[]){
        int temp = a[low];
        a[low] = a[mid];
        a[mid] = temp;
    }
    public static void main(String[] args) {
        int i[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        dutchNationalFlag(i);
    }

}
