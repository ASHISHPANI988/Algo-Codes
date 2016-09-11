import java.util.*;
import java.io.*;
import static java.lang.System.*;

class MinHeap{

	ArrayList<Integer> a=new ArrayList<Integer>();
	int n;

	public MinHeap(int[] b){
		for(int x:b){
			a.add(x);
		}
		n=a.size()-1;
	}

	public MinHeap(){
		n=-1;
	}

	public void add(int x){
		++n;
		a.add(x);	
		BottomUpHeapify(n);
	}
	public int delete(int x){
        int i=a.indexOf(x);
        return deleteNode(i);
    }

	public int getMin(){
        return a.get(0);
    }
	public void print(){
		StringBuilder s=new StringBuilder();
		s.append(a.toString());
		System.out.println(s.toString());
	}
	public  void swap(int pos1,int pos2){
    	int temp = a.get(pos1);
    	a.set(pos1,a.get(pos2));
    	a.set(pos2,temp);
	}

	public  void BottomUpHeapify(int i){
		while(i>0 && a.get((i-1)/2)>a.get(i) ){
			swap(i,(i-1)/2);
			i=(i-1)/2;
		}
	}
	public  void TopDownHeapify(int i){
		//int n=a.length-1;
		//int n=a.size()-1;
		while(2*i+1<=n){
			int l=2*i+1;
			int r=2*i+2;
			int m;
			if(r<=n && a.get(l)>a.get(r)){
				m=r;
			}else{
				m=l;
			}

			if(a.get(i)>a.get(m)){
				swap(i,m);
				i=m;
			}else{
				break;
			}
		}
	}

	public  void increase(int i,int x){
		a.set(i,x);
		TopDownHeapify(i);
	}
	
	public  void decrease(int i,int x){
		a.set(i,x);
		BottomUpHeapify(i);
	}

	public  void update(int i,int x){
		if(a.get(i)<x){
			increase(i,x);
		}else{
			decrease(i,x);
		}
	}

	public  int deleteMin(){
		//int n=a.size()-1;
		int x=a.get(0);
		swap(0,n);
		a.remove(n);//reduce array size by 1
		--n;
		TopDownHeapify(0);

		return x;
	}

	public  int deleteNode(int i){
		//int n=a.size()-1;
		int x=a.get(i);
		
		if(a.get(n)>a.get(i)){
			swap(i,n);
			a.remove(n);//reduce array size by 1
			--n;
			TopDownHeapify(i);	
		}else{
			swap(i,n);
			a.remove(n);//reduce array size by 1
			--n;
			if(i<=n){
				BottomUpHeapify(i);
			}
		}
		return x;
	}

	public  void buildHeap(){
		//int n=a.size()-1;
		int i=0;
		for(i=(n/2);i>=0;--i){
			//System.out.print(a[i]+" :");
			TopDownHeapify(i);
			//printArray(a);
		}
	}

	public int[] HeapSort(){
		//int n=a.size()-1;
		int[] b=new int[n];
		int i=0;
		buildHeap();
		//print();
		//printArray(a);
		for(;n>0;){
			b[i]=deleteMin();
			//printArray(b);
			++i;//--n;
			TopDownHeapify(0);
			//print();
		}

		//repopulAte 
		for(int x:b){
			a.add(x);
		}
		n=a.size()-1;

		return b;
	}

	public static void printArray(int a[]){
		StringBuilder s=new StringBuilder();
		for(int x:a){
			s.append(x).append(" ");
		}
		System.out.println(s.toString());
	}

}

class MaxHeap{

	ArrayList<Integer> a=new ArrayList<Integer>();
	int n;

	public MaxHeap(int[] b){
		for(int x:b){
			a.add(x);
		}
		n=a.size()-1;
	}

	public MaxHeap(){
		n=0;
	}
	public int getMax(){
		return a.get(0);
	}
	public void add(int x){
		++n;
		a.add(x);	
		BottomUpHeapify(n);
	}

	public void print(){
		StringBuilder s=new StringBuilder();
		s.append(a.toString());
		System.out.println(s.toString());
	}
	public  void swap(int pos1,int pos2){
    	int temp = a.get(pos1);
    	a.set(pos1,a.get(pos2));
    	a.set(pos2,temp);
	}

	public  void BottomUpHeapify(int i){
		while(i>0 && a.get((i-1)/2)<a.get(i) ){
			//out.println("a["+((i-1)/2)+"]:"+a.get((i-1)/2)+"    a["+i+"]"+a.get(i) );
			swap(i,(i-1)/2);
			//out.print(":");
			//print();
			i=(i-1)/2;
		}
	}
	public  void TopDownHeapify(int i){
		//int n=a.length-1;
		//int n=a.size()-1;
		while(2*i+1<=n){
			int l=2*i+1;
			int r=2*i+2;
			int m;
			if(r<=n && a.get(l)<a.get(r)){
				m=r;
			}else{
				/////////////////////////////////////
				m=l;
			}

			if(a.get(i)<a.get(m)){
				swap(i,m);
				i=m;
			}else{
				break;
			}
		}
	}

	public  void increase(int i,int x){
		a.set(i,x);
		BottomUpHeapify(i);
	}
	public  void decrease(int i,int x){
		a.set(i,x);
		TopDownHeapify(i);
	}
	public  void update(int i,int x){
		if(a.get(i)>x){
			increase(i,x);
		}else{
			decrease(i,x);
		}
	}

	public  int deleteMax(){
		//int n=a.size()-1;
		int x=a.get(0);
		swap(0,n);
		a.remove(n);//reduce array size by 1
		--n;
		TopDownHeapify(0);

		return x;
	}

	public  int deleteNode(int i){
		//int n=a.size()-1;
		int x=a.get(i);
		
		if(a.get(n)<a.get(i)){
			swap(i,n);
			a.remove(n);//reduce array size by 1
			--n;
			TopDownHeapify(i);	
		}else{
			swap(i,n);
			a.remove(n);//reduce array size by 1
			--n;
			if(i<=n){
				BottomUpHeapify(i);
			}
		}
		return x;
	}



	public  void buildHeap(){
		//int n=a.size()-1;
		int i=0;
		for(i=(n/2);i>=0;--i){
			//System.out.print(a.get(i)+" :");
			TopDownHeapify(i);
			//print();
		}
	}

	public int[] HeapSort(){
		//int n=a.size()-1;
		int[] b=new int[n];
		int i=0;
		buildHeap();
		//print();
		//printArray(a);
		for(;n>0;){
			b[i]=deleteMax();
			//printArray(b);
			++i;//--n;
			TopDownHeapify(0);
			//print();
		}

		//repopulAte 
		for(int x:b){
			a.add(x);
		}
		n=a.size()-1;

		return b;
	}
}

public class KSmallestHeap{
	public static void printArray(int a[]){
		StringBuilder s=new StringBuilder();
		for(int x:a){
			s.append(x).append(" ");
		}
		System.out.println(s.toString());
	}

	public static void main(String[] args) throws IOException{
		//int[] a={23,56,78,21,1,45,98,45,34,27};
		int[] b=new int[100000];
		
		BufferedReader in=new BufferedReader(new FileReader("IntegerArray.txt"));
        int i=0;
        
        for(i=0;i<100000;++i){
        	b[i]=Integer.parseInt(in.readLine().trim());
        }

        int[] ans = Arrays.copyOfRange(b,0,100);
        
		MaxHeap h=new MaxHeap(ans);

		h.buildHeap();
		//h.print();
		//out.println("---------------------------------------");

		for(i=100;i<100000;++i){
			h.add(b[i]);
			h.deleteMax();
		}
		h.print();   //[1146,  ,5]  for 10000   and [100,98,99, ,1,2] for 100000
	}
}