import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class MinHeap<T>{
	public T[] heap= null;
	private int last =1;
	private int capacity = 0; //capacity of the heap array
//	private AvlTree<T>() tree = new AvlTree<T>();

	
	@SuppressWarnings("unchecked")
	MinHeap(){
		//Don't change the next two lines; they ensures you write something to expand capacity
		capacity=100;
		heap = (T[]) (new Object[capacity]);
	}

	// Don't modify
	public void writeDot(String filename){
		PrintWriter outfile=null;
		try {
			outfile = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		outfile.println("digraph untitled {");
		outfile.println("node [shape = record,height=.1];");
		outfile.println(toDot());
		outfile.println("};");
		outfile.close();
	}

	// Don't modify 
	public String toDot() {	
		String result="";
		System.err.println("Writing "+(last-1)+" entries to dot file.");
		for(int i =1;i<last;i++){
			result+="\""+heap[i].hashCode()+i+"\"[label=\"<f0> |<f1>"+heap[i].toString()+" |<f2>\"]\n";
			if (2*i<(last)){
				result += "\""+heap[i].hashCode()+i+"\":f0->\""+heap[2*i].hashCode()+(2*i)+"\":f1\n";
			}
			if ((2*i+1)<(last)){
				result += "\""+heap[i].hashCode()+i+"\":f2->\""+heap[2*i+1].hashCode()+(2*i+1)+"\":f1\n";
			}
		}
		return result;
	}
	
	
	private void expandCapacity(){
		T[] temp = (T[])(new Object[heap.length*2]);
		
		for(int i = 0; i<heap.length; i++)
			temp[i]=heap[i];
		
		heap=temp;
	}
	

	/**
	 * Inserts specified element in the heap. Expands the array when needed, and reorders elements in the heap
	 * when needed.
	 * @param e the element to be inserted
	 */
	public void insert(T e)  {
		if(last==heap.length)
			expandCapacity();
		
		heap[last]=e;
		last++;
		
		if(last>2)
			heapifyAdd();
		
	}
	
	private void heapifyAdd(){
		T temp;
		int next = last-1;
		
		temp = heap[next];
		
		while((next!=1) && (((Comparable<T>)temp).compareTo(heap[(next)/2])<0)){
			heap[next]=heap[(next)/2];
			next = (next)/2;
		}
		
		heap[next] = temp;
	}

	/**
	 * Returns the number of different elements contained in the heap
	 * @return the size of the heap
	 */
	int size() {
		//fill this in
		return last-1;
		}

	
	/**
	 * Removes the smallest element in the heap, and reorders remaining elements to their correct position 
	 * in the heap.
	 * @return the smallest element in the heap
	 */
	public T removeMin(){
		if(size()==0){
			return null;
		}
		
		T result = heap[1];
		heap[1]=heap[last-1];
		heapifyRemove();
		last--;
		
		
		return result;
	}
	
	private void heapifyRemove(){
		T temp;
		int node = 1;
		int left = 2;
		int right = 3;
		int next;
		
		if((heap[left] == null) && (heap[right] == null))
			next = last;
		else if (heap[left] == null)
			next = left;
		else if (heap[right] == null)
			next = right;
		else if (((Comparable<T>)heap[left]).compareTo(heap[right]) < 0)
			next = left;
		else
			next = right;
		
		temp = heap[node];

		while((next < last) && (((Comparable<T>)heap[next]).compareTo(temp) < 0)){
//			System.out.println("Here: "+heap[next]);
			heap[node] = heap[next];
			node=next;
			left = 2*node;
			right = 2*node+1;
			
			if(right > last)
				break;
			
			if((heap[left] == null) && (heap[right] == null))
				next = last;
			else if (heap[left] == null)
				next = right;
			else if (heap[right] == null)
				next = left;
			else if (((Comparable<T>)heap[left]).compareTo(heap[right]) < 0)
				next = left;
			else
				next = right;
		}
		
		heap[node] = temp;
		}
		
	

//	public T Iterator(){
//		while(last != 1)
//			return removeMin();
//	}


}
