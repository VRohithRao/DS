/**
 * Created by Rohith Vallu on 11/1/2015.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;

        for(int i = length-1;i>=0;i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i] = digits[i]+1;
                break;
            }

            if(digits[i] ==0 && i==0){
                int[] temp = new int[length+1];
                temp[0] = 1;

                // now iterate through the entire digit array and copy elements to temp till index 1

                for(int j=1;j<temp.length;j++)
                    temp[j] = digits[j-1];

                digits = temp;
            }
        }
        return digits;
    }
    public static void main(String[] args) {
        int a[] = {0};
        plusOne(a);
    }
}
