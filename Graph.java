import java.util.ArrayList;
class Graph {
	int V;
	ArrayList<ArrayList<Integer>> adjList;

	// constructor
	Graph(int V)
	{
		this.V = V;
		adjList=new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjList.add(i, new ArrayList<>());
		}
	}

	void addEdge(int u, int v)
	{
		adjList.get(v).add(u);
		adjList.get(u).add(v);
	}

	void DFS(int v, boolean[] visited)
	{
		visited[v] = true;
		for (int x : adjList.get(v)) {
			if (!visited[x])
				DFS(x, visited);
		}
	}
	int connectedComponents()
	{

        int count=0;
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; ++v) {
			if (!visited[v]) {
				DFS(v, visited);
				count++;
			}
		}

        return count;
	}

	// Driver code
	public static void main(String[] args)
	{
		Graph g = new Graph(15);

		g.addEdge(0,4);
		g.addEdge(0,9);
		g.addEdge(9,4);

		g.addEdge(1,8);
		g.addEdge(1,14);
		g.addEdge(1,11);
		g.addEdge(8,14);
		g.addEdge(11,14);

		g.addEdge(12,7);
        
		g.addEdge(5,13);
		g.addEdge(2,13);
		g.addEdge(2,6);
		g.addEdge(10,6);
		g.addEdge(10,5);
		
		System.out.println(g.connectedComponents());
	}
}
