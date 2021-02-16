package model;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	
	//Attributes
	private Set<Node> nodes = new HashSet<Node>(); //we will represent a graph as a set of nodes

	//Constructor
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    //Getters and Setters
    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

}
