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
//    private DoublyLinkedList<Cidadao> listaCidadao;

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
}
