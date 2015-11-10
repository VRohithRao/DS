/**
 * Created by Rohith Vallu on 10/23/2015.
 */
public class checkIfMajorityEle {
    public static int isMajority(int[] a,int i,int length){
        int flag =0;
        if(i<=length/2) {
            if (a[i] == a[length] && (i + (length / 2)) <= length)
                return 1;
            else
                flag += isMajority(a, i+1, length);
        }
        return flag;
    }

    public static void main(String args[]) {
        MajorityElement me = new MajorityElement();
        int[] num1 = {1, 2, 3, 4, 4, 4, 4};
        System.out.print(isMajority(num1,0, num1.length-1));
    }
}
