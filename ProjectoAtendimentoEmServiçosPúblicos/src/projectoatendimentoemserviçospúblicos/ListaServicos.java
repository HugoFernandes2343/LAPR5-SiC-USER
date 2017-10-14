/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import java.util.ArrayList;

/**
 *
 * @author hugod
 */
public class ListaServicos {
    private ArrayList<Servico> listaServicos;
    
    public ListaServicos(){
         listaServicos = new ArrayList<>();
    }
    
    public ArrayList<Servico> getListaServicos(){
        return listaServicos;
    }

    public boolean checkForServ(Servico serv) {
        for (int i = 0; i < listaServicos.size(); i++) {
            if(listaServicos.get(i).equals(serv)){
                return true;
            }
        }
        return false;
    }
    
}
