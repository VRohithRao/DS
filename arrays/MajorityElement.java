import java.util.Arrays;


public class MajorityElement {
	
//	Takes O(nlogn) because of sort
	public int majorityElementBySort(int[] num) {
        if(num.length==1){
            return num[0];
        }
 
        Arrays.sort(num);
 
        int prev=num[0];
        int count=1;
        for(int i=1; i<num.length; i++){
            if(num[i] == prev){
                count++;
                if(count > num.length/2) return num[i];
            }else{
                count=1;
                prev = num[i];
            }
        }
 
        return 0;
    }
//	Takes Linear time O(n)
	public int majorityElementByVote(int[] nums) {
	    int result = 0, count = 0;
	 
	    for(int i = 0; i<nums.length; i++ ) {
	        if(count == 0){
	            result = nums[ i ];
	            count = 1;
	        }else if(result == nums[i]){
	           count++;
	        }else{
	           count--;
	        }
	    }
	 
	    return result;
	}
	public static void main(String args[]){
		MajorityElement me = new MajorityElement();
		int[] num =  {3, 3, 4, 2,4, 2, 4};
		int n = me.majorityElementBySort(num);
		int m = me.majorityElementByVote(num);
		System.out.println(n+" : "+m);
	}
}

// me.majorityElementBySort(num); is more efficient.