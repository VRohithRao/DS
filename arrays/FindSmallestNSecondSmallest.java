/**
 * Created by Rohith Vallu on 10/23/2015.
 */
public class FindSmallestNSecondSmallest {

    public static void firstTwoSmallest(int a[]){
        int l = 0;
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        while(l < a.length){
            if(firstSmallest>a[l]) {
                secondSmallest = firstSmallest;
                firstSmallest = a[l];
            }
            if(secondSmallest > a[l] && a[l]>firstSmallest)
                secondSmallest = a[l];

            l++;

        }

        System.out.print(firstSmallest+ " "+ secondSmallest);
    }

    public static void main(String args[]) {
        int i[] = { -80,70, 1, 60, 85,-75,}; // -80 -10 1 60 70 85
        firstTwoSmallest(i);
    }
    }
