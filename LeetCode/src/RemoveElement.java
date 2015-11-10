/**
 * Created by Rohith Vallu on 11/2/2015.
 *
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */


public class RemoveElement {
    public static int removeElement(int[] a, int val) {
        int zeros = 0;
        for(int k=0;k<a.length;k++)
            if(a[k]==val)
                a[k]=0;

        int i=0,j=0;
        while(j<a.length){
            if(a[i]!=0){
                i++;
                j++;
            }else if(a[i]==0 && a[j]!=0){
                zeros +=1;
                a[i]=a[j];
                a[j]=0;
            }else{
                j++;
            }
        }

        return a.length-zeros+1;
    }

    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(removeElement(a,1));

        for(int i=0;i<a.length;i++)
            System.out.print(" "+a[i]);
    }
}
