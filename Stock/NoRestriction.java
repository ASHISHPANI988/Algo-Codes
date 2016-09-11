import static java.lang.System.*;
import java.util.*;

public class NoRestriction{

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

	/* Stock   max aj-ai  */
	public static int maxGap(int[] a){
		int n=a.length,i=0,j=0;
		int ans=a[0];
		for(j=1;j<n;++j){
			ans=max(2,ans,a[j]-a[i]);
			if(a[j]<a[i]){
				i=j;
			}
		}
		return ans;
	}

	public static void main(String[] args){
		int[] a={-2,-3,4,-1,-1,1,1,1,1,-1,-3,3,8};

		printArray(a);

		out.println(maxGap(a));

	}

}

// 	sum=sum+a[i]-a[i-l];
// 	sum=max(2,sum,rsum+a[i]);