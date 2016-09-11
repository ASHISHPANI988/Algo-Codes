import static java.lang.System.*;
import java.util.*;

public class pairSum{

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

	/*   nlogn  ai+aj=x*/
	public static boolean pairSum(int[] a,int x){
		int n=a.length,one,second;
		//qsort(a,0,n-1);
		Arrays.sort(a);
		printArray(a);
		int l=0,r=n-1;
		while(l<r){
			if(a[l]+a[r]==x){
				return true;
			}else{
				if(a[l]+a[r]>x){
					--r;
				}else{
					++l;
				}
			}
		}
		return false;
	}
	/*  nlogn  ai+aj=ak*/
	public static int pairSum(int[] a){
		int n=a.length,one,second;
		Arrays.sort(a);
		printArray(a);int i=0,len=a.length;
		int l=0,r=n-1,x;
		for(i=0;i<len;++i){
			l=0;
			r=n-1;
			x=a[i];
			while(l<r){
				if(a[l]+a[r]==x){
					return x;
				}else{
					if(a[l]+a[r]>x){
						--r;
					}else{
						++l;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args){
		int[] a={-2,-3,4,-1,-1,1,1,1,1,-1,-3,3,8};

		printArray(a);

		out.println(pairSum(a));

	}

}

// 	sum=sum+a[i]-a[i-l];
// 	sum=max(2,sum,rsum+a[i]);