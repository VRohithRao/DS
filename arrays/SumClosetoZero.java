import java.util.Arrays;

/**
 * Created by Rohith Vallu on 10/23/2015.
 */

public class SumClosetoZero {
    public static int[] pairSumCloseToZero(int a[]){
        Arrays.sort(a);
        int l=0; int r = a.length - 1;
        int sumSoFar = Integer.MAX_VALUE;
        int temp[] = new int[2];
        while(l<r){
            if((a[l] + a[r]) < 0) {
                if(sumSoFar > Math.abs(a[l] + a[r])) {
                    sumSoFar = Math.abs(a[l] + a[r]);
                    temp[0] = a[l];
                    temp[1] = a[r];
                }
                l++;

            }
            else {
                if(sumSoFar > a[l] + a[r]) {
                    sumSoFar = a[l] + a[r];
                    temp[0] = a[l];
                    temp[1] = a[r];
                }
                r--;

            }
        }
        return temp;
    }

    public static void main(String args[]){
        int i[] = {1, 60, -75, 70, -80, 85}; // -80 -10 1 60 70 85
        int j[] = pairSumCloseToZero(i);

        for(int k=0;k<j.length;k++)
            System.out.print(j[k]+" ");

    }
}
