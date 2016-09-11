import static java.lang.System.*;
import java.util.*;

public class ArrSum{
	public static int MAX=Integer.MAX_VALUE;
	public static int MIN=Integer.MIN_VALUE;

	public static void printArray(int a[]){
		StringBuilder s=new StringBuilder();
		for(int x:a){
			s.append(x).append(" ");
		}
		System.out.println(s.toString());
	}
	public static void printArray(int a[],int l,int r){
		StringBuilder s=new StringBuilder();
		int n=a.length;
		for(int i=l;i<=r;++i){
			s.append(a[i]).append(" ");
		}
		System.out.println(s.toString());
	}
	public static int max(int count,int... numbers){
		int max=Integer.MIN_VALUE;
		for(int num:numbers){
			if(num>max){
				max=num;
			}
		}
		return max;
	}
	public static int min(int count,int... numbers){
		int min=Integer.MAX_VALUE;
		for(int num:numbers){
			if(num<min){
				min=num;
			}
		}
		return min;
	}
	public static int crossSum(int[] a,int l,int mid,int r){
		int sum1=a[mid],sum2=a[mid+1];
		int max=a[mid];
		if(l==r){
			return a[l];
		}
		for(int i=mid-1;i>=l;--i){
			sum1=sum1+a[i];
			if(sum1>max){
				max=sum1;
			}
		}
		sum1=max;
		max=a[mid+1];
		for(int i=mid+2;i<=r;++i){
			sum2=sum2+a[i];
			if(sum2>max){
				max=sum2;
			}
		}
		sum2=max;
		return sum1+sum2;
	} 

	public static int MaxSumDC(int[] a,int l,int r){
		int n1=0,n2=0,n3=0;
		if(l<r){
			int mid=(l+r)/2;
			n1=MaxSumDC(a,l,mid);
			n2=MaxSumDC(a,mid+1,r);
			n3=crossSum(a,l,mid,r);
		}
		return max(3,n1,n2,n3);
	}

	public static int MaxSumSubArray(int[] a){
		int i=0,sum=a[0],n=a.length,ans=a[0];
		for(i=1;i<n;++i){
			sum=max(2,sum+a[i],a[i]);
			ans=max(2,sum,ans);
		}
		return ans;
	}
	
	public static void main(String[] s){
		
		int[] e={-2,-3,4,-1,-1,1,1,1,1,-1,-3,3,8};
		
		printArray(e);
		out.println(MaxSumSubArray(e));
		
	}

}
