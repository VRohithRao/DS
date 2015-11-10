import java.util.Random;

public class Test {
	public static int recursionTest(int a, int b){
		int i = 2;
		if(a < 10){
			
			a += i; b = b*i/2;  
			System.out.println("Inside recursion call :" +a);
			return recursionTest(a,b);
			
		}
		else
			return 0;
	}

	public static void testRandom(int[] a){

		for(int i=0;i<a.length;i++){
			int rnd = new Random().nextInt(a.length);
			System.out.println(a[rnd] + " "+ rnd);
		}

	}

	public static void selectKRandom(int input[],int k) {

		int temp[] = new int[k];

		Random randomGenerator = new Random();


		for (int i = 0; i < k; i++)
			temp[i] = input[i];

		for (int i = 0; i < input.length; i++) {
			int randomIndex = randomGenerator.nextInt(input.length);
			if (randomIndex < k)
				temp[randomIndex] = input[i];
		}

		for (int i = 0; i < temp.length; i++)
			System.out.print(temp[i]+" ");
	}

	public static void main(String arg[]){
		int[] i ={1, 2, 4, -22, -1, -3, 3};
		int a = i[0];
		for(int j = 1;j < i.length;j++)
			a = a ^ i[j];
		
		
		int x = 4, y = 3;
		
//		x  = x ^ y;
//		System.out.println(x + ":" + y);
//		y  = x ^ y;
//		System.out.println(x + ":" + y);
//		x  = x ^ y;
//		System.out.println(x + ":" + y);
//		System.out.println(a);
//		System.out.println("recursion"+ recursionTest(3,3));

//		testRandom(i);
		selectKRandom(i,3);
		
	}
}
