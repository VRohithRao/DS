import java.util.*;
public class SortBasedOnID {

			public static void main(String args[]){
		   ArrayList<String> listofcountries = new ArrayList<String>();
		   listofcountries.add("1;India;2001");
		   listofcountries.add("2.5;US;2000");
		   listofcountries.add("5.1;China;2010");
		   listofcountries.add("0.45;Denmark;2004");

		   /*Unsorted List*/
		   System.out.println("Before Sorting:");
		   for(String counter: listofcountries){
				System.out.println(counter);
			}

		   /* Sort statement*/
		   Collections.sort(listofcountries);

		   /* Sorted List*/
		   System.out.println("After Sorting:");
		   for(String counter: listofcountries){
				System.out.println(counter);
			}
		   for (int i = 0 ; i < 2; i++){
			   System.out.println(i+ " : "+listofcountries.get(i));
		   }
		}
	}

