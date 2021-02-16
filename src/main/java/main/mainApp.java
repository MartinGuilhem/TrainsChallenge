package main;

import model.Dijkstra;
import model.Graph;
import model.Node;

public class mainApp {

	public static void main(String[] args) {

		argsValidation(args);

		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");

		nodeA.addDestination(nodeB, 5);
		nodeA.addDestination(nodeD, 5);
		nodeA.addDestination(nodeE, 7);

		nodeB.addDestination(nodeC, 4);

		nodeC.addDestination(nodeD, 8);
		nodeC.addDestination(nodeE, 2);

		nodeD.addDestination(nodeE, 6);

		nodeE.addDestination(nodeB, 3);

		Graph graph = new Graph();

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);

		char city = args[0].toUpperCase().charAt(0);

		switch (city) {
		case 'A':
			graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
			break;
		case 'B':
			graph = Dijkstra.calculateShortestPathFromSource(graph, nodeB);
			break;
		case 'C':
			graph = Dijkstra.calculateShortestPathFromSource(graph, nodeC);
			break;
		case 'D':
			graph = Dijkstra.calculateShortestPathFromSource(graph, nodeD);
			break;
		case 'E':
			graph = Dijkstra.calculateShortestPathFromSource(graph, nodeE);
			break;
		}

		System.out.println("Results for: " + city + " as origin.\n");
		for (Node node : graph.getNodes()) {
			for (Node nNode : node.getShortestPath()) {
				System.out.print(nNode.getName() + "->");
			}
			if (node.getDistance() >= Integer.MAX_VALUE) {
				System.out.print("No such route to " + node.getName());
				System.out.print("\n");
			} else if (node.getDistance() > 0) {
				System.out.print(node.getName() + " Distance: " + node.getDistance() + "\n");
			}
		}
		System.out.println("\n---> HAVE A NICE TRIP!! <---");
	}

	private static void argsValidation(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String city = args[i];
			if (city.length() > 1) {
				throw new RuntimeException("Should be only one character");
			}
			if (!city.matches("[a-eA-E]+")) {
				throw new RuntimeException("The input should be a character between A-E");
			}
		}
	}
}
