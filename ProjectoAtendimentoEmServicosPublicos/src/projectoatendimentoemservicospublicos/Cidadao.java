/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemservicospublicos;

/**
 *
 * @author 1120608 Norberto Sousa 1161155 Hugo Fernandes
 */
public class Cidadao {

    private String nome;
    private int numeroContribuinte;
    private String email;
    private String codigoPostal;
    private int numeroReparticao; 
   

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

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cidadao)) {
            return false;
        }
        Cidadao that = (Cidadao) obj;
        return numeroContribuinte == that.numeroContribuinte;
    }
    
}
