package projectoatendimentoemserviçospúblicos;

import java.util.Iterator;

public class ListaReparticao {
    private DoublyLinkedList<Reparticao> listaReparticao;
    
    public ListaReparticao(){
        listaReparticao = new DoublyLinkedList<>();
    }

    public DoublyLinkedList<Reparticao> getListaReparticao() {
        return listaReparticao;
    }
    
    public Reparticao getReparticaoPorNumero(int numero){
        Iterator itr = listaReparticao.iterator();
        while(itr.hasNext()){
            Reparticao temp = (Reparticao) itr.next();
            if(temp.getNumeroReparticao() == numero){
                return temp;
            }
        }
        return null;
    }
    
}
