package DynamicProgramming;

/**
 * Created by Rohith Vallu on 11/12/2015.
 *
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm}
 * valued coins, what is the minimum number of coins to make the change?
 */
public class MinimumNoOfCoins {

//    this is a dumb program
    public static int recursiveCount(int[] S,int m,int V){
        if(V==0)
            return 0;
        int res = Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            if(S[i]<=V){
                int subRes = recursiveCount(S,m,V-S[i]);

                if(subRes!= Integer.MAX_VALUE && subRes+1<res)
                    res=subRes+1;
            }
        }

        return res;
    }

    //    DP
    public static int count(int[] S,int m, int V){
        int[] table = new int[V+1];

        table[0] = 0;

        for(int i=1;i<table.length;i++){
            table[i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<=V;i++){
            for(int j=0;j<m;j++) {
                if (S[j] <= i) {
                    int subRes = table[i - S[j]];
                    if (subRes != Integer.MAX_VALUE && subRes + 1 < table[i])
                        table[i]= subRes + 1;
                }
            }

        }

        return table[V];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int val = 5;
        System.out.println(count(coins, coins.length, val));
//        System.out.println(recursiveCount(coins, coins.length, val));
    }
}
