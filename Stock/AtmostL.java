import static java.lang.System.*;
import java.util.*;

public class AtmostL{
	public static int MAX=Integer.MAX_VALUE;
	public static int MIN=Integer.MIN_VALUE;
	
	public static void printArray(int a[]){
		StringBuilder s=new StringBuilder();
		for(int x:a){
			s.append(x).append(" ");
		}
		System.out.println(s.toString());
	}
	/*min element index*/
	public static int min(int[] a,int l,int r){
		int min=MAX,i=0,ri=0;
		for(i=l;i<=r;++i){
			if(min>a[i]){
				min=a[i];
				ri=i;
			}
		}
		return ri;
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

	/*O(n)     max aj-ai  of atmost L size*/
	public static int maxAtmostLD(int[] a,int l){
		int len=a.length,i=0,j=0;
		int ans=a[0],max=a[0];

		ArrayDeque<Integer> Q=new ArrayDeque<Integer>(l);
		Q.add(0);
		for(i=1;i<l;++i){
			if(a[i]>a[Q.getLast()]){
				Q.addLast(i);
			}else{
				while(!Q.isEmpty() && a[Q.getLast()]>=a[i])
					Q.removeLast();
				Q.addLast(i);
			}
			if(a[i]-a[Q.getFirst()]>max){
				max=a[i]-a[Q.getFirst()];
			}
		}
		//out.println(a[Q.getFirst()]);
		//out.println(max);
		for(i=l;i<len;++i){
			if(i-l==Q.getFirst()){
				Q.removeFirst();
			}
			while(!Q.isEmpty() && a[Q.getLast()]>=a[i])
					Q.removeLast();
			Q.addLast(i);

			if(a[i]-a[Q.getFirst()]>max){
				max=a[i]-a[Q.getFirst()];
			}
		//out.println(a[Q.getFirst()]);
		//	out.println(max);
		}
		return max;
	}

	/*O(nk)    max aj-ai  of atmost L size*/
	public static int maxAtmostL(int[] a,int l){
		int len=a.length,i=0,j=0;
		int ans=a[0];int ni=1;
		for(j=1;j<len;++j){
			ans=max(2,ans,a[j]-a[i]);
			if(a[j]<=a[i]){
				i=j;
			}
			if(j-i>=l){
				i=min(a,i+1,j);
			}
				
		}
		return ans;
	}

	public static void main(String[] args){
		int[] a={-2,-3,4,-1,-1,1,1,1,1,-1,-3,3,8};

		printArray(a);

		out.println(maxAtmostLD(a,4));

	}

}

// 	sum=sum+a[i]-a[i-l];
// 	sum=max(2,sum,rsum+a[i]);