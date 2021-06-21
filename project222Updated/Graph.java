import java.util.*;

class Graph<E> {

	/**
	* Map that keeps vertices
	*/
	private Map<E, List<E> > map = new HashMap<>();

	/**
	* Method to add vertex
	*/
	public void addVertex(E s)
	{
		map.put(s, new LinkedList<E>());
	}

	/**
	* Method to add edge
	*/
	public void addEdge(E source,
						E destination)
	{

		if (!map.containsKey(source))
			addVertex(source);

		if (!map.containsKey(destination))
			addVertex(destination);

		map.get(source).add(destination);
		map.get(destination).add(source);
	}

	/**
	* Method to get count of clinics in graph
	*/
	public void getVertexCount()
	{
		System.out.println("The building has "
						+ map.keySet().size()
						+ " clinics\n");
	}

	/**
	* Method to check whether given vertex is in graph
	*/
	public void hasVertex(E s)
	{
		if (map.containsKey(s)) {
			System.out.println( s + " exists in the building.\n");
		}
		else {
			System.out.println(s + " does not exist in the building.\n");
		}
	}

	/**
	* Method to check whether there is an edge between given vertices
	*/
	public void hasEdge(E s, E d)
	{
		if (map.get(s).contains(d)) {
			System.out.println(s + " and " + d + " are in the same building.\n");
		}
		else {
			System.out.println(s + " and " + d + " are not in the same building.\n");
		}
	}

	/**
	* Method to remove vertex
	*/
	public void removeVertex(E source){
		map.remove(source);
	}

	/**
	* toString method
	*/
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		for (E v : map.keySet()) {
			builder.append(v.toString() + " <-> ");
			for (E w : map.get(v)) {
				builder.append(w.toString() + " ");
			}
			builder.append("\n");
		}

		return (builder.toString());
	}
}