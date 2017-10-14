/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hugod
 */
public class Reparticao {

    private String cidade;
    private int numeroReparticao;
    private int codigoPostal;
    private ListaServicos listaServicos;
    private ListaCidadao listaCidadao;

    public Reparticao(String c, int n, int codigo, List<String> s) {
        this.cidade = c;
        this.numeroReparticao = n;
        this.codigoPostal = codigo;
        for (int i = 0; i < s.size() ; i++) {
            String letra = s.get(i);
            Servico serv = new Servico(letra);
            listaServicos.getListaServicos().add(serv);
        }
        this.listaCidadao = new ListaCidadao();
    }

    public Reparticao() {
        this.cidade = "";
        this.numeroReparticao = 0;
        this.codigoPostal = 0;
        this.listaServicos = new  ListaServicos();

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

    public  ListaServicos getListaServicos() {
        return listaServicos;
    }

    public ListaCidadao getListaCidadao() {
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
       for (int i = 0; i < s.size() ; i++) {
            String letra = s.get(i);
            Servico serv = new Servico(letra);
            listaServicos.getListaServicos().add(serv);
        }
    }

    public void addCidadao(Cidadao cid) {
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

    public boolean checkForCidadaoPorNumero(int n) {
        Iterator itr = this.listaCidadao.getListaCidadao().iterator();
        while (itr.hasNext()) {
            Cidadao c = (Cidadao) itr.next();
            if (c.getNumeroContribuinte() == n) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkForServico(Servico serv){
        if(listaServicos.checkForServ(serv)){
        return true;
        }
        return false;
    }
}
