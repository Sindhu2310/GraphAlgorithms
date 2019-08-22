
public class MinHeap {
	
     int[] heap;
     int size;
     int MAXSIZE;
     
     public MinHeap(int maxSize) {
    	 this.MAXSIZE=maxSize;
    	 this.heap=new int[maxSize+1];
    	 this.size=0;
    	 heap[0]=Integer.MIN_VALUE;
    	 for(int i=1;i<=maxSize;i++) {
    		 heap[i]=-1;
    	 }
    	 
     }
     
     public void insert(int element) {
    	 if(size>=this.MAXSIZE) {
    		return; 
    	 }else {
    		 heap[++size]=element;
    		 int current=size;
    		 while(heap[current]<heap[getParent(current)]) {
    		    swap(current,getParent(current));
    			current=getParent(current);
    		 }
    	 }
     }
     /**
      * Build the Min Heap 
      */
     public void minHeap() {
    	 for(int i=size/2;i>=1;i--) {
    		 minHeapify(i);
    	 }
     }
     public void swap(int i,int j) {
    	 int temp=heap[i];
    	 heap[i]=heap[j];
    	 heap[j]=temp;
     }
     
     public int remove() {
    	 if(size<=0) {
    		 return -1;
    	 }else {
    		 int elem=heap[size];
    		 heap[size]=-1;
    		 size--;
    		 minHeapify(size);
    		 return elem;
    		 
    	 }
    	 
     }
     
    /**
     * Parent in Minheap is heap[i-1/2]
     * @param heap
     */
     
     public int getParent(int i) {
    	
    		 return i/2;
    	
     }

     /**
      * Left child is A[2*i+1]
      * @param heap
      */
     
     public int getLeftChild(int i) {
    
    		 return 2*i;
    	
     }
     
     /**
      * Right Child is A[2*i+2]
      * @param heap
      */
     
     public int getRightChild(int i) {
    	 
    		 return 2*i+1;
    	
     }
     /**
      * In min heap a leaf node is the one which index>=size/2 
      * and less than or equal to size
      * @param elemPos
      * @return
      */
     public boolean isLeaf(int elemPos) {
    	 if(elemPos>=this.size/2 && elemPos<=size ) {
    		 return true;
    	 }else {
    		 return false;
    	 }
     }
     /**
      * Min Heapify a specific Index
      * @param index
      */
	public void minHeapify(int index) {
		
		if(!isLeaf(index)) {
			if(heap[getLeftChild(index)]<heap[index] || heap[getRightChild(index)]<heap[index] ) {
				if(heap[getLeftChild(index)]<heap[index]) {
				swap(index,getLeftChild(index))	;
				minHeapify(getLeftChild(index));
				}else {
			    swap(index,getRightChild(index));
			    minHeapify(getRightChild(index));

				}
			}
		}
		
		
		
	}
	
	/**
	 * Display the Min Heap
	 */
     public void display() {
    	 for(int i=1;i<=size/2;i++) {
    		 System.out.println("Parent "+heap[i]+" left "+heap[getLeftChild(i)]+"  right "+heap[getRightChild(i)]);
    	 }
     }

     public static void main(String args[]) {
    	 MinHeap minHeap=new MinHeap(15);
    	  minHeap.insert(5); 
          minHeap.insert(3); 
          minHeap.insert(17); 
          minHeap.insert(10); 
          minHeap.insert(84); 
          minHeap.insert(19); 
          minHeap.insert(6); 
          minHeap.insert(22); 
          minHeap.insert(9); 
          minHeap.minHeap(); 
          minHeap.display();
    
     }
}
