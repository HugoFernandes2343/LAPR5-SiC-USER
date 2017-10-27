/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author hugod
 */
public class GameBase {
    private AdjacencyMatrixGraph<Locale,Roads > map1;
    private AdjacencyMatrixGraph<Character,Aliance > map2;

    public boolean insertLocale(String n, Character o, int d) {
        return map1.insertVertex(new Locale(n, o,d));

    }

    public boolean insertRoads(int d,Locale l1, Locale l2) {
        return map1.insertEdge(l1,l2,new Roads(d, l1,l2));

    }
    
    public boolean insertCharacter(String n, int s) {
        return map2.insertVertex(new Character(n,s));

    }
    
    public boolean insertAliance(boolean p, float cf,float pw, Character c1,Character c2) {
        return map2.insertEdge(c1,c2,new Aliance(p,cf,pw,c1,c2));

    }
}
