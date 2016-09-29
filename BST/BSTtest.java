
class BST{

	class BSTnode{
		private int data;
		BSTnode left,right;
		BSTnode(int d){
			this(d,null,null);
		}
		BSTnode(int data,BSTnode left,BSTnode right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
		public int getData(){
			return this.data;
		}
		public void setData(int data){
			this.data=data;
		}
		public String toString(){
			return data+" Left:"+this.left+" Right:"+this.right;
		}
	}

	public BSTnode root;

	public void insert(int data){
		insert(this.root,data);
	}

	private void insert(BSTnode node,int data){
		if(node==null){
			if(node==this.root){
				node=new BSTnode(data);
				this.root=node;
			}else{
				node=new BSTnode(data);
			}	
		}
		else{
			int b=node.getData()-data;			
			if(b>=0){   //less than root
				if(node.left==null){
					node.left=new BSTnode(data);
				}
				else{
					insert(node.left,data);
				}
			}
			if(b<0){
				if(node.right==null){
					node.right=new BSTnode(data);
				}
				else{
					insert(node.right,data);
				}
			}
		}
	}

	public int max(){
		BSTnode node=this.root;
		int m=root.getData();
		while(node!=null){
			m=node.getData();
			node=node.right;
		}
		return m;
	}
	public int min(){
		BSTnode node=this.root;
		int m=root.getData();
		while(node!=null){
			m=node.getData();
			node=node.left;
		}
		return m;
	}
	public int min(BSTnode x){  //min in sub tree
		BSTnode node=x;
		int m=node.getData();
		while(node!=null){
			m=node.getData();
			node=node.left;
		}
		return m;
	}
	public int max(BSTnode x){  //min in sub tree
		BSTnode node=x;
		int m=node.getData();
		while(node!=null){
			m=node.getData();
			node=node.right;
		}
		return m;
	}
	public void deleteMin(){
		if(root==null){
			return;
		}
		if(root.left==null){
			root=root.right;
			return;
		}
		deleteMin(this.root,null);
	}
	public void deleteMin(BSTnode x,BSTnode parentx){
		BSTnode node=x;
		BSTnode parent=parentx;
		while(node.left!=null){
			parent=node;
			node=node.left;
		}
		parent.left=node.right;
	}

	public void deleteMax(){
		if(root==null){
			return;
		}
		if(root.right==null){
			root=root.left;
			return;
		}
		deleteMax(this.root,null);
	}
	public void deleteMax(BSTnode x,BSTnode parentx){
		BSTnode node=x;
		BSTnode parent=parentx;
		while(node.right!=null){
			parent=node;
			node=node.right;
		}
		//System.out.println();
		parent.right=node.left;
	}

	public void remove(int data){
		BSTnode node=this.root;
		BSTnode parent=null;     //fail at boundary
		int d=1;

		while(node!=null){
			if(node.getData()<data){
				parent=node;
				d=2;
				node=node.right;
			}else{
				if(node.getData()>data){
					parent=node;
					d=1;
					node=node.left;
				}else{
					//equal
					//case 1: leaf
					if(node.left==null && node.right==null){
						if(parent==null){
							this.root=null;
							return;
						}
						if(d==1){parent.left=null;}else{parent.right=null;}
						return;
					}
					//case 2: one child is null
					if(node.left==null || node.right==null){
						if(node.right==null){
							if(parent==null){
							//root
								this.root=node.left;root.left=null;root.right=null;
								return;
							}
							if(d==1){
								parent.left=node.left;
							}else{
								parent.right=node.left;
							}
							return;
						}
						if(node.left==null){
							if(parent==null){
								this.root=node.right;root.left=null;root.right=null;
								return;
							}
							if(d==1){
								parent.left=node.right;
							}else{
								parent.right=node.right;
							}
							return;
						}
					}
					else{   //case 3: intermediate node with both children
						node.setData(max(node.right));  //replace with inorder successor
						deleteMax(node.right,node);
					}
				}
			}
		}
	}
	
	public void inorder(){
		if(this.root!=null){
			//System.out.print("First Inorder :");
			inorder(this.root.left);
			System.out.print(root.getData()+" ");
			inorder(this.root.right);
		}
	}
	private void inorder(BSTnode node){
		if(node!=null){
			//System.out.print("Second Inorder :");
			inorder(node.left);
			System.out.print(node.getData()+" ");
			inorder(node.right);
		}
	}

	public void preorder(){
		if(this.root!=null){
			System.out.print(this.root.getData()+" ");
			preorder(this.root.left);
			preorder(this.root.right);
		}
	}
	public void preorder(BSTnode node){
		if(node!=null){
			System.out.print(node.data+" ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public boolean search(int data){
		BSTnode node=this.root;
		while(node!=null){
			if(data<node.getData()){
				node=node.left;
			}else{
				if(data>node.getData()){
					node=node.right;
				}else{
					if(node.getData()==data){
						return true;
					}else{
						return false;
					}
				}
			}
		}
		return false;
	}
}


public class BSTtest{
	public static void main(String[] args){
		BST bst=new BST();

		bst.insert(56);
		bst.insert(23);
		bst.insert(98);
		bst.insert(31);
		bst.insert(68);
		bst.insert(6);

		System.out.print("\ninorder:");
		bst.inorder();
		System.out.print("\npreorder:");
		bst.preorder();
		System.out.println();

		bst.remove(23);//bst.remove(31);bst.remove(98);bst.remove(56);bst.remove(68);bst.remove(6);
		System.out.print("\ninorder:");
		bst.inorder();
		System.out.print("\npreorder:");
		bst.preorder();
		System.out.println();
	}
}

