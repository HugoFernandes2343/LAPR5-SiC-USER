/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemservicospublicos;

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
        for (Servico s : listaServicos) {
            if(s.equals(serv)){
                return true;
            }
        }
        return false;
    }
    
}
