
import java.util.*;
import java.io.*;
 
public class Fibo{
 	
	public static String generateBigNumber(int n){
		StringBuilder s=new StringBuilder();
		for(int i=0;i<n;++i){
			s.append((int)(Math.random()*1000)%10);
		}
		return s.toString();
	}

	public static String generateBinaryBig(int n){
		StringBuilder s=new StringBuilder("1");
		for(int i=0;i<n-1;++i){
			s.append((int)(Math.random()*1000)%2);
		}
		return s.toString();
	}

	/*log(n)*/
	public static String DivideBy2(String n){
		StringBuilder s=new StringBuilder();
		int rem=0,num=0;
		for(int i=0;i<n.length();++i){
			if(i==0 && n.charAt(i)-'0'<2){    //If no starts with 1
				rem=n.charAt(i)-'0';
				continue;
		    }
			num=rem*10+(n.charAt(i)-'0');
			s.append(num/2);
			rem=num%2;
		}
		if(s.length()==0){
			s.append(0);
		}
		System.out.println(s.toString());
		return s.toString();
	}
	/*log(n)*/
	public static int ModBy2(String n){
		StringBuilder s=new StringBuilder();
		int rem=0,num=0;
		for(int i=0;i<n.length();++i){
			if(i==0 && n.charAt(i)-'0'<2){    //If no starts with 1
				rem=n.charAt(i)-'0';
				continue;
		    }
			num=rem*10+(n.charAt(i)-'0');
			s.append(num/2);
			rem=num%2;
		}
		return rem;
	}

	/*(log(n))^2 */
	public static String binary(String n){
		int i=0;
		int num;
		StringBuilder s=new StringBuilder();
		int N=n.charAt(0)-'0';
		while(N>0){
			num=ModBy2(n);
			s.append(num);			
			n=DivideBy2(n);
			//System.out.println("L:"+n.length());
			if(n.length()==1){
				//System.out.println(n.charAt(0));
			}
			if(n.charAt(0)-'0'==0 && n.length()==1){
				N=0;
			}
			else{//System.out.println("Length:"+n.length()+"\n");
				N=n.charAt(0)-'0';
			}     
		}
		return s.reverse().toString();
	} 

	public static int[][] MMmodM(int[][] A,int[][] B,int m){
		int a_rows=A.length;
		int a_cols=A[0].length;
		int b_rows=B.length;
		int b_cols=B[0].length;

		int i=0,j=0,k=0,sum=0;
		int[][] res=new int[a_rows][b_cols];
		if(a_cols!=b_rows){
			System.out.println("Ordered Mismatch "+" a_cols:"+a_cols+" b_rows:"+b_rows);
		}else{
			for(i=0;i<a_rows;++i){
				for(j=0;j<b_cols;++j){
					sum=0;
					for(k=0;k<a_cols;++k){
						sum=(sum+(A[i][k]*B[k][j]))%m;
						res[i][j]=sum;
					}
				}
			}
		}
		return res;
	}

	public static int[][] pow(int[][] X,String n){
			int[][] y={{1,0},{0,1}};   //Identity matrix
			char[] N=n.toCharArray();
			int i=N.length-1;
			//System.out.println("Reaching pow");
			while(i>=0){
				
				if(N[i]-'0'==1){
					y=MMmodM(y,X,99);
				}
				X=MMmodM(X,X,99);
				//System.out.println("N["+i+"]:"+N[i]+"  y[1][0]:"+y[1][0]);
				--i;//Divide by 2								
			}
			return y;
	}

	public static int F(String n){
		int[][] A={{1,1},{1,0}};
      	int[][] a={{1},{0}};
      	int[][] res={{0},{0}};

      	//F(n)=pow(A,n)*[1,0]';	
      	n=binary(n);
      	//System.out.print("Binary:"+n+"\n");
      	res=pow(A,n);
      	//res=pow(A,n)*[1,0]';
      	return res[1][0];	
	}

	public static void main(String[] args) throws IOException{
		/*  Calculating
		 *	[F(n+1)]   = A^n [1] 
		 *	[F(n)  ]         [0]  
		 */
		String n="";
		/*******************Generate a file with the no of size 10^10************/
		//10^1000   
		// n=generateBigNumber(1000000);//no of digits    10^n
		// try{
		// 	File f=new File("fs6.txt");
		// 	if(f.createNewFile()){
		// 		System.out.println("New File created\n");
		// 	}else{
		// 		System.out.print("File not created");
		// 	}
		// }
		// catch(Exception e){

		// }
		// FileWriter out=new FileWriter("fs6.txt");
		// out.write(n);
		// out.close();

		/*  *****************Read the No from File******************************/
		//Here n is big number of 1000000digits;
		try{
			n= new Scanner(new File("fs3.txt")).useDelimiter("\\Z").next();
			n.trim();			
		}
		catch(Exception e){
        	e.printStackTrace();
      	}
		System.out.println(F(n));
		// System.out.println(n);
		// System.out.println(DivideBy2(n));
		//System.out.print(sb.toString());
	}
} 



// int[][] a={{1,2},{3,4}};
// 		int[][]	b={{1},{0}};
		
// 		int[][] c=MMmodM(a,b);      	

// 		for(int i=0;i<c.length;++i){
// 			for(int j=0;j<c[0].length;++j){
// 				System.out.print(c[i][j]+" ");
// 			}
// 			System.out.println();
// 		}