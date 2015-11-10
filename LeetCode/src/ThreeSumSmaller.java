import java.util.Arrays;

/**
 * Created by Rohith Vallu on 10/31/2015.
 */
public class ThreeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if(nums.length >= 3) {
            Arrays.sort(nums);
            int length = nums.length-2;

            for(int i =0;i<length;i++){
                int j = i+1;
                int k = nums.length-1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        count += k - j;
                        j++;
                    }else{
                        k--;
                    }
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] a = { 1,5, -10,2,5,7,-11 };
//        int[] a = { 4,0,1,3,-4,8,-2,1};
        int[] a = {1,-1,2,0,3,-2};
        System.out.print(threeSumSmaller(a,2));
    }
}
