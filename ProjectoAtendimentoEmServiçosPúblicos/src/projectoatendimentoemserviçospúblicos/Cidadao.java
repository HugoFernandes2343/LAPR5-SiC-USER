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
public class Cidadao {

    private String nome;
    private int numeroContribuinte;
    private String email;
    private String codigoPostal; //neste caso seria uma string pq o codigo postal do cidadao ao contrario do das reparticoes é completo ou seja tem um hifen no meio
    private int numeroReparticao; // verificar o que hugo acha sobre esta variavel

    public Cidadao(String n, int contribuinte, String e, String cod, int nRep) {
        this.nome = n;
        this.numeroContribuinte = contribuinte;
        this.email = e;
        this.codigoPostal = cod;
        this.numeroReparticao = nRep;
    }

    public Cidadao() {
        this.nome = "";
        this.numeroContribuinte = 0;
        this.email = "@";
        this.codigoPostal = "-";
        this.numeroReparticao = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumeroContribuinte() {
        return this.numeroContribuinte;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public int getNumeroReparticao() {
        return this.numeroReparticao;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public void setNumeroContribuinte(int n) {
        this.numeroContribuinte = n;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setCodigoPostal(String cod) {
        this.codigoPostal = cod;
    }

    public void setNumeroReparticao(int nRep) {
        this.numeroReparticao = nRep;
    }

}
