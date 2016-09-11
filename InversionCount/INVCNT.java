import java.util.*;
import java.lang.*;
import java.io.*; 

class INVCNT
{
	public static long merge(int[] a,int l,int mid,int r){
		int len=r-l+1;
		int[] b=new int[len];
		int i=0,j,k=0;
		long c=0;

		for(i=l,j=mid+1;i<=mid && j<=r;){
			if(a[i]<a[j]){
				b[k]=a[i];
				++k;++i;
			}else{
				b[k]=a[j];
				c+=mid-i+1;
				++k;++j;
			}
		}	

		for(;j<=r;++j,++k){
			b[k]=a[j];
		}
	
		for(;i<=mid;++i,++k){
			b[k]=a[i];
		}
	
		k=l;
		for(int p=0;k<=r;++k,++p){
			a[k]=b[p];
		}
		return c;
	}

	public static long mergeSort(int[] a,int l,int r){
		long sum=0;
		if(l<r){
			int mid=(l+r)/2;
			sum=mergeSort(a,l,mid);
			sum+=mergeSort(a,mid+1,r);
			sum+=merge(a,l,mid,r);
		}
		return sum;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T,i=0;
		String s;
		int n=0,j=0;;
		T=Integer.parseInt(in.readLine().trim());
		in.readLine();
		while(i<T){
			n=0;
			n=Integer.parseInt(in.readLine().trim());
			int[] a=new int[n];
			for(j=0;j<n;++j){
				a[j]=Integer.parseInt(in.readLine().trim());
			}
			
			System.out.println(mergeSort(a,0,n-1));
			
			++i;
			in.readLine();	
		}
	}
}