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
public class Locale {

    private String name = "";
    private Character owner = new Character();
    private int difficulty = 0;

    public Locale(String n, int d) {

        this.name = n;
        this.difficulty = d;
    }

    public Locale() {
    }

    public String getName() {
        return name;
    }

    public Character getOwner() {
        return owner;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setOwner(Character o) {
        this.owner = o;
    }

    public void setDifficulty(int d) {
        this.difficulty = d;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Locale)) {
            return false;
        }
        Locale that = (Locale) obj;
       
            return this.name.equalsIgnoreCase(that.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.owner);
        hash = 79 * hash + this.difficulty;
        return hash;
    }
}
