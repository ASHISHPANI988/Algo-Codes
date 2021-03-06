import java.util.*;
import static java.lang.System.*;

public class DFindRank{

	public static void swap(int[] a,int pos1,int pos2){
    	int temp = a[pos1];
    	a[pos1] = a[pos2];
    	a[pos2] = temp;
	}
	public static void printArray(int a[]){
		StringBuilder s=new StringBuilder();
		for(int x:a){
			s.append(x).append(" ");
		}
		System.out.println(s.toString());
	}
	/*partition(b,0,b.length-1,2)*/
	public static int partition(int a[],int l,int r,int p){
		int i=l,j=r;
		int x=a[p];int pi=p;
		//out.println("Partion Starts\n    i:"+l+" j:"+r+" pivot:"+x+" pindex:"+p);
		while(i<j){
			//out.println("  i:"+i+" j:"+j);
			while(i<r && a[i]<=x) {
				++i;
				//out.println("loop  i:"+i);
			}
			
			while(j>l && a[j]>x){
				--j;
				//out.println("loop  j:"+j);
			}
			/*Pivot tracking*/
			if (a[j]==x) {
			 	pi=j;
			}
			/////////////////
			//out.println("  i:"+i+" j:"+j+" pi:"+pi+" \n");
			if(i<j){
				//out.println("Swapping  a[i]:"+a[i]+" a[j]:"+a[j]+"\n");
				swap(a,i,j);
				/*Pivot Tracking*/
				if(j==pi){
					pi=i;
				}
				////////////////
			}	
			//printArray(a);		
		}
		swap(a,pi,j);
		//out.println("End of Partition:");
		//printArray(a);
		return j;
	}
	public static int median(int[] a,int l,int r){
		//Sort the a from l to r
		Arrays.sort(a,l,r+1);
		int mid=(l+r)/2;
		//int median=a[mid];
		//out.println("Med:"+a[mid]);
		return mid;
		//returning index   
	}
	public static int DSelect(int[] a,int l,int r){
		int n=r-l+1;
		int i=0,j=l,mindex=0;

		if(n==1)
        {
            return l;
        }

        int Groups= n/5;
        if(n%5 > 0)
        {
            Groups++;
        }

        if(Groups==1){
        	return median(a,l,r);
        }
        for(i=0,j=l;i<Groups-1;++i,j+=5)
        {
            	mindex=median(a,j,j+4);
            	swap(a,l+i,mindex);
        }
       	mindex=median(a,j,r);
       	swap(a,l+i,mindex);
        //median of median index
        return median(a,l,l+Groups-1);
	}
	public static int DfindRank(int[] a,int i,int j,int r){
		if(i<=j){
			int p=DSelect(a,i,j);
			//out.println("p is "+p+" a[p]:"+a[p]);
			int k=partition(a,i,j,p);
			if(r==j-k+1){
				return a[k];
			}else{
				if(r<j-k+1){
					//out.println("\nR< j:"+j+" k:"+k+" r:"+r);
					return DfindRank(a,k+1,j,r);
				}else{
					//out.println("\nR> j:"+j+" k:"+k+" r:"+r);
					return DfindRank(a,i,k-1,r-(j-k+1));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args){
		//int[] b={12,11,8,7,5,3,2,1};
		int[] c={12,16,13,1,2,3,4,5,6,17,7,8,9,14,15,12,15};

		printArray(c);
		out.println();
		out.println(DfindRank(c,0,c.length-1,1));
		//out.println("Pivot:"+b[1]);
		//out.println("Pos:"+partition(c,0,c.length-1,12));
		//printArray(c);
		
	}
}

