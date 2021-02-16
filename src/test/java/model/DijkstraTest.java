package model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {

	public Graph graph;
	public Dijkstra dijkstra;
	
	Node nodeA;
	Node nodeB;
	Node nodeC;
	Node nodeD;
	Node nodeE;
	
	@Before
	public void setUp() throws Exception {
		
		dijkstra = new Dijkstra();
		graph = new Graph();
		
		nodeA = new Node("A");
		nodeB = new Node("B");
		nodeC = new Node("C");
		nodeD = new Node("D"); 
		nodeE = new Node("E");

		nodeA.addDestination(nodeB, 5);
		nodeA.addDestination(nodeD, 5);
		nodeA.addDestination(nodeE, 7);

		nodeB.addDestination(nodeC, 4);

		nodeC.addDestination(nodeD, 8);
		nodeC.addDestination(nodeE, 2);

		nodeD.addDestination(nodeE, 6);

		nodeE.addDestination(nodeB, 3);

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		
//		graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

	}

	@Test
	public void testCalculateShortestPathFromSourceA() {
		
		graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

        List<Node> shortestPathForNodeB = Arrays.asList(nodeA);
        List<Node> shortestPathForNodeC = Arrays.asList(nodeA, nodeB);
        List<Node> shortestPathForNodeD = Arrays.asList(nodeA);
        List<Node> shortestPathForNodeE = Arrays.asList(nodeA);
		
        for (Node node : graph.getNodes()) {
            switch (node.getName()) {
            case "B":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeB));
                break;
            case "C":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeC));
                break;
            case "D":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeD));
                break;
            case "E":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeE));
                break;
            }
        }
		
		
		
		
		
//		String message1 = String.format(mainApp.SUCCESS, 4);
		
//		Results:
//			B->C Distance: 4
//			B->C->D Distance: 12
//			No souch route to A
//			B->C->E Distance: 6
	}
	
		

}
