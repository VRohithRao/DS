
public class MagicIndexDuplicates {
	
	public static int magicFast(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
		return -1;
		}
		int midlndex = (start + end) / 2;
		int midValue = array[midlndex];
		if (midValue == midlndex) {
		return midlndex;
		}
		int leftlndex = Math.min(midlndex - 1, midValue);
		int left = magicFast(array, start, leftlndex);
		if (left >= 0) {
		return left;
		}

		/* Search right */
		int rightlndex = Math.max(midlndex + 1, midValue);
		int right = magicFast(array, rightlndex, end);
		return right;
		}

		public static int magicFast(int[] array) {
			return magicFast(array, 0, array.length - 1);
		}
		
		public static void main(String arg[]){
			MagicIndexDuplicates mis = new MagicIndexDuplicates();
			int[] a = {-20,0,0,3,3,4,6,7,9,8,10};
			System.out.print(mis.magicFast(a));
		}	
}
