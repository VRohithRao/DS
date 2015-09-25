/*
**  Use the Collections API to sort a List for you.
**
**  When your class has a "natural" sort order you can implement
**  the Comparable interface.
**
**  You can use an alternate sort order when you implement
**  a Comparator for your class.
*/
import java.util.*;

public class SortCompanies
{
    String name;
    int Rank;

    public SortCompanies(String name, int Rank)
    {
       	this.name = name;
       	this.Rank = Rank;
    }

    public String getName()
    {
    	return name;
    }

    public int getRank()
    {
    	return Rank;
    }

    public String toString()
    {
    	return name + " : " + Rank;
    }

    /*
    **  Implement the natural order for this class
    */
//    public int compareTo(SortCompanies p)
//    {
//    	return getName().compareTo(p.getName());
//    }

    static class RankComparator implements Comparator<SortCompanies>
    {
    	public int compare(SortCompanies p1, SortCompanies p2)
    	{
    		int Rank1 = p1.getRank();
    		int Rank2 = p2.getRank();

    		if (Rank1 == Rank2)
    			return 0;
    		else if (Rank1 > Rank2)
    			return 1;
    		else
    			return -1;
    	}
    }

    public static void main(String[] args)
    {
    	List<SortCompanies> people = new ArrayList<SortCompanies>();
    	people.add( new SortCompanies("Apple", 2) );
    	people.add( new SortCompanies("Google", 3) );
    	people.add( new SortCompanies("Microsoft", 1) );
    	people.add( new SortCompanies("Amazon", 5) );


    	//  Use a Comparator to sort by Rank

    	Collections.sort(people, new SortCompanies.RankComparator());
    	System.out.println("Sort using Rank Comparator");
    	System.out.println("\t" + people);

    	//  Use a Comparator to sort by descending Rank

    	Collections.sort(people,
    		Collections.reverseOrder(new SortCompanies.RankComparator()));
    	System.out.println("Sort using Reverse Rank Comparator");
    	System.out.println("\t" + people);
    }
}