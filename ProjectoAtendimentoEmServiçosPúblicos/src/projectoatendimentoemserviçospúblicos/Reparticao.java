/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugod
 */
public class Reparticao {

    private String cidade;
    private int numeroReparticao;
    private int codigoPostal;
    private List<String> listaServicos;
    private ListaCidadao listaCidadao;
    

    public Reparticao(String s, int n, int codigo, List<String> serv) {
        this.cidade = s;
        this.numeroReparticao = n;
        this.codigoPostal = codigo;
        this.listaServicos = serv;
        this.listaCidadao = new ListaCidadao();
    }

    public Reparticao() {
        this.cidade = "";
        this.numeroReparticao = 0;
        this.codigoPostal = 0;
        this.listaServicos = new ArrayList<>();
        
    }

    public String getCidade() {
        return cidade;
    }

    public int getNumeroReparticao() {
        return numeroReparticao;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public List<String> getListaServicos() {
        return listaServicos;
    }
    
    public ListaCidadao getListaCidadao(){
        return listaCidadao;
    }
    
    public void setCidade(String c) {
        this.cidade = c;
    }

    public void setNumeroReparticao(int n) {
        this.numeroReparticao = n;
    }

    public void setCodigoPostal(int n) {
        this.codigoPostal = n;
    }

    public void setListaServicos(List<String> s) {
        this.listaServicos = s;
    }
    
    public void addCidadao(Cidadao cid){
        listaCidadao.getListaCidadao().addLast(cid);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reparticao)) {
            return false;
        }
        Reparticao that = (Reparticao) obj;
        return numeroReparticao == that.numeroReparticao && codigoPostal == that.codigoPostal;
    }
}
