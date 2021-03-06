
public class MissingNumber {
	public static void missingNumberFormula(int[] a){
		int n = a.length;
		int total = (n)*(n+1)/2;
		
		for(int i=0;i<n;i++){
			total -= a[i];
		}
		System.out.println(total);
	}
	public static void MissingNumberXOR(int[] a){
		int n = a.length;
		int xor1 = 1;
		int xor2 = a[0];
		for(int i=0;i<n+1;i++){
			xor1 = xor1 ^ i;
		}
		
		for(int i=1;i<n;i++){
			xor2 = xor2 ^ a[i];
		}
		System.out.println(xor2 ^ xor1);
	}
	public static void main(String args[]){
		int i[] = {0,1,3,4,5,6,7,8,9};
		missingNumberFormula(i);
		MissingNumberXOR(i);
	}
}
