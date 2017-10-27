package gameproject;


import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

/**
 * Implementation of graph algorithms for a (undirected) graph structure
 * Considering generic vertex V and edge E types
 *
 * Works on AdjancyMatrixGraph objects
 *
 * @author DEI-ESINF
 *
 */
public class GraphAlgorithms {

    private static <T> LinkedList<T> reverse(LinkedList<T> list) {
        LinkedList<T> reversed = new LinkedList<T>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            reversed.push(it.next());
        }
        return reversed;
    }

    /**
     * Performs depth-first search of the graph starting at vertex. Calls
     * package recursive version of the method.
     *
     * @param graph Graph object
     * @param vertex Vertex of graph that will be the source of the search
     * @return queue of vertices found by search (including vertex), null if
     * vertex does not exist
     *
     */
    public static <V, E> LinkedList<V> DFS(AdjacencyMatrixGraph<V, E> graph, V vertex) {

        int index = graph.toIndex(vertex);
        if (index == -1) {
            return null;
        }

        LinkedList<V> resultQueue = new LinkedList<V>();
        resultQueue.add(vertex);
        boolean[] knownVertices = new boolean[graph.numVertices];
        DFS(graph, index, knownVertices, resultQueue);
        return resultQueue;
    }

    /**
     * Actual depth-first search of the graph starting at vertex. The method
     * adds discovered vertices (including vertex) to the queue of vertices
     *
     * @param graph Graph object
     * @param index Index of vertex of graph that will be the source of the
     * search
     * @param known previously discovered vertices
     * @param verticesQueue queue of vertices found by search
     *
     */
    static <V, E> void DFS(AdjacencyMatrixGraph<V, E> graph, int index, boolean[] knownVertices, LinkedList<V> verticesQueue) {
        knownVertices[index] = true;
        for (int i = 0; i < graph.numVertices; i++) {
            if (graph.edgeMatrix[index][i] != null && knownVertices[i] == false) {
                verticesQueue.add(graph.vertices.get(i));
                DFS(graph, i, knownVertices, verticesQueue);
            }
        }
    }

    /**
     * ADICIONEI:
     *
     * Performs breath-first search of the graph starting at vertex. The method
     * adds discovered vertices (including vertex) to the queue of vertices
     *
     * @param graph Graph object
     * @param vertex Vertex of graph that will be the source of the search
     * @return queue of vertices found by search (including vertex), null if
     * vertex does not exist
     *
     */
    public static <V, E> LinkedList<V> BFS(AdjacencyMatrixGraph<V, E> graph, V vertex) {

        if (!graph.checkVertex(vertex)) {      //se ele não existir retorna null
            return null;
        } else {
            LinkedList<V> qbfs = new LinkedList();               // lista a retornar
            Queue<V> qaux = new LinkedList<>();               // auxiliar para guardar os vértices ainda não visitados

            qbfs.add(vertex);                                // adiciono porque é a origem. Adiciono sempre ao fim que assim eles ficam na ordem
            qaux.add(vertex);

            while (!qaux.isEmpty()) {
                V temp = qaux.peek();               //guardo temporariamente o Vértice
                qaux.remove();

                if (!qbfs.contains(temp)) {           //se já foi atingido/visitado não adiciona
                    qbfs.add(temp);
                }

                for (V it : graph.directConnections(temp)) {//tem de ser um Iterable porque é esse o retorno do método directConnections
                    if (!(qbfs.contains(it)) && !(qaux.contains(it))) {    //se não estiver contida em nenhuma das 2. adiciona ao auxiliar
                        //se estiver na qbfs já foi visitado// se estiver na qaux já está marcada para visitar
                        qaux.add(it);           //adiciono ao qaux, todos os vértices vizinhos do vértice removido, ficam no final da queue
                    }

                }

            }
            return qbfs;
        }

    }

    /**
     * ADICIONEI: ver pág 41 e 42 da Teórica
     *
     * All paths between two vertices Calls recursive version of the method.
     *
     * @param graph Graph object
     * @param source Source vertex of path
     * @param dest Destination vertex of path
     * @param path LinkedList with paths (queues)
     * @return false if vertices not in the graph
     *
     */
    public static <V, E> boolean allPaths(AdjacencyMatrixGraph<V, E> graph, V source, V dest, LinkedList<LinkedList<V>> paths) {

        if (graph.checkVertex(source) && graph.checkVertex(dest)) { //verifico se ambos os vértices existem
//temos de preencher a LinkedList paths, e se tiver pelo menos uma ligação retorna boolean true
            paths.clear();
            boolean[] knownVertices = new boolean[graph.numVertices];
            LinkedList<V> auxStack = new LinkedList<>();

//        //chamo o método all Paths, que é recursivo e irá preencher todos os caminhos a partir dos vértices a 1 ramo de distância da origem
//        for (V it : graph.directConnections(source)) { //retorna os vizinhos da source
            GraphAlgorithms.allPaths(graph, graph.vertices.indexOf(source), graph.vertices.indexOf(dest), knownVertices, auxStack, paths);
//        }
            return paths.size() > 0;
        }
        return false;
    }

    /**
     * Actual paths search The method adds vertices to the current path (stack
     * of vertices) when destination is found, the current path is saved to the
     * list of paths
     *
     * @param graph Graph object
     * @param sourceIdx Index of source vertex
     * @param destIdx Index of destination vertex
     * @param knownVertices previously discovered vertices
     * @param auxStack stack of vertices in the path
     * @param path LinkedList with paths (queues)
     *
     */
    static <V, E> void allPaths(AdjacencyMatrixGraph<V, E> graph, int sourceIdx, int destIdx, boolean[] knownVertices, LinkedList<V> auxStack, LinkedList<LinkedList<V>> paths) {
    //condição de paragem...qd o destino é igual ao source(o source muda a cada chamada recursiva)
        //adiciono o caminho encontrado e o método pára
        if (sourceIdx == destIdx) {
            auxStack.add(graph.vertices.get(sourceIdx));
            paths.add(auxStack);
        } else {
            //marca o index do vertice no ArrayList do grafo no mesmo indice no array de booleans         
            knownVertices[sourceIdx] = true;
            //adiciono ao path
            auxStack.add(graph.vertices.get(sourceIdx));

            for (V it : graph.directConnections(graph.vertices.get(sourceIdx))) { //retorna os vizinhos da source
                V vDestino = graph.vertices.get(destIdx); //guardo temporariamente o destino, para simplificar o codigo

                if (knownVertices[graph.toIndex(it)] == false) {    //se ainda n foi visitado
                    GraphAlgorithms.allPaths(graph, graph.vertices.indexOf(it), destIdx, knownVertices, auxStack, paths);

                }
            }
        }
        knownVertices[sourceIdx] = false;
        auxStack.remove(); //duvidas, pode ter de ser comentado

    }

    /**
     * ADICIONEI....NÃO CONFIRMADO COM PROF Transforms a graph into its
     * transitive closure uses the Floyd-Warshall algorithm
     *
     * @param graph Graph object
     * @param dummyEdge object to insert in the newly created edges
     * @return the new graph
     */
    public static <V, E> AdjacencyMatrixGraph<V, E> transitiveClosure(AdjacencyMatrixGraph<V, E> graph, E dummyEdge) {


        for (int k = 0; k < graph.numVertices; k++) {
            for (int i = 0; i < graph.numVertices; i++) {
                if (i != k && graph.getEdge(graph.vertices.get(i), graph.vertices.get(k)) != null) { //se existir ramo entre vértice i e vértice k
                    for (int j = 0; j < graph.numVertices; j++) {
                        if (i != j && k != j && graph.getEdge(graph.vertices.get(k), graph.vertices.get(j)) != null) {
                           graph.insertEdge(graph.vertices.get(i), graph.vertices.get(j), dummyEdge);

                        }
                    }

                }

            }

        }
        return null;
    }

}
