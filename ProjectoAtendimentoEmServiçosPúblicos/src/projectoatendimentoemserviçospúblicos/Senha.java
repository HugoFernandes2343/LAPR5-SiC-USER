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
    // o que fazer com o numero de contribuinte que vem do ficheiro ????

    private String servico;
    private int numeroOrdem;

    public Senha(String s, int n) {
        this.servico = s;
        this.numeroOrdem = n;
    }

    public Senha() {
        this.servico = "0";
        this.numeroOrdem = 0;
    }

    public String getServico() {
        return servico;
    }

    public int getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setServico(String s) {
        this.servico = s;
    }

    public void setNumeroOrdem(int i) {
        this.numeroOrdem = i;
    }

}
