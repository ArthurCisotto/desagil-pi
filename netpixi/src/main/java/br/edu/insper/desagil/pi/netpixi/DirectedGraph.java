package br.edu.insper.desagil.pi.netpixi;

public class DirectedGraph extends Graph {
	@Override
	public void addEdge(int i, int j) {
		vertex(i).addNeighbor(vertex(j));
	}
}
