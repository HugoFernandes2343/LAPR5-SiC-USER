/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import graphMap.Edge;
import graphMap.Graph;
import graphMap.GraphAlgorithms;
import graphMatrix.AdjacencyMatrixGraph;
import graphMatrix.EdgeAsDoubleGraphAlgorithms;
//import graphMatrix.EdgeAsDoubleGraphAlgorithms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author 1120608 Norberto Sousa 1161155 Hugo Fernandes
 */
public class GameBase {

    private AdjacencyMatrixGraph<Locale, Road> matrix;
    private Graph<Character, Aliance> map; // mudar isto para map e nao matrix

    public void GameBase() {
        this.matrix = new AdjacencyMatrixGraph<>(10000);
        this.map = new Graph<>(false);
    }

    public Locale searchForLocal(String s) {
        ArrayList<Locale> al = new ArrayList<>();
        al = (ArrayList<Locale>) matrix.vertices();
        Locale l = new Locale();
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getName().equalsIgnoreCase(s)) {
                l = al.get(i);
            }

        }
        // searchForLocal(s, ll, l);
        return l;
    }

    public AdjacencyMatrixGraph<Locale, Road> getMatrix() {
        return matrix;
    }

    public Graph<Character, Aliance> getMap() {
        return map;
    }

    public void insertLocale(String n, int d) {
        matrix.insertVertex(new Locale(n, d));

    }

    public void insertRoads(int d, Locale l1, Locale l2) {
        Road r1 = new Road(l1, l2, d);
        matrix.insertEdge(l1, l2, r1);

    }

    public void insertCharacter(String n, int s, Locale l) {
        Character c = new Character(n, s, l);
        map.insertVertex(c);

    }

    public void insertAliance(boolean p, float cf, float pw, Character c1, Character c2) {
        Aliance al = new Aliance(p, cf, pw, c1, c2);
        map.insertEdge(c1, c2, al, pw);
    }

    public Character searchForCharacter(String s) {
        ArrayList<Character> al = new ArrayList<>();
        for (Character cTemp : map.vertices()) {
            al.add(cTemp);
        }
        Character c = new Character();
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getName().equalsIgnoreCase(s)) {
                c = al.get(i);
            }
        }
        return c;
    }

    public  LinkedList<Locale> caminhoMaisFacil(Locale l1, Locale l2) {
        LinkedList<Locale> path = new LinkedList<>();
        AdjacencyMatrixGraph<Locale, Double> g = cloneToDouble(matrix);

        double dist = EdgeAsDoubleGraphAlgorithms.shortestPath( g,  l1,  l2, path);
        return path;
    }

    public AdjacencyMatrixGraph<Locale, Double> cloneToDouble(AdjacencyMatrixGraph<Locale, Road> graph) {

        AdjacencyMatrixGraph<Locale, Double> clone = new AdjacencyMatrixGraph<>(graph.numVertices());

        for (Locale l : graph.vertices()) {
            clone.insertVertex(l);
        }
        for (Road r : graph.edges()) {
            clone.insertEdge(r.getFirst(), r.getSecond(), (double) r.getDifficulty());
        }
        return clone;
    }

    public Iterable<Character> todosAliados(Character dude) {
        return map.adjVertices(dude);
    }

    public float alianceMaisForte(LinkedList<Character> membros) {

        float power = 0.0f;

        for (Edge<Character, Aliance> edg : map.edges()) {
            float temp = edg.getElement().getPower();
            if (temp > power) {
                power = temp;
                membros.clear();
                membros.add(edg.getElement().getFirstCharacter());
                membros.add(edg.getElement().getSecondCharacter());
            }
        }
        return power;
    }

    /**
     * ALINEA 1.c)
     *
     * @param c
     * @param l
     * @return
     */
    public ArrayList<String> conquerInformation(Character c, Locale l) {
       
        ArrayList<String> al = new ArrayList<>(3);
        
        /*LinkedList<Road> lr = new LinkedList<Road>();
        int str_c = c.getStrength();
        Locale origin_c = c.getStartingLocale();
        lr = caminhoMaisFacil(c.getStartingLocale(), l);
        Iterator itr = lr.iterator();
        Locale localeTemp = new Locale();
        Road roadTemp = new Road();
        int str_conquer = 0;
        int maxPower = 0;
        while (itr.hasNext() && str_c > str_conquer) {
            roadTemp = (Road) itr.next();
            if (roadTemp.getFirst().equals(origin_c)) {
                localeTemp = roadTemp.getSecond();
            } else {
                localeTemp = roadTemp.getFirst();
            }
            str_conquer = roadTemp.getDifficulty() + localeTemp.getDifficulty();
            if (str_c <= str_conquer) {
                al.set(1, "Não é possivel conquistar");
                al.set(3, this + "Stopped at ");
            } else {
                al.set(1, "Sim é possivel conquistar");
            }
            if (str_conquer > maxPower) {
                maxPower = str_conquer;
            }
            al.set(3, this + localeTemp.getName() + ",");
            origin_c = localeTemp;
        }
        al.set(2, Integer.toString(maxPower));
        return al;*/
    }

    public Aliance novaAlianca(Graph<Character, Aliance> map, Character a, Character b) {
        if (!map.validVertex(a) || !map.validVertex(b) || a.equals(b)) {
            return null;
        }
        ArrayList<Character> teste = (ArrayList<Character>) map.adjVertices(a);
        if (teste.contains(b)) {
            return null;
        }

        LinkedList<Character> paths = new LinkedList<>();
        GraphAlgorithms.shortestPath(map, a, b, paths);
        float compFactor = 0;
        float power = 0;
        int contAlPublic = 0;

        if (paths.size() == 0) {
            compFactor = (float) Math.random();
            if (compFactor == 0) {
                compFactor = 0.1f;
            }
        } else {
            Aliance al = map.getEdge(paths.get(0), paths.get(1)).getElement();
            compFactor = compFactor + al.getCompatibilityFactor();
            contAlPublic++;

            for (int i = 1; i < paths.size() - 1; i++) {
                al = map.getEdge(paths.get(i), paths.get(i + 1)).getElement();
                if (!al.getPriv()) {
                    compFactor = compFactor + al.getCompatibilityFactor();
                    contAlPublic++;
                }
            }
            compFactor = compFactor / contAlPublic;
        }
        power = (a.getStrength() + b.getStrength()) * compFactor;
        Aliance newAl = new Aliance(false, compFactor, power, a, b);
        map.insertEdge(a, b, newAl, power);
        return newAl;
    }

    private Graph<Character, Aliance> todasAliancasPublico() {
        Graph<Character, Aliance> novoGraph = new Graph<>(false);
        for (Character a : map.vertices()) {
            novoGraph.insertVertex(a);
        }
        for (Edge<Character, Aliance> edge : map.edges()) {
            Aliance al = new Aliance(false, edge.getElement().getCompatibilityFactor(), edge.getElement().getPower(), edge.getElement().getFirstCharacter(), edge.getElement().getSecondCharacter());
            novoGraph.insertEdge(al.getFirstCharacter(), al.getSecondCharacter(), al, al.getPower());
        }
        return novoGraph;
    }

    private void todasAliancasPossiveis(Graph<Character, Aliance> novoMap, LinkedList<Character> listaChar) {
        if ((listaChar.size() > 1)) {
            Character a = listaChar.pollFirst();
            for (Character b : listaChar) {
                if (a != null && b != null) {
                    novaAlianca(novoMap, a, b);
                }
            }
            todasAliancasPossiveis(novoMap, listaChar);
        }
    }

    public Graph<Character, Aliance> todasAliancasPossiveis() {
        Graph<Character, Aliance> novoMap = todasAliancasPublico();
        LinkedList<Character> listaChar = (LinkedList<Character>) map.vertices();

        todasAliancasPossiveis(novoMap, listaChar);
        return novoMap;

    }

    public float conquerGroup(Character pers, Character aliado, LinkedList<Locale> locaisIntermedios, Locale localX) {
        if (!map.validVertex(pers) || !map.validVertex(aliado) || !matrix.checkVertex(localX)) {
            return -1;
        }
        aliado = null;
        float powerAliance = 0;
        float powerX = localX.getDifficulty();
        if (localX.getOwner() != null) {
            powerX = powerX + localX.getOwner().getStrength();
        }

        LinkedList<LinkedList<Locale>> lista = new LinkedList<>();
        if (graphMatrix.GraphAlgorithms.allPaths(matrix, pers.getStartingLocale(), localX, lista)) {
            locaisIntermedios = lista.pollFirst();
            for (LinkedList<Locale> l : lista) {
                if (l.size() < locaisIntermedios.size()) {
                    locaisIntermedios = l;
                }
            }
        }

        for (Character al : map.adjVertices(pers)) {
            powerAliance = map.getEdge(pers, al).getElement().getPower();
            if (!locaisIntermedios.contains(al.getStartingLocale()) && powerAliance > powerX) {
                aliado = al;
            }
        }
        if (aliado == null) {
            return -1;
        }
        return powerAliance;
    }

}
