import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class PreScreen {
	
	static List<PackageDependency> packageDependencies = new ArrayList<PackageDependency>();
	static List<Package> buildOrderList = new ArrayList<Package>();
    static List<Package> allPackages = new ArrayList<Package>();
    static HashSet<Package> S = new HashSet<Package>();
    
	// Package
	public static class Package {
	    public String packageName;
	    HashSet<PackageDependency> inDependency;
	    HashSet<PackageDependency> outDependency;
	    
	    public Package(String packageName) {
	    	this.packageName = packageName;
	    	inDependency = new HashSet<PackageDependency>();
	    	outDependency = new HashSet<PackageDependency>();
	    }
	    public Package addDependency(Package p1) {
	    	PackageDependency pd = new PackageDependency(this, p1);
	    	outDependency.add(pd);
	    	p1.inDependency.add(pd);
	    	return this;
	    	
	    }
	    @Override
	    public String toString() {
	      return packageName;
	    }
	}
	// Edge
	public static class PackageDependency {
	    public final Package package1;
	    public final Package dependency;
	    
	    public PackageDependency(Package package1, Package dependency) {
	    	this.package1 = package1;
	    	this.dependency = dependency;
	    }
	    @Override
	    public boolean equals(Object obj) {
	      PackageDependency e = (PackageDependency)obj;
	      return e.package1 == package1 && e.dependency == dependency;
	    }
	    
	}
	
	public List<Package> validBuildOrder(List<PackageDependency> packageDependencies) {
		
		for (int i = 0; i < packageDependencies.size(); i++) {
			System.out.println(packageDependencies.get(i).package1.packageName + ", " + packageDependencies.get(i).dependency.packageName);
		}
		
		System.out.println("==========");
		System.out.println(allPackages.size());
		for (int i = 0 ; i < allPackages.size(); i++) {
			if (allPackages.get(i).inDependency.size() == 0) {
				System.out.println(allPackages.get(i).packageName);
				//System.out.println(p.outDependency.toString());
				S.add(allPackages.get(i));
				System.out.println(S.toString());
			}
		}
		System.out.println("==========");
		while (!S.isEmpty()) {
			Package p = S.iterator().next();
			S.remove(p);
			
			buildOrderList.add(p);
			
			for (Iterator<PackageDependency> it = p.outDependency.iterator(); it.hasNext();) {
				PackageDependency pd = it.next();
				Package p1 = pd.dependency;
				it.remove();
				p1.inDependency.remove(pd);
				if (p1.inDependency.isEmpty())
					S.add(p1);
			}
		}
		for (Package p2 : buildOrderList)
			System.out.println(p2.packageName);
		return buildOrderList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = new FileInputStream("C:/Users/Rohith/workspace/LinkedList/src/input.txt");
			
			// Construct BufferedReader from InputSteamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			HashSet<String> pkgCheck = new HashSet<String>();
			String line = null;
			Package st = null ,se = null;
			while ((line = br.readLine()) != null) {
				if(!pkgCheck.contains(line.substring(1, 2))){
					pkgCheck.add(line.substring(1, 2));
					st = new Package(line.substring(1, 2));
					allPackages.add(st);
				}
				if(!pkgCheck.contains(line.substring(4, 5))){
					pkgCheck.add(line.substring(4, 5));
					se = new Package(line.substring(4, 5));
					allPackages.add(se);
					
				}
				//allPackages.
					
				se.addDependency(st);
					
				//packageDependencies.add(new PackageDependency(st, se));
				
			}
//			Package A = new Package("A");
//			Package B = new Package("B");
//			Package C = new Package("C");
//			Package D = new Package("D");
//			Package E = new Package("A");
//			B.addDependency(A);
//			C.addDependency(A);
//			D.addDependency(A);
//			C.addDependency(B);
//			D.addDependency(B);
//			D.addDependency(C);
//			allPackages.add(A);
//			allPackages.add(B);
//			allPackages.add(C);
//			allPackages.add(D);
			
			/*Package seven = new Package("7");
		    Package five = new Package("5");
		    Package three = new Package("3");
		    Package eleven = new Package("11");
		    Package eight = new Package("8");
		    Package two = new Package("2");
		    Package nine = new Package("9");
		    Package ten = new Package("10");
		    seven.addDependency(eleven);
		    seven.addDependency(eight);
		    five.addDependency(eleven);
		    three.addDependency(eight);
		    three.addDependency(ten);
		    eleven.addDependency(two);
		    eleven.addDependency(nine);
		    eleven.addDependency(ten);
		    eight.addDependency(nine);
		    
		    allPackages.add(seven);
		    allPackages.add(eight);
		    allPackages.add(two);
		    allPackages.add(three);
		    allPackages.add(five);
		    allPackages.add(nine);
		    allPackages.add(ten);
		    allPackages.add(eleven);*/
			
		    
			
			br.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		PreScreen myObject = new PreScreen();
		myObject.validBuildOrder(packageDependencies);
	}
}