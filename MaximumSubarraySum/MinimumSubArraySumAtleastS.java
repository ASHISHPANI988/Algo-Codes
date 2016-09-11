import static java.lang.System.*;
import java.util.*;

public class MinimumSubArraySumAtleastS{

	public static int MAX=Integer.MAX_VALUE;
	public static int MIN=Integer.MIN_VALUE;

	public static void printArray(int a[]){
		StringBuilder s=new StringBuilder();
		for(int x:a){
			s.append(x).append(" ");
		}
		System.out.println(s.toString());
	}
	//max among the arguments
	public static int max(int count,int... numbers){
		int max=Integer.MIN_VALUE;
		for(int num:numbers){
			if(num>max){
				max=num;
			}
		}
		return max;
	}
	//min among the arguments
	public static int min(int count,int... numbers){
		int min=Integer.MAX_VALUE;
		for(int num:numbers){
			if(num<min){
				min=num;
			}
		}
		return min;
	}

	public static int minSubArrayofS(int[] a,int s){
		int sum=0,i=0,n=a.length,j=1;
		int ans=n+1;

		if(n==0){
		    return 0;
		}

		for(j=0;j<n;++j){
			
			sum+=a[j];

			if(sum<0){
				sum=0;
				i=j+1;
			}else if(sum>=s){
				if(i==j){ans=1;break;}

				while(i<j){
					if(sum>=s && ans>j-i+1){
						ans=j-i+1;
					}
					sum=sum-a[i];
					i++;
				}
				
			}		
		}
		
		
		return ans;
		// if(sum>=s){
		//     return ans;
		// }else{
		//     return 0;
		// }
	}

	public static void main(String[] args){
		int[] a={-2,-3,4,-1,-1,1,1,1,1,-1,-3,3,8};

		printArray(a);
		//ans=Math.min(minSubArrayofS(a,10),);
		out.println("Length:"+minSubArrayofS(a,9));
	}

}

// 	sum=sum+a[i]-a[i-l];
// 	sum=max(2,sum,rsum+a[i]);