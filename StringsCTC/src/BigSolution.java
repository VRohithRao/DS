
import java.math.BigInteger;
import java.util.Scanner;

public class BigSolution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger bigSum = new BigInteger("0");

        for (int i = 0; i < n; i++){
        	System.out.println("Number : "+n);
            int num = in.nextInt();
            System.out.println("Number : "+num);
            
            BigInteger bigNum = new   BigInteger(Integer.toString(num));

            bigSum = bigSum.add(bigNum);
        }

        System.out.println(bigSum);
        in.close();

    }

}