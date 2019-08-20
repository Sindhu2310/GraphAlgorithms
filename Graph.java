import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;


public class Graph {

	int vertex;
	LinkedHashSet<Integer>[] edgeList;
	
	Graph(int vertex){
		this.vertex=vertex;
		this.edgeList=new LinkedHashSet[vertex];
		for(int i=0;i<vertex;i++) {
			this.edgeList[i]=new LinkedHashSet<Integer>();
		}
		
	}
	
	public static void main(String args[]) {
		Graph g=new Graph(10);
		g.vertex=10;
		g.edgeList[0].add(3);
		g.edgeList[0].add(4);
		g.edgeList[0].add(7);
		g.edgeList[1].add(2);
		g.edgeList[1].add(3);
		g.edgeList[1].add(5);
		g.edgeList[1].add(8);
		g.edgeList[5].add(2);
		g.edgeList[6].add(7);
		g.edgeList[6].add(8);
		g.edgeList[6].add(0);
		bfs(6,g);
		displayGraph(g);
	}
	public static void bfs(int start,Graph g) {
	
		boolean[] visited=new boolean[g.vertex];
		visited[start]=true;
		LinkedList<Integer> bfsList=new LinkedList<Integer>();
		bfsList.add(start);
		System.out.println("bfs from "+start);
		while(bfsList.size()!=0) {
			Integer elem=bfsList.poll();
			System.out.println(elem);
			LinkedHashSet<Integer> listOfElem=g.edgeList[elem];
			Iterator it=listOfElem.iterator();
			while(it.hasNext()) {
				Integer tobeAdded=(Integer)it.next();
				if(!visited[tobeAdded]) {
					bfsList.add(tobeAdded);
					visited[tobeAdded]=true;
				}
			}
			
			
		}
	}
	public static void displayGraph(Graph g) {
		for(int i=0;i<g.vertex;i++) {
			if(g.edgeList[i]!=null && g.edgeList[i].size()>0) {
				Iterator it=g.edgeList[i].iterator();
				for(;it.hasNext();) {
					System.out.println(i+" "+it.next());
				}
			}
			
		}
	}
}
