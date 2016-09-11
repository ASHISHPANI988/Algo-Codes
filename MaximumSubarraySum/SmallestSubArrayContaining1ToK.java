import static java.lang.System.*;
import java.util.*;

public class SmallestSubArrayContaining1ToK{

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

	public static int minsubArray1k(int[] a,int k){
		int[] count=new int[k+1];
		int i=0,n=a.length,ans=MAX,tcount=0,j=0;
		Arrays.fill(count,0);
		//Finding the first occurence
		for(j=0;j<n;++j){
			if(1<=a[j] && a[j]<=k){
				i=j;count[a[j]]++;++tcount;
				break;
			}
		}
		//out.println(i);
		if(i>n-k){
			return 0;
		}

		for(j=i+1;j<n;++j){
			//out.print("a["+i+"]:"+a[i]+" a["+j+"]:"+a[j]+" ans:"+ans+"     ");
			if(a[j]==a[i]){
				//move forward and --
				//update start i
				//out.println("here");
				if(count[a[j]]==1){
					++i;
				}
				
				while( ( (i<j) && (a[i]<=0 || a[i]>k) ) || ( (i<j) && (1<=a[i] && a[i]<=k) && count[a[i]]>1) ){
					if((1<=a[i] && a[i]<=k) && (count[a[i]]>1)){
						count[a[i]]-=1;
					}
					++i;
				}
				
			}else{
				if(1<=a[j] && a[j]<=k){
					if(count[a[j]]==0){
						++tcount;
					}
					count[a[j]]++;
				}
			}	
			if(tcount==k){
				ans=Math.min(ans,j-i+1);
			}
			//out.println("tc:"+tcount+" i:"+i+" j:"+j);
		}
		if(ans<=n){
			return ans;
		}else{
			return 0;
		}	
	}

	public static void main(String[] args){
		int[] a={2,3,4,1,1,1,1,1,1,1,3,3,8};

		printArray(a);

		out.println("Length:"+minsubArray1k(a,4));

	}

}

// 	sum=sum+a[i]-a[i-l];
// 	sum=max(2,sum,rsum+a[i]);