/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.Objects;

/**
 *
 * @author hugod
 */
public class Character {
    private String name;
    private int strength;

    public Character(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public Character() {
        this.name = "";
        this.strength = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Character)) {
            return false;
        }
        
        Character that = (Character) obj;
        if(strength != that.strength){
            return false;
        }
        
        return name == that.name;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.strength;
        return hash;
    }

    
    
}
