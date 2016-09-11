import static java.lang.System.*;
import java.util.*;

public class AtleastL{

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

	public static int MSSatleastL(int[] a,int l){
		int sum=0,ans=0,i=0,n=a.length,rsum=0;

		//Calculating till L first
		for(i=0;i<l;++i){
			sum+=a[i];
		}

		ans=sum;
		rsum=sum;

		for(i=l;i<n;++i){
			sum=sum+a[i]-a[i-l];
			rsum=max(2,sum,rsum+a[i]);
			ans=max(2,rsum,ans);
			//out.println("sum:"+sum+" rsum:"+rsum+" ans:"+ans);
		}

		return ans;
	}

	public static void main(String[] args){
		int[] a={-2,-3,4,-1,-1,1,1,1,1,-1,-3,3,8};

		printArray(a);

		out.println(MSSatleastL(a,4));

	}

}