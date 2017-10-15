package projectoatendimentoemserviçospúblicos;

import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author hugod
 */
public class Servico {

    private String letraCodigo;
    private ListaSenha listaSenha;

    public Servico(String letra) {
        this.letraCodigo = letra.toUpperCase();
        this.listaSenha = new ListaSenha();
    }

    public ListaSenha getListaSenha() {
        return listaSenha;
    }

    public String getLetraCodigo() {
        return letraCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Servico)) {
            return false;
        }
        Servico that = (Servico) obj;
        return letraCodigo.equalsIgnoreCase(that.letraCodigo);
    }
    
    public boolean CheckSenhasDoCidadao(Cidadao c){
         Iterator itr=listaSenha.getListaSenha().iterator();
        Senha senhaTemp = new Senha();
        while(itr.hasNext()){
            senhaTemp = (Senha) itr.next();
            if(senhaTemp.getNumeroContribuinte()== c.getNumeroContribuinte()){
                return true;
            }
        }
        return false;
    }
    public void RemoveSenhaDoCidadao(Cidadao c) {
        Iterator itr=listaSenha.getListaSenha().iterator();
        Senha senhaTemp = new Senha();
        while(itr.hasNext()){
            senhaTemp = (Senha) itr.next();
            if(senhaTemp.getNumeroContribuinte()== c.getNumeroContribuinte()){
                itr.remove();
            }
        }
    }
}
