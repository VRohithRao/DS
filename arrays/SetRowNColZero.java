/*Solution for CTC V5 1.7*/


public class SetRowNColZero {

	public static int[][] setZero(int[][] matrix) {
      boolean[] row =new boolean[matrix.length];
      boolean[] col =new boolean[matrix[0].length];
      
      for(int i=0;i<matrix.length;i++)
    	  for(int j=0;j<matrix[0].length;j++){
    		  if(matrix[i][j] == 0){
    			  row[i] = true;
    			  col[j] = true;
    		  }
    	  }
      
      for(int i=0;i<matrix.length;i++)
    	  for(int j=0;j<matrix[0].length;j++){
    		  if(row[i] || col[j]){
    			  matrix[i][j] = 0;
    			 
    		  }
    	  }
      
      return matrix;
      
	}
	public static void main(String args[]){
		SetRowNColZero r90 = new SetRowNColZero();
		int a[][] = new int[4][5];
		int row = a.length;
		int col = a[0].length;
		for(int i =0, count = 1; i<row;i++)
			for(int j =0;j<col;j++, count++)
				a[i][j] = count;
		
//		TEST CONDITION
		a[2][2] = 0;
		
		int[][] matrix = r90.setZero(a);
		for(int k = 0; k < row;k++){
	    	  System.out.print("\n");
	    	  for(int l = 0; l<col;l++){
	    		  System.out.print(matrix[k][l] + "\t");
	    	  }
	      }
	}
	

}
