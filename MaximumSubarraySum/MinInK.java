import static java.lang.System.*;
import java.util.*;

public class MinInK{

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

	public static void minInL(int[] a,int l){
		int len=a.length,i=0,j=0;

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
			// if(a[i]-a[Q.getFirst()]>min){
			// 	min=a[i]-a[Q.getFirst()];
			// }
		}
		//out.println(a[Q.getFirst()]);
		out.println(a[Q.getFirst()]);

		for(i=l;i<len;++i){
			if(!Q.isEmpty() && (i-l)==Q.getFirst()){
				Q.removeFirst();
			}
			while(!Q.isEmpty() && a[Q.getLast()]>=a[i])
					Q.removeLast();
			Q.addLast(i);

			// if(a[i]-a[Q.getFirst()]>min){
			// 	min=a[i]-a[Q.getFirst()];
			// }

			//out.println(a[Q.getFirst()]);
			out.println(a[Q.getFirst()]);
		}
		
	}

	public static void main(String[] args){
		int[] a={2,3,4,1,1,1,1,1,1,1,3,3,8};

		printArray(a);

		minInL(a,3);
	}

}

// 	sum=sum+a[i]-a[i-l];
// 	sum=max(2,sum,rsum+a[i]);