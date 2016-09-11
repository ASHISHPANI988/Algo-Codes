import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class KSmallestFindRank{

	public static int random(int min,int max){
		if(max==min){
			return min;
		}
		return min+(int)(Math.random()*1000)%(max-min);
	}
	
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

	public static int RfindRank(int[] a,int i,int j,int r){
		int p=random(i,j);
		//out.println("p is "+p);
		int k=partition(a,i,j,p);
		if(r==j-k+1){
			return a[k];
		}else{
			if(r<j-k+1){
				//out.println("\nR< j:"+j+" k:"+k+" r:"+r);
				return RfindRank(a,k+1,j,r);
			}else{
				//out.println("\nR> j:"+j+" k:"+k+" r:"+r);
				return RfindRank(a,i,k,r-(j-k));
			}
		}
	}

	public static void copy(int[] a,int a_start,int[] b,int start,int length){
		int i=a_start,j=start;
		for(;j<start+length;){
			b[j]=a[i];
			++j;++i;
		}
	}

	public static void main(String[] args) throws IOException{
		int[] b=new int[100000];
		String s=new Scanner(new File("IntegerArray.txt")).useDelimiter("\\Z").next();
		String[] tmp=s.split("\\r?\\n");
		//BufferedReader in=new BufferedReader(new FileReader("IntegerArray.txt"));
        int i=0;
        
        for(i=0;i<100000;++i){
        	//b[i]=Integer.parseInt(in.readLine().trim());
        	b[i]=Integer.parseInt(tmp[i]);
        }


        int j,k=100;
        int[] ans=new int[2*k];
        copy(b,0,ans,0,k);

        
        for(i=0;i<1000-1;++i){
        	//System.arraycopy(b,100*(i+1),ans,k,k);  //System.arraycopy ( objectArray, startIndex, newArray, 0, length );
        	copy(b,100*(i+1),ans,k,k);
        	
        	out.println(RfindRank(ans,0,ans.length-1,k+1)+"\n");
        	//printArray(ans);
        }

        printArray(ans);
	}
}
