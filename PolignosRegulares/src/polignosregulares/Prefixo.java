
package polignosregulares;

public class Prefixo implements Comparable {

    private String Pref;

    private int numeroLados;

    public Prefixo(int nl, String p) {
        this.Pref = p;
        this.numeroLados = nl;
    }

    public Prefixo() {
        this.Pref = "";
        this.numeroLados = 0;
    }

    public Prefixo(int nl) {
        this.Pref = "";
        this.numeroLados = nl;
    }

    public void setPref(String Pref) {
        this.Pref = Pref;
    }

    public void setNumeroLados(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    public String getPref() {
        return Pref;
    }

    public int getNumeroLados() {
        return numeroLados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.numeroLados;
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s", Pref);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prefixo other = (Prefixo) obj;
        return this.numeroLados != other.numeroLados;
    }

    @Override
    public int compareTo(Object t) {
        Prefixo p = (Prefixo) t;

        if (this.numeroLados > p.getNumeroLados()) {
            return 1;
        }
        if (this.numeroLados < p.getNumeroLados()) {
            return -1;
        }
        return 0;
    }

}
