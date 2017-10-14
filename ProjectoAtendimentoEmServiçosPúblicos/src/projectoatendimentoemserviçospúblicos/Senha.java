/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

/**
 *
 * @author hugod
 */
public class Senha {

    
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

}
