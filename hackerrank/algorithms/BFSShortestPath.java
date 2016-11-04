package hackerrank.algorithms;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Rohit
 */
public class BFSShortestPath {

    private int[] getShortestPath(int[][] adjacency_matrix, int source) {

        LinkedList<Integer> queue = new LinkedList<>();

        int no_of_nodes = adjacency_matrix.length, element;
        int visited[] = new int[no_of_nodes], shortest_paths[] = new int[no_of_nodes];

        for (int a0 = 0; a0 < no_of_nodes; a0++) {
            shortest_paths[a0] = -1;
        }

        queue.add(source);
        visited[source] = 1;
        shortest_paths[source] = 0;

        while (!queue.isEmpty()) {

            element = queue.pop();

            for (int vertex = 0; vertex < no_of_nodes; vertex++) {
                if (adjacency_matrix[element][vertex] == 1 && visited[vertex] == 0) {
                    queue.add(vertex);
                    visited[vertex] = 1;
                    shortest_paths[vertex] = shortest_paths[element] + 6;
                }
            }
        }
        return shortest_paths;
    }

    public static void main(String[] args) {
        BFSShortestPath sol = new BFSShortestPath();
        int t, n, m;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        ArrayList<int[]> shortestPaths = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            int adjacencyMatrix[][] = new int[n][n], x, y, source;

            for (int j = 0; j < m; j++) {
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
                adjacencyMatrix[x][y] = 1;
                adjacencyMatrix[y][x] = 1;

            }
            source = sc.nextInt() - 1;
            shortestPaths.add(sol.getShortestPath(adjacencyMatrix, source));
        }
        Iterator iterator = shortestPaths.iterator();

        int next = 0;

        while (iterator.hasNext()) {
            int[] arr = (int[]) iterator.next();
            for (int anArr : arr) {
                if (anArr != 0) System.out.print((anArr) + " ");
            }
            System.out.println();
        }

    }
}


