import java.util.LinkedHashSet;

public class MinHeapDijkstra {

	Integer vertex;
	LinkedHashSet<Edge>[] edgeList;
	MinHeapDijkstra(Integer vertex){
		this.vertex=vertex;
		edgeList=new LinkedHashSet[vertex];
		
		for(int i=0;i<vertex;i++) {
			edgeList[i]=new LinkedHashSet<Edge>();
		}
		
	}
}
