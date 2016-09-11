import static java.lang.System.*;
import java.util.*;

public class AtmostL{

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

	public static int MSSatmostL(int[] a,int l){

		int sum=a[0],ans=a[0];
		int i=0,n=a.length,rsum=0,start=0;
	
		//Calculating till L
		for(i=1;i<l;++i){
			sum+=a[i];
			if(a[i]>sum){
				sum=a[i];
				start=i;
			}
			ans=max(2,ans,sum);
		}
		//If starting element of current sum is negative then move start forward
		if(start==i-l || a[start]<0){
			sum-=a[start];
			++start;
		}

		
		for(i=l;i<n;++i){
			
			sum=sum+a[i];

			//If current element is greater than current sum
			if(a[i]>sum){
				sum=a[i];
				start=i;
			}
			ans=max(2,ans,sum);
			//out.println("s:"+start+" sum:"+sum+" a[start]:"+a[start]);
			//out.println("sum:"+sum+" rsum:"+rsum+" ans:"+ans);
			while(start==i-l+1 || a[start]<0){
				sum-=a[start];
				++start;
				//out.println("Loop:    s:"+start+" sum:"+sum+" a[start]:"+a[start]);
				ans=max(2,ans,sum);
			}
		}
		return ans;
	}

	public static void main(String[] args){
		int[] a={-2,-3,4,-1,-1,1,1,1,1,-1,-3,3,8};

		printArray(a);

		out.println(MSSatmostL(a,4));

	}

}

// 	sum=sum+a[i]-a[i-l];
// 	sum=max(2,sum,rsum+a[i]);