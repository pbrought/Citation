class TNode<T> {
	private int leftDepth =0, rightDepth=0;
	public int getLeftDepth() {
		return leftDepth;
	}
	public void setLeftDepth(int leftDepth) {
		this.leftDepth = leftDepth;
	}
	public int getRightDepth() {
		return rightDepth;
	}
	public void setRightDepth(int rightDepth) {
		this.rightDepth = rightDepth;
	}
	public int getAvl() {return leftDepth-rightDepth;}
	private TNode<T> left,right;
	private TNode<T> parent;
	private T key;
	TNode(T e, TNode<T> p){	
		key = e;
		parent=p;
	}
	public T getElement() {return key;}
	Boolean  hasLeft() {return (left!=null);}
	Boolean  hasRight() {return (right!=null);}
	public TNode<T> getLeft() {return left;}
	public TNode<T> getRight() {return right;}
	public TNode<T> getParent() {return parent;}
	public void setElement(T e) {key = e;}
	void setParent (TNode<T> p) {parent=p;}
	void setLeft (TNode<T> l ) {left=l;}
	void setRight (TNode<T> r) {right=r;}

	public String toDot(){
		String result="\""+this.toString()+"\"[label =\"<f0> |<f1> "+key+" (avl:"+getAvl()+")|<f2>\"]\n";
		if (hasLeft()){
			result += "\""+this.toString()+"\":f0->\""+getLeft().toString()+"\":f1\n";
			result+=getLeft().toDot();
		}
		if (hasRight()){
			result += "\""+this.toString()+"\":f2->\""+getRight().toString()+"\":f1\n";
			result+=getRight().toDot();
		}
		return result;
	}
	public boolean hasParent() {
		return (parent!=null);
	}
	public int getDepth() {
		return Math.max(getLeftDepth(),getRightDepth());
	}

}
