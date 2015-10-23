/**
 * Created by Rohith Vallu on 10/21/2015.
 */
public class LeaderInArray {

    public static int findLeader(int a[]){
        int max = a[a.length-1];
        for(int i = a.length-1;i>=0;i--){
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }

    public static void main(String args[]){
        int i[] = {6,7,2,3,4};

        System.out.print(findLeader(i));
    }
}


