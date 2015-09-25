/*Solution for CTC V5 1.6*/


public class rotate90 {
	public static void rotateInPlace90DegreesClockwise(int[][] matrix) {
	      int n = matrix.length;
	      int half = n / 2;

	      for (int layer = 0; layer < half; ++layer) {
	    	  int first = layer;
	          int last = n - 1 - layer;
//	          System.out.println(first + " : "+last);
	          for (int i = first; i < last; i++) {
	              int offset = i - first;
	              int j = last - offset;
//	              System.out.println(i + " :  : "+j);
	              
	              
	              int top = matrix[first][i]; // save top = A

	              // left -> top 
	              matrix[first][i] = matrix[j][first];  // is M        

	              // bottom -> left
	              matrix[j][first] = matrix[last][j]; // P

	              // right -> bottom
	              matrix[last][j] = matrix[i][last]; // D 

	              // top -> right
	              matrix[i][last] = top; // right <- saved top
		      }
	      }
	      for(int k = 0; k < n;k++){
	    	  System.out.print("\n");
	    	  for(int l = 0; l<n;l++){
	    		  System.out.print(matrix[k][l] + "\t");
	    	  }
	      }
	}
	public static void main(String args[]){
		rotate90 r90 = new rotate90();
		int a[][] = new int[4][4];
		for(int i =0, count = 0; i<4;i++)
			for(int j =0;j<4;j++, count++)
				a[i][j] = count;
		
		r90.rotateInPlace90DegreesClockwise(a);
	}
	
}
