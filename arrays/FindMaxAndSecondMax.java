/**
 * Created by Rohith Vallu on 11/14/2015.
 */
public class FindMaxAndSecondMax {
    public static void firstTwoSmallest(int a[]){
        int l = 0;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        while(l < a.length){
            if(firstMax<a[l]) {
                secondMax = firstMax;
                firstMax = a[l];
            }
            if(secondMax < a[l] && a[l]<firstMax)
                secondMax = a[l];

            l++;

        }

        System.out.print(firstMax+ " "+ secondMax);
    }

    public static void main(String args[]) {
        int i[] = { -80,70, 1, 60, 85,-75,}; // -80 -10 1 60 70 85
        firstTwoSmallest(i);
    }
}
