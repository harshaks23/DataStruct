package Lab14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DshortPath {

	public static void main(String[] args) {

		Scanner abon = new Scanner(System.in);
		Scanner inp = new Scanner(System.in);
		int source = 0;
		System.out.println("Input the original network Topology matrixreq data file(ie the palce the file is present): ");
		String file = inp.nextLine();
		List<List<Integer>> matrixreq;List<Integer> Nodesremoved1 = new ArrayList<Integer>();

		
		matrixreq = readFileIntoMatrix(file);

		while (true) {

			List<Object[]> Rlist = extractShortestPath(matrixreq, Nodesremoved1);

			System.out.println("Please enter starting vertex:");
			for (;;) {
				source = abon.nextInt();
				if (source > matrixreq.size() ||Nodesremoved1.contains(source)) {
					System.out.println("Node does not exist in the network\n " + "Please Enter a new source node");
				} else {
					break;
				}
			}
			performSourceNodeOperations(source, Rlist);
			break;

		}

	}

	private static List<List<Integer>> readFileIntoMatrix(String fileName) {

		List<List<Integer>> matrixreq = null;
		try {
			File file1 = new File(fileName);
			FileReader filereader = new FileReader(file1);
			BufferedReader bufferreader = new BufferedReader(filereader);
			matrixreq = new ArrayList<List<Integer>>();
			String curentLineS = bufferreader.readLine(); 

			while (null != curentLineS)
			{
					String[] distanceArray = curentLineS.split(" ");

				List<Integer> row = new ArrayList<Integer>();
				for (String value : distanceArray) {
					row.add(Integer.valueOf(value)); 
				}
				matrixreq.add(row); 
				curentLineS = bufferreader.readLine();
			}
			bufferreader.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found please enter a validd location");
		} catch (IOException e) {
			
			System.out.println("Cannot read the file");
		} catch (NumberFormatException e) {
			System.out.println("File contents invalid erre");
		}

		return matrixreq;
	}

	private static void performSourceNodeOperations(int source, List<Object[]> Rlist) {
		Object[] Resulto = Rlist.get(source - 1);
			int[] distance = (int[]) Resulto[0];
		String[] path = (String[]) Resulto[1];
		System.out.println("Starting Vertex: " + source);
		for (int i = 1; i <= path.length; i++) {
			String tempfac;
			String[] Pathvalue = path[i - 1].split(",");
			
			if (Pathvalue.length == 1) {
				tempfac = Pathvalue[0];
			} else {
				tempfac = Pathvalue[1];
			}
			if (distance[i - 1] == -1) {
				distance[i - 1] = 0;
			}
			System.out.println(source + "-->" + i + ":   Cost is   " + distance[i - 1] + ",   Path is   "+ path[i - 1].replaceAll(",", "-->"));
		}
	}

	private static Object[] findshortestpath(int[][] arr, int size, int source, int maxVal,List<Integer> Nodesremoved1)
	{

		boolean[] visited = new boolean[size];

		int[] distance = new int[size];
		String[] path = new String[size];
		int minimum;
		int nextNode = 0;
		String Previouspath;
		source--;

		for (int i = 0; i < size; i++) {
			visited[i] = false; 
			distance[i] = arr[source][i]; 
		}
		distance[source] = 0;

		for (int i = 0; i < size; i++) {
				path[i] = String.valueOf(source + 1) + "," + String.valueOf(i + 1);
			if (distance[i] == maxVal) {
				path[i] = String.valueOf(source + 1);
			}
		}
		path[source] = "-";
		
		visited[source] = true;

		for (int i = 0; i < size; i++) {
				if (Nodesremoved1.contains(i + 1)) {
				path[i] = "-";
				visited[i] = true;
			}
		}

		for (int i = 0; i < size; i++) {
			minimum = maxVal;

			for (int j = 0; j < size; j++)
				
				if (minimum > distance[j] && visited[j] != true) {
					minimum = distance[j];
					nextNode = j;
				}

			visited[nextNode] = true;
			Previouspath = path[nextNode]; 

			for (int k = 0; k < size; k++) {
				if (visited[k] != true) {
					
					if (minimum + arr[nextNode][k] < distance[k]) {
					
						distance[k] = minimum + arr[nextNode][k];
						path[k] = Previouspath + "," + String.valueOf(k + 1);
					}
				}
			}
		}
		for (int i = 0; i < path.length; i++) {
			if (distance[i] == 999) {
				path[i] = "-";
				distance[i] = -1;
			}
		}
		Object[] obj = new Object[2];
		obj[0] = distance;
		obj[1] = path;
		
		return obj;
	}

	private static List<Object[]> extractShortestPath(List<List<Integer>> matrixreq, List<Integer> Nodesremoved1) {
		List<Object[]> Rlist = new ArrayList<Object[]>();
		int size = matrixreq.size();
		int[][] arr = new int[size][size];
		int maxVal = 999;
	for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = matrixreq.get(i).get(j);
					if (arr[i][j] <= -1)
					arr[i][j] = maxVal;
			}
		}
		for (int i = 0; i < matrixreq.size(); i++) {
			Object[] Resulto = findshortestpath(arr, size, i + 1, maxVal, Nodesremoved1);
			Rlist.add(Resulto);
		}
		return Rlist;
	}

}
