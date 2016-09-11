




import static java.lang.System.*;
import java.util.*;

public class FixedL{

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

	public static int MSSFixedL(int[] a,int l){
		int sum=0,ans=0,i=0,n=a.length;
		for(i=0;i<l;++i){
			sum+=a[i];
		}
		ans=sum;
		for(;i<n;++i){
			sum=sum-a[i-l]+a[i];
			ans=max(2,sum,ans);
		}
		return ans;
	}

	public static void main(String[] args){
		int[] a={-2,-3,4,-1,-1,1,1,1,1,-1,-3,3,8};

		printArray(a);

		out.println(MSSFixedL(a,4));

	}

}



