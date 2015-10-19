/**
 * Created by Rohith Vallu on 10/18/2015.
 */
public class MaxSumNoEleAdj {
    //  This is a dp
    public static int maxSum(int[] ar){
        if(ar.length == 0)
            return 0;
        if(ar.length == 1)
            return ar[0];
        if(ar.length == 2)
            return Math.max(ar[0],ar[1]);
        int a = 0, b = 0;
        if(ar[0] < 0 && ar[1] < 0)
        {
             a = ar[0];
             b = ar[1];
        }else{
             a = Math.max(0,ar[0]);
             b = Math.max(0,ar[1]);
        }
        int temp = 0;

        for(int i = 2; i < ar.length; i++){
            System.out.println(temp + " " + a + " "+ ar[i] + " "+ b);
            temp = b;
            b = Math.max(ar[i] + a, ar[i]);
            a = Math.max(a,temp);
            System.out.println(temp + " " + a + " "+ b);
        }
        return Math.max(a,b);
    }

    public static void main(String args[]) {
        int i[] = {1,2,3,4,5,6,7};
        System.out.print(maxSum(i));
    }
}
