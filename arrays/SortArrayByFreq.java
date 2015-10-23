import java.util.*;

/**
 * Created by Rohith Vallu on 10/21/2015.
 */
public class SortArrayByFreq {

    public static void sortByFreq(int[] a){
        Arrays.sort(a);
        int[][] freqCount = new int[a.length][2];
        int count = 1;
        int index = 0;

        for(int i=1; i<a.length;i++){
           if(a[i-1] == a[i]) {
               count++;
               freqCount[index][0] = a[index];
               freqCount[index][1] = count;
           }
           else{
               index = i;
               freqCount[index][0] = a[index];
               freqCount[index][1] = 1;
               count = 1;
           }
        }
        Arrays.sort(freqCount, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (String.valueOf(o2[1])).compareTo(String.valueOf(o1[1]));
            }
        });

        for(int k=0;k<freqCount.length;k++) {
            for (int l = 0; l < 2; l++)
                if(freqCount[k][l]!=0)
                System.out.print(freqCount[k][l] + " ");
            System.out.println();
        }
    }

    public static void sortByHashMap(int a[]){
        HashMap<Integer,Integer> freqCount = new HashMap<Integer,Integer>();
        for(int i =0;i<a.length;i++)
            if(freqCount.containsKey(a[i]))
                freqCount.put(a[i],freqCount.get(a[i])+1);
            else
                freqCount.put(a[i],1);

        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(freqCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry : list)
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String args[]){
        int i[] = {2,4,5,2,5,8,5,9999998,9999998};
        sortByHashMap(i);
        sortByFreq(i);
    }
}
