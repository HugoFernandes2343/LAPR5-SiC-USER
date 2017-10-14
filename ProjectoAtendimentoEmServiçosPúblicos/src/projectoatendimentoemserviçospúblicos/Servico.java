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
public class Servico {
    private String letraCodigo;
    private ListaSenha listaSenha;
    
    public Servico(String letra){
    this.letraCodigo = letra;
    this.listaSenha = new ListaSenha();
    }
    public ListaSenha getListaSenha(){
     return listaSenha;
    }
}
