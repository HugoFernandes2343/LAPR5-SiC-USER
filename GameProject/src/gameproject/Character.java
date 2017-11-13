/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.Objects;

/**
 *
 * @author 1120608 Norberto Sousa 1161155 Hugo Fernandes
 */
public class Character {

    private String name;
    private int strength;
    private Locale startingLocale;

    /**
     * constructor for Character
     * @param name
     * @param strength
     * @param l
     */
    public Character(String name, int strength, Locale l) {
        this.name = name;
        this.strength = strength;
        this.startingLocale = l;
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
    
    public Locale getStartingLocale() {
        return startingLocale;
    }

    public void setStartingLocale(Locale l) {
        this.startingLocale = l;
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
        if (strength != that.strength) {
            return false;
        }
        if (startingLocale != that.startingLocale) {
            return false;
        }
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.strength;
        return hash;
    }

}

