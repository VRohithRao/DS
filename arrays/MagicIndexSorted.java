import java.util.Scanner;


public class MagicIndexSorted {

public static int magicFast(int[] array, int start, int end) {
	if (end < start || start < 0 || end >= array.length) {
		return -1;
	}
	int mid = (start + end) / 2;
	if (array[mid] == mid) {
		return mid;
	} else if (array[mid] > mid){
		return magicFast(array, start, mid - 1);
	} else {
		return magicFast(array, mid + 1, end);
	}
}

public static int magicFast(int[] array) {
	return magicFast(array, 0, array.length - 1);
}

public static void main(String arg[]){
	MagicIndexSorted mis = new MagicIndexSorted();
	Scanner in = new Scanner(System.in);
	int i = 0;
	int a[] = new int[10];
	while(i<10){
		a[i] = in.nextInt();
		i++;
	}
	System.out.print(mis.magicFast(a));
}	

}