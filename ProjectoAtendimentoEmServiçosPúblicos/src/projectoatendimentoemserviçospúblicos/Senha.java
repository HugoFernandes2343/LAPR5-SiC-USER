/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import java.util.Comparator;

/**
 *
 * @author hugod
 */
public class Senha implements Comparable<Senha> {

    private int numeroContribuinte;
    private String servico;
    private int numeroOrdem;

    public Senha(int n, String s, int n2) {
        this.numeroContribuinte = n;
        this.servico = s;
        this.numeroOrdem = n2;
    }

    public Senha() {
        this.servico = "0";
        this.numeroOrdem = 0;
    }

    public int getNumeroContribuinte() {
        return numeroContribuinte;
    }

    public String getServico() {
        return servico;
    }

    public int getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroContribuinte(int i) {
        this.numeroContribuinte = i;
    }

    public void setServico(String s) {
        this.servico = s;
    }

    public void setNumeroOrdem(int i) {
        this.numeroOrdem = i;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Senha)) {
            return false;
        }
        Senha that = (Senha) obj;
        return numeroContribuinte == that.numeroContribuinte && servico.equalsIgnoreCase(that.servico) && numeroOrdem == that.numeroOrdem;
    }

    @Override
    public int compareTo(Senha t) {
        if (this.numeroOrdem < t.getNumeroOrdem()) {
            return -1;
        }
        if (this.numeroOrdem > t.getNumeroOrdem()) {
            return 1;
        }
        return 0;
    }

}
