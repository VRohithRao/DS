/**
 * Created by Rohith Vallu on 10/26/2015.
 */
public class Equilibrium {
    public static int equilibrium(int arr[], int n)
    {
        int sum = 0;      // initialize sum of whole array
        int leftsum = 0; // initialize leftsum
        int i;

   /* Find sum of the whole array */
        for (i = 0; i < n; ++i)
            sum += arr[i];

        for( i = 0; i < n; ++i)
        {


            sum -= arr[i]; // sum is now right sum for index i

            if(leftsum == sum)
                return i;

            leftsum += arr[i];
            System.out.println(leftsum+" " +sum);
        }

    /* If no equilibrium index found, then return 0 */
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.print(equilibrium(arr, arr.length));
    }
}
