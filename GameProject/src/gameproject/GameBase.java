/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import graphMap.Edge;
import graphMap.Graph;
import graphMatrix.AdjacencyMatrixGraph;
import graphMatrix.EdgeAsDoubleGraphAlgorithms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

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
            if(al.get(i).getName().equalsIgnoreCase(s)) {
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
        Road r1 = new Road(l1,l2,d);
        matrix.insertEdge(l1,l2, r1);

    }

    public void  insertCharacter(String n, int s, Locale l) {
        Character c = new Character(n,s,l);
         map.insertVertex(c);

    }

    public void insertAliance(boolean p, float cf, float pw, Character c1, Character c2) {
        Aliance al = new Aliance(p, cf, pw, c1, c2);
        map.insertEdge(c1, c2, al, pw);
    }

    public Character searchForCharacter(String s) {
        ArrayList<Character> al = new ArrayList<>();
        for(Character cTemp : map.vertices()){
            al.add(cTemp);
        }
        Character c = new Character();
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i).getName().equalsIgnoreCase(s)) {
                c = al.get(i);
            }
        }
        return c;
    }

    public <V> LinkedList<Road> caminhoMaisFacil(Locale l1, Locale l2) {
        LinkedList<Road> path = new LinkedList<>();
        AdjacencyMatrixGraph<Locale, Double> g = cloneToDouble(matrix);

        double dist = EdgeAsDoubleGraphAlgorithms.shortestPath((AdjacencyMatrixGraph<V, Double>) g, (V) l1, (V) l2, (LinkedList<V>) path);
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
     * @param c
     * @param l
     * @return
     */
    public ArrayList<String> conquerInformation(Character c, Locale l) {
        ArrayList<String> al = new ArrayList<>(3);
        LinkedList<Road> lr = new LinkedList<Road>();
        int str_c = c.getStrength();
        Locale origin_c = c.getStartingLocale();
        lr = caminhoMaisFacil(c.getStartingLocale(), l);
        Iterator itr = lr.iterator();
        Locale localeTemp = new Locale();
        Road roadTemp = new Road();
        int str_conquer = 0;
        int maxPower=0;
        while ( itr.hasNext() && str_c > str_conquer) {
            roadTemp = (Road) itr.next();
            if(roadTemp.getFirst().equals(origin_c)){
                localeTemp = roadTemp.getSecond();
            } else{
                localeTemp = roadTemp.getFirst();
            }
            str_conquer = roadTemp.getDifficulty() + localeTemp.getDifficulty();
            if(str_c <= str_conquer){
                al.set(1, "Não é possivel conquistar");
                al.set(3, this + "Stopped at ");
            }else{
                al.set(1, "Sim é possivel conquistar");
            }
            if(str_conquer > maxPower){
                maxPower = str_conquer;
            }
            al.set(3, this + localeTemp.getName() + ",");
            origin_c = localeTemp;
        }
        al.set(2, Integer.toString(maxPower));
        return al;
    }
}
