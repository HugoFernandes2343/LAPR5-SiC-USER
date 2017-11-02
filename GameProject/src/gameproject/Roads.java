package gameproject;

import java.util.Objects;

/**
 *
 * @author hugod
 */
public class Roads {

    private int difficulty;
    private Locale first;
    private Locale second;

    public Roads(int difficulty, Locale first, Locale second) {
        this.difficulty = difficulty;
        this.first = first;
        this.second = second;
    }

    public Roads() {
        this.difficulty = 0;
        this.first = new Locale();
        this.second = new Locale();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Locale getFirst() {
        return first;
    }

    public void setFirst(Locale first) {
        this.first = first;
    }

    public Locale getSecond() {
        return second;
    }

    public void setSecond(Locale second) {
        this.second = second;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.difficulty;
        hash = 97 * hash + Objects.hashCode(this.first);
        hash = 97 * hash + Objects.hashCode(this.second);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Roads other = (Roads) obj;
        if (this.difficulty != other.difficulty) {
            return false;
        }
        if (!Objects.equals(this.first, other.first)) {
            return false;
        }
        if (!Objects.equals(this.second, other.second)) {
            return false;
        }
        return true;
    }

}
