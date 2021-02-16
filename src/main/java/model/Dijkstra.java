package model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map.Entry;

public class Dijkstra {
	
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<Node>(); //nodes with a known minimum distance from the source.
        Set<Node> unsettledNodes = new HashSet<Node>(); //Nodes that we can reach from the source, but we don't know the minimum distance from the starting node.
        unsettledNodes.add(source); 

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes); 
            
            unsettledNodes.remove(currentNode);
            
            for (Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) { 
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) { 
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode); 
                    unsettledNodes.add(adjacentNode); 
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
	
	//Returns the node with the lowest distance from the unsettled nodes set
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
    	
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        
        for (Node node : unsettledNodes) {  
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
	
    //Compares the actual distance with the newly calculated one while following the newly explored path
    private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance(); 
        
        if (sourceDistance + edgeWeight < evaluationNode.getDistance()) {  
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<Node>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}
